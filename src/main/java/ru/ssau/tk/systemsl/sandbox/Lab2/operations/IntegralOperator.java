package ru.ssau.tk.systemsl.sandbox.Lab2.operations;

import ru.ssau.tk.systemsl.sandbox.Lab2.functions.TabulatedFunction;

import java.util.concurrent.ExecutionException;

public interface IntegralOperator{
    double integrate(TabulatedFunction function) throws InterruptedException, ExecutionException;
}
