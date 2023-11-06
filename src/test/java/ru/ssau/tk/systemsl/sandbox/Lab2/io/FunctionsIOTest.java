package ru.ssau.tk.systemsl.sandbox.Lab2.io;

import org.junit.AfterClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.SqrFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.TabulatedFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.systemsl.sandbox.Lab2.operations.TabulatedDifferentialOperator;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class FunctionsIOTest {
    private final ArrayTabulatedFunctionFactory factory = new ArrayTabulatedFunctionFactory();
    private final ArrayTabulatedFunction a = new ArrayTabulatedFunction(new double[]{1, 2, 3, 4}, new double[]{2, 3, 4, 5});
    @Test
    void writeTabulatedFunctionTest() {
        try(FileWriter fw_a = new FileWriter("temp/array_function.txt")) {
            BufferedWriter bfw_a = new BufferedWriter(fw_a);
            FunctionsIO.writeTabulatedFunction(bfw_a, a);
        }
        catch (IOException er) {
            er.printStackTrace();
        }
    }
    @Test
    void readTabulatedFunctionTest() {
        try(FileWriter fw_a = new FileWriter("temp/array_function.txt")) {
            BufferedWriter bfw_a = new BufferedWriter(fw_a);
            FunctionsIO.writeTabulatedFunction(bfw_a, a);
        }
        catch (IOException er) {
            er.printStackTrace();
        }
        try(FileReader fr_a = new FileReader("temp/array_function.txt")) {
            BufferedReader bfr_a = new BufferedReader(fr_a);
            ArrayTabulatedFunctionFactory atff = new ArrayTabulatedFunctionFactory();
            TabulatedFunction atf = FunctionsIO.readTabulatedFunction(bfr_a, atff);
            assertEquals(a, atf);
        }
        catch (IOException er) {
            er.printStackTrace();
        }
    }
    @Test
    void SerializationTest() {
        try(FileOutputStream fos = new FileOutputStream("temp/serialized_array_function.txt")) {
            BufferedOutputStream bfos = new BufferedOutputStream(fos);
            FunctionsIO.serialize(bfos, a);
        }
        catch (IOException er) {
            er.printStackTrace();
        }
    }
    @Test
    void DeserializationTest() {
        try(FileOutputStream fos = new FileOutputStream("temp/serialized_array_function.bin")) {
            BufferedOutputStream bfos = new BufferedOutputStream(fos);
            FunctionsIO.serialize(bfos, a);
        }
        catch (IOException er) {
            er.printStackTrace();
        }
        try(FileInputStream fis = new FileInputStream("temp/serialized_array_function.bin")) {
            BufferedInputStream bfis = new BufferedInputStream(fis);
            TabulatedFunction atf = FunctionsIO.deserialize(bfis);
            assertEquals(a, atf);
        }
        catch (IOException er) {
            er.printStackTrace();
        }
        catch (ClassNotFoundException cnfe) {
            cnfe.printStackTrace();
        }
    }
    @Test
    void SerializationXmlTest() {
        try(FileWriter fw_a = new FileWriter("temp/serialized_xml_array_function.xml")) {
            BufferedWriter bfw_a = new BufferedWriter(fw_a);
            FunctionsIO.serializeXml(bfw_a, a);
        }
        catch (IOException er) {
            er.printStackTrace();
        }
    }
    @Test
    void DeserializationXmlTest() {
        try(FileWriter fw_a = new FileWriter("temp/serialized_xml_array_function.xml")) {
            BufferedWriter bfw_a = new BufferedWriter(fw_a);
            FunctionsIO.serializeXml(bfw_a, a);
        }
        catch (IOException er) {
            er.printStackTrace();
        }
        try(FileReader fr_a = new FileReader("temp/serialized_xml_array_function.xml")) {
            BufferedReader bfr_a = new BufferedReader(fr_a);
            ArrayTabulatedFunction b = FunctionsIO.deserializeXml(bfr_a);
            assertEquals(a, b);
        }
        catch (IOException er) {
            er.printStackTrace();
        }
    }
    @AfterAll
    public static void after(){
        File dir = new File("temp");
        for(File file : dir.listFiles()){
            file.delete();
        }
    }
}