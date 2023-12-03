package edu.hw8.TestTask1;

import edu.hw8.Task1.Client;
import edu.hw8.Task1.TaskServer;
import org.junit.jupiter.api.Test;
import java.util.concurrent.CountDownLatch;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClientServer {

    @Test
    public void testClient(){
        TaskServer taskServer = new TaskServer();
        Client client = new Client();
        CountDownLatch serverReadyLatch = new CountDownLatch(1);
        new Thread(() -> {
            taskServer.run(serverReadyLatch);
        }).start();
        try {
            serverReadyLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        client.connect();
        assertEquals("Сервер: Не переходи на личности там, где их нет", client.sendMessage("Личности"));
        assertEquals("Сервер: Чем ниже интеллект, тем громче оскорбления", client.sendMessage("интеллект"));
        assertEquals("Сервер: Неизвестное ключевое слово: NULL", client.sendMessage("NULL"));
        client.disconnect();
        taskServer.interrupt();
    }

}
