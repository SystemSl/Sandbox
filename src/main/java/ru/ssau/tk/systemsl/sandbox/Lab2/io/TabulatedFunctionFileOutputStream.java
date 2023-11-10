package ru.ssau.tk.systemsl.sandbox.Lab2.io;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.LinkedListTabulatedFunction;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;

public class TabulatedFunctionFileOutputStream {
    public static void main(String[] args) {
        try(FileOutputStream fos_a = new FileOutputStream("output/array_function.bin");
            FileOutputStream fos_ll = new FileOutputStream("output/linked_list_function.bin")) {
            BufferedOutputStream bfos_a = new BufferedOutputStream(fos_a);
            BufferedOutputStream bfos_ll = new BufferedOutputStream(fos_ll);
            double[] x = {1, 2, 3, 4};
            double[] y = {2, 3, 4, 5};
            ArrayTabulatedFunction a = new ArrayTabulatedFunction(x, y);
            LinkedListTabulatedFunction ll = new LinkedListTabulatedFunction(x, y);
            FunctionsIO.writeTabulatedFunction(bfos_a, a);
            FunctionsIO.writeTabulatedFunction(bfos_ll, ll);
        }
        catch (IOException er) {
            er.printStackTrace();
        }
    }
}
