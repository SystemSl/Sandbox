package ru.ssau.tk.systemsl.sandbox.Lab2.functions;
import java.util.Iterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnmodifiableTabulatedFunctionTest {
    private ArrayTabulatedFunction Af;

    private LinkedListTabulatedFunction Lf;

    private UnmodifiableTabulatedFunction UAf;

    private UnmodifiableTabulatedFunction ULf;

    @BeforeEach
    void setUp() {
        double[] xValues = {0.0, 1.0, 2.0, 3.0};
        double[] yValues = {0.0, 1.0, 4.0, 9.0};
        Af = new ArrayTabulatedFunction(xValues, yValues);
        Lf = new LinkedListTabulatedFunction(xValues, yValues);
        UAf = new UnmodifiableTabulatedFunction(Af);
        ULf = new UnmodifiableTabulatedFunction(Lf);
    }

    @Test
    void getCount() {
        assertEquals(Af.getCount(), UAf.getCount());
        assertEquals(Lf.getCount(), ULf.getCount());
    }

    @Test
    void getX() {
        assertEquals(Af.getX(0), UAf.getX(0));
        assertEquals(Lf.getX(0), ULf.getX(0));
    }

    @Test
    void getY() {
        assertEquals(Af.getY(0), UAf.getY(0));
        assertEquals(Lf.getY(0), ULf.getY(0));
    }

    @Test
    void setY() {
        assertThrows(UnsupportedOperationException.class, () -> UAf.setY(0, 0));
        assertThrows(UnsupportedOperationException.class, () -> ULf.setY(0, 0));
    }

    @Test
    void indexOfX() {
        assertEquals(Af.indexOfX(0), UAf.indexOfX(0));
        assertEquals(Lf.indexOfX(0), ULf.indexOfX(0));
    }

    @Test
    void indexOfY() {
        assertEquals(Af.indexOfY(0), UAf.indexOfY(0));
        assertEquals(Lf.indexOfY(0), ULf.indexOfY(0));
    }

    @Test
    void leftBound() {
        assertEquals(Af.leftBound(), UAf.leftBound());
        assertEquals(Lf.leftBound(), ULf.leftBound());
    }

    @Test
    void rightBound() {
        assertEquals(Af.rightBound(), UAf.rightBound());
        assertEquals(Lf.rightBound(), ULf.rightBound());
    }

    @Test
    void apply() {
        assertEquals(Af.apply(0.5), UAf.apply(0.5));
        assertEquals(Lf.apply(0.5), ULf.apply(0.5));
    }

    @Test
    public void Iterator() {
        int i = 0;
        for (Point point : UAf) {
            assertEquals(Af.getX(i), point.x);
            assertEquals(Af.getY(i++), point.y);
        }
        i = 0;
        for (Point point : ULf) {
            assertEquals(Lf.getX(i), point.x);
            assertEquals(Lf.getY(i++), point.y);
        }
    }
}