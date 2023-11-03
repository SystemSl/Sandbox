package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StrictAndUnmodifiableTabulatedFunctionsTest {

    @Test
    void testStrictWrappedUnmodifiable() {
        double[] x = {1.0, 2.0, 3.0};
        double[] y = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction arrayFunction = new ArrayTabulatedFunction(x, y);

        StrictTabulatedFunction strictFunction = new StrictTabulatedFunction(arrayFunction);
        UnmodifiableTabulatedFunction unmodifiableFunction = new UnmodifiableTabulatedFunction(strictFunction);

        assertThrows(UnsupportedOperationException.class, () -> unmodifiableFunction.apply(1.5));
        assertThrows(UnsupportedOperationException.class, () -> unmodifiableFunction.setY(0, 3.0));
    }

    @Test
    void testUnmodifiableWrappedStrict() {
        double[] x = {1.0, 2.0, 3.0};
        double[] y = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction arrayFunction = new ArrayTabulatedFunction(x, y);

        UnmodifiableTabulatedFunction unmodifiableFunction = new UnmodifiableTabulatedFunction(arrayFunction);
        StrictTabulatedFunction strictFunction = new StrictTabulatedFunction(unmodifiableFunction);

        assertThrows(UnsupportedOperationException.class, () -> strictFunction.apply(2.5));
        assertThrows(UnsupportedOperationException.class, () -> strictFunction.setY(1, 3.0));
    }
}
