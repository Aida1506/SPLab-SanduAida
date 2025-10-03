package com.example.demo;

public class Table extends Content {
    private String title;

    public Table(String title) {
        this.title = title;
    }

    @Override
    public void display() {
        System.out.println("Table: " + title);
    }
}
