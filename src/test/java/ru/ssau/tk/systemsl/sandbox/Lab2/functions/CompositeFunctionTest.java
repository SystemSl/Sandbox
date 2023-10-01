package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CompositeFunctionTest {

    @Test
    void testSqrSumAtanActanFunc() {
        SqrFunction f1 = new SqrFunction();
        SumAtanActanFunction f2 = new SumAtanActanFunction();
        CompositeFunction x = new CompositeFunction(f1, f2);
        assertEquals(x.apply(2), Math.PI/2, 0.00001);
    }

    @Test
    void testSumAtanActanSqrFunc() {
        SumAtanActanFunction f1 = new SumAtanActanFunction();
        SqrFunction f2 = new SqrFunction();
        CompositeFunction x = new CompositeFunction(f1, f2);
        assertEquals(x.apply(2), Math.pow(Math.PI/2, 2), 0.00001);
    }

    @Test
    void testUnitSumAsinAcosFunc() {
        UnitFunction f1 = new UnitFunction();
        SumAsinAcosFunction f2 = new SumAsinAcosFunction();
        CompositeFunction x = new CompositeFunction(f1, f2);
        assertEquals(x.apply(2), Math.PI/2, 0.00001);
    }

    @Test
    void testZeroSumAsinAcosFunc() {
        ZeroFunction f1 = new ZeroFunction();
        SumAsinAcosFunction f2 = new SumAsinAcosFunction();
        CompositeFunction x = new CompositeFunction(f1, f2);
        assertEquals(x.apply(2), Math.PI/2, 0.00001);
    }
}