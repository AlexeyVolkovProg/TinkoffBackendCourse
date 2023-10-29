package edu.hw2.Task3.Connections;

import edu.hw2.Task3.Exeptions.ConnectionException;
import edu.hw2.Task3.Interfaces.Connection;
import java.util.Random;
import static edu.hw2.Task3.PopularCommandExecutor.logger;

public class FaultyConnection implements Connection {
    private static final double EXCEPTION_PROBABILITY = 0.4;

    @Override
    public void execute(String command) {
        Random random = new Random();
        if (random.nextDouble() < EXCEPTION_PROBABILITY) {
            close();
            throw new ConnectionException();
        } else {
            logger.info("Происходит выполнение команды: " + command);
            close();
        }
    }
}
