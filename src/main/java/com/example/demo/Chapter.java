package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@DiscriminatorValue("CHAPTER")
public class Chapter extends Element {
    private String title;

    private List<Subchapter> subChapters = new ArrayList<>();

    public Chapter(String title) {
        this.title = title;
    }

    public Chapter() {

    }

    public void addSubChapter(Subchapter subChapter) {
        subChapters.add(subChapter);
        subChapter.setParent(this);
    }

    @Override
    public int get(Element element) {
        return subChapters.indexOf(element);
    }

    @Override
    public Element getParent() {
        return parent;
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
