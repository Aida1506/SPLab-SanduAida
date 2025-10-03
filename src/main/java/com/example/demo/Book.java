package com.example.demo;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private List<Author> authors = new ArrayList<>();
    private List<Chapter> chapters = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addChapter(Chapter chapter) {
        chapters.add(chapter);
    }

    public void display() {
        System.out.println("Book: " + title);
        System.out.println("Authors:");
        for (Author a : authors) {
            System.out.println(" - " + a.getName());
        }
        System.out.println("Table of Contents:");
        for (Chapter c : chapters) {
            System.out.println(" * " + c);
        }
        System.out.println("\nContent:");
        for (Chapter c : chapters) {
            c.display();
        }
    }
}

