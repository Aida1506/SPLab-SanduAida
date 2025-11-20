package com.example.demo.controllers;

import com.example.demo.Book;
import com.example.demo.sse.AllBooksSubject;
import com.example.demo.sse.SseObserver;
import com.example.demo.repository.BookRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/books-sse")
public class BooksSseController {

    private final AllBooksSubject allBooksSubject;

    private final BookRepository booksRepository;

    public BooksSseController(AllBooksSubject allBooksSubject, BookRepository booksRepository) {
        this.allBooksSubject = allBooksSubject;
        this.booksRepository = booksRepository;
    }

    @GetMapping
    public SseEmitter getBooksSse() {
        final SseEmitter emitter = new SseEmitter(0L);
        SseObserver observer = new SseObserver(emitter);
        observer.setSubject(allBooksSubject);
        allBooksSubject.attach(observer);

        for (Book book : booksRepository.findAll()) {
            observer.update(book);
        }

        return emitter;
    }

}
