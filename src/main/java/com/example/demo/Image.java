package com.example.demo;

public class Image implements Element {
    private String path;

    public Image(String path) {
        this.path = path;
    }

    @Override
    public void print() {
        System.out.println("Image: " + path);
    }

    @Override
    public void add(Element element) {
        throw new UnsupportedOperationException("Cannot add element to Image");
    }

    @Override
    public void remove(Element element) {
        throw new UnsupportedOperationException("Cannot remove element from Image");
    }

    @Override
    public int get(Element element) {
        throw new UnsupportedOperationException("No elements in Image");
    }
}
