package ru.ssau.tk.systemsl.sandbox.Lab2.operations;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.*;
public class LeftSteppingDifferentialOperator extends SteppingDifferentialOperator{
    LeftSteppingDifferentialOperator(double step) {
        super(step);
    }
    public MathFunction derive(MathFunction function) {
        return ((x)->(function.apply(x)-function.apply(x-step))/step);
    }
}
