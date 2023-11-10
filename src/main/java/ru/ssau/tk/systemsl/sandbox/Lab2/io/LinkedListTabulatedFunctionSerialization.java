package ru.ssau.tk.systemsl.sandbox.Lab2.io;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.LinkedListTabulatedFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.SqrFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.TabulatedFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.operations.TabulatedDifferentialOperator;

import java.io.*;

public class LinkedListTabulatedFunctionSerialization {
    public static void main(String[] args) {
        try(FileOutputStream fos = new FileOutputStream("output/serialized_linked_list_functions.bin")) {
            BufferedOutputStream bfos = new BufferedOutputStream(fos);
            LinkedListTabulatedFunction ll = new LinkedListTabulatedFunction(new SqrFunction(),0, 10, 101);
            TabulatedDifferentialOperator op = new TabulatedDifferentialOperator();
            TabulatedFunction ll1 = op.derive(ll);
            TabulatedFunction ll2 = op.derive(ll1);
            FunctionsIO.serialize(bfos, ll);
            FunctionsIO.serialize(bfos, ll1);
            FunctionsIO.serialize(bfos, ll2);
        }
        catch (IOException er) {
            er.printStackTrace();
        }
        try(FileInputStream fis = new FileInputStream("output/serialized_linked_list_functions.bin")) {
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
