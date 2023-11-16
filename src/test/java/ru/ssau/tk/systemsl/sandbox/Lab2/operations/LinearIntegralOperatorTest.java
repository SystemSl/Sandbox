package ru.ssau.tk.systemsl.sandbox.Lab2.operations;

import org.junit.jupiter.api.Test;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.ArrayTabulatedFunction;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.*;

class LinearIntegralOperatorTest {

    @Test
    void integrate() throws InterruptedException, ExecutionException {
        ArrayTabulatedFunction ar = new ArrayTabulatedFunction(new double[]{-3, 3, 6, 9, 12}, new double[] {-1, 1, 1, 2, 2});
        LinearIntegralOperator op = new LinearIntegralOperator();
        assertEquals(16.5 , op.integrate(ar));
    }
}