package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

import static org.junit.jupiter.api.Assertions.*;

class IdentityFunctionTest {

    @org.junit.jupiter.api.Test
    void apply() {
        IdentityFunction x = new IdentityFunction();
        assertEquals(x.apply(10), 10);
    }
}