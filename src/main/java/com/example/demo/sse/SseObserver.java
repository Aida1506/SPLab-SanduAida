package com.example.demo.sse;

import com.example.demo.Book;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

public class SseObserver {

    private final SseEmitter emitter;
    private AllBooksSubject subject;

    public SseObserver(SseEmitter emitter) {
        this.emitter = emitter;

        this.emitter.onCompletion(() -> {
            if( subject != null) {
                subject.detach(this);
            }
        });

        this.emitter.onTimeout(() -> {
            emitter.complete();
            if( subject != null) {
                subject.detach(this);
            }
        });
    }

    public void setSubject(AllBooksSubject subject) {
        this.subject = subject;
    }

    public void update(Book book) {
        try {
            emitter.send(book, MediaType.APPLICATION_JSON);
        } catch (IOException e) {
            emitter.completeWithError(e);
            if(subject != null) {
                subject.detach(this);
            }
        }
    }

}
