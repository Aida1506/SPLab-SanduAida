package com.example.demo.controllers;

import com.example.demo.Author;
import com.example.demo.repository.AuthorsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    private final AuthorsRepository authorsRepository;

    @Autowired
    public AuthorsController(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    @GetMapping
    public List<Author> getAllAuthors() {
        return authorsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Author getAuthorById(@PathVariable Integer id) {
        return authorsRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Author createAuthor(@RequestBody Author author) {
        return authorsRepository.save(author);
    }

    @PutMapping("/{id}")
    public Author updateAuthor(@PathVariable Integer id, @RequestBody Author updatedAuthor) {
        return authorsRepository.findById(id)
                .map(author -> {
                    author.setName(updatedAuthor.getName());
                    return authorsRepository.save(author);
                })
                .orElseGet(() -> {
                    updatedAuthor.setId(Long.valueOf(id));
                    return authorsRepository.save(updatedAuthor);
                });
    }

    @DeleteMapping("/{id}")
    public String deleteAuthor(@PathVariable Integer id) {
        if (authorsRepository.existsById(id)) {
            authorsRepository.deleteById(id);
            return "Author with ID " + id + " deleted.";
        } else {
            return "Author not found";
        }
    }
}
