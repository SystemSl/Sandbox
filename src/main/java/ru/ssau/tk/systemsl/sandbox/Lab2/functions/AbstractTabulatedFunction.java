package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

import ru.ssau.tk.systemsl.sandbox.Lab2.exceptions.ArrayIsNotSortedException;
import ru.ssau.tk.systemsl.sandbox.Lab2.exceptions.DifferentLengthOfArraysException;

import java.io.Serial;
import java.io.Serializable;

public abstract class AbstractTabulatedFunction implements TabulatedFunction, Serializable {
    @Serial
    private static final long serialVersionUID = -4102961108545481362L;

    protected abstract int floorIndexOfX(double x);
    protected abstract double extrapolateLeft(double x);
    protected abstract double extrapolateRight(double x);
    protected abstract double interpolate(double x, int floorIndex);
    protected double interpolate(double x, double leftX, double rightX, double leftY, double rightY) {
        return leftY+((rightY-leftY)/(rightX-leftX))*(x-leftX);
    }
    public double apply(double x) {
        if (x < leftBound())
            return extrapolateLeft(x);
        else if (x > rightBound())
            return extrapolateRight(x);
        else if (indexOfX(x) != -1)
            return getY(indexOfX(x));
        return interpolate(x, floorIndexOfX(x));
    }
    static void checkLengthIsTheSame(double[] xValues, double[] yValues) {
        if (xValues.length != yValues.length) throw new DifferentLengthOfArraysException("Arrays have different length.");
    }
    static void checkSorted(double[] xValues) {
        int i = 1;
        while (i < xValues.length) {
            if (xValues[i] <= xValues[(i++)-1]) throw new ArrayIsNotSortedException("Array is not sorted.");
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName())
                .append(" size = ")
                .append(getCount())
                .append("\n");

        for (Point point : this) {
            stringBuilder.append("[")
                    .append(point.x)
                    .append("; ")
                    .append(point.y)
                    .append("]\n");
        }

        return stringBuilder.toString();
    }
}
