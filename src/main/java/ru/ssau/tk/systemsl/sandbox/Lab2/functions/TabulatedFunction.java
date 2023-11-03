package ru.ssau.tk.systemsl.sandbox.Lab2.functions;
import java.util.Iterator;

public interface TabulatedFunction extends MathFunction, Iterable<Point> {

    //obtaining the number of tabulated values
    int getCount();

    //gets the value of argument x by index number
    double getX(int index);

    //gets the y value by index number
    double getY(int index);

    //sets the y value by index number
    void setY(int index, double value);

    //returns the index of the argument x
    int indexOfX(double x);

    //returns the index of the first occurrence of the value y
    int indexOfY(double y);

    //returns the leftmost x
    double leftBound();

    //returns the rightmost x
    double rightBound();
    @Override
    default Iterator<Point> iterator() {
        throw new UnsupportedOperationException();
    }
}
