package edu.hw8.TestTask1;

import edu.hw8.Task1.ClientHandler;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestClientHandler {

    @Test
    public void testGetResponse_Lichnosti() {
        ClientHandler clientHandler = new ClientHandler(null);
        String response = clientHandler.getResponse("Личности");
        assertEquals("Сервер: Не переходи на личности там, где их нет", response);
    }

    @Test
    public void testGetResponse_Oskorbleniya() {
        ClientHandler clientHandler = new ClientHandler(null);
        String response = clientHandler.getResponse("Оскорбления");
        assertEquals("Сервер: Если твои противники перешли на личные оскорбления, " +
            "будь уверен(а) — твоя победа не за горами", response);
    }

}
