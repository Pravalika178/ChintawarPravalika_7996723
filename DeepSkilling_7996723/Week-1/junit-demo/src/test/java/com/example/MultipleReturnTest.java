package com.example;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class MultipleReturnTest {

    @Test
    void testMultipleReturns() {

        ExternalApi mockApi = mock(ExternalApi.class);

        when(mockApi.getData())
                .thenReturn("First")
                .thenReturn("Second")
                .thenReturn("Third");

        assertEquals("First", mockApi.getData());
        assertEquals("Second", mockApi.getData());
        assertEquals("Third", mockApi.getData());
    }
}