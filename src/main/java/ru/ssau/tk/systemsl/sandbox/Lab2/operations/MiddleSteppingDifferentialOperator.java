package ru.ssau.tk.systemsl.sandbox.Lab2.operations;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.MathFunction;

public class MiddleSteppingDifferentialOperator extends SteppingDifferentialOperator{
    MiddleSteppingDifferentialOperator(double step) {
        super(step);
    }
    public MathFunction derive(MathFunction function) {
        return ((x)->(function.apply(x+step)-function.apply(x-step))/(2*step));
    }
}
