package ru.ssau.tk.systemsl.sandbox.Lab2.functions;

import java.util.HashMap;
import java.util.Map;

public class FunctionsMap {
    public static Map<String, MathFunction> create() {
        Map<String, MathFunction> map = new HashMap<>();
        map.put("Const function", new ConstantFunction(0));
        map.put("Unit function", new UnitFunction());
        map.put("Zero function", new ZeroFunction());
        map.put("Square function", new SqrFunction());
        map.put("Atan + Actan", new SumAtanActanFunction());
        map.put("Asin + Acos", new SumAsinAcosFunction());
        map.put("Identity function", new IdentityFunction());
        return map;
    }
}
