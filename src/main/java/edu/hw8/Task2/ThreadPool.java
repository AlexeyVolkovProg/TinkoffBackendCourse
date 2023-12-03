package edu.hw8.Task2;

@SuppressWarnings("MagicNumber")
public interface ThreadPool extends AutoCloseable {
    void start();

    void execute(Runnable runnable);
}
