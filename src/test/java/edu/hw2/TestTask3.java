package edu.hw2;

import edu.hw2.Task3.Connections.FaultyConnection;
import edu.hw2.Task3.Connections.StableConnection;
import edu.hw2.Task3.Managers.DefaultConnectionManager;
import edu.hw2.Task3.Managers.FaultyConnectionManager;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestTask3 {
    @Test
    public void connectManagersTest() {
        // Проверка, что созданный объект FaultyConnectionManager возвращает FaultyConnection
        FaultyConnectionManager faultyManager = new FaultyConnectionManager();
        assertTrue(faultyManager.getConnection() instanceof FaultyConnection);

        // Проверка, что хотя бы один объект DefaultConnectionManager возвращает FaultyConnection
        boolean anyDefaultManagerReturnsFaulty = false;
        for (int i = 0; i < 10000; i++) {
            DefaultConnectionManager defaultManager = new DefaultConnectionManager();
            if (defaultManager.getConnection() instanceof FaultyConnection) {
                anyDefaultManagerReturnsFaulty = true;
                break;
            }
        }
        assertTrue(anyDefaultManagerReturnsFaulty);
    }

    @Test
    public void connectionsTest() {
        // Проверка, что StableConnection работает без выбрасывания исключений
        for (int i = 0; i < 10000; i++) {
            StableConnection connection = new StableConnection();
            assertDoesNotThrow(() -> connection.execute(""));
        }

        // Проверка, что FaultyConnection, когда-то выкинет исключение
        boolean someFaultyConnectionThrow = false;
        for (int i = 0; i < 10000; i++) {
            try {
                var connection = new FaultyConnection();
                connection.execute("something");
            } catch (Exception ignored) {
                someFaultyConnectionThrow = true;
                break;
            }
        }
        assertTrue(someFaultyConnectionThrow);
    }
}
