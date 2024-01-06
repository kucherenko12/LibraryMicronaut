package com.example.controller;

import java.util.Optional;

import com.example.entity.BookInInventory;
import com.example.logic.Logic;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.scheduling.TaskExecutors;
import io.micronaut.scheduling.annotation.ExecuteOn;

@ExecuteOn(TaskExecutors.IO)
@Controller("/")
public class GatewayController
{
    @Get("/{id}")
    public Optional<BookInInventory> getBook(Long id)
    {
        return Logic.getBookInInventory(id);
    }
}
