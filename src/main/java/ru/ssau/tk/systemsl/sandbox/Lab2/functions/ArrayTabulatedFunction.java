package ru.ssau.tk.systemsl.sandbox.Lab2.functions;
import java.util.Arrays;

public class ArrayTabulatedFunction extends AbstractTabulatedFunction{
    protected double[] xValues;
    protected double[] yValues;
    protected int count;
    public ArrayTabulatedFunction(double[] xValues, double[] yValues) {
        if (xValues.length == 0)
            throw new IllegalArgumentException("Array is empty");
        else if (xValues.length != yValues.length) {
            throw new IllegalArgumentException("Sizes of arrays are different");
        }
        else {
            this.xValues = Arrays.copyOf(xValues, xValues.length);
            this.yValues = Arrays.copyOf(yValues, xValues.length);
            this.count = xValues.length;
        }
    }
    public ArrayTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (count <= 0)
            throw new IllegalArgumentException("Size <= 0");
        else {
            this.count = count;
            this.xValues = new double[count];
            if (xFrom > xTo) {
                xTo = xFrom + xTo;
                xFrom = xTo - xFrom;
                xTo = xTo - xFrom;
            } else if (xFrom == xTo) {
                double y = source.apply(xFrom);
                for (int i = 0; i < count; i++) {
                    this.xValues[i] = y;
                }
            } else {
                double d = (xFrom - xTo) / (count - 1);
                double xs = xFrom;
                for (int i = 0; i < count; i++, xs += d) {
                    this.xValues[i] = source.apply(xs);
                }
            }
        }
    }
    public int getCount() {
        return this.count;
    }
    public double getX(int index) {
        if (index >= count || index < 0)
            throw new IllegalArgumentException("Index not in array.");
        else
            return this.xValues[index];
    }
    public double getY(int index) {
        if (index >= count || index < 0)
            throw new IllegalArgumentException("Index not in array.");
        else
            return this.yValues[index];
    }
    public void setY(int index, double value) {
        if (index >= count || index < 0)
            throw new IllegalArgumentException("Index not in array.");
        else
            this.yValues[index] = value;
    }

    public double leftBound() {
        return this.xValues[0];
    }
    public double rightBound() {
        return this.xValues[count-1];
    }
    public int indexOfX(double x) {
        int i = 0;
        while ((i < this.count) && (x != this.xValues[i])) {
            i++;
        }
        if (i == this.count)
            return -1;
        else
            return i;
    }
    public int indexOfY(double y) {
        int i = 0;
        while ((i < this.count) && (y != this.yValues[i])) {
            i++;
        }
        if (i == this.count)
            return -1;
        else
            return i;
    }
    protected int floorIndexOfX(double x) {
        if (x < leftBound())
            return 0;
        else if (x > rightBound())
            return this.count;
        int i = 0;
        while (x > this.xValues[i+1]) {
            i++;
        }
        return i;
    }
    protected double interpolate(double x, int floorIndex) {
        if (count == 1)
            return this.yValues[0];
        return interpolate(x, this.xValues[floorIndex], this.xValues[floorIndex+1], this.yValues[floorIndex], this.yValues[floorIndex+1]);
    }
    protected double extrapolateLeft(double x) {
        if (count == 1)
            return this.yValues[0];
        return interpolate(x, this.xValues[0], this.xValues[1], this.yValues[0], this.yValues[1]);
    }
    protected double extrapolateRight(double x) {
        if (count == 1)
            return this.yValues[0];
        return interpolate(x, this.xValues[this.count-2], this.xValues[this.count-1], this.yValues[this.count-2], this.yValues[this.count-1]);
    }
}
