package com.example.repository;

import com.example.entity.Inventory;

import java.util.List;
import java.util.Optional;

public interface InventoryRepository
{
    Optional<Inventory> findById(Long id);

    Inventory save(Inventory inventory);

    void deleteById(Long id);

    List<Inventory> findAll();

    void update(Long id, Inventory inventory);

}
