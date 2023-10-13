package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

public class IdentityFunction implements MathFunction, Cloneable {
    public double apply (double x) {
        return x;
    }

    @Override
    public String toString() {
        return "IdentityFunction";
    }

    @Override
    public boolean equals(Object o) {
        return (this.getClass() == o.getClass());
    }

    @Override
    public int hashCode() {
        return this.getClass().hashCode();
    }
    @Override
    public Object clone() {
        return new IdentityFunction();
    }
}
