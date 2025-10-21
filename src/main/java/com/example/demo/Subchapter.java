package com.example.demo;

import javax.lang.model.util.Elements;
import java.util.ArrayList;
import java.util.List;

public class Subchapter implements Element{
    private String title;
    private List<Element> elements = new ArrayList<>();

    public Subchapter(String title) {
        this.title = title;
    }

    public void print() {
        System.out.println("  SubChapter: " + title);
        for (Element c : elements) {
            c.print();
        }
    }

    @Override
    public void add(Element element) {

    }

    @Override
    public void remove(Element element) {

    }

    @Override
    public int get(Element element) {
        return 0;
    }
}
