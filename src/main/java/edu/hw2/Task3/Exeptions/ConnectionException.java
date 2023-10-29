package edu.hw2.Task3.Exeptions;

public class ConnectionException extends RuntimeException {
    public ConnectionException() {
        super("Connection failed.");
    }

    public ConnectionException(String message) {
        super(message);
    }

}
