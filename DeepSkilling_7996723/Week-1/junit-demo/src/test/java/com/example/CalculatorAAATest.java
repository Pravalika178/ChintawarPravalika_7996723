package com.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class CalculatorAAATest
{
    private Calculator calculator;
    @BeforeEach
    public void setUp()
    {
        calculator = new Calculator();
        System.out.println("Setup executed");
    }
    @AfterEach
    public void tearDown()
    {
        calculator = null;
        System.out.println("Teardown executed");
    }
    @Test
    public void testAdd()
    {
        int a = 10;
        int b = 5;
        int result = calculator.add(a, b);
        assertEquals(15, result);
    }

    @Test
    public void testSubtract() {

        // Arrange
        int a = 10;
        int b = 5;

        // Act
        int result = calculator.subtract(a, b);

        // Assert
        assertEquals(5, result);
    }
}