package com.example;

import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class VoidMethodTest {

    @Test
    void testVoidMethod() {

        ExternalApi mockApi = mock(ExternalApi.class);

        doNothing().when(mockApi).sendData(anyString());

        MyService service = new MyService(mockApi);

        service.processData("Test Data");

        verify(mockApi).sendData("Test Data");
    }
}