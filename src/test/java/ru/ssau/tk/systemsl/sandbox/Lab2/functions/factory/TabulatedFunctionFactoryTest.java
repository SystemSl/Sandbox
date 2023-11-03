package ru.ssau.tk.systemsl.sandbox.Lab2.functions.factory;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TabulatedFunctionFactoryTest {

    @Test
    void testArrayTabulatedFunctionFactory() {
        TabulatedFunctionFactory factory = new ArrayTabulatedFunctionFactory();
        TabulatedFunction function = factory.create(new double[] {1.0, 2.0, 3.0}, new double[] {2.0, 4.0, 6.0});
        assertTrue(function instanceof ArrayTabulatedFunction);
    }

    @Test
    void testLinkedListTabulatedFunctionFactory() {
        TabulatedFunctionFactory factory = new LinkedListTabulatedFunctionFactory();
        TabulatedFunction function = factory.create(new double[] {1.0, 2.0, 3.0}, new double[] {2.0, 4.0, 6.0});
        assertTrue(function instanceof LinkedListTabulatedFunction);
    }

    @Test
    void Unmodifiable() {
        double[] xValues = {0.0, 1.0, 2.0, 3.0};
        double[] yValues = {1.0, 2.0, 3.0, 4.0};
        ArrayTabulatedFunctionFactory a = new ArrayTabulatedFunctionFactory();
        LinkedListTabulatedFunctionFactory ll = new LinkedListTabulatedFunctionFactory();
        assertThrows(UnsupportedOperationException.class, () -> (a.createUnmodifiable(xValues, yValues)).setY(0, 0));
        assertThrows(UnsupportedOperationException.class, () -> (ll.createUnmodifiable(xValues, yValues)).setY(0, 0));
    }

    @Test
    void Strict() {
        double[] xValues = {0.0, 1.0, 2.0, 3.0};
        double[] yValues = {1.0, 2.0, 3.0, 4.0};
        ArrayTabulatedFunctionFactory a = new ArrayTabulatedFunctionFactory();
        LinkedListTabulatedFunctionFactory ll = new LinkedListTabulatedFunctionFactory();
        assertThrows(UnsupportedOperationException.class, () -> (a.createStrict(xValues, yValues)).apply(0.5));
        assertThrows(UnsupportedOperationException.class, () -> (ll.createStrict(xValues, yValues)).apply(0.5));
    }

    @Test
    void StrictUnmodifiable() {
        double[] xValues = {0.0, 1.0, 2.0, 3.0};
        double[] yValues = {1.0, 2.0, 3.0, 4.0};
        ArrayTabulatedFunctionFactory a = new ArrayTabulatedFunctionFactory();
        LinkedListTabulatedFunctionFactory ll = new LinkedListTabulatedFunctionFactory();
        TabulatedFunction t1 = a.createStrictUnmodifiable(xValues, yValues);
        TabulatedFunction t2 = ll.createStrictUnmodifiable(xValues, yValues);
        assertThrows(UnsupportedOperationException.class, () -> (t1).apply(0.5));
        assertThrows(UnsupportedOperationException.class, () -> (t2).apply(0.5));
        assertThrows(UnsupportedOperationException.class, () -> (t1).setY(0, 0));
        assertThrows(UnsupportedOperationException.class, () -> (t2).setY(0, 0));
    }
}