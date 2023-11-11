package ru.ssau.tk.systemsl.sandbox.Lab2.concurrent;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.Point;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.TabulatedFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.operations.TabulatedFunctionOperationService;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.SynchronousQueue;

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
            Point[] points = TabulatedFunctionOperationService.asPoints(function);
            return new Iterator<Point>() {
                int i;

                @Override
                public boolean hasNext() {
                    return (i < points.length);
                }

                @Override
                public Point next() {
                    if (hasNext())
                        return points[i++];
                    else
                        throw new NoSuchElementException();
                }
            };
        }
    }
    public interface Operation<T> {
        T apply(SynchronizedTabulatedFunction function);
    }
    public <T> T doSynchronously(Operation<T> operation) {
        synchronized (mutex) {
            return operation.apply(new SynchronizedTabulatedFunction(function));
        }
    }
}
