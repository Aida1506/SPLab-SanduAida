package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Subchapter {
    private String title;
    private List<Content> contents = new ArrayList<>();

    public Subchapter(String title) {
        this.title = title;
    }

    public void addContent(Content content) {
        contents.add(content);
    }

    public void display() {
        System.out.println("  SubChapter: " + title);
        for (Content c : contents) {
            c.display();
        }
    }
}
