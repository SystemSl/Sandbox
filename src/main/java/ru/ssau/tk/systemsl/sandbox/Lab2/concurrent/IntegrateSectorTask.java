package ru.ssau.tk.systemsl.sandbox.Lab2.concurrent;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.TabulatedFunction;

import java.util.concurrent.Callable;

public class IntegrateSectorTask implements Callable<Double> {
    final TabulatedFunction function;
    final double x1;
    final double x2;
    public IntegrateSectorTask(TabulatedFunction function, double x1, double x2) {
        this.function = function;
        this.x1 = x1;
        this.x2 = x2;
    }
    public Double call() {
        double result = 0;
        double y1 = function.getY(function.indexOfX(x1));
        double y2 = function.getY(function.indexOfX(x2));
        if ((x1 >= 0) != (x2 >=0)) {
            double x0 = (-y1/(y2-y1))*(x2-x1)+x1;
            return (Math.abs((y1/2)*(x2-x1)) + Math.abs((y2/2)*(x2-x1)));
        }
        result = Math.abs(((y1+y2)/2)*(x2-x1));
        return result;
    }
}
