package edu.hw2.Task3;

import edu.hw2.Task3.Exeptions.ConnectionException;
import edu.hw2.Task3.Interfaces.ConnectionManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class PopularCommandExecutor {
    private final ConnectionManager manager;
    private final int maxAttempts;
    Throwable cause;
    public static Logger logger = (Logger) LogManager.getLogger(PopularCommandExecutor.class);

    public PopularCommandExecutor(ConnectionManager manager, int maxAttempts) {
        this.manager = manager;
        this.maxAttempts = maxAttempts;
    }

    public void updatePackages() {
        tryExecute("apt update && apt upgrade -y");
    }

    void tryExecute(String command) {
        for (int i = 0; i < maxAttempts; i++) {
            try {
                manager.getConnection().execute(command);
                break;
            } catch (ConnectionException e) {
                cause = e.getCause();
                logger.info("Connection failed.");
            }
        }
    }
}
