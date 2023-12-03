package edu.hw8.Task1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import static edu.hw8.Task1.Client.logger;

@SuppressWarnings("MagicNumber")
public class ClientHandler implements Runnable {
    private static final String RESPONSE_PREFIX = "Сервер: ";
    private final Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = clientSocket.getInputStream();
             OutputStream outputStream = clientSocket.getOutputStream()) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                String message = new String(buffer, 0, bytesRead);
                logger.info("Получено сообщение от клиента: " + message);
                String response = getResponse(message);
                outputStream.write(response.getBytes());
            }

        } catch (IOException e) {
            logger.info(e.getMessage());
        }

    }

    public String getResponse(String keyword) {
        switch (keyword.toLowerCase()) {
            case "личности":
                return RESPONSE_PREFIX
                    + "Не переходи на личности там, где их нет";
            case "оскорбления":
                return RESPONSE_PREFIX + "Если твои противники перешли на личные оскорбления, "
                    +
                    "будь уверен(а) — твоя победа не за горами";
            case "интеллект":
                return RESPONSE_PREFIX
                    + "Чем ниже интеллект, тем громче оскорбления";
            default:
                return RESPONSE_PREFIX
                    + "Неизвестное ключевое слово: " + keyword;
        }
    }
}
