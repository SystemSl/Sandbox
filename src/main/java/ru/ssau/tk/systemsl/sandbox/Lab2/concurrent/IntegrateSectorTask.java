package ru.ssau.tk.systemsl.sandbox.Lab2.concurrent;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.TabulatedFunction;

import java.util.concurrent.Callable;

public class IntegrateSectorTask implements Callable<Double> {
    final TabulatedFunction function;
    final int i1;
    final int i2;
    public IntegrateSectorTask(TabulatedFunction function, int i1, int i2) {
        this.function = function;
        this.i1 = i1;
        this.i2 = i2;
    }
    public Double call() {
        double x1 = function.getX(i1);
        double x2 = function.getX(i2);
        double y1 = function.getY(i1);
        double y2 = function.getY(i2);
        if ((y1 >= 0) != (y2 >=0)) {
            double x0 = (-y1/(y2-y1))*(x2-x1)+x1;
            return (Math.abs((y1/2)*(x0-x1)) + Math.abs((y2/2)*(x2-x0)));
        }
        return Math.abs(((y1+y2)/2)*(x2-x1));
    }
}
