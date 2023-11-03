package ru.ssau.tk.systemsl.sandbox.Lab2.operations;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.*;
public abstract class SteppingDifferentialOperator implements DifferentialOperator<MathFunction> {

    protected double step;

    SteppingDifferentialOperator(double step) {
        if (step <= 0 || Double.isInfinite(step) || Double.isNaN(step))
            throw new IllegalArgumentException("Incorrect step");
        else
            this.step = step;
    }

    public double getStep() {
        return step;
    }

    public void setStep(double step) {
        if (step <= 0 || Double.isInfinite(step) || Double.isNaN(step))
            throw new IllegalArgumentException("Incorrect step");
        else
            this.step = step;
    }
}
