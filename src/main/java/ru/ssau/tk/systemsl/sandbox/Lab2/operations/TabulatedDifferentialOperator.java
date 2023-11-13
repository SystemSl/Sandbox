package ru.ssau.tk.systemsl.sandbox.Lab2.operations;

import ru.ssau.tk.systemsl.sandbox.Lab2.concurrent.SynchronizedTabulatedFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.*;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.factory.*;

public class TabulatedDifferentialOperator implements DifferentialOperator<TabulatedFunction> {
    protected TabulatedFunctionFactory factory;

    public TabulatedDifferentialOperator(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    public TabulatedDifferentialOperator() {
        this.factory = new ArrayTabulatedFunctionFactory();
    }

    public TabulatedFunctionFactory getFactory() {
        return factory;
    }

    public void setFactory(TabulatedFunctionFactory factory) {
        this.factory = factory;
    }

    @Override
    public TabulatedFunction derive(TabulatedFunction function) {
        int count = function.getCount();
        Point[] points = TabulatedFunctionOperationService.asPoints(function);
        double[] xValues = new double[count];
        double[] yValues = new double[count];

        int i = 0;
        while (i < count - 1) {
            xValues[i] = points[i].x;
            yValues[i] = (points[i + 1].y - points[i].y) / (points[i + 1].x - points[i].x);
            i++;
        }

        xValues[i] = points[i].x;
        yValues[i] = yValues[i - 1];

        return factory.create(xValues, yValues);
    }
    public SynchronizedTabulatedFunction deriveSynchronously(TabulatedFunction function) {
        SynchronizedTabulatedFunction syn_function;
        if (function.getClass() != SynchronizedTabulatedFunction.class)
            syn_function = new SynchronizedTabulatedFunction(function);
        else
            syn_function = (SynchronizedTabulatedFunction) function;
        return syn_function.doSynchronously(syn_func -> {
            return new SynchronizedTabulatedFunction(this.derive(syn_function));});
    }
}
