package com.example.demo;

public class Paragraph extends Content {
    private String text;

    public Paragraph(String text) {
        this.text = text;
    }

    @Override
    public void display() {
        System.out.println("Paragraph: " + text);
    }
}
