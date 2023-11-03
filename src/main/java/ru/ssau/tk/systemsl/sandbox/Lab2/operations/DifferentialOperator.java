package ru.ssau.tk.systemsl.sandbox.Lab2.operations;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.MathFunction;

public interface DifferentialOperator<T extends MathFunction> {
    T derive(T function);
}
