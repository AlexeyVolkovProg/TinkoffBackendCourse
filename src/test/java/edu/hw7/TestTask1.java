package edu.hw7;

import edu.hw7.Task1.AtomicIncrement;
import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTask1 {
    @Test
    public void testIncrement() throws InterruptedException {
        int numThreads = 10;
        int incrementsPerThread = 1000;
        AtomicIncrement atomicIncrement = new AtomicIncrement();
        ExecutorService executorService = Executors.newFixedThreadPool(numThreads);
        CountDownLatch latch = new CountDownLatch(numThreads);
        for (int i = 0; i < numThreads; i++) {
            executorService.execute(() -> {for (int j = 0; j < incrementsPerThread; j++) {
                    atomicIncrement.increment();
                }
                latch.countDown();
            });
        }
        latch.await();
        executorService.shutdown();
        assertEquals(numThreads * incrementsPerThread, atomicIncrement.getValue());
    }

}
