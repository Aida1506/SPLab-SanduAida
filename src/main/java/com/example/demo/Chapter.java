package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class Chapter implements Element{
    private String title;
    private List<Subchapter> subChapters = new ArrayList<>();

    public Chapter(String title) {
        this.title = title;
    }

    public void addSubChapter(Subchapter subChapter) {
        subChapters.add(subChapter);
    }

    @Override
    public int get(Element element) {
        return subChapters.indexOf(element);
    }

    @Override
    public Element getParent() {
        return null;
    }

    @Override
    public void setParent(Element element) {

    }


    public void print() {
        System.out.println("Chapter: " + title);
        for (Subchapter sc : subChapters) {
            sc.print();
        }
    }

    @Override
    public void add(Element element) {

    }

    @Override
    public void remove(Element element) {

    }
}
