package ru.ssau.tk.systemsl.sandbox.Lab2.io;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.TabulatedFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.factory.LinkedListTabulatedFunctionFactory;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;

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
    }
}
