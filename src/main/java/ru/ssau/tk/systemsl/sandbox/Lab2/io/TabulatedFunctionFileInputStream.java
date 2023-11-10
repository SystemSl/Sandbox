package ru.ssau.tk.systemsl.sandbox.Lab2.io;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.TabulatedFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.factory.LinkedListTabulatedFunctionFactory;
import ru.ssau.tk.systemsl.sandbox.Lab2.operations.TabulatedDifferentialOperator;

import java.io.*;

public class TabulatedFunctionFileInputStream {
    public static void main(String[] args) {
        try(FileInputStream fis = new FileInputStream("input/binary_function.bin")) {
            BufferedInputStream bfis = new BufferedInputStream(fis);
            ArrayTabulatedFunctionFactory atff = new ArrayTabulatedFunctionFactory();
            TabulatedFunction atf = FunctionsIO.readTabulatedFunction(bfis, atff);
            System.out.println(atf.toString());
        }
        catch (IOException er) {
            er.printStackTrace();
        }
        try {
            System.out.println("Введите размер и значения функции");
            LinkedListTabulatedFunctionFactory lltff = new LinkedListTabulatedFunctionFactory();
            BufferedReader bisr = new BufferedReader(new InputStreamReader(System.in));
            TabulatedFunction lltf = FunctionsIO.readTabulatedFunction(bisr, lltff);
            TabulatedDifferentialOperator dif = new TabulatedDifferentialOperator();
            System.out.println(dif.derive(lltf).toString());
        }
        catch (IOException er) {
            er.printStackTrace();
        }
    }
}
