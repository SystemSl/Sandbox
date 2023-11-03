package ru.ssau.tk.systemsl.sandbox.Lab2.functions.factory;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.*;

public class ArrayTabulatedFunctionFactory implements TabulatedFunctionFactory {
    @Override
    public TabulatedFunction create(double[] xValues, double[] yValues) {
        return new ArrayTabulatedFunction(xValues, yValues);
    }
}
