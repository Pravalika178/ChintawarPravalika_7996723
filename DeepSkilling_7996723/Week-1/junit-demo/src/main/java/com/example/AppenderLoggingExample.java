package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppenderLoggingExample {

    private static final Logger logger =
            LoggerFactory.getLogger(AppenderLoggingExample.class);

    public static void main(String[] args) {

        logger.debug("Debug message");
        logger.info("Info message");
        logger.warn("Warning message");
        logger.error("Error message");

        System.out.println("Check console + app.log file");
    }
}