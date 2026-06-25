package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParameterizedLoggingExample {

    private static final Logger logger =
            LoggerFactory.getLogger(ParameterizedLoggingExample.class);

    public static void main(String[] args) {

        String user = "Alice";
        int age = 25;

        logger.info("User {} logged in", user);
        logger.info("User {} is {} years old", user, age);

        logger.warn("Checking warning for user {}", user);
        logger.error("Error occurred for user {}", user);
    }
}