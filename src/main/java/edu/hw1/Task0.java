package edu.hw1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Task0 {
    private Task0() {

    }

    private static final Logger LOGGER = LogManager.getLogger(Task0.class);

    public static void printLog(String[] args) {
        LOGGER.info("Привет, мир!");
    }
}
