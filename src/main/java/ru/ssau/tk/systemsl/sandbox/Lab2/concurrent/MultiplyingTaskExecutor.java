package ru.ssau.tk.systemsl.sandbox.Lab2.concurrent;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.UnitFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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
        Thread.sleep(2000);
        System.out.println(ll);
    }
}
