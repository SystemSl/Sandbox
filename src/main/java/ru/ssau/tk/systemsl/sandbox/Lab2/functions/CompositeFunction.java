package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

public class CompositeFunction implements MathFunction {
    private final MathFunction firstFunc; //final
    private final MathFunction secondFunc; //final

    public CompositeFunction(MathFunction firstFunc, MathFunction secondFunc) { //constructor
        this.firstFunc = firstFunc;
        this.secondFunc = secondFunc;
    }

    public double apply(double x) {
        return secondFunc.apply(firstFunc.apply(x));
    }

}
