package com.example.demo.controllers;

import com.example.demo.Author;
import com.example.demo.Element;
import com.example.demo.dto.NewBookRequest;
import com.example.demo.repository.AuthorsRepository;
import com.example.demo.repository.ElementRepository;
import com.example.demo.sse.AllBooksSubject;
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
    private final AllBooksSubject allBooksSubject;

    @Autowired
    public BooksController(BookRepository booksRepository, AuthorsRepository authorsRepository, ElementRepository elementRepository,  AllBooksSubject allBooksSubject) {
        this.booksRepository = booksRepository;
        this.authorsRepository = authorsRepository;
        this.elementRepository = elementRepository;
        this.allBooksSubject = allBooksSubject;
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
    public String newBook(@RequestBody NewBookRequest newBookRequest) {
        Book book = new Book();
        book.setTitle(newBookRequest.getTitle());

        if (newBookRequest.getAuthorIds() != null) {
            List<Author> authors = new ArrayList<>();
            for (Integer id : newBookRequest.getAuthorIds()) {
                authorsRepository.findById(id).ifPresent(authors::add);
            }
            book.setAuthors(authors);
        }

        if (newBookRequest.getElements() != null) {
            for (Element e : newBookRequest.getElements()) {
                e.setParent(null);
            }
            book.setElements(newBookRequest.getElements());
        }

        book = booksRepository.save(book);
        allBooksSubject.add(book);

        return "Book saved [" + book.getId() + "] " + book.getTitle();
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
                    updatedBook.setId(Long.valueOf(id));
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
