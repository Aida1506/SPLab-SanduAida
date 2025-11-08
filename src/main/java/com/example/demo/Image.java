package com.example.demo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;


@Entity
@DiscriminatorValue("IMAGE")
public class Image extends Element {
    private String path;

    public Image(String path) {
        this.path = path;
    }

    public Image(){

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
