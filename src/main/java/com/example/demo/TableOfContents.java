package com.example.demo;

import java.util.ArrayList;
import java.util.List;

public class TableOfContents extends Element {
    private List<Element> elements = new ArrayList<>();

    @Override
    public void print() {
        System.out.println("Table of Contents:");
        for (Element e : elements) {
            e.print();
        }
    }

    @Override
    public void add(Element element) {
        elements.add(element);
    }

    @Override
    public void remove(Element element) {
        elements.remove(element);
    }

    @Override
    public int get(Element element) {
        return elements.indexOf(element);
    }

    @Override
    public Element getParent() {
        return null;
    }

    @Override
    public void setParent(Element element) {

    }
}

