package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

public interface MathFunction {
    double apply(double x);
    default CompositeFunction andThen(MathFunction afterFunction) {
        return new CompositeFunction(this, afterFunction);
    }
}

