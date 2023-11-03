package ru.ssau.tk.systemsl.sandbox.Lab2.operations;

import org.junit.jupiter.api.Test;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.MathFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.SqrFunction;

import static org.junit.jupiter.api.Assertions.*;

class MiddleSteppingDifferentialOperatorTest {

    @Test
    void derive() {
        SqrFunction sq = new SqrFunction();
        MiddleSteppingDifferentialOperator op = new MiddleSteppingDifferentialOperator(0.0000001);
        MathFunction dif = op.derive(sq);
        assertEquals(4, dif.apply(2), 0.01);
    }
}