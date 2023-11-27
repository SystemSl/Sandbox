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
import ru.ssau.tk.systemsl.sandbox.Lab2.operations.TabulatedFunctionOperationService;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.*;

@Controller
public class MainController {

    private Map<String, MathFunction> map = FunctionsMap.create();
    private TabulatedFunctionFactory fac = new ArrayTabulatedFunctionFactory();

    private TabulatedFunction func_1;
    private TabulatedFunction func_2;
    private TabulatedFunction func_3;

    private TabulatedFunction element_wise_result;

    private TabulatedFunction differ_result;

    private String upload_path = "C:/Users/Dmitr/Downloads/";

    private double[] ParseUsingTable(String str) throws java.text.ParseException {
        NumberFormat nf = NumberFormat.getInstance(Locale.US);
        String[] a = str.split(" ");
        double[] vals = new double[a.length];
        for (int i = 0; i < a.length; i++)
            vals[i] = nf.parse(a[i]).doubleValue();
        return vals;
    }

    private String TabulatedFunctionXAsString(TabulatedFunction func) {
        if (func != null) {
            StringBuilder result = new StringBuilder();
            for (Point p : func) {
                result.append(p.x).append(" ");
            }
            return result.toString();
        }
        return "";
    }

    private String TabulatedFunctionYAsString(TabulatedFunction func) {
        if (func != null) {
            StringBuilder result = new StringBuilder();
            for (Point p : func) {
                result.append(p.y).append(" ");
            }
            return result.toString();
        }
        return "";
    }

    @GetMapping("/")
    public String tabulatedfunction(Model model) {
        model.addAttribute("title", "Tabulated function");
        model.addAttribute("func_1_x", TabulatedFunctionXAsString(func_1));
        model.addAttribute("func_1_y", TabulatedFunctionYAsString(func_1));
        model.addAttribute("func_2_x", TabulatedFunctionXAsString(func_2));
        model.addAttribute("func_2_y", TabulatedFunctionYAsString(func_2));
        model.addAttribute("func_3_x", TabulatedFunctionXAsString(func_3));
        model.addAttribute("func_3_y", TabulatedFunctionYAsString(func_3));
        model.addAttribute("func_differ_x", TabulatedFunctionXAsString(differ_result));
        model.addAttribute("func_differ_y", TabulatedFunctionYAsString(differ_result));
        model.addAttribute("element_wise_result_x", TabulatedFunctionXAsString(element_wise_result));
        model.addAttribute("element_wise_result_y", TabulatedFunctionYAsString(element_wise_result));
        return "tabulatedfunction";
    }

    @PostMapping("/")
    public String controllerMethod(HttpServletRequest hsr, Model model) throws ParseException {
        if ((hsr.getParameter("xValues_table") != null) && (hsr.getParameter("yValues_table") != null)) {
            String xValues_table = hsr.getParameter("xValues_table");
            String yValues_table = hsr.getParameter("yValues_table");
            TabulatedFunction func_table = fac.create(ParseUsingTable(xValues_table), ParseUsingTable(yValues_table));
            System.out.println(func_table.toString());
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_table.bin")) {
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
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_function.bin")) {
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                FunctionsIO.serialize(bfos, func_table);
            } catch (IOException er) {
                er.printStackTrace();
            }
        } else if ((hsr.getParameter("source") != null) && (hsr.getParameter("xFrom") != null) && (hsr.getParameter("xTo") != null) && (hsr.getParameter("count") != null)) {
            MathFunction source = map.get(hsr.getParameter("source"));
            NumberFormat nf = NumberFormat.getInstance(Locale.US);
            double xFrom = nf.parse(hsr.getParameter("xFrom")).doubleValue();
            double xTo = nf.parse(hsr.getParameter("xTo")).doubleValue();
            int count = nf.parse(hsr.getParameter("count")).intValue();
            TabulatedFunction func_table = fac.create(source, xFrom, xTo, count);
            System.out.println(func_table.toString());
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_function.bin")) {
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                FunctionsIO.serialize(bfos, func_table);
            } catch (IOException er) {
                er.printStackTrace();
            }
        }

        if ((hsr.getParameter("xValues_table1") != null) && (hsr.getParameter("yValues_table1") != null)) {
            String xValues_table = hsr.getParameter("xValues_table1");
            String yValues_table = hsr.getParameter("yValues_table1");
            func_1 = fac.create(ParseUsingTable(xValues_table), ParseUsingTable(yValues_table));
            System.out.println(func_1.toString());
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_1.bin")) {
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                FunctionsIO.serialize(bfos, func_1);
            } catch (IOException er) {
                er.printStackTrace();
            }
        }

        if ((hsr.getParameter("source_1") != null) && (hsr.getParameter("xFrom_1") != null) && (hsr.getParameter("xTo_1") != null) && (hsr.getParameter("count_1") != null) && (hsr.getParameter("c_1") != null)) {
            NumberFormat nf = NumberFormat.getInstance(Locale.US);
            MathFunction source = new ConstantFunction(nf.parse(hsr.getParameter("c_1")).doubleValue());
            double xFrom = nf.parse(hsr.getParameter("xFrom_1")).doubleValue();
            double xTo = nf.parse(hsr.getParameter("xTo_1")).doubleValue();
            int count = nf.parse(hsr.getParameter("count_1")).intValue();
            func_1 = fac.create(source, xFrom, xTo, count);
            System.out.println(func_1.toString());
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_1.bin")) {
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                FunctionsIO.serialize(bfos, func_1);
            } catch (IOException er) {
                er.printStackTrace();
            }
        } else if ((hsr.getParameter("source_1") != null) && (hsr.getParameter("xFrom_1") != null) && (hsr.getParameter("xTo_1") != null) && (hsr.getParameter("count_1") != null)) {
            MathFunction source = map.get(hsr.getParameter("source_1"));
            NumberFormat nf = NumberFormat.getInstance(Locale.US);
            double xFrom = nf.parse(hsr.getParameter("xFrom_1")).doubleValue();
            double xTo = nf.parse(hsr.getParameter("xTo_1")).doubleValue();
            int count = nf.parse(hsr.getParameter("count_1")).intValue();
            func_1 = fac.create(source, xFrom, xTo, count);
            System.out.println(func_1.toString());
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_1.bin")) {
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                FunctionsIO.serialize(bfos, func_1);
            } catch (IOException er) {
                er.printStackTrace();
            }
        }

        if ((hsr.getParameter("xValues_table2") != null) && (hsr.getParameter("yValues_table2") != null)) {
            String xValues_table = hsr.getParameter("xValues_table2");
            String yValues_table = hsr.getParameter("yValues_table2");
            func_2 = fac.create(ParseUsingTable(xValues_table), ParseUsingTable(yValues_table));
            System.out.println(func_2.toString());
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_2.bin")) {
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                FunctionsIO.serialize(bfos, func_2);
            } catch (IOException er) {
                er.printStackTrace();
            }
        }

        if ((hsr.getParameter("source_2") != null) && (hsr.getParameter("xFrom_2") != null) && (hsr.getParameter("xTo_2") != null) && (hsr.getParameter("count_2") != null) && (hsr.getParameter("c_2") != null)) {
            NumberFormat nf = NumberFormat.getInstance(Locale.US);
            MathFunction source = new ConstantFunction(nf.parse(hsr.getParameter("c_2")).doubleValue());
            double xFrom = nf.parse(hsr.getParameter("xFrom_2")).doubleValue();
            double xTo = nf.parse(hsr.getParameter("xTo_2")).doubleValue();
            int count = nf.parse(hsr.getParameter("count_2")).intValue();
            func_2 = fac.create(source, xFrom, xTo, count);
            System.out.println(func_2.toString());
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_2.bin")) {
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                FunctionsIO.serialize(bfos, func_2);
            } catch (IOException er) {
                er.printStackTrace();
            }
        } else if ((hsr.getParameter("source_2") != null) && (hsr.getParameter("xFrom_2") != null) && (hsr.getParameter("xTo_2") != null) && (hsr.getParameter("count_2") != null)) {
            MathFunction source = map.get(hsr.getParameter("source_2"));
            NumberFormat nf = NumberFormat.getInstance(Locale.US);
            double xFrom = nf.parse(hsr.getParameter("xFrom_2")).doubleValue();
            double xTo = nf.parse(hsr.getParameter("xTo_2")).doubleValue();
            int count = nf.parse(hsr.getParameter("count_2")).intValue();
            func_2 = fac.create(source, xFrom, xTo, count);
            System.out.println(func_2.toString());
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_2.bin")) {
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                FunctionsIO.serialize(bfos, func_2);
            } catch (IOException er) {
                er.printStackTrace();
            }
        }

        if ((hsr.getParameter("xValues_table3") != null) && (hsr.getParameter("yValues_table3") != null)) {
            String xValues_table = hsr.getParameter("xValues_table3");
            String yValues_table = hsr.getParameter("yValues_table3");
            func_3 = fac.create(ParseUsingTable(xValues_table), ParseUsingTable(yValues_table));
            System.out.println(func_3.toString());
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_3.bin")) {
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                FunctionsIO.serialize(bfos, func_3);
            } catch (IOException er) {
                er.printStackTrace();
            }
        }

        if ((hsr.getParameter("source_3") != null) && (hsr.getParameter("xFrom_3") != null) && (hsr.getParameter("xTo_3") != null) && (hsr.getParameter("count_3") != null) && (hsr.getParameter("c_3") != null)) {
            NumberFormat nf = NumberFormat.getInstance(Locale.US);
            MathFunction source = new ConstantFunction(nf.parse(hsr.getParameter("c_3")).doubleValue());
            double xFrom = nf.parse(hsr.getParameter("xFrom_3")).doubleValue();
            double xTo = nf.parse(hsr.getParameter("xTo_3")).doubleValue();
            int count = nf.parse(hsr.getParameter("count_3")).intValue();
            func_3 = fac.create(source, xFrom, xTo, count);
            System.out.println(func_3.toString());
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_3.bin")) {
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                FunctionsIO.serialize(bfos, func_3);
            } catch (IOException er) {
                er.printStackTrace();
            }
        } else if ((hsr.getParameter("source_3") != null) && (hsr.getParameter("xFrom_3") != null) && (hsr.getParameter("xTo_3") != null) && (hsr.getParameter("count_3") != null)) {
            MathFunction source = map.get(hsr.getParameter("source_3"));
            NumberFormat nf = NumberFormat.getInstance(Locale.US);
            double xFrom = nf.parse(hsr.getParameter("xFrom_3")).doubleValue();
            double xTo = nf.parse(hsr.getParameter("xTo_3")).doubleValue();
            int count = nf.parse(hsr.getParameter("count_3")).intValue();
            func_3 = fac.create(source, xFrom, xTo, count);
            System.out.println(func_3.toString());
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_3.bin")) {
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                FunctionsIO.serialize(bfos, func_3);
            } catch (IOException er) {
                er.printStackTrace();
            }
        }

        if (hsr.getParameter("clear") != null) {
            func_1 = null;
            func_2 = null;
            func_3 = null;
            element_wise_result = null;
            differ_result = null;
        }

        if (hsr.getParameter("file_1") != null) {
            String file_1 = upload_path + hsr.getParameter("file_1");
            try (FileInputStream fis = new FileInputStream(file_1)) {
                BufferedInputStream bfis = new BufferedInputStream(fis);
                func_1 = FunctionsIO.deserialize(bfis);
            } catch (IOException er) {
                er.printStackTrace();
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
            }
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_1.bin")) {
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                FunctionsIO.serialize(bfos, func_1);
                System.out.println(func_1);
            } catch (IOException er) {
                er.printStackTrace();
            }
        }

        if (hsr.getParameter("file_2") != null) {
            String file_2 = upload_path + hsr.getParameter("file_2");
            try (FileInputStream fis = new FileInputStream(file_2)) {
                BufferedInputStream bfis = new BufferedInputStream(fis);
                func_2 = FunctionsIO.deserialize(bfis);
            } catch (IOException er) {
                er.printStackTrace();
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
            }
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_2.bin")) {
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                FunctionsIO.serialize(bfos, func_2);
                System.out.println(func_2);
            } catch (IOException er) {
                er.printStackTrace();
            }
        }

        if (hsr.getParameter("file_3") != null) {
            String file_3 = upload_path + hsr.getParameter("file_3");
            try (FileInputStream fis = new FileInputStream(file_3)) {
                BufferedInputStream bfis = new BufferedInputStream(fis);
                func_3 = FunctionsIO.deserialize(bfis);
            } catch (IOException er) {
                er.printStackTrace();
            } catch (ClassNotFoundException cnfe) {
                cnfe.printStackTrace();
            }
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_3.bin")) {
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                FunctionsIO.serialize(bfos, func_3);
                System.out.println(func_3);
            } catch (IOException er) {
                er.printStackTrace();
            }
        }

        if ((hsr.getParameter("xValues_result") != null) && (hsr.getParameter("yValues_op_1") != null) && (hsr.getParameter("yValues_op_2") != null) && (hsr.getParameter("operation") != null)) {
            String xValues_result = hsr.getParameter("xValues_result");
            String yValues_op_1 = hsr.getParameter("yValues_op_1");
            String yValues_op_2 = hsr.getParameter("yValues_op_2");
            String operation = hsr.getParameter("operation");
            TabulatedFunctionOperationService service = new TabulatedFunctionOperationService();
            func_1 = fac.create(ParseUsingTable(xValues_result), ParseUsingTable(yValues_op_1));
            func_2 = fac.create(ParseUsingTable(xValues_result), ParseUsingTable(yValues_op_2));
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_1.bin")) {
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                FunctionsIO.serialize(bfos, func_1);
            } catch (IOException er) {
                er.printStackTrace();
            }
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_2.bin")) {
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                FunctionsIO.serialize(bfos, func_2);
            } catch (IOException er) {
                er.printStackTrace();
            }
            switch(operation) {
                case ("+"):
                    element_wise_result = service.Addition(func_1, func_2);
                    break;
                case ("-"):
                    element_wise_result = service.Subtraction(func_1, func_2);
                    break;
                case ("*"):
                    element_wise_result = service.Multiplication(func_1, func_2);
                    break;
                case ("/"):
                    element_wise_result = service.Division(func_1, func_2);
                    break;
            }
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_result.bin")) {
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                FunctionsIO.serialize(bfos, element_wise_result);
            } catch (IOException er) {
                er.printStackTrace();
            }
        }

        if ((hsr.getParameter("xValues_differ") != null) && (hsr.getParameter("yValues_op_3") != null)) {
            String xValues_differ = hsr.getParameter("xValues_differ");
            String yValues_op_3 = hsr.getParameter("yValues_op_3");
            TabulatedDifferentialOperator op = new TabulatedDifferentialOperator();
            func_3 = fac.create(ParseUsingTable(xValues_differ), ParseUsingTable(yValues_op_3));
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_3.bin")) {
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                FunctionsIO.serialize(bfos, func_3);
            } catch (IOException er) {
                er.printStackTrace();
            }
            differ_result = op.derive(func_3);
            try (FileOutputStream fos = new FileOutputStream("src/main/resources/static/WebOutput/tabfunc_differ.bin")) {
                BufferedOutputStream bfos = new BufferedOutputStream(fos);
                FunctionsIO.serialize(bfos, differ_result);
            } catch (IOException er) {
                er.printStackTrace();
            }
        }

        if (hsr.getParameter("cur_fac") != null) {
            if (Objects.equals(hsr.getParameter("cur_fac"), "Array"))
                fac = new ArrayTabulatedFunctionFactory();
            else
                fac = new LinkedListTabulatedFunctionFactory();
        }

        if (hsr.getParameter("uploadpath") != null) {
            upload_path = hsr.getParameter("uploadpath");
        }

        return "tabulatedfunction";
    }
}
