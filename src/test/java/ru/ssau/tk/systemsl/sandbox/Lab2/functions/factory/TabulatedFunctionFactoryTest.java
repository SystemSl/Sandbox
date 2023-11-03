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
}