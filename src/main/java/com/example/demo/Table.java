package com.example.demo;

public class Table implements Element {
    private String title;

    public Table(String title) {
        this.title = title;
    }

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
