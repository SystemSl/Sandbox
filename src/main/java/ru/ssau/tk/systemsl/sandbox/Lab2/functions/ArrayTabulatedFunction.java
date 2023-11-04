package ru.ssau.tk.systemsl.sandbox.Lab2.functions;
import ru.ssau.tk.systemsl.sandbox.Lab2.exceptions.InterpolationException;

import java.io.Serial;
import java.io.Serializable;
import java.util.Iterator;

import java.util.Arrays;
import java.util.NoSuchElementException;

public class ArrayTabulatedFunction extends AbstractTabulatedFunction implements Cloneable, Insertable, Removable, Serializable {
    @Serial
    private static final long serialVersionUID = -6030744339129575121L;
    protected double[] xValues;
    protected double[] yValues;
    protected int count;
    public ArrayTabulatedFunction(double[] xValues, double[] yValues) {
        checkLengthIsTheSame(xValues, yValues);
        if (xValues.length < 2)
            throw new IllegalArgumentException("Array length < 2");
        checkSorted(xValues);
        this.xValues = Arrays.copyOf(xValues, xValues.length);
        this.yValues = Arrays.copyOf(yValues, xValues.length);
        this.count = xValues.length;
    }
    public ArrayTabulatedFunction(MathFunction source, double xFrom, double xTo, int count) {
        if (count < 2)
            throw new IllegalArgumentException("Size < 2");
        else {
            this.count = count;
            this.xValues = new double[count];
            this.yValues = new double[count];
            if (xFrom > xTo) {
                xTo = xFrom + xTo;
                xFrom = xTo - xFrom;
                xTo = xTo - xFrom;
            }
            if (xFrom == xTo) {
                double d = (xFrom - xTo) / (count - 1);
                double xs = xFrom;
                double y = source.apply(xFrom);
                for (int i = 0; i < count; i++, xs+=d) {
                    this.yValues[i] = y;
                    this.xValues[i] = xs;
                }
            } else {
                double d = (xFrom - xTo) / (count - 1);
                double xs = xFrom;
                for (int i = 0; i < count; i++, xs += d) {
                    this.yValues[i] = source.apply(xs);
                    this.xValues[i] = xs;
                }
            }
        }
    }
    public int getCount() {
        return this.count;
    }
    public double getX(int index) {
            return this.xValues[index];
    }
    public double getY(int index) {
            return this.yValues[index];
    }
    public void setY(int index, double value) {
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
            throw new IllegalArgumentException("x is less than the left boundary");
        else if (x > rightBound())
            return this.count;
        int i = 0;
        while (x > this.xValues[i+1]) {
            i++;
        }
        return i;
    }
    protected double interpolate(double x, int floorIndex) {
        if (this.xValues[floorIndex] < x && x < this.xValues[floorIndex+1])
            return interpolate(x, this.xValues[floorIndex], this.xValues[floorIndex+1], this.yValues[floorIndex], this.yValues[floorIndex+1]);
        else
            throw new InterpolationException();
    }
    protected double extrapolateLeft(double x) {
        return interpolate(x, this.xValues[0], this.xValues[1], this.yValues[0], this.yValues[1]);
    }
    protected double extrapolateRight(double x) {
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
            int insertionIndex;
            if (x < xValues[0] )
                insertionIndex = 0;
            else
                insertionIndex = floorIndexOfX(x);

            System.arraycopy(xValues, insertionIndex, xValues, insertionIndex + 1, count - insertionIndex);
            System.arraycopy(yValues, insertionIndex, yValues, insertionIndex + 1, count - insertionIndex);

            xValues[insertionIndex] = x;
            yValues[insertionIndex] = y;

            count++;
        }
    }
    public void remove(int index) {
        if (count > 1) {
            System.arraycopy(xValues, index + 1, xValues, index, count - index - 1);
            System.arraycopy(yValues, index + 1, yValues, index, count - index - 1);
        }
        count--;
    }
    public double apply(double x) {
        if (x < leftBound()) {
            double y = extrapolateLeft(x);
            insert(x, y);
            return y;
        }
        else if (x > rightBound()) {
            double y = extrapolateRight(x);
            insert(x, y);
            return y;
        }
        else if (indexOfX(x) != -1)
            return getY(indexOfX(x));
        double y = interpolate(x, floorIndexOfX(x));
        insert(x, y);
        return y;
    }

    @Override
    public String toString() {
        String ans = "("+ this.xValues[0] + "; " + this.yValues[0] + ")";
        for (int i = 1; i < this.count; i++) {
            ans += " (" + this.xValues[i] + "; " + this.yValues[i] + ")";
        }
        return ans;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (!(o instanceof TabulatedFunction obj)) return false;
        if (this.count != obj.getCount()) return false;
        for (int i = 0; i < this.count; i++) {
            if ((this.xValues[i] != obj.getX(i)) || (this.yValues[i] != obj.getY(i)))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hc = 0;
        int fb;
        long l;
        for (int i = 0; i < this.count; i++) {
            l = Double.doubleToLongBits(this.xValues[i]);
            fb = (int) (l >> 32);
            hc ^= fb;
            fb = (int) (l);
            hc ^= fb;
        }
        for (int i = 0; i < this.count; i++) {
            l = Double.doubleToLongBits(this.yValues[i]);
            fb = (int) (l >> 32);
            hc ^= fb;
            fb = (int) (l);
            hc ^= fb;
        }
        return hc;
    }

    @Override
    protected Object clone() {
        return new ArrayTabulatedFunction(this.xValues, this.yValues);
    }

    @Override
    public Iterator<Point>  iterator() {
        Iterator<Point> iterator = new Iterator<Point>() {
            int i;

            @Override
            public boolean hasNext() {
                return (i < count);
            }

            @Override
            public Point next() {
                if (hasNext())
                    return new Point(xValues[i], yValues[i++]);
                else
                    throw new NoSuchElementException();
            }
        };
        return iterator;
    }
}

