package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

import org.junit.jupiter.api.Test;
import ru.ssau.tk.systemsl.sandbox.Lab2.exceptions.ArrayIsNotSortedException;
import ru.ssau.tk.systemsl.sandbox.Lab2.exceptions.DifferentLengthOfArraysException;

import static org.junit.jupiter.api.Assertions.*;

public class AbstractTabulatedFunctionTest {

    @Test
    void testInterpolate() {
        MockTabulatedFunction function = new MockTabulatedFunction(0.0, 1.0, 0.0, 1.0);
        assertEquals(0.5, function.interpolate(0.5, 0), 0.0001);
    }

    @Test
    void testApply() {
        MockTabulatedFunction function = new MockTabulatedFunction(0.0, 1.0, 0.0, 1.0);
        assertEquals(0.5, function.apply(0.5), 0.0001);
        assertEquals(0.0, function.apply(-1.0), 0.0001); // Left extrapolation
        assertEquals(1.0, function.apply(2.0), 0.0001);  // Right extrapolation
    }
    @Test
    void testExceptions() {
        AbstractTabulatedFunction f = null;
        double[] x1 = {1, 2, 3, 4, 3};
        double[] x2 = {2, 1, 3, 4, 5};
        double[] x3 = {1, 2, 4, 3, 5};
        double[] x4 = {2, 2, 4, 3, 5};
        double[] y = {1, 2, 3};
        assertThrowsExactly(DifferentLengthOfArraysException.class, ()->f.checkLengthIsTheSame(x1, y));
        assertThrowsExactly(ArrayIsNotSortedException.class, ()->f.checkSorted(x1));
        assertThrowsExactly(ArrayIsNotSortedException.class, ()->f.checkSorted(x2));
        assertThrowsExactly(ArrayIsNotSortedException.class, ()->f.checkSorted(x3));
        assertThrowsExactly(ArrayIsNotSortedException.class, ()->f.checkSorted(x4));
    }
}