package com.example;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class ArgumentMatcherTest {

    @Test
    void testArgumentMatching() {

        ExternalApi mockApi = mock(ExternalApi.class);

        MyService service = new MyService(mockApi);

        service.processData("Hello");

        verify(mockApi).sendData(anyString());
    }
}