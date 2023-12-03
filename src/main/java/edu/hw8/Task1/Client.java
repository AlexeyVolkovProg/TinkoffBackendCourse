package edu.hw8.Task1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

@SuppressWarnings("MagicNumber")
public class Client {
    public static Logger logger = (Logger) LogManager.getLogger(Client.class);
    private static final String SERVER_IP = "localhost";
    private static final int SERVER_PORT = 64139;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;

    public void connect() {
        try {
            socket = new Socket(SERVER_IP, SERVER_PORT);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }

    public void disconnect() {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }

    public String sendMessage(String message) {
        try {
            outputStream.write(message.getBytes());

            byte[] buffer = new byte[1024];
            int bytesRead = inputStream.read(buffer);

            if (bytesRead != -1) {
                return new String(buffer, 0, bytesRead);
            }
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
        return "";
    }
}
