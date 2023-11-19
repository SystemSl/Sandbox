package ru.ssau.tk.systemsl.sandbox.Lab2.operations;

import org.junit.jupiter.api.Test;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.UnitFunction;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class LinearIntegralOperatorTest {

    @Test
    void integrate() throws InterruptedException, ExecutionException {
        ArrayTabulatedFunction ar = new ArrayTabulatedFunction(new UnitFunction(), 0, 10, 1000000);
        LinearIntegralOperator op = new LinearIntegralOperator();
        assertEquals(10 , op.integrate(ar), 0.001);
    }
}