package edu.hw6.Task1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

/**
 * Задание 1
 * Реализуйте класс DiskMap, который представляет собой ассоциативный массив,
 * хранящий пары ключ-значение на жестком диске.
 * Класс должен реализовывать интерфейс Map String, String
 * Ключи и значения должны быть сохранены на жестком диске в файле в формате "ключ:значение".
 * Класс должен поддерживать сохранение и загрузку из файла на диске.
 */
public class DiskManager extends HashMap<String, String> {
    public static Logger logger = (Logger) LogManager.getLogger(DiskManager.class);
    File currentFile;
    public Path currentPathToFile;

    private DiskManager() {

    }

    public DiskManager(String path) throws IOException {
        if (checkThePath(Paths.get(path))) {
            this.readFromFile();
        } else {
            logger.info("Не удалось создать файл, из-да некорректного пути ");
        }
    }

    /**
     * Проверит путь и установит currentFile
     *
     * @param path путь, который будем проверять
     */
    public Boolean checkThePath(Path path) {
        if (Files.exists(path)) {
            logger.info("Путь до файла существует, как и сам файл");
            setCurrentFile(new File(path.toUri())); // устанавливаем файл
            setCurrentPathToFile(path);
            return true;
        } else {
            try {
                setCurrentFile(Files.createFile(path).toFile());
                setCurrentPathToFile(path);
                return true;
            } catch (IOException e) {
                logger.info("По данному пути не удалось ничего создать");
                return false;
            }
        }
    }

    /**
     * Метод позволяющий считать данные из файла и подгрузить их нашу Map
     */
    public void readFromFile() throws IOException {
        Pattern pattern = Pattern.compile("(?<key>.*):(?<value>.*)"); // паттерн для проверки
        List<String> strings = Files.readAllLines(this.currentPathToFile);
        for (String string : strings) {
            Matcher matcher = pattern.matcher(string);
            if (matcher.matches()) {
                this.put(matcher.group("key"), matcher.group("value"));
            }
        }
    }

    /**
     * Метод, которые будет подгружать нужные нам данные в файл, после обновления Map
     */
    public void loadToFile() {
        Set<Entry<String, String>> entrySet = this.entrySet();
        List<String> strings = new ArrayList<>();
        for (Entry<String, String> entry : this.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            strings.add(key + ":" + value);
        }
        try {
            Files.write(currentPathToFile, strings);
            logger.info("Данные успешно записаны в файл.");
        } catch (Exception e) {
            logger.info("Ошибка при записи в файл: " + e.getMessage());
        }
    }

    public void setCurrentFile(File currentFile) {
        this.currentFile = currentFile;
    }

    public void setCurrentPathToFile(Path currentPathToFile) {
        this.currentPathToFile = currentPathToFile;
    }

}
