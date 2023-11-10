package ru.ssau.tk.systemsl.sandbox.Lab2.io;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.ArrayTabulatedFunction;

import java.io.*;

public class ArrayTabulatedFunctionSerializationJson {
    public static void main(String[] args) {
        try(FileWriter fw_a = new FileWriter("output/serialized_json_array_function.json")) {
            BufferedWriter bfw_a = new BufferedWriter(fw_a);
            double[] x = {1, 2, 3, 4};
            double[] y = {2, 3, 4, 5};
            ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
            FunctionsIO.serializeJson(bfw_a, a);
        }
        catch (IOException er) {
            er.printStackTrace();
        }
        try(FileReader fr_a = new FileReader("output/serialized_json_array_function.json")) {
            BufferedReader bfr_a = new BufferedReader(fr_a);
            ArrayTabulatedFunction a = FunctionsIO.deserializeJson(bfr_a);
            System.out.println(a.toString());
        }
        catch (IOException er) {
            er.printStackTrace();
        }
    }
}
