package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

public class ConstantFunction implements MathFunction{
    public ConstantFunction(double x) {
        this.c = x;
    }
    private final double c;
    public double apply(double x) {
        return c;
    }
}
