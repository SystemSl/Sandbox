package ru.ssau.tk.systemsl.sandbox.Lab2.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.ArrayTabulatedFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.SqrFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.TabulatedFunction;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.factory.TabulatedFunctionFactory;
import ru.ssau.tk.systemsl.sandbox.Lab2.io.FunctionsIO;
import ru.ssau.tk.systemsl.sandbox.Lab2.operations.TabulatedDifferentialOperator;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

@Controller
public class MainController {

    private double[] xVal;

    private double[] yVal;

    private TabulatedFunction func_table;

    private TabulatedFunctionFactory fac = new ArrayTabulatedFunctionFactory();

    private double[] ParseString(String str) throws java.text.ParseException {
        NumberFormat nf = NumberFormat.getInstance(Locale.US);
        String[] a = str.split(" ");
        double[] vals = new double[a.length];
        for (int i = 0; i < a.length; i++)
            vals[i] = nf.parse(a[i]).doubleValue();
        return vals;
    }

    @GetMapping("/")
    public String tabulatedfunction(Model model) {
        model.addAttribute("title", "Tabulated function");
        return "tabulatedfunction";
    }

    @PostMapping("/")
    public String controllerMethod(HttpServletRequest hsr) throws ParseException {
        String xValues_table = hsr.getParameter("xValues_table");
        String yValues_table = hsr.getParameter("yValues_table");
        System.out.println(xValues_table);
        System.out.println(yValues_table);
        if (xValues_table != null) {
            xVal = ParseString(xValues_table);
        }
        if (yValues_table != null) {
            yVal = ParseString(yValues_table);
        }
        if (xVal != null && yVal != null) {
            func_table = fac.create(xVal, yVal);
            xVal = null;
            yVal = null;
            System.out.println(func_table.toString());
            try(FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_table.bin")) {
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                FunctionsIO.serialize(bfos, func_table);
            }
            catch (IOException er) {
                er.printStackTrace();
            }
        }
        return "redirect:/";
    }
}
