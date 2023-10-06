package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTabulatedFunctionTest {

    @Test
    void getCount() {
        double[] x = {1, 2, 3, 4};
        double[] y = {1, 2, 3, 4};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.getCount(), 4);
    }

    @Test
    void getX() {
        double[] x = {1, 2, 3, 4};
        double[] y = {1, 2, 3, 4};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.getX(1), 2);
    }

    @Test
    void getY() {
        double[] x = {1, 2, 3, 4};
        double[] y = {1, 2, 3, 4};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.getY(2), 3);
    }

    @Test
    void setY() {
        double[] x = {1, 2, 3, 4};
        double[] y = {1, 2, 3, 4};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        a.setY(2,5);
        assertEquals(a.getY(2), 5);
    }

    @Test
    void leftBound() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.leftBound(), 1);
    }

    @Test
    void rightBound() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.rightBound(), 4);
    }

    @Test
    void indexOfX() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.indexOfX(3), 2);
    }

    @Test
    void indexOfY() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.indexOfY(3), 1);
    }

    @Test
    void floorIndexOfX1() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.floorIndexOfX(3), 1);
    }
    @Test
    void floorIndexOfX2() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.floorIndexOfX(5), 4);
    }
    @Test
    void floorIndexOfX3() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.floorIndexOfX(-1), 0);
    }

    @Test
    void interpolate() {
        double[] x = {1, 2, 3, 4};
        double[] y = {1, 2, 3, 4};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.interpolate(1.5, a.floorIndexOfX(1.5)), 1.5);
    }

    @Test
    void extrapolateLeft() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.extrapolateLeft(0), 1);
    }

    @Test
    void extrapolateRight() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.extrapolateLeft(5), 6);
    }
}