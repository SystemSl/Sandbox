package ru.ssau.tk.systemsl.sandbox.Lab2.controllers;

import jakarta.servlet.http.HttpServletRequest;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.*;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.factory.ArrayTabulatedFunctionFactory;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.factory.LinkedListTabulatedFunctionFactory;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.factory.TabulatedFunctionFactory;
import ru.ssau.tk.systemsl.sandbox.Lab2.io.FunctionsIO;
import ru.ssau.tk.systemsl.sandbox.Lab2.operations.TabulatedDifferentialOperator;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

@Controller
public class MainController {

    private Map<String, MathFunction> map = FunctionsMap.create();
    private TabulatedFunctionFactory fac = new ArrayTabulatedFunctionFactory();

    private double[] ParseUsingTable(String str) throws java.text.ParseException {
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
        if ((hsr.getParameter("xValues_table") != null) && (hsr.getParameter("yValues_table") != null)) {
            String xValues_table = hsr.getParameter("xValues_table");
            String yValues_table = hsr.getParameter("yValues_table");
            TabulatedFunction func_table = fac.create(ParseUsingTable(xValues_table), ParseUsingTable(yValues_table));
            System.out.println(func_table.toString());
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_1.bin")) {
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                FunctionsIO.serialize(bfos, func_table);
            } catch (IOException er) {
                er.printStackTrace();
            }
        }

        if ((hsr.getParameter("source") != null) && (hsr.getParameter("xFrom") != null) && (hsr.getParameter("xTo") != null) && (hsr.getParameter("count") != null) && (hsr.getParameter("c") != null)) {
            NumberFormat nf = NumberFormat.getInstance(Locale.US);
            MathFunction source = new ConstantFunction(nf.parse(hsr.getParameter("c")).doubleValue());
            double xFrom = nf.parse(hsr.getParameter("xFrom")).doubleValue();
            double xTo = nf.parse(hsr.getParameter("xTo")).doubleValue();
            int count = nf.parse(hsr.getParameter("count")).intValue();
            TabulatedFunction func_table = fac.create(source, xFrom, xTo, count);
            System.out.println(func_table.toString());
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_2.bin")) {
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                FunctionsIO.serialize(bfos, func_table);
            } catch (IOException er) {
                er.printStackTrace();
            }
        }
        else if ((hsr.getParameter("source") != null) && (hsr.getParameter("xFrom") != null) && (hsr.getParameter("xTo") != null) && (hsr.getParameter("count") != null)) {
            MathFunction source = map.get(hsr.getParameter("source"));
            NumberFormat nf = NumberFormat.getInstance(Locale.US);
            double xFrom = nf.parse(hsr.getParameter("xFrom")).doubleValue();
            double xTo = nf.parse(hsr.getParameter("xTo")).doubleValue();
            int count = nf.parse(hsr.getParameter("count")).intValue();
            TabulatedFunction func_table = fac.create(source, xFrom, xTo, count);
            System.out.println(func_table.toString());
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_2.bin")) {
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                FunctionsIO.serialize(bfos, func_table);
            } catch (IOException er) {
                er.printStackTrace();
            }
        }



        if (hsr.getParameter("cur_fac") != null)
            if (Objects.equals(hsr.getParameter("cur_fac"), "Array"))
                fac = new ArrayTabulatedFunctionFactory();
            else
                fac = new LinkedListTabulatedFunctionFactory();
        return "redirect:/";
    }
}
