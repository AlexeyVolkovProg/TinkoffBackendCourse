package edu.hw8.Task2;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

@SuppressWarnings("MagicNumber")
public class MyThreadPool implements ThreadPool {
    private final BlockingQueue<Runnable> taskQueue;
    private final Thread[] threads;
    private volatile boolean isRunning = false;

    public MyThreadPool(int poolSize) {
        this.taskQueue = new ArrayBlockingQueue<>(poolSize);
        this.threads = new Thread[poolSize];
    }

    @Override
    public void start() {
        if (!isRunning) {
            isRunning = true;

            for (int i = 0; i < threads.length; i++) {
                threads[i] = new Thread(() -> {
                    while (isRunning) {
                        try {
                            Runnable task = taskQueue.take();
                            task.run();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                });
                threads[i].start();
            }
        }
    }

    @Override
    public void execute(Runnable runnable) {
        try {
            taskQueue.put(runnable);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    public void close() {
        isRunning = false;
        for (Thread thread : threads) {
            thread.interrupt();
        }
    }
}
