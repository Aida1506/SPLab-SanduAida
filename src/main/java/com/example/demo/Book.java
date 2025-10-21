package com.example.demo;
import java.util.ArrayList;
import java.util.List;

public class Book{
    private String title;
    private List<Author> authors = new ArrayList<>();
    private List<Element> elements = new ArrayList<>();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        authors.add(author);
    }

    public void addElement(Element element) {
        elements.add(element);
    }

    public void print() {
        System.out.println("Book: " + title);
        System.out.print("Authors: ");
        for (Author a : authors) {
            System.out.print(a.getName() + " ");
        }
        System.out.println("\nContent:");
        for (Element e : elements) {
            e.print();
        }
    }
}

