package ru.ssau.tk.systemsl.sandbox.Lab2.operations;

import org.junit.jupiter.api.Test;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.Point;

import static org.junit.jupiter.api.Assertions.*;

class TabulatedFunctionOperationServiceTest {

    @Test
    void asPoints() {
        double[] x = {1.0, 2.0, 3.0};
        double[] y = {2.0, 4.0, 6.0};
        ArrayTabulatedFunction f = new ArrayTabulatedFunction(x, y);
        Point[] points1 = new Point[f.getCount()];
        int i = 0;
        for(Point point : f)
            points1[i++] = point;
        Point[] points2 = TabulatedFunctionOperationService.asPoints(f);
        for(i = 0; i < 3; i++) {
            assertEquals(points1[i].x, points2[i].x);
            assertEquals(points1[i].y, points2[i].y);
        }
    }
}