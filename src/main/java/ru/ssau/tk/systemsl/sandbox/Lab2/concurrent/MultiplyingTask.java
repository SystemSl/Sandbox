package ru.ssau.tk.systemsl.sandbox.Lab2.concurrent;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.TabulatedFunction;

public class MultiplyingTask implements Runnable{
    TabulatedFunction function;
    public MultiplyingTask(TabulatedFunction function) {
        this.function = function;
    }

    @Override
    public void run() {
        for (int i = 0; i < function.getCount(); i++) {
            function.setY(i, function.getY(i) * 2);
        }
        System.out.printf("Thread-%s has finished its work\n", Thread.currentThread().getName());
    }
}
