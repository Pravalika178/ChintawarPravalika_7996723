package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorServiceTest {

    @Test
    void testAdd() {

        CalculatorService calculatorService = new CalculatorService();

        int result = calculatorService.add(2, 3);

        assertEquals(5, result);
    }
}