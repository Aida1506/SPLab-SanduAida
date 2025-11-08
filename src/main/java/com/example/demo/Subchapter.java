package com.example.demo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import javax.lang.model.util.Elements;
import java.util.ArrayList;
import java.util.List;


@Entity
@DiscriminatorValue("SUBCHAPTER")
public class Subchapter extends Element {
    private String title;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Element> elements = new ArrayList<>();

    public Subchapter(String title) {
        this.title = title;
    }

    public Subchapter() {}

    public void print() {
        System.out.println("  SubChapter: " + title);
        for (Element c : elements) {
            c.print();
        }
    }

    @Override
    public void add(Element element) {
        if (element.getParent() != null) {
            throw new IllegalStateException("Element already belongs to another Subchapter!");
        }
        element.setParent(this);
        elements.add(element);
    }

    @Override
    public void remove(Element element) {
        elements.remove(element);
        element.setParent(null);
    }

    @Override
    public int get(Element element) {
        return elements.indexOf(element);
    }
}
