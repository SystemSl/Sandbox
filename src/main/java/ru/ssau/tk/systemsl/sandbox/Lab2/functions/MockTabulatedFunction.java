package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

public class MockTabulatedFunction extends AbstractTabulatedFunction {
    private final double x0;
    private final double x1;
    private final double y0;
    private final double y1;

    public MockTabulatedFunction(double x0, double x1, double y0, double y1) {
        this.x0 = x0;
        this.x1 = x1;
        this.y0 = y0;
        this.y1 = y1;
    }

    public int indexOfX(double x) {
        if (x < x0 || x > x1) {
            return -1;
        } else if (x == x0) {
            return 0;
        } else if (x == x1) {
            return 1;
        }
        return -1;
    }

    public int indexOfY(double y) {
        if (y == y0) {
            return 0;
        } else if (y == y1) {
            return 1;
        }
        return -1;
    }
    protected int floorIndexOfX(double x) {
        if (x < x0) {
            return -1;
        } else if (x >= x0 && x < x1) {
            return 0;
        } else {
            return 1;
        }
    }

    protected double extrapolateLeft(double x) {
        return y0;
    }

    protected double extrapolateRight(double x) {
        return y1;
    }

    protected double interpolate(double x, int floorIndex) {
        return interpolate(x, x0, x1, y0, y1);
    }

    public double getX(int index) {
        if (index == 0) {
            return x0;
        } else if (index == 1) {
            return x1;
        }
        throw new IndexOutOfBoundsException("Index out of range");
    }

    public double getY(int index) {
        if (index == 0) {
            return y0;
        } else if (index == 1) {
            return y1;
        }
        throw new IndexOutOfBoundsException("Index out of range");
    }

    public void setY(int index, double value) {

    }

    public int getCount() {
        return 2;
    }

    public double leftBound() {
        return x0;
    }

    public double rightBound() {
        return x1;
    }
}
