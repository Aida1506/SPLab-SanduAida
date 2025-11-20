package com.example.demo.sse;

import com.example.demo.Book;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class AllBooksSubject {

    private final List<SseObserver> observers = new ArrayList<>();

    public void attach(SseObserver observer) {
        observers.add(observer);
    }

    public void detach(SseObserver observer) {
        observers.remove(observer);
    }

    public void add(Book book) {
        notifyObservers(book);
    }

    private void notifyObservers(Book book) {
        for (SseObserver observer : observers) {
            observer.update(book);
        }
    }
}
