package com.example.demo;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("TABLEOFCONTENTS")
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
        element.setParent(this);
        elements.add(element);
    }

    @Override
    public void remove(Element element) {
        element.setParent(null);
        elements.remove(element);
    }

    @Override
    public int get(Element element) {
        return elements.indexOf(element);
    }
}

