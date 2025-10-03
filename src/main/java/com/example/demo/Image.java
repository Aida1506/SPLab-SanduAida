package com.example.demo;

public class Image extends Content {
    private String imageName;

    public Image(String imageName) {
        this.imageName = imageName;
    }

    @Override
    public void display() {
        System.out.println("Image: " + imageName);
    }
}
