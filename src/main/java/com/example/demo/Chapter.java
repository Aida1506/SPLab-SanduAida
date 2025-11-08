package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("CHAPTER")
@Data
@AllArgsConstructor
public class Chapter extends Element {
    private String title;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Element> subChapters = new ArrayList<>();

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

    public void print() {
        System.out.println("Chapter: " + title);
        for (Element sc : subChapters) {
            sc.print();
        }
    }

    @Override
    public void add(Element element) {
        subChapters.add(element);
        element.setParent(this);
    }

    @Override
    public void remove(Element element) {
        subChapters.remove(element);
        element.setParent(null);
    }
}
