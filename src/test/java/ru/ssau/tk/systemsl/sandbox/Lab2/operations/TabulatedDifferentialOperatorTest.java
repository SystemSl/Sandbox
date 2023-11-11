package ru.ssau.tk.systemsl.sandbox.Lab2.operations;

import org.junit.jupiter.api.Test;
import ru.ssau.tk.systemsl.sandbox.Lab2.concurrent.SynchronizedTabulatedFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.*;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.factory.*;

import static org.junit.jupiter.api.Assertions.*;

class TabulatedDifferentialOperatorTest {

    @Test
    void testSetFactoryArray() {
        TabulatedFunctionFactory factory = new ArrayTabulatedFunctionFactory();
        TabulatedDifferentialOperator operator = new TabulatedDifferentialOperator();
        operator.setFactory(factory);
        assertSame(operator.getFactory(), factory);
    }

    @Test
    void testSetFactoryLList() {
        TabulatedFunctionFactory factory = new LinkedListTabulatedFunctionFactory();
        TabulatedDifferentialOperator operator = new TabulatedDifferentialOperator();
        operator.setFactory(factory);
        assertSame(operator.getFactory(), factory);
    }

    @Test
    void testDeriveArray() {
        TabulatedDifferentialOperator differentialOperator = new TabulatedDifferentialOperator();
        double[] xValues = {0.0, 1.0, 2.0, 3.0};
        double[] yValues = {0.0, 1.0, 4.0, 9.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);

        TabulatedFunction differentialFunction = differentialOperator.derive(function);
        assertEquals(differentialFunction.getY(0), 1.0);
        assertEquals(differentialFunction.getY(1), 3.0);
        assertEquals(differentialFunction.getY(2), 5.0);
        assertEquals(differentialFunction.getY(3), 5.0);
    }

    @Test
    void testDeriveLList() {
        LinkedListTabulatedFunctionFactory factory = new LinkedListTabulatedFunctionFactory();
        TabulatedDifferentialOperator differentialOperator = new TabulatedDifferentialOperator(factory);
        double[] xValues = {0.0, 1.0, 2.0, 3.0};
        double[] yValues = {0.0, 1.0, 4.0, 9.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(xValues, yValues);

        TabulatedFunction differentialFunction = differentialOperator.derive(function);
        assertEquals(differentialFunction.getY(0), 1.0);
        assertEquals(differentialFunction.getY(1), 3.0);
        assertEquals(differentialFunction.getY(2), 5.0);
        assertEquals(differentialFunction.getY(3), 5.0);
    }

    @Test
    void deriveSynchronouslyTest() {
        TabulatedDifferentialOperator differentialOperator = new TabulatedDifferentialOperator(new ArrayTabulatedFunctionFactory());
        ArrayTabulatedFunction array = new ArrayTabulatedFunction(new UnitFunction(), 1, 1000, 1000);
        SynchronizedTabulatedFunction syn_derived_array1 = differentialOperator.deriveSynchronously(array);
        SynchronizedTabulatedFunction syn_array = new SynchronizedTabulatedFunction(array);
        SynchronizedTabulatedFunction syn_derived_array2 = differentialOperator.deriveSynchronously(syn_array);
        for (Point p : syn_derived_array1) {
            assertEquals(0, p.y);
        }
        for (Point p : syn_derived_array2) {
            assertEquals(0, p.y);
        }
    }
}