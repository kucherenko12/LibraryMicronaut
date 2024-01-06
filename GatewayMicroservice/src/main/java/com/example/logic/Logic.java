package com.example.logic;

import com.example.entity.Book;
import com.example.entity.BookInInventory;
import com.example.entity.Inventory;

import java.util.Optional;

public class Logic
{
    public static Optional<BookInInventory> getBookInInventory(Long id)
    {
        try
        {
            Optional inventoryOptional = Requets.getInventory(id);
            Inventory inventory;
            Book book;
            if (inventoryOptional.isPresent())
            {
                inventory = (Inventory) inventoryOptional.get();
                Optional bookOptional = Requets.getBook(inventory.getBookId());
                if (bookOptional.isPresent())
                {
                    book = (Book) bookOptional.get();
                    BookInInventory bookInInventory = new BookInInventory(inventory.getId(),
                            book.getName(), book.getAuthor(), book.getYear(), inventory.getQuantity());
                    return Optional.of(bookInInventory);
                }
                else {return Optional.empty();}
            }
            else {return Optional.empty();}
        }
        catch (final Exception ex)
        {
            ex.printStackTrace();
            return Optional.empty();
        }
    }

    public static Optional<Book> getAllBooks(Long id)
    {
        try
        {
            //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            Inventory inventory = Requets.getInventory(id).get();
            Book book = Requets.getBook(inventory.getBookId()).get();

            return Requets.getBook(id);
        }
        catch (final Exception ex)
        {
            ex.printStackTrace();
            return Optional.empty();
        }
    }

}
