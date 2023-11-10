package ru.ssau.tk.systemsl.sandbox.Lab2.concurrent;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.UnitFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Vector;

public class MultiplyingTaskExecutor {
    public static void main(String[] args) throws InterruptedException {
        LinkedListTabulatedFunction ll = new LinkedListTabulatedFunction(new UnitFunction(), 1, 1000, 1000);
        List<Thread> list = new ArrayList<>();
        int number_of_iterations = 10;
        for (int i = 0; i < number_of_iterations; i++) {
            list.add(new Thread(new MultiplyingTask(ll)));
        }
        for (Thread th : list) {
            th.start();
        }
        Vector<Thread> vec_with_active_threads = new Vector<>(list);
        while (!vec_with_active_threads.isEmpty()) {
            for (int i = 0; i < vec_with_active_threads.size(); i++) {
                if (!vec_with_active_threads.get(i).isAlive())
                    vec_with_active_threads.remove(i--);
            }
        }
        System.out.println(ll);
    }
}
