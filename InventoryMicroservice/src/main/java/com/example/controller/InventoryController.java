package com.example.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Optional;

import com.example.entity.Inventory;
import com.example.repository.InventoryRepository;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Delete;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Put;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

@ExecuteOn(TaskExecutors.IO)
@Controller("/")
public class InventoryController
{
    protected final InventoryRepository inventoryRepository;
    public InventoryController(InventoryRepository inventoryRepository)
        { this.inventoryRepository = inventoryRepository; }
    @Get
    public List<Inventory> getInventoryAll() { return inventoryRepository.findAll(); }
    @Get("/{id}")
    public Optional<Inventory> getInventory(Long id) { return inventoryRepository.findById(id); }
    @Put("/edit/{id}")
    public void updateInventory(@Body Inventory inventory, Long id)
        { inventoryRepository.update(id, inventory); }
    @Post
    public Inventory addInventory(@Body Inventory inventory) { return inventoryRepository.save(inventory); }
    @Delete("/{id}")
    public void deleteInventory(Long id) { inventoryRepository.deleteById(id); }

}
