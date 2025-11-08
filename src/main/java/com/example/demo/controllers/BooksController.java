package com.example.demo.controllers;

import com.example.demo.repository.AuthorsRepository;
import com.example.demo.repository.ElementRepository;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.*;

@RestController
@RequestMapping("/books")
public class BooksController {

    private final BookRepository booksRepository;
    private final AuthorsRepository authorsRepository;
    private final ElementRepository  elementRepository;

    @Autowired
    public BooksController(BookRepository booksRepository, AuthorsRepository authorsRepository, ElementRepository elementRepository) {
        this.booksRepository = booksRepository;
        this.authorsRepository = authorsRepository;
        this.elementRepository = elementRepository;
    }

    // GET /books - toate cartile
    @GetMapping
    public List<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    // GET /books/{id} - carte dupa id
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Integer id) {
        return booksRepository.findById(id).orElse(null);
    }

    // POST /books - adauga o carte noua
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return booksRepository.save(book);
    }

    // PUT /books/{id} - actulizeaza o carte
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable Integer id, @RequestBody Book updatedBook) {
        return booksRepository.findById(id)
                .map(book -> {
                    book.setTitle(updatedBook.getTitle());
                    book.setAuthors(updatedBook.getAuthors());
                    book.setElements(updatedBook.getElements());
                    return booksRepository.save(book);
                })
                .orElseGet(() -> {
                    updatedBook.setId(Long.valueOf(id)); // crearea unei carti daca nu exista
                    return booksRepository.save(updatedBook);
                });
    }

    // DELETE /books/{id} - sterge o carte
    @DeleteMapping("/{id}")
    public String deleteBook(@PathVariable Integer id) {
        if (booksRepository.existsById(id)) {
            booksRepository.deleteById(id);
            return "Book with ID " + id + " deleted.";
        } else {
            return "Book not found";
        }
    }
}
