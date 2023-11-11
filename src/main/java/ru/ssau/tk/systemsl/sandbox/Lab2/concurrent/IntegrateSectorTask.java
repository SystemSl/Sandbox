package ru.ssau.tk.systemsl.sandbox.Lab2.concurrent;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.TabulatedFunction;

import java.util.concurrent.Callable;

public class IntegrateSectorTask implements Callable<Double> {
    final TabulatedFunction function;
    final double x1;
    final double x2;
    final double step;
    public IntegrateSectorTask(TabulatedFunction function, double x1, double x2, double step) {
        this.function = function;
        this.x1 = x1;
        this.x2 = x2;
        this.step = step;
    }
    public Double call() {
        double result = 0;
        for (int i = 1; x1 + i * step <= x2; i++) {
            synchronized (function) {
                function.apply(x1 + i * step);
                result += Math.abs(function.getY(function.indexOfX(x1 + (i - 1) * step)) + function.getY(function.indexOfX(x1 + i * step)))*step/2;
            }
        }
        return result;
    }
}
