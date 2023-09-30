package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

public class ConstantFunction {
    public ConstantFunction(double x) {
        this.c = x;
    }
    private final double c;
    public double apply(double x) {
        return c;
    }
}
