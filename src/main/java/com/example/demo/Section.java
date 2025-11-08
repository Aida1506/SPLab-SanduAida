package com.example.demo;

import jakarta.persistence.CascadeType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue("SECTION")
public class Section extends Element {
    private String title;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
    private List<Element> elements = new ArrayList<>();

    public Section(String title) {
        this.title = title;
    }

    public Section() {}

    @Override
    public void print() {
        System.out.println("Section: " + title);
        for (Element e : elements) {
            e.print();
        }
    }

    @Override
    public void add(Element element) {
        if (element.getParent() != null) {
            throw new IllegalStateException(
                    "Element already belongs to another Section!"
            );
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

