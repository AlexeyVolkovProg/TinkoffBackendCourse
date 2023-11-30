package edu.hw7;

import edu.hw7.Task3.DatabaseLock;
import edu.hw7.Task3.RealPerson;
import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestTask3Lock {
    @Test
    void testConcurrentReadWrite() throws ExecutionException {
        DatabaseLock database = new DatabaseLock();
        int numThreads = 10;  // Количество потоков
        int numIterations = 100;
        CountDownLatch startLatch = new CountDownLatch(1);
        ExecutorService executor = Executors.newFixedThreadPool(numThreads);
        for (int i = 0; i < numThreads; i++) {
            executor.submit(() -> {
                startLatch.countDown();
                try {
                    startLatch.await();
                    for (int j = 0; j < numIterations; j++) {
                        RealPerson person = new RealPerson(j, "Person" + j, "Address" + j, "Phone" + j);
                        database.add(person);
                        database.delete(j);
                        database.findByName("Person" + j);
                        database.findByAddress("Address" + j);
                        database.findByPhone("Phone" + j);
                    }
                } catch (InterruptedException e) {
                    System.out.println("Произошло прерывание");
                }
                assertFalse(Thread.currentThread().isInterrupted()); // все отработало без прерываний
            });
        }
        executor.shutdown();
    }
}

