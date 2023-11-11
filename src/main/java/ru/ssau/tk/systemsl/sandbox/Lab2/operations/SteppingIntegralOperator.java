package ru.ssau.tk.systemsl.sandbox.Lab2.operations;

import ru.ssau.tk.systemsl.sandbox.Lab2.concurrent.IntegrateSectorTask;
import ru.ssau.tk.systemsl.sandbox.Lab2.functions.TabulatedFunction;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SteppingIntegralOperator implements IntegralOperator{
    protected double step;
    public SteppingIntegralOperator(double step) {
        if (step <= 0 || Double.isInfinite(step) || Double.isNaN(step))
            throw new IllegalArgumentException("Incorrect step");
        else
            this.step = step;
    }
    public double getStep() {
        return step;
    }
    public void setStep(double step) {
        if (step <= 0 || Double.isInfinite(step) || Double.isNaN(step))
            throw new IllegalArgumentException("Incorrect step");
        else
            this.step = step;
    }
//    public double integrate(TabulatedFunction function) {
//        int count = (int) ((function.getX(function.getCount() - 1) - function.getX(0)) / step + 1);
//        for (int i = 0; i < count; i++) {
//            function.apply(function.getX(0) + step*i);
//        }
//        List<Thread> list_of_threads = new ArrayList<>();
//        double integral = 0;
//        for (int i = 0; i < count - 1; i++) {
//            integral += integrateSector(function.getY(i), function.getY(i+1));
//        }
//        return integral;
//    }
    public double integrate(TabulatedFunction function) throws ExecutionException, InterruptedException {
        int count = function.getCount() - 1;
        ExecutorService service = Executors.newFixedThreadPool(count);
        Future<Double>[] results = new Future[count];
        for (int i = 0; i < count; i++) {
            results[i] = service.submit(new IntegrateSectorTask(function, function.getX(i), function.getX(i + 1), step));
        }
        double integral = 0;
        for (int i = 0; i < count; i++) {
            integral += results[i].get();
        }
        service.shutdown();
        return integral;
    }
}
