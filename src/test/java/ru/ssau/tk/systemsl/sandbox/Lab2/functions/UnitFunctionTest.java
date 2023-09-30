package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitFunctionTest {
    @Test
    void apply() {
        UnitFunction a = new UnitFunction();
        assertEquals(a.apply(10), 1);
    }
}