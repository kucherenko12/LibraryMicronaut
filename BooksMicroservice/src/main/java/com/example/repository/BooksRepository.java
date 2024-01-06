package com.example.repository;

import com.example.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BooksRepository {
    Optional<Book> findById(Long id);

    Book save(Book book);

    void deleteById(Long id);

    List<Book> findAll();

    void update(Long id, Book book);

}
