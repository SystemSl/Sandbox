package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

import org.junit.jupiter.api.Test;

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
}