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
        assertEquals(a.floorIndexOfX(2.5), 1);
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

    //Insert tests
    @Test
    void testInsertExistingXValue() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        a.insert(3, 6);
        assertEquals(a.getCount(), 4);
        assertEquals(a.getY(2), 6);
    }

    @Test
    void testInsertNewXValue() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        a.insert(5, 6);
        assertEquals(a.getCount(), 5);
        assertEquals(a.getX(4), 5);
        assertEquals(a.getY(4), 6);
    }

    @Test
    void testInsertAtBeginning() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        a.insert(0.5, 1.5);
        assertEquals(a.getCount(), 5);
        assertEquals(a.getX(0), 0.5);
        assertEquals(a.getY(0), 1.5);
    }

    @Test
    void remove() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        a.remove(0);
        assertEquals(2, a.getX(0));
    }
}