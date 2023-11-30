package edu.hw7.Task1;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Напишите программу, в которой несколько потоков увеличивают общий счетчик на 1.
 * Напишите тесты: убедитесь, что счетчик потокобезопасен и использует классы Atomic для исключения состояния гонки.
 */
public class AtomicIncrement {
    public AtomicIncrement() {

    }

    private final AtomicInteger count = new AtomicInteger(0);

    public void increment() {
        count.incrementAndGet();
    }

    public int getValue() {
        return count.get();
    }
}
