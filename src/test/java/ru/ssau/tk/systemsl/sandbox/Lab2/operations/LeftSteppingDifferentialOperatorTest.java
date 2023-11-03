package ru.ssau.tk.systemsl.sandbox.Lab2.operations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.*;
class LeftSteppingDifferentialOperatorTest {

    @Test
    void derive() {
        SqrFunction sq = new SqrFunction();
        LeftSteppingDifferentialOperator op = new LeftSteppingDifferentialOperator(0.0000001);
        MathFunction dif = op.derive(sq);
        assertEquals(4, dif.apply(2), 0.01);
    }
}