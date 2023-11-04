package ru.ssau.tk.systemsl.sandbox.Lab2.io;
import java.io.*;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.*;
public final class FunctionsIO {
    private FunctionsIO() {
        throw new UnsupportedOperationException();
    }
    public static void writeTabulatedFunction(BufferedWriter writer, TabulatedFunction function) {
        PrintWriter printwriter = new PrintWriter(writer);
        printwriter.println(function.getCount());
        for (Point point : function) {
            printwriter.printf("%f %f\n", point.x, point.y);
        }
        printwriter.flush();
    }
}
