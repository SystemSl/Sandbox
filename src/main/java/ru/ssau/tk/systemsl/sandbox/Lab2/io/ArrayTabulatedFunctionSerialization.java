package ru.ssau.tk.systemsl.sandbox.Lab2.io;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.*;
import ru.ssau.tk.systemsl.sandbox.Lab2.operations.TabulatedDifferentialOperator;

import java.io.*;

public class ArrayTabulatedFunctionSerialization {
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream("C:/Users/Dmitr/IdeaProjects/systemsl-sandbox/output/serialized_array_functions.bin")) {
            BufferedOutputStream bfos = new BufferedOutputStream(fos);
            ArrayTabulatedFunction a = new ArrayTabulatedFunction(new SqrFunction(),0, 10, 100);
            TabulatedDifferentialOperator op = new TabulatedDifferentialOperator();
            TabulatedFunction a1 = op.derive(a);
            TabulatedFunction a2 = op.derive(a1);
            FunctionsIO.serialize(bfos, a);
            FunctionsIO.serialize(bfos, a1);
            FunctionsIO.serialize(bfos, a2);
        }
        catch (IOException er) {
            er.printStackTrace();
        }
        try(FileInputStream fis = new FileInputStream("C:/Users/Dmitr/IdeaProjects/systemsl-sandbox/output/serialized_array_functions.bin")) {
            BufferedInputStream bfis = new BufferedInputStream(fis);
            System.out.println(FunctionsIO.deserialize(bfis).toString());
            System.out.println(FunctionsIO.deserialize(bfis).toString());
            System.out.println(FunctionsIO.deserialize(bfis).toString());
        }
        catch (IOException er) {
            er.printStackTrace();
        }
        catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }
}
