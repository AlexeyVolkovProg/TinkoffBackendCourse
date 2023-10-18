package edu.hw2.Task3.Managers;

import edu.hw2.Task3.Connections.FaultyConnection;
import edu.hw2.Task3.Interfaces.Connection;
import edu.hw2.Task3.Interfaces.ConnectionManager;
import static edu.hw2.Task3.PopularCommandExecutor.logger;

public class FaultyConnectionManager implements ConnectionManager {
    @Override
    public Connection getConnection() {
        logger.info("Используется Faulty Connection");
        return new FaultyConnection();
    }
}
