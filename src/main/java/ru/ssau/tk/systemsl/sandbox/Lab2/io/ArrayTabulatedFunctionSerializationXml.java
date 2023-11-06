package ru.ssau.tk.systemsl.sandbox.Lab2.io;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.ArrayTabulatedFunction;

import java.io.*;

public class ArrayTabulatedFunctionSerializationXml {
    public static void main(String[] args) {
        try(FileWriter fw_a = new FileWriter("C:/Users/Dmitr/IdeaProjects/systemsl-sandbox/output/serialized_xml_array_function.xml")) {
            BufferedWriter bfw_a = new BufferedWriter(fw_a);
            double[] x = {1, 2, 3, 4};
            double[] y = {2, 3, 4, 5};
            ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
            FunctionsIO.serializeXml(bfw_a, a);
        }
        catch (IOException er) {
            er.printStackTrace();
        }
        try(FileReader fr_a = new FileReader("C:/Users/Dmitr/IdeaProjects/systemsl-sandbox/output/serialized_xml_array_function.xml")) {
            BufferedReader bfr_a = new BufferedReader(fr_a);
            ArrayTabulatedFunction a = FunctionsIO.deserializeXml(bfr_a);
            System.out.println(a.toString());
        }
        catch (IOException er) {
            er.printStackTrace();
        }
    }
}
