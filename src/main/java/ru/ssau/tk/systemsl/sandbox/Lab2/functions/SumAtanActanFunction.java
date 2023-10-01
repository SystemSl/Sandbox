package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

public class SumAtanActanFunction implements MathFunction{
    public double apply(double x) {
        return Math.atan(x) + Math.atan(-x) + Math.PI / 2;
    }
}
