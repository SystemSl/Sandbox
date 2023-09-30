package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ConstantFunctionTest {

    @Test
    void apply() {
        ConstantFunction a = new ConstantFunction(2);
        assertEquals(a.apply(10), 2);
    }
}