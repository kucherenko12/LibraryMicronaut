package com.example.repository.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.example.entity.Book;
import com.example.repository.BooksRepository;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.TransactionalAdvice;
import jakarta.inject.Singleton;

@Singleton
public class BooksRepositoryImpl implements BooksRepository
{
    private final EntityManager entityManager;
    public BooksRepositoryImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }
    @Override
    @ReadOnly
    public Optional<Book> findById(Long id)
    {
        return Optional.ofNullable(entityManager.find(Book.class, id));
    }
    @Override
    @TransactionalAdvice
    @Transactional
    public Book save(Book book)
    {
        entityManager.persist(book);
        return book;
    }
    @Override
    @TransactionalAdvice
    @Transactional
    public void deleteById(Long id)
    {
        findById(id).ifPresent(entityManager::remove);
    }
    @ReadOnly
    public List<Book> findAll()
    {
        return entityManager.
                createQuery("SELECT c FROM Book c").
                getResultList();
    }
    @Override
    @Transactional
    @TransactionalAdvice
    public void update(Long id, Book book)
    {
        Book bookToUpdate = entityManager.find(Book.class, id);
        if (null != bookToUpdate)
        {
            bookToUpdate.setName(book.getName());
            bookToUpdate.setAuthor(book.getAuthor());
            bookToUpdate.setYear(book.getYear());
        }
        else
        {
            throw new RuntimeException("No such book available");
        }
    }
}
