package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Iterator;

class StrictTabulatedFunctionTest {

    private ArrayTabulatedFunction ATF;
    private LinkedListTabulatedFunction LLTF;
    private StrictTabulatedFunction SATF;
    private StrictTabulatedFunction SLLTF;

    @BeforeEach
    void setUp() {
        double[] xValues = {0.0, 1.0, 2.0, 3.0};
        double[] yValues = {0.0, 1.0, 4.0, 9.0};
        ATF = new ArrayTabulatedFunction(xValues, yValues);
        LLTF = new LinkedListTabulatedFunction(xValues, yValues);
        SATF = new StrictTabulatedFunction(ATF);
        SLLTF = new StrictTabulatedFunction(LLTF);
    }

    @Test
    void getCount() {
        assertEquals(ATF.getCount(), SATF.getCount());
        assertEquals(LLTF.getCount(), SLLTF.getCount());
    }

    @Test
    void getX() {
        assertEquals(ATF.getX(0), SATF.getX(0));
        assertEquals(LLTF.getX(0), SLLTF.getX(0));
    }

    @Test
    void getY() {
        assertEquals(ATF.getY(0), SATF.getY(0));
        assertEquals(LLTF.getY(0), SLLTF.getY(0));
    }

    @Test
    void setY() {
        SATF.setY(0, 0);
        assertEquals(0, SATF.getY(0));
        SLLTF.setY(0, 0);
        assertEquals(0, SLLTF.getY(0));;
    }

    @Test
    void indexOfX() {
        assertEquals(ATF.indexOfX(0), SATF.indexOfX(0));
        assertEquals(LLTF.indexOfX(0), SLLTF.indexOfX(0));
    }

    @Test
    void indexOfY() {
        assertEquals(ATF.indexOfY(0), SATF.indexOfY(0));
        assertEquals(LLTF.indexOfY(0), SLLTF.indexOfY(0));
    }

    @Test
    void leftBound() {
        assertEquals(ATF.leftBound(), SATF.leftBound());
        assertEquals(LLTF.leftBound(), SLLTF.leftBound());
    }

    @Test
    void rightBound() {
        assertEquals(ATF.rightBound(), SATF.rightBound());
        assertEquals(LLTF.rightBound(), SLLTF.rightBound());
    }

    @Test
    void apply() {
        assertThrows(UnsupportedOperationException.class, () -> {
            SATF.apply(0.5);
        });
        assertThrows(UnsupportedOperationException.class, () -> {
            SLLTF.apply(0.5);
        });
    }

    @Test
    void iterator() {
        Iterator<Point> iteratorSATF = SATF.iterator();
        Iterator<Point> iteratorSLLTF = SLLTF.iterator();

        int i = 0;

        while (iteratorSATF.hasNext()) {
            Point point = iteratorSATF.next();
            assertEquals(ATF.getX(i), point.x);
            assertEquals(ATF.getY(i), point.y);
            i++;
        }

        i = 0;

        while (iteratorSLLTF.hasNext()) {
            Point point = iteratorSLLTF.next();
            assertEquals(LLTF.getX(i), point.x);
            assertEquals(LLTF.getY(i), point.y);
            i++;
        }

        assertThrows(UnsupportedOperationException.class, iteratorSATF::remove);
        assertThrows(UnsupportedOperationException.class, iteratorSLLTF::remove);
    }
}