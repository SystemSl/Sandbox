package ru.ssau.tk.systemsl.sandbox.Lab2.concurrent;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.TabulatedFunction;

public class WriteTask implements Runnable{
    private final TabulatedFunction function;
    private final float value;
    public WriteTask(TabulatedFunction function, float value) {
        this.function = function;
        this.value = value;
    }

    @Override
    public void run() {
        for (int i = 0; i < function.getCount(); i++) {
            function.setY(i, value);
            System.out.printf("Writing for index %d complete", i);
        }
    }
}
