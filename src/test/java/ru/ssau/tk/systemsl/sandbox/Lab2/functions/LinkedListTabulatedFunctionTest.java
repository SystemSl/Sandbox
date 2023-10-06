package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTabulatedFunctionTest {

    private LinkedListTabulatedFunction function;

    @BeforeEach
    void setUp() {
        double[] xValues = {0.0, 1.0, 2.0, 3.0};
        double[] yValues = {0.0, 1.0, 4.0, 9.0};
        function = new LinkedListTabulatedFunction(xValues, yValues);
    }

    @Test
    void testGetX() {
        assertEquals(0.0, function.getX(0), 0.0001);
        assertEquals(1.0, function.getX(1), 0.0001);
        assertEquals(2.0, function.getX(2), 0.0001);
        assertEquals(3.0, function.getX(3), 0.0001);
    }

    @Test
    void testGetY() {
        assertEquals(0.0, function.getY(0), 0.0001);
        assertEquals(1.0, function.getY(1), 0.0001);
        assertEquals(4.0, function.getY(2), 0.0001);
        assertEquals(9.0, function.getY(3), 0.0001);
    }

    @Test
    void testSetY() {
        function.setY(1, 10.0);
        assertEquals(10.0, function.getY(1), 0.0001);
    }

    @Test
    void testIndexOfX() {
        assertEquals(0, function.indexOfX(0.0));
        assertEquals(1, function.indexOfX(1.0));
        assertEquals(2, function.indexOfX(2.0));
        assertEquals(3, function.indexOfX(3.0));
        assertEquals(-1, function.indexOfX(4.0));
    }

    @Test
    void testIndexOfY() {
        assertEquals(0, function.indexOfY(0.0));
        assertEquals(1, function.indexOfY(1.0));
        assertEquals(2, function.indexOfY(4.0));
        assertEquals(3, function.indexOfY(9.0));
        assertEquals(-1, function.indexOfY(10.0));
    }

    @Test
    void testFloorIndexOfX() {
        assertEquals(0, function.floorIndexOfX(0.0));
        assertEquals(1, function.floorIndexOfX(1.5));
        assertEquals(2, function.floorIndexOfX(2.5));
        assertEquals(4, function.floorIndexOfX(3.5));
        assertEquals(0, function.floorIndexOfX(-1.0));
        assertEquals(0, function.floorIndexOfX(0.5));
    }

    @Test
    void testLeftBound() {
        assertEquals(0.0, function.leftBound(), 0.0001);
    }

    @Test
    void testRightBound() {
        assertEquals(3.0, function.rightBound(), 0.0001);
    }

    @Test
    void testInterpolate() {
        assertEquals(0.5, function.interpolate(0.5, 0), 0.0001);
        assertEquals(2.5, function.interpolate(1.5, 1), 0.0001);
        assertEquals(6.5, function.interpolate(2.5, 2), 0.0001);
    }

    @Test
    void testExtrapolateLeft() {
        assertEquals(-1.0, function.extrapolateLeft(-1.0), 0.0001);
    }

    @Test
    void testExtrapolateRight() {
        assertEquals(14.0, function.extrapolateRight(4.0), 0.0001);
        assertEquals(11.5, function.extrapolateRight(3.5), 0.0001);
    }

    @Test
    void testApplyInsideRange() {
        assertEquals(0.0, function.apply(0.0), 0.0001);
        assertEquals(1.0, function.apply(1.0), 0.0001);
        assertEquals(4.0, function.apply(2.0), 0.0001);

        // Interpolation
        assertEquals(0.5, function.apply(0.5), 0.0001);
        assertEquals(2.5, function.apply(1.5), 0.0001);
        assertEquals(6.5, function.apply(2.5), 0.0001);
    }

    @Test
    void testApplyOutsideRange() {
        assertEquals(-1.0, function.apply(-1.0));
        assertEquals(14.0, function.apply(4.0), 0.0001);
    }

    @Test
    void testApplyBetweenValues() {
        assertEquals(0.25, function.apply(0.25), 0.0001);
        assertEquals(7.75, function.apply(2.75), 0.0001);
    }

    @Test
    void testApplyEqualXValues() {
        double[] xValues = {0.0, 0.0, 1.0, 1.0, 2.0, 2.0};
        double[] yValues = {0.0, 1.0, 2.0, 3.0, 4.0, 5.0};
        LinkedListTabulatedFunction equalXFunction = new LinkedListTabulatedFunction(xValues, yValues);

        assertEquals(0.0, equalXFunction.apply(0.0), 0.0001);
        assertEquals(2.0, equalXFunction.apply(1.0), 0.0001);
        assertEquals(4.0, equalXFunction.apply(2.0), 0.0001);
    }
    @Test
    void insert() {
        function.insert(-1, -2);
        assertEquals(-2, function.getY(0));
    }
}