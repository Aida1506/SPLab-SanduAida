package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Chapter {
    private String title;
    private List<Subchapter> subChapters = new ArrayList<>();

    public Chapter(String title) {
        this.title = title;
    }

    public void addSubChapter(Subchapter subChapter) {
        subChapters.add(subChapter);
    }

    public void display() {
        System.out.println("Chapter: " + title);
        for (Subchapter sc : subChapters) {
            sc.display();
        }
    }
}
