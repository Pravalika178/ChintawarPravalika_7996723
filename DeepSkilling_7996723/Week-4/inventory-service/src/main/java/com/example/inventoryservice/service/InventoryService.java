package com.example.inventoryservice.service;

import com.example.inventoryservice.entity.Inventory;
import com.example.inventoryservice.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    InventoryRepository repository;

    public List<Inventory> getAll() {
        return repository.findAll();
    }

    public Inventory save(
            Inventory inventory) {

        return repository.save(inventory);
    }
}