package edu.hw8.TestTask2;

import edu.hw8.Task2.MyThreadPool;
import org.junit.jupiter.api.Test;

public class TestTreadPool {
    @Test
    public void firstTest() {
        MyThreadPool threadPool = new MyThreadPool(3);
        threadPool.start();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            threadPool.execute(() -> {
                long fibonacciResult = calculateFibonacci(index);
                System.out.println("Фибонначи(" + index + ") = " + fibonacciResult +
                    " посчитано потоком  " + Thread.currentThread().getId());
            });
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadPool.close();
    }

    private static long calculateFibonacci(int n) {
        if (n <= 1) {
            return n;
        } else {
            return calculateFibonacci(n - 1) + calculateFibonacci(n - 2);
        }
    }
}

