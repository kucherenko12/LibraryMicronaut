package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "inventory")
public class Inventory implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long bookId;
    private Long quantity;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getBookId() { return bookId; }
    public void setBookId(Long name) { this.bookId = bookId; }

    public Long getQuantity() { return quantity; }
    public void setQuantity(Long quantity) { this.quantity = quantity; }

    public Inventory(Long id, Long bookId, Long quantity) {
        super();
        this.id = id;
        this.bookId = bookId;
        this.quantity = quantity;
    }
    public Inventory() { super(); }
}

