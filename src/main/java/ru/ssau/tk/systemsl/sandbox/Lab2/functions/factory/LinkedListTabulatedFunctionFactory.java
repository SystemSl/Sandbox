package ru.ssau.tk.systemsl.sandbox.Lab2.functions.factory;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.*;

public class LinkedListTabulatedFunctionFactory implements TabulatedFunctionFactory {
    @Override
    public TabulatedFunction create(double[] xValues, double[] yValues) {
        return new LinkedListTabulatedFunction(xValues, yValues);
    }
}
