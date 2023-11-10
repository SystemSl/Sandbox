package ru.ssau.tk.systemsl.sandbox.Lab2.concurrent;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.Point;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.TabulatedFunction;

import java.util.Iterator;

public class SynchronizedTabulatedFunction implements TabulatedFunction {
    public final TabulatedFunction function;
    final Object mutex;
    public SynchronizedTabulatedFunction(TabulatedFunction function) {
        this.function = function;
        mutex = this;
    }
    public SynchronizedTabulatedFunction(TabulatedFunction function, Object mutex) {
        this.function = function;
        this.mutex = mutex;
    }

    @Override
    public double apply(double x) {
        synchronized (mutex) {
            return function.apply(x);
        }
    }

    @Override
    public int getCount() {
        synchronized (mutex) {
            return function.getCount();
        }
    }

    @Override
    public double getX(int index) {
        synchronized (mutex) {
            return function.getX(index);
        }
    }

    @Override
    public double getY(int index) {
        synchronized (mutex) {
            return function.getY(index);
        }
    }

    @Override
    public void setY(int index, double value) {
        synchronized (mutex) {
            function.setY(index, value);
        }
    }

    @Override
    public int indexOfX(double x) {
        synchronized (mutex) {
            return function.indexOfX(x);
        }
    }

    @Override
    public int indexOfY(double y) {
        synchronized (mutex) {
            return function.indexOfY(y);
        }
    }

    @Override
    public double leftBound() {
        synchronized (mutex) {
            return function.leftBound();
        }
    }

    @Override
    public double rightBound() {
        synchronized (mutex) {
            return function.rightBound();
        }
    }

    @Override
    public Iterator<Point> iterator() {
        synchronized (mutex) {
            return function.iterator();
        }
    }
}
