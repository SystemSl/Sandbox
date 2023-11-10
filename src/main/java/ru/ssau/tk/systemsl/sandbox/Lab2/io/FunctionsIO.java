package ru.ssau.tk.systemsl.sandbox.Lab2.io;
import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.xstream.XStream;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.*;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.factory.*;

public final class FunctionsIO {
    private FunctionsIO() {
        throw new UnsupportedOperationException();
    }
    public static void writeTabulatedFunction(BufferedWriter writer, TabulatedFunction function) throws IOException {
        PrintWriter printwriter = new PrintWriter(writer);
        printwriter.println(function.getCount());
        for (Point point : function) {
            printwriter.printf("%f %f\n", point.x, point.y);
        }
        writer.flush();
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
    public static void serialize(BufferedOutputStream stream, TabulatedFunction function) throws IOException {
        ObjectOutputStream objstream = new ObjectOutputStream(stream);
        objstream.writeObject(function);
        stream.flush();
    }
    public static TabulatedFunction deserialize(BufferedInputStream stream) throws IOException, ClassNotFoundException{
        ObjectInputStream objstream = new ObjectInputStream(stream);
        return (TabulatedFunction) objstream.readObject();
    }
    public static void serializeXml(BufferedWriter writer, ArrayTabulatedFunction function) throws IOException {
        XStream xs = new XStream();
        writer.write(xs.toXML(function));
        writer.flush();
    }
    public static ArrayTabulatedFunction deserializeXml(BufferedReader reader) {
        XStream xs = new XStream();
        xs.allowTypes(new Class[]{ArrayTabulatedFunction.class});
        return (ArrayTabulatedFunction) xs.fromXML(reader);
    }
    public static void writeTabulatedFunction(BufferedOutputStream outputStream, TabulatedFunction function) throws IOException {
        DataOutputStream dataoutputstream = new DataOutputStream(outputStream);
        dataoutputstream.writeInt(function.getCount());
        for (Point point : function) {
            dataoutputstream.writeDouble(point.x);
            dataoutputstream.writeDouble(point.y);
        }
        outputStream.flush();
    }
    public static TabulatedFunction readTabulatedFunction(BufferedInputStream inputStream, TabulatedFunctionFactory factory) throws IOException {
        DataInputStream datainputstream = new DataInputStream(inputStream);
        int count = 0;
        try {
            count = datainputstream.readInt();
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
        }
        double[] xValues = new double[count];
        double[] yValues = new double[count];
        for (int i = 0; i < count; i++) {
            double x = 0;
            double y = 0;
            x = datainputstream.readDouble();
            y = datainputstream.readDouble();
            xValues[i] = x;
            yValues[i] = y;
        }
        return factory.create(xValues, yValues);
    }
    public static void serializeJson(BufferedWriter writer, ArrayTabulatedFunction function) throws IOException {
        ObjectMapper om = new ObjectMapper();
        writer.write(om.writeValueAsString(function));
        writer.flush();
    }
    public static ArrayTabulatedFunction deserializeJson(BufferedReader reader) throws IOException {
        ObjectMapper om = new ObjectMapper();
        return om.readerFor(ArrayTabulatedFunction.class).readValue(reader);
    }
}
