package com.example;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class InteractionOrderTest {

    @Test
    void testInteractionOrder() {

        ExternalApi mockApi = mock(ExternalApi.class);

        mockApi.sendData("A");
        mockApi.sendData("B");

        InOrder order = inOrder(mockApi);

        order.verify(mockApi).sendData("A");
        order.verify(mockApi).sendData("B");
    }
}