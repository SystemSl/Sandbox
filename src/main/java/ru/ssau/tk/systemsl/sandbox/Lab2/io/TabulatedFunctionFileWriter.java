package ru.ssau.tk.systemsl.sandbox.Lab2.io;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.LinkedListTabulatedFunction;

import java.io.*;
public class TabulatedFunctionFileWriter {
    public static void main(String[] args) {
        try(FileWriter fw_a = new FileWriter("C:/Users/Dmitr/IdeaProjects/systemsl-sandbox/output/array_function.txt");
            FileWriter fw_ll = new FileWriter("C:/Users/Dmitr/IdeaProjects/systemsl-sandbox/output/linked_list_function.txt")) {
            BufferedWriter bfw_a = new BufferedWriter(fw_a);
            BufferedWriter bfw_ll = new BufferedWriter(fw_ll);
            double[] x = {1, 2, 3, 4};
            double[] y = {2, 3, 4, 5};
            ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
            LinkedListTabulatedFunction ll = new LinkedListTabulatedFunction(x, y);
            FunctionsIO.writeTabulatedFunction(bfw_a, a);
            FunctionsIO.writeTabulatedFunction(bfw_ll, ll);
        }
        catch (IOException er) {
            er.printStackTrace();
        }
    }
}
