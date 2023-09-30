package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SumAsinAcosFunctionTest {

    @Test
    void apply() {
        SumAsinAcosFunction a = new SumAsinAcosFunction();
        assertEquals(a.apply(0.5), Math.PI/2, 0.00001);
    }
}