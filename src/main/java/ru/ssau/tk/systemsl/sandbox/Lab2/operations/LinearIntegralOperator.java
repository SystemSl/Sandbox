package ru.ssau.tk.systemsl.sandbox.Lab2.operations;

import ru.ssau.tk.systemsl.sandbox.Lab2.concurrent.IntegrateSectorTask;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.TabulatedFunction;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class LinearIntegralOperator implements IntegralOperator{
    public LinearIntegralOperator() {}
    public double integrate(TabulatedFunction function) throws ExecutionException, InterruptedException {
        int count = function.getCount() - 1;
        ExecutorService service = Executors.newFixedThreadPool(count);
        Future<Double>[] results = new Future[count];
        for (int i = 0; i < count; i++) {
            results[i] = service.submit(new IntegrateSectorTask(function, function.getX(i), function.getX(i + 1)));
        }
        double integral = 0;
        for (int i = 0; i < count; i++) {
            integral += results[i].get();
        }
        service.shutdown();
        return integral;
    }
}
