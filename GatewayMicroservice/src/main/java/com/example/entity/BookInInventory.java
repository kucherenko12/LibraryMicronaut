package com.example.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class BookInInventory implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String author;
    private int year;
    private Long quantity;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public Long getQuantity() { return quantity; }
    public void setQuantity(Long quantity) { this.quantity = quantity; }

    public BookInInventory(Long id, String name, String author, int year, Long quantity)
    {
        super();
        this.id = id;
        this.name = name;
        this.author = author;
        this.year = year;
        this.quantity = quantity;
    }
    public BookInInventory() { super(); }
}