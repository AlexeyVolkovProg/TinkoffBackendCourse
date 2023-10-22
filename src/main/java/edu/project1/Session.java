package edu.project1;

import java.util.NoSuchElementException;
import java.util.Scanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;

public class Session {
    final String questionToTheUser = "Enter the length of the desired word";
    final String infoForUser = "Unfortunately, there are no words of this length. Enter a different length";

    final String earlyEndGame = "Early termination of the game";
    final String startGameText = "You have started a new game session!(so far, 5 or 6 words are available)";
    final String earlyFinal = "If you want to finish the game ahead of time, press cntrl+d";

    int lengthSearchWord;
    final int maxAttempts = 5;
    Scanner scanner = new Scanner(System.in);

    public static Logger logger = (Logger) LogManager.getLogger(Session.class);

    /**
     * Отвечает за старт игры и ее дальнейшее ведение
     */
    public void startNewGameSession() {
        try {
            logger.info(startGameText);
            logger.info(earlyFinal);
            lengthSearchWord = dataRequest();
            String searchWord = GameDictionary.getRandomWord(lengthSearchWord);
            StringManager.setProcessedString(searchWord);
            StringManager.createCharCountMap();
            int counterAttempts = maxAttempts;
            while (counterAttempts > 0) {
                char processedChar = readCharFromConsole();
                logger.info("You have selected a symbol: " + processedChar);
                if (StringManager.decreaseCharCount(processedChar) == 1) {
                    logger.info("You have successfully found the symbol!");
                } else if (StringManager.decreaseCharCount(processedChar) == 0) {
                    logger.info("This symbol has already been found in the past");
                } else if (StringManager.decreaseCharCount(processedChar) == -1) {
                    logger.info("Mistake! This symbol is not in the word");
                    counterAttempts -= 1;
                }
                StringManager.printProcessedString();
                if (StringManager.isSuccess()) {
                    logger.info("You win!!!");
                    break;
                } else if (counterAttempts == 0) {
                    logger.info("You lose(((");
                    break;
                }
            }
        } catch (NoSuchElementException e) {
            logger.info(earlyEndGame);
            System.exit(0);
        }
        scanner.close();
    }

    /**
     * Метод для считывания длины игрового слова от пользователя
     */
    public int dataRequest() {
        int length = 0;
        while (true) {
            logger.info(questionToTheUser);
            try {
                length = Integer.parseInt(scanner.nextLine());
                if (GameDictionary.getWordDictionary().containsKey(length)) {
                    break;
                } else {
                    logger.info(infoForUser);
                }
            } catch (NumberFormatException e) {
                logger.info("Error: Only integers can be entered\n");
            }
        }
        return length;
    }

    /**
     * Позволяет корректно считать символ с консоли
     */
    public char readCharFromConsole() {
        char userInput = '0'; // Инициализируем переменную значением по умолчанию
        logger.info("Enter character: ");
        try {
            String input = scanner.nextLine();
            if (input.length() == 1) {
                userInput = input.charAt(0);
            } else if (input.isBlank() || input.isEmpty()) {
                logger.info("You entered an empty string. Enter a character.");
                userInput = readCharFromConsole(); // Рекурсивный вызов для повторного ввода
            } else {
                logger.info("Enter only one character.");
                userInput = readCharFromConsole(); // Рекурсивный вызов для повторного ввода
            }
        } catch (NoSuchElementException e) {
            logger.info(earlyEndGame);
            System.exit(0);
        } catch (Exception e) {
            logger.info("Error: " + e.getMessage());
            logger.info("Repeat input.");
            userInput = readCharFromConsole(); // Рекурсивный вызов для повторного ввода
        }
        return userInput;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }
}
