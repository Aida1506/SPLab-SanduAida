package com.example.demo;
import jakarta.persistence.*;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "element_type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Chapter.class, name = "CHAPTER"),
        @JsonSubTypes.Type(value = Chapter.class, name = "IMAGE"),
        @JsonSubTypes.Type(value = Chapter.class, name = "PARAGRAPH"),
        @JsonSubTypes.Type(value = Chapter.class, name = "SECTION"),
        @JsonSubTypes.Type(value = Chapter.class, name = "SUBCHAPTER"),
        @JsonSubTypes.Type(value = Chapter.class, name = "TABLE"),
        @JsonSubTypes.Type(value = Chapter.class, name = "TABLEOFCONTENTS")
})
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
