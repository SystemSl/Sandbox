package ru.ssau.tk.systemsl.sandbox.Lab2.io;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.factory.*;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.*;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;

public class TabulatedFunctionFileReader {
    public static void main(String[] args) {
        try(FileReader fr_a = new FileReader("C:/Users/Dmitr/IdeaProjects/systemsl-sandbox/input/function.txt");
            FileReader fr_ll = new FileReader("C:/Users/Dmitr/IdeaProjects/systemsl-sandbox/input/function.txt")) {
            BufferedReader bfr_a = new BufferedReader(fr_a);
            BufferedReader bfr_ll = new BufferedReader(fr_ll);
            ArrayTabulatedFunctionFactory atff = new ArrayTabulatedFunctionFactory();
            LinkedListTabulatedFunctionFactory lltff = new LinkedListTabulatedFunctionFactory();
            TabulatedFunction atf = FunctionsIO.readTabulatedFunction(bfr_a, atff);
            TabulatedFunction lltf = FunctionsIO.readTabulatedFunction(bfr_ll, lltff);
            System.out.println(atf.toString());
            System.out.println(lltf.toString());
        }
        catch (IOException er) {
            er.printStackTrace();
        }
    }
}
