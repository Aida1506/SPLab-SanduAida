package com.example.demo.controllers;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/books")
public class BooksController {
    private final Map<Integer, String> books = new HashMap<>();

    public BooksController() {
        books.put(1, "The Great Gatsby");
        books.put(2, "To Kill a Mockingbird");
        books.put(3, "1984");
    }

    // GET /books - returnează toate cărțile
    @GetMapping
    public Collection<String> getAllBooks() {
        return books.values();
    }

    // GET /books/{id} - returnează detalii despre o carte anume
    @GetMapping("/{id}")
    public String getBookById(@PathVariable int id) {
        return books.getOrDefault(id, "Book not found");
    }

    // POST /books - creează o carte nouă
    @PostMapping
    public String createBook(@RequestBody String title) {
        int newId = books.size() + 1;
        books.put(newId, title);
        return "Book created with ID: " + newId;
    }

    // PUT /books/{id} - înlocuiește o carte existentă
    @PutMapping("/{id}")
    public String updateBook(@PathVariable int id, @RequestBody String title) {
        if (books.containsKey(id)) {
            books.put(id, title);
            return "Book with ID " + id + " updated to: " + title;
        } else {
            return "Book not found";
        }
    }

    // DELETE /books/{id} - șterge o carte
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable int id) {
        if (books.remove(id) != null) {
            return "Book with ID " + id + " deleted.";
        } else {
            return "Book not found";
        }
    }
}
