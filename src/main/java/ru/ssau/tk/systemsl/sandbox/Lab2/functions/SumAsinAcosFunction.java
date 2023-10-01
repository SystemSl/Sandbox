package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

public class SumAsinAcosFunction implements MathFunction{
    public double apply(double x) {
        return Math.acos(x) + Math.asin(x);
    }
}
