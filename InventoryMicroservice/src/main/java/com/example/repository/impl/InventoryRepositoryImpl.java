package com.example.repository.impl;

import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.example.entity.Inventory;
import com.example.repository.InventoryRepository;
import io.micronaut.transaction.annotation.ReadOnly;
import io.micronaut.transaction.annotation.TransactionalAdvice;
import jakarta.inject.Singleton;

@Singleton
public class InventoryRepositoryImpl implements InventoryRepository
{
    private final EntityManager entityManager;
    public InventoryRepositoryImpl(EntityManager entityManager)
    {
        this.entityManager = entityManager;
    }
    @Override
    @ReadOnly
    public Optional<Inventory> findById(Long id)
    {
        return Optional.ofNullable(entityManager.find(Inventory.class, id));
    }
    @Override
    @TransactionalAdvice
    @Transactional
    public Inventory save(Inventory inventory)
    {
        entityManager.persist(inventory);
        return inventory;
    }
    @Override
    @TransactionalAdvice
    @Transactional
    public void deleteById(Long id)
    {
        findById(id).ifPresent(entityManager::remove);
    }
    @ReadOnly
    public List<Inventory> findAll()
    {
        return entityManager.
                createQuery("SELECT c FROM Inventory c").
                getResultList();
    }
    @Override
    @Transactional
    @TransactionalAdvice
    public void update(Long id, Inventory inventory)
    {
        Inventory inventoryToUpdate = entityManager.find(Inventory.class, id);
        if (null != inventoryToUpdate)
        {
            inventoryToUpdate.setBookId(inventory.getBookId());
            inventoryToUpdate.setQuantity(inventory.getQuantity());
        }
        else
        {
            throw new RuntimeException("No such inventory available");
        }
    }
}
