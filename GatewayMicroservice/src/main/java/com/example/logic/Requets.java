package com.example.logic;

import com.example.entity.Book;
import com.example.entity.Inventory;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;

public class Requets
{
    public static Optional<Book> getBook(Long id)
    {
        try
        {
            final HttpURLConnection connection = Support.ConstuctHttpURLConnection
                    ("http://localhost:8080/books/" + id, "GET");
            //int code = connection.getResponseCode();

            try (final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream())))
            {
                String inputLine;
                final StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null)
                {
                    content.append(inputLine);
                }
                Book book = new Gson().fromJson(content.toString(), Book.class);
                return Optional.of(book);
            }
            catch (final Exception ex)
            {
                ex.printStackTrace();
                return Optional.empty();
            }
        }
        catch (final Exception ex)
        {
            ex.printStackTrace();
            return Optional.empty();
        }
    }

//===================================================================================

    public static Optional<Inventory> getInventory(Long id)
    {
        try
        {
            final HttpURLConnection connection = Support.ConstuctHttpURLConnection
                    ("http://localhost:8080/inventory/" + id, "GET");
            //int code = connection.getResponseCode();

            try (final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream())))
            {
                String inputLine;
                final StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null)
                {
                    content.append(inputLine);
                }
                Inventory inventory = new Gson().fromJson(content.toString(), Inventory.class);
                return Optional.of(inventory);
            }
            catch (final Exception ex)
            {
                ex.printStackTrace();
                return Optional.empty();
            }
        }
        catch (final Exception ex)
        {
            ex.printStackTrace();
            return Optional.empty();
        }
    }

//---------------------------------------------------------------------------

    public static Optional<Book> getAllBooks(Long id)
    {
        try
        {
            final HttpURLConnection connection = Support.ConstuctHttpURLConnection
                    ("http://localhost:8080/books/", "GET");

            int code = connection.getResponseCode();
            int code1 = code;

            try (final BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream())))
            {
                String inputLine;
                final StringBuilder content = new StringBuilder();
                while ((inputLine = in.readLine()) != null)
                {
                    content.append(inputLine);
                }

                ObjectMapper objectMapper = new ObjectMapper();
                //List<Book> participantJsonList =
                //        objectMapper.readValue(content.toString(), new TypeReference<List<Book>>(){});
                //Book[] studentList = Arrays.asList(
                //        objectMapper.readValue(new String[] {content.toString()}, Book.class));
                //return content.toString());
                //String aaa = participantJsonList.toString();

                Book book = new Gson().fromJson(content.toString(), Book.class);

                Gson gson = new Gson();
                Type listType = new TypeToken<ArrayList<Book>>() {}.getType();
                ArrayList<Book> books = new Gson().fromJson(content.toString() , listType);
                return Optional.of(new Book(3L, "a", "a", 1950));
            }
            catch (final Exception ex)
            {
                ex.printStackTrace();
                return Optional.empty();
            }
        }
        catch (final Exception ex)
        {
            ex.printStackTrace();
            return Optional.empty();
        }
    }
}
