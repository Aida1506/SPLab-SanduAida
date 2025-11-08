package com.example.demo;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "element_type")
@Data
@AllArgsConstructor
@NoArgsConstructor(force = true)
public abstract class Element {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    public Element parent;

    abstract void print();
    abstract void add(Element element);
    abstract void remove(Element element);
    abstract int get(Element element);
    public Element getParent() {
        return parent;
    }
    public void setParent(Element parent) {
        this.parent = parent;
    }
}
