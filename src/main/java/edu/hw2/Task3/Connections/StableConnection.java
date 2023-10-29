package edu.hw2.Task3.Connections;

import edu.hw2.Task3.Interfaces.Connection;
import static edu.hw2.Task3.PopularCommandExecutor.logger;

public class StableConnection implements Connection {
    @Override
    public void execute(String command) {
        logger.info("Используется: " + this.getClass());
        logger.info("Происходит выполнение команды: " + command);
        close();
    }
}
