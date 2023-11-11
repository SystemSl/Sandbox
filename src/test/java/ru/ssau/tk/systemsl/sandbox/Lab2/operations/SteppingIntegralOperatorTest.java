package ru.ssau.tk.systemsl.sandbox.Lab2.operations;

import org.junit.jupiter.api.Test;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.ArrayTabulatedFunction;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class SteppingIntegralOperatorTest {

    @Test
    void integrate() throws InterruptedException, ExecutionException {
        ArrayTabulatedFunction ar = new ArrayTabulatedFunction(new double[]{0, 3, 6, 9, 12}, new double[] {0, 1, 1, 2, 2});
        SteppingIntegralOperator op = new SteppingIntegralOperator(0.01);
        assertEquals(15, op.integrate(ar), 0.00001);
    }
}