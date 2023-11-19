package ru.ssau.tk.systemsl.sandbox.Lab2.operations;

import ru.ssau.tk.systemsl.sandbox.Lab2.concurrent.IntegrateSectorTask;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.TabulatedFunction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LinearIntegralOperator implements IntegralOperator{
    public LinearIntegralOperator() {}
    public double integrate(TabulatedFunction function) throws ExecutionException, InterruptedException {
        int count = function.getCount() - 1;
        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService service = Executors.newFixedThreadPool(cores);
        List<Future> results = new ArrayList();
        for (int i = 0; i < count; i++) {
            results.add(service.submit(new IntegrateSectorTask(function, i, i+1)));
        }
        double integral = 0;
        for (Future<Double> f: results) {
            integral += f.get();
        }
        service.shutdown();
        return integral;
    }
}
