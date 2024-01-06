package com.example.controller;

import java.util.List;
import java.util.Optional;

import com.example.entity.Book;
import com.example.repository.BooksRepository;
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
public class BooksController
{
    protected final BooksRepository booksRepository;
    public BooksController(BooksRepository booksRepository) { this.booksRepository = booksRepository; }
    @Get
    public List<Book> getBooks() { return booksRepository.findAll(); }
    @Get("/{id}")
    public Optional<Book> getBook(Long id) { return booksRepository.findById(id); }
    @Put("/edit/{id}")
    public void updateBook(@Body Book book, Long id) { booksRepository.update(id, book); }
    @Post
    public Book addBook(@Body Book book) { return booksRepository.save(book); }
    @Delete("/{id}")
    public void deleteBook(Long id) { booksRepository.deleteById(id); }

}
