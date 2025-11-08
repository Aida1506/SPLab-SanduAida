package com.example.demo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "element_type")
@Setter
@Getter
public abstract class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    public Element parent;
    abstract void print();
    abstract void add(Element element);
    abstract void remove(Element element);
    abstract int get(Element element);

    public abstract Element getParent();
    public abstract void setParent(Element element);
}
