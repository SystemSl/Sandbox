package ru.ssau.tk.systemsl.sandbox.Lab2.functions;
import java.util.Iterator;
import org.junit.jupiter.api.Test;
import ru.ssau.tk.systemsl.sandbox.Lab2.exceptions.ArrayIsNotSortedException;
import ru.ssau.tk.systemsl.sandbox.Lab2.exceptions.DifferentLengthOfArraysException;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTabulatedFunctionTest {

    @Test
    void getCount() {
        double[] x = {1, 2, 3, 4};
        double[] y = {1, 2, 3, 4};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.getCount(), 4);
    }

    @Test
    void getX() {
        double[] x = {1, 2, 3, 4};
        double[] y = {1, 2, 3, 4};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.getX(1), 2);
    }

    @Test
    void getY() {
        double[] x = {1, 2, 3, 4};
        double[] y = {1, 2, 3, 4};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.getY(2), 3);
    }

    @Test
    void setY() {
        double[] x = {1, 2, 3, 4};
        double[] y = {1, 2, 3, 4};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        a.setY(2,5);
        assertEquals(a.getY(2), 5);
    }

    @Test
    void leftBound() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.leftBound(), 1);
    }

    @Test
    void rightBound() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.rightBound(), 4);
    }

    @Test
    void indexOfX() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.indexOfX(3), 2);
    }

    @Test
    void indexOfY() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.indexOfY(3), 1);
    }

    @Test
    void floorIndexOfX1() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.floorIndexOfX(2.5), 1);
    }
    @Test
    void floorIndexOfX2() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.floorIndexOfX(5), 4);
    }
    @Test
    void floorIndexOfXWithInvalidX() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertThrows(IllegalArgumentException.class, () -> {
            a.floorIndexOfX(-1.0);
        });
    }

    @Test
    void interpolate() {
        double[] x = {1, 2, 3, 4};
        double[] y = {1, 2, 3, 4};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.interpolate(1.5, a.floorIndexOfX(1.5)), 1.5);
    }

    @Test
    void extrapolateLeft() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.extrapolateLeft(0), 1);
    }

    @Test
    void extrapolateRight() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.extrapolateLeft(5), 6);
    }

    //Insert tests
    @Test
    void testInsertExistingXValue() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        a.insert(3, 6);
        assertEquals(a.getCount(), 4);
        assertEquals(a.getY(2), 6);
    }

    @Test
    void testInsertNewXValue() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        a.insert(5, 6);
        assertEquals(a.getCount(), 5);
        assertEquals(a.getX(4), 5);
        assertEquals(a.getY(4), 6);
    }

    @Test
    void testInsertAtBeginning() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        a.insert(0.5, 1.5);
        assertEquals(a.getCount(), 5);
        assertEquals(a.getX(0), 0.5);
        assertEquals(a.getY(0), 1.5);
    }

    @Test
    void remove() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        a.remove(0);
        assertEquals(2, a.getX(0));
    }

    @Test
    void TFTest1() {
        SqrFunction s = new SqrFunction();
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(s, 0, 3, 100);
        assertEquals(9, a.getY(99), 0.00001);
    }

    @Test
    void TFTest2() {
        ConstantFunction s = new ConstantFunction(5);
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(s, 0, 3, 10);
        assertEquals(5, a.getY(5), 0.00001);
        ArrayTabulatedFunction b = new ArrayTabulatedFunction(a, -3, 3, 20);
        assertEquals(5, b.getY(5), 0.00001);
    }

    @Test
    void tS() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        assertEquals(a.toString(), "ArrayTabulatedFunction size = 4\n[1.0; 2.0]\n[2.0; 3.0]\n[3.0; 4.0]\n[4.0; 5.0]\n");
    }

    @Test
    void cl() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        ArrayTabulatedFunction b = (ArrayTabulatedFunction) a.clone();
        assertEquals(b.toString(), "ArrayTabulatedFunction size = 4\n[1.0; 2.0]\n[2.0; 3.0]\n[3.0; 4.0]\n[4.0; 5.0]\n");
    }

    @Test
    void eq() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        double[] x1 = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        ArrayTabulatedFunction b = (ArrayTabulatedFunction) a.clone();
        ArrayTabulatedFunction c = new ArrayTabulatedFunction(x1, y);
        LinkedListTabulatedFunction d = new LinkedListTabulatedFunction(x, y);
        ArrayTabulatedFunction e = null;
        assertEquals(a, b);
        assertNotEquals(a, c);
        assertNotEquals(a, e);
        assertEquals(a, d);
    }

    @Test
    void hC() {
        double[] x = {1, 2, 3, 4};
        double[] y = {2, 3, 4, 5};
        double[] x1 = {2, 3, 4, 5};
        ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
        ArrayTabulatedFunction b = (ArrayTabulatedFunction) a.clone();
        ArrayTabulatedFunction c = new ArrayTabulatedFunction(x1, y);
        assertEquals(a.hashCode(), b.hashCode());
        assertNotEquals(a.hashCode(), c.hashCode());
    }

    @Test
    public void testGetXWithInvalidIndex() {
        double[] x = {1.0, 2.0, 3.0};
        double[] y = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(x, y);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            function.getX(3);
        });
    }

    @Test
    public void testGetYWithInvalidIndex() {
        double[] x = {1.0, 2.0, 3.0};
        double[] y = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(x, y);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            function.getY(4);
        });
    }

    @Test
    public void testSetYWithInvalidIndex() {
        double[] x = {1.0, 2.0, 3.0};
        double[] y = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(x, y);

        assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            function.setY(1, 5.0);
            function.setY(3, 7.0);
        });
    }

    @Test
    public void testFloorIndexOfXWithInvalidX() {
        double[] x = {1.0, 2.0, 3.0};
        double[] y = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction function = new ArrayTabulatedFunction(x, y);

        assertThrows(IllegalArgumentException.class, () -> {
            function.floorIndexOfX(0.5);
        });
    }

    @Test
    public void ConstructorException() {
        double[] x1 = {1.0, 2.0, 3.0, 4.0};
        double[] x2 = {1.0, 2.0, 1.5};
        double[] y = {2.0, 4.0, 6.0};
        assertThrows(DifferentLengthOfArraysException.class, () ->{new ArrayTabulatedFunction(x1, y);});
        assertThrows(ArrayIsNotSortedException.class, () ->{new ArrayTabulatedFunction(x2, y);});
    }

    @Test
    public void IteratorWhileTest() {
        double[] x = {1.0, 2.0, 3.0};
        double[] y = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction f = new ArrayTabulatedFunction(x, y);
        Iterator<Point> iterator = f.iterator();
        int i = 0;
        while(iterator.hasNext()) {
            Point point = iterator.next();
            assertEquals(x[i], point.x);
            assertEquals(y[i++], point.y);
        }
    }

    @Test
    public void IteratorForEachTest() {
        double[] x = {1.0, 2.0, 3.0};
        double[] y = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction f = new ArrayTabulatedFunction(x, y);
        int i = 0;
        for (Point point : f) {
            assertEquals(x[i], point.x);
            assertEquals(y[i++], point.y);
        }
    }
}