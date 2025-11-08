package com.example.demo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("TABLEOFCONTENTS")
public class TableOfContents extends Element {

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
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

