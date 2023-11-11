package ru.ssau.tk.systemsl.sandbox.Lab2.concurrent;

import org.junit.jupiter.api.Test;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class SynchronizedTabulatedFunctionTest {
    double[] x = {1, 2, 3, 4};
    double[] y = {2, 3, 4, 5};
    private final ArrayTabulatedFunction a = new ArrayTabulatedFunction(new double[]{1, 2, 3, 4}, new double[]{2, 3, 4, 5});
    private final SynchronizedTabulatedFunction syn_a = new SynchronizedTabulatedFunction(a);

    @Test
    void apply() {
        assertEquals(2.5, syn_a.apply(1.5));
    }

    @Test
    void getCount() {
        assertEquals(4, syn_a.getCount());
    }

    @Test
    void getX() {
        assertEquals(1, syn_a.getX(0));
    }

    @Test
    void getY() {
        assertEquals(2, syn_a.getY(0));
    }

    @Test
    void setY() {
        syn_a.setY(0, 10);
        assertEquals(10, syn_a.getY(0));
    }

    @Test
    void indexOfX() {
        assertEquals(0, syn_a.indexOfX(1));
    }

    @Test
    void indexOfY() {
        assertEquals(0, syn_a.indexOfY(2));
    }

    @Test
    void leftBound() {
        assertEquals(1, syn_a.leftBound());
    }

    @Test
    void rightBound() {
        assertEquals(4, syn_a.rightBound());
    }

    @Test
    void iterator() {
        int i = 0;
        for (Point point : syn_a) {
            assertEquals(x[i], point.x);
            assertEquals(y[i++], point.y);
        }
    }

    @Test
    void Operation_Multithreaded_Test() {
        ArrayTabulatedFunction array = new ArrayTabulatedFunction(new UnitFunction(), 1, 1000, 1000);
        SynchronizedTabulatedFunction syn_a = new SynchronizedTabulatedFunction(array);
        SynchronizedTabulatedFunction.Operation<Void> a = function -> {
            int i = 0;
            for (Point p : syn_a) {
                syn_a.setY(i++, p.y+1);
            }
            System.out.println("Operation complete");
            return null;
        };
        List<Thread> list = new ArrayList<>();
        int number_of_iterations = 10;
        for (int i = 0; i < number_of_iterations; i++) {
            list.add(new Thread(new MultiplyingTask(syn_a)));
        }
        for (Thread th : list) {
            th.start();
        }
        Vector<Thread> vec_with_active_threads = new Vector<>(list);
        syn_a.doSynchronously(a);
        System.out.println();
        while (!vec_with_active_threads.isEmpty()) {
            for (int i = 0; i < vec_with_active_threads.size(); i++) {
                if (!vec_with_active_threads.get(i).isAlive())
                    vec_with_active_threads.remove(i--);
            }
        }
        for (Point p : syn_a) {
            System.out.printf("[%f, %f]\n", p.x, p.y);
        }
    }
    @Test
    void Operation_Single_thread_Test() {
        SynchronizedTabulatedFunction.Operation<Void> op = function -> {
            int i = 0;
            for (Point p : syn_a) {
                syn_a.setY(i++, p.y+1);
            }
            return null;
        };
        SynchronizedTabulatedFunction.Operation<double[]> op1 = function -> {
            double[] y_val = new double[4];
            int i = 0;
            for (Point p : syn_a) {
                y_val[i++] = p.y;
            }
            return y_val;
        };
        syn_a.doSynchronously(op);
        double[] y_val = syn_a.doSynchronously(op1);
        int i = 0;
        for (Point p : syn_a) {
            assertEquals(y[i] + 1, p.y);
            assertEquals(y_val[i++], p.y);
        }
    }
}