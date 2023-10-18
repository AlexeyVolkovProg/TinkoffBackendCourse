package edu.hw2.Task3.Managers;

import edu.hw2.Task3.Connections.FaultyConnection;
import edu.hw2.Task3.Connections.StableConnection;
import edu.hw2.Task3.Interfaces.Connection;
import edu.hw2.Task3.Interfaces.ConnectionManager;
import java.util.Random;

public class DefaultConnectionManager implements ConnectionManager {
    final double faultyProbability = 0.4; // Вероятность получения проблемного соединения

    @Override
    public Connection getConnection() {
        Random random = new Random();
        if (random.nextDouble() < faultyProbability) {
            return new FaultyConnection();
        } else {
            return new StableConnection();
        }
    }
}
