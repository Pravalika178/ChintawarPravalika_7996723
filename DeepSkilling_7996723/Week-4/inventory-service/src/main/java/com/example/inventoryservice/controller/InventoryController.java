package com.example.inventoryservice.controller;

import com.example.inventoryservice.client.ProductClient;
import com.example.inventoryservice.entity.Inventory;
import com.example.inventoryservice.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    InventoryService service;

    @Autowired
    ProductClient productClient;

    @GetMapping
    public List<Inventory> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Inventory save(
            @RequestBody Inventory inventory) {

        productClient.getProduct(
                inventory.getProductId());

        return service.save(inventory);
    }
}