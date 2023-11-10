package ru.ssau.tk.systemsl.sandbox.Lab2.concurrent;

import org.junit.jupiter.api.Test;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.Point;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.UnitFunction;

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
}