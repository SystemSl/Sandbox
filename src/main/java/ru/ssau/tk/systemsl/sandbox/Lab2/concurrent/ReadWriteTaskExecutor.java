package ru.ssau.tk.systemsl.sandbox.Lab2.concurrent;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.ConstantFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.LinkedListTabulatedFunction;

public class ReadWriteTaskExecutor {
    public static void main(String[] args) {
        LinkedListTabulatedFunction ll = new LinkedListTabulatedFunction(new ConstantFunction(-1), 1, 1000, 1000);
        Thread t1 = new Thread(new ReadTask(ll));
        Thread t2 = new Thread(new WriteTask(ll, 0.5));
        t1.start();
        t2.start();
    }
}
