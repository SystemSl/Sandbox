package ru.ssau.tk.systemsl.sandbox.Lab2.operations;
import java.util.Arrays;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.*;

public class TabulatedFunctionOperationService {
    public static Point[] asPoints(TabulatedFunction tabulatedFunction) {
        int i = 0;
        Point[] points = new Point[tabulatedFunction.getCount()];
        for(Point point : tabulatedFunction)
            points[i++] = point;
        return points;
    }
}
