package com.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ExceptionThrowerTest
{
    @Test
    void testException()
    {
        ExceptionThrower exceptionThrower = new ExceptionThrower();
        assertThrows(RuntimeException.class,exceptionThrower::throwException);
    }
}