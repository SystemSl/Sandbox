package ru.ssau.tk.systemsl.sandbox.Lab2.functions.factory;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.*;

public interface TabulatedFunctionFactory {
    TabulatedFunction create(double[] xValues, double[] yValues);

    /*default TabulatedFunction createStrict(double[] xValues, double[] yValues) {
        TabulatedFunction function = create(xValues, yValues);
        return new StrictTabulatedFunction(function);
    }*/

    //def create Unmodif()

    /*default TabulatedFunction createStrictUnmodifiable(double[] xValues, double[] yValues) {
        TabulatedFunction strictFunction = createStrict(xValues, yValues);
        return new UnmodifiableTabulatedFunction(strictFunction);
    }*/
}
