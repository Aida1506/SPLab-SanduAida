package com.example.demo;


import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("TABLE")
public class Table extends Element {
    private String title;

    public Table(String title) {
        this.title = title;
    }

    public Table() {}

    @Override
    public void print() {
        System.out.println("Table: " + title);
    }

    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException("Cannot add element to Table");
    }

    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException("Cannot remove element from Table");
    }

    @Override
    public int get(Element element) {
        throw new UnsupportedOperationException("No elements in Table");
    }
}
