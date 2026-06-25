package com.example;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class VoidExceptionTest {

    @Test
    void testVoidMethodException() {

        ExternalApi mockApi = mock(ExternalApi.class);

        doThrow(new RuntimeException("Error"))
                .when(mockApi)
                .sendData(anyString());

        assertThrows(RuntimeException.class, () -> {
            mockApi.sendData("Test");
        });

        verify(mockApi).sendData("Test");
    }
}