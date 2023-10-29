package edu.hw2.Task3.Interfaces;

import static edu.hw2.Task3.PopularCommandExecutor.logger;

public interface AutoCloseable {
    default void close() {
       logger.info("Закрытие соединения");
    }
}
