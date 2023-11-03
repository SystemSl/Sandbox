package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LinkedListTabulatedFunctionTest {

    private LinkedListTabulatedFunction function;

    @BeforeEach
    void setUp() {
        double[] xValues = {0.0, 1.0, 2.0, 3.0};
        double[] yValues = {0.0, 1.0, 4.0, 9.0};
        function = new LinkedListTabulatedFunction(xValues, yValues);
    }

    @Test
    void testGetX() {
        assertEquals(0.0, function.getX(0), 0.0001);
        assertEquals(1.0, function.getX(1), 0.0001);
        assertEquals(2.0, function.getX(2), 0.0001);
        assertEquals(3.0, function.getX(3), 0.0001);
    }

    @Test
    void testGetY() {
        assertEquals(0.0, function.getY(0), 0.0001);
        assertEquals(1.0, function.getY(1), 0.0001);
        assertEquals(4.0, function.getY(2), 0.0001);
        assertEquals(9.0, function.getY(3), 0.0001);
    }

    @Test
    void testSetY() {
        function.setY(1, 10.0);
        assertEquals(10.0, function.getY(1), 0.0001);
    }

    @Test
    void testIndexOfX() {
        assertEquals(0, function.indexOfX(0.0));
        assertEquals(1, function.indexOfX(1.0));
        assertEquals(2, function.indexOfX(2.0));
        assertEquals(3, function.indexOfX(3.0));
        assertEquals(-1, function.indexOfX(4.0));
    }

    @Test
    void testIndexOfY() {
        assertEquals(0, function.indexOfY(0.0));
        assertEquals(1, function.indexOfY(1.0));
        assertEquals(2, function.indexOfY(4.0));
        assertEquals(3, function.indexOfY(9.0));
        assertEquals(-1, function.indexOfY(10.0));
    }

    @Test
    void testFloorIndexOfX() {
        assertEquals(0, function.floorIndexOfX(0.0));
        assertEquals(1, function.floorIndexOfX(1.5));
        assertEquals(2, function.floorIndexOfX(2.5));
        assertEquals(4, function.floorIndexOfX(3.5));
        assertEquals(0, function.floorIndexOfX(0.5));
    }

    @Test
    void testLeftBound() {
        assertEquals(0.0, function.leftBound(), 0.0001);
    }

    @Test
    void testRightBound() {
        assertEquals(3.0, function.rightBound(), 0.0001);
    }

    @Test
    void testInterpolate() {
        assertEquals(0.5, function.interpolate(0.5, 0), 0.0001);
        assertEquals(2.5, function.interpolate(1.5, 1), 0.0001);
        assertEquals(6.5, function.interpolate(2.5, 2), 0.0001);
    }

    @Test
    void testExtrapolateLeft() {
        assertEquals(-1.0, function.extrapolateLeft(-1.0), 0.0001);
    }

    @Test
    void testExtrapolateRight() {
        assertEquals(14.0, function.extrapolateRight(4.0), 0.0001);
        assertEquals(11.5, function.extrapolateRight(3.5), 0.0001);
    }

    @Test
    void testApplyInsideRange() {
        assertEquals(0.0, function.apply(0.0), 0.0001);
        assertEquals(1.0, function.apply(1.0), 0.0001);
        assertEquals(4.0, function.apply(2.0), 0.0001);

        // Interpolation
        assertEquals(0.5, function.apply(0.5), 0.0001);
        assertEquals(2.5, function.apply(1.5), 0.0001);
        assertEquals(6.5, function.apply(2.5), 0.0001);
    }

    @Test
    void testApplyOutsideRange() {
        assertEquals(-1.0, function.apply(-1.0));
        assertEquals(14.0, function.apply(4.0), 0.0001);
    }

    @Test
    void testApplyBetweenValues() {
        assertEquals(0.25, function.apply(0.25), 0.0001);
        assertEquals(7.75, function.apply(2.75), 0.0001);
    }

    @Test
    void testApplyEqualXValues() {
        double[] xValues = {0.0, 0.0, 1.0, 1.0, 2.0, 2.0};
        double[] yValues = {0.0, 1.0, 2.0, 3.0, 4.0, 5.0};
        LinkedListTabulatedFunction equalXFunction = new LinkedListTabulatedFunction(xValues, yValues);

        assertEquals(0.0, equalXFunction.apply(0.0), 0.0001);
        assertEquals(2.0, equalXFunction.apply(1.0), 0.0001);
        assertEquals(4.0, equalXFunction.apply(2.0), 0.0001);
    }

    @Test
    void TestInsertInTheBegin() {
        function.insert(-1, -2);
        assertEquals(-2, function.getY(0));
    }

    @Test
    void TestInsertInTheEnd() {
        function.insert(10, 5);
        assertEquals(5, function.getY(4));
    }

    @Test
    void TestInsertInside() {
        function.insert(2.5, 5);
        assertEquals(5, function.getY(3));
    }

    @Test
    void TestRemoveX0() {
        function.remove(0);
        assertEquals(1, function.getX(0));
        assertEquals(2, function.getX(1));
        assertEquals(3, function.getX(2));
    }

    @Test
    void TestRemoveX2() {
        function.remove(1);
        assertEquals(0, function.getX(0));
        assertEquals(2, function.getX(1));
        assertEquals(3, function.getX(2));
    }

    @Test
    void TestRemoveX3() {
        function.remove(3);
        assertEquals(0, function.getX(0));
        assertEquals(1, function.getX(1));
        assertEquals(2, function.getX(2));
    }

    @Test
    void TFTest1() {
        SqrFunction s = new SqrFunction();
        LinkedListTabulatedFunction a = new LinkedListTabulatedFunction(s, 0, 3, 100);
        assertEquals(9, a.getY(99), 0.00001);
    }

    @Test
    void TFTest2() {
        ConstantFunction s = new ConstantFunction(5);
        LinkedListTabulatedFunction a = new LinkedListTabulatedFunction(s, 0, 3, 10);
        assertEquals(5, a.getY(5), 0.00001);
        LinkedListTabulatedFunction b = new LinkedListTabulatedFunction(a, -3, 3, 20);
        assertEquals(5, b.getY(5), 0.00001);
    }

    @Test
    public void testNodeToString() {
        LinkedListTabulatedFunction.Node node = new LinkedListTabulatedFunction.Node(1.1, -5.5);
        String expected = "(1.1; -5.5)";
        assertEquals(expected, node.toString());
    }

    @Test
    public void testNodeEquals() {
        LinkedListTabulatedFunction.Node node1 = new LinkedListTabulatedFunction.Node(1.1, -5.5);
        LinkedListTabulatedFunction.Node node2 = new LinkedListTabulatedFunction.Node(1.1, -5.5);
        LinkedListTabulatedFunction.Node node3 = new LinkedListTabulatedFunction.Node(1.2, -5.5);
        assertEquals(node1, node2);
        assertNotEquals(node1, node3);
    }

    @Test
    public void testNodeHashCode() {
        LinkedListTabulatedFunction.Node node1 = new LinkedListTabulatedFunction.Node(1.1, -5.5);
        LinkedListTabulatedFunction.Node node2 = new LinkedListTabulatedFunction.Node(1.1, -5.5);
        LinkedListTabulatedFunction.Node node3 = new LinkedListTabulatedFunction.Node(1.2, -5.5);
        assertEquals(node2.hashCode(), node1.hashCode());
        assertNotEquals(node3.hashCode(), node1.hashCode());
    }

    @Test
    public void testNodeClone() {
        LinkedListTabulatedFunction.Node node = new LinkedListTabulatedFunction.Node(1.1, -5.5);
        LinkedListTabulatedFunction.Node clonedNode = (LinkedListTabulatedFunction.Node) node.clone();
        assertNotSame(node, clonedNode);
        assertEquals(node, clonedNode);
    }

    @Test
    void toStringTest() {
        assertEquals("(0.0; 0.0) (1.0; 1.0) (2.0; 4.0) (3.0; 9.0)", function.toString());
    }

    @Test
    public void testEquals() {
        LinkedListTabulatedFunction function1 = new LinkedListTabulatedFunction(new double[]{0.0, 1.0, 2.0, 3.0}, new double[]{0.0, 1.0, 4.0, 9.0});
        LinkedListTabulatedFunction function2 = new LinkedListTabulatedFunction(new double[]{2.0, 3.0, 4.0, 5.0}, new double[]{10.0, 20.0, 40.0, 50.0});
        ArrayTabulatedFunction function3 = new ArrayTabulatedFunction(new double[]{0.0, 1.0, 2.0, 3.0}, new double[]{0.0, 1.0, 4.0, 9.0});
        LinkedListTabulatedFunction function4 = null;
        assertEquals(function, function1);
        assertNotEquals(function, function2);
        assertEquals(function, function3);
        assertNotEquals(function, function4);
    }

    @Test
    public void testHashCode() {
        LinkedListTabulatedFunction function1 = new LinkedListTabulatedFunction(new double[]{0.0, 1.0, 2.0, 3.0}, new double[]{0.0, 1.0, 4.0, 9.0});
        LinkedListTabulatedFunction function2 = new LinkedListTabulatedFunction(new double[]{2.0, 3.0, 4.0, 5.0}, new double[]{10.0, 20.0, 40.0, 50.0});
        assertEquals(function.hashCode(), function1.hashCode());
        assertNotEquals(function.hashCode(), function2.hashCode());
    }

    @Test
    public void testClone() {
        LinkedListTabulatedFunction clonedFunction = (LinkedListTabulatedFunction) function.clone();
        assertNotSame(function, clonedFunction);
        assertEquals(function, clonedFunction);
    }

    @Test
    public void testGetXWithInvalidIndex() {
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(new double[] {1.0, 2.0, 3.0}, new double[] {2.0, 4.0, 6.0});
        assertThrows(IllegalArgumentException.class, () -> {
            function.getX(3);
        });
    }

    @Test
    public void testGetYWithInvalidIndex() {
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(new double[] {1.0, 2.0, 3.0}, new double[] {2.0, 4.0, 6.0});
        assertThrows(IllegalArgumentException.class, () -> {
            function.getY(4);
        });
    }

    @Test
    public void testSetYWithInvalidIndex() {
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(new double[] {1.0, 2.0, 3.0}, new double[] {2.0, 4.0, 6.0});
        assertThrows(IllegalArgumentException.class, () -> {
            function.setY(1, 5.0);
            function.setY(3, 7.0);
        });
    }

    @Test
    public void testFloorIndexOfXWithInvalidX() {
        LinkedListTabulatedFunction function = new LinkedListTabulatedFunction(new double[] {1.0, 2.0, 3.0}, new double[] {2.0, 4.0, 6.0});
        assertThrows(IllegalArgumentException.class, () -> {
            function.floorIndexOfX(0.5);
        });
    }
}