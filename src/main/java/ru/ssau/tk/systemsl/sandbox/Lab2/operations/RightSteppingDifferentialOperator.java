package ru.ssau.tk.systemsl.sandbox.Lab2.operations;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.MathFunction;

public class RightSteppingDifferentialOperator extends SteppingDifferentialOperator{
    RightSteppingDifferentialOperator(double step) {
        super(step);
    }
    public MathFunction derive(MathFunction function) {
        return ((x)->(function.apply(x+step)-function.apply(x))/step);
    }
}
