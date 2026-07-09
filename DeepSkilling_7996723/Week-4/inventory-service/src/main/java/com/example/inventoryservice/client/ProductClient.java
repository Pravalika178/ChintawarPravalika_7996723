package com.example.inventoryservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        name = "product-service",
        url = "http://localhost:8083"
)
public interface ProductClient {

    @GetMapping("/products/{id}")
    Object getProduct(
            @PathVariable Long id
    );
}