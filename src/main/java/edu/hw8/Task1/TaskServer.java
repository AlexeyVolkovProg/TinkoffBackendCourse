package edu.hw8.Task1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import static edu.hw8.Task1.Client.logger;

@SuppressWarnings("MagicNumber")
public class TaskServer extends Thread {
    private static final int PORT = 1010;
    private static final int MAX_CONNECTIONS = 5;

    public void run(CountDownLatch countDownLatch) {
        ExecutorService executor = Executors.newFixedThreadPool(MAX_CONNECTIONS);
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            logger.info("Сервер запущен. Ожидание подключений...");
            countDownLatch.countDown();
            while (true) {
                Socket clientSocket = serverSocket.accept();
                logger.info("Новое подключение: " + clientSocket);
                executor.execute(new ClientHandler(clientSocket));
            }
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
    }
}
