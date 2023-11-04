package ru.ssau.tk.systemsl.sandbox.Lab2.io;
import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.*;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.factory.*;

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

    public static TabulatedFunction readTabulatedFunction(BufferedReader reader, TabulatedFunctionFactory factory) throws IOException {
        int count = 0;
        try {
            count = Integer.parseInt(reader.readLine());
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        double[] xValues = new double[count];
        double[] yValues = new double[count];
        NumberFormat nf = NumberFormat.getInstance(Locale.forLanguageTag("ru"));
        for (int i = 0; i < count; i++) {
            String xy = "";
            try {
                xy = reader.readLine();
            }
            catch (IOException ioe) {
                ioe.printStackTrace();
            }
            String[] xay = xy.split(" ");
            try {
                xValues[i] = nf.parse(xay[0]).doubleValue();
                yValues[i] = nf.parse(xay[1]).doubleValue();
            }
            catch (ParseException pe) {
                throw new IOException(pe);
            }
        }
        return factory.create(xValues, yValues);
    }
}
