package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

import static org.junit.jupiter.api.Assertions.*;

class IdentityFunctionTest {

    @org.junit.jupiter.api.Test
    void apply() {
        IdentityFunction x = new IdentityFunction();
        assertEquals(x.apply(10), 10);
    }

    @org.junit.jupiter.api.Test
    void tS() {
        IdentityFunction x = new IdentityFunction();
        assertEquals(x.toString(), "IdentityFunction");
    }

    @org.junit.jupiter.api.Test
    void cl() {
        IdentityFunction x = new IdentityFunction();
        IdentityFunction y = (IdentityFunction) x.clone();
        assertEquals(y.apply(10), 10);
    }

    @org.junit.jupiter.api.Test
    void eq() {
        IdentityFunction x = new IdentityFunction();
        IdentityFunction y = (IdentityFunction) x.clone();
        assertEquals(x, y);
        assertEquals(y, x);
    }

    @org.junit.jupiter.api.Test
    void hC() {
        IdentityFunction x = new IdentityFunction();
        IdentityFunction y = (IdentityFunction) x.clone();
        assertEquals(x.hashCode(), y.hashCode());
    }
}