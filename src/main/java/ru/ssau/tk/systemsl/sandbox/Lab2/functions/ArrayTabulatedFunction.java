package ru.ssau.tk.systemsl.sandbox.Lab2.functions;
import java.util.Arrays;

public class ArrayTabulatedFunction extends AbstractTabulatedFunction implements Insertable, Removable{
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

    public void insert(double x, double y) {
        int index = indexOfX(x);

        if (index != -1) {
            yValues[index] = y;
        } else {
            if (count >= xValues.length) {
                int newLength = count+1;
                double[] newXValues = new double[newLength];
                double[] newYValues = new double[newLength];

                System.arraycopy(xValues, 0, newXValues, 0, count);
                System.arraycopy(yValues, 0, newYValues, 0, count);

                xValues = newXValues;
                yValues = newYValues;
            }

            int insertionIndex = floorIndexOfX(x);

            System.arraycopy(xValues, insertionIndex, xValues, insertionIndex + 1, count - insertionIndex);
            System.arraycopy(yValues, insertionIndex, yValues, insertionIndex + 1, count - insertionIndex);

            xValues[insertionIndex] = x;
            yValues[insertionIndex] = y;

            count++;
        }
    }
    public void remove(int index) {
        if (index < 0 || index >= count) {
            throw new IllegalArgumentException("Index is out of bounds");
        }
        if (count > 1) {
            System.arraycopy(xValues, index + 1, xValues, index, count - index - 1);
            System.arraycopy(yValues, index + 1, yValues, index, count - index - 1);
        }
        count--;
    }
}

