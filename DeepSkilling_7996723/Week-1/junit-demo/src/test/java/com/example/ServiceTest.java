package com.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    @Test
    void testProcessData() {

        Repository repo = () -> "Mock Data";

        Service service = new Service(repo);

        String result = service.processData();

        assertEquals("Processed Mock Data", result);
    }
}