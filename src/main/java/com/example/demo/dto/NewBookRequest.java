package com.example.demo.dto;

import com.example.demo.Element;
import java.util.List;

public class NewBookRequest {
    private String title;
    private List<Integer> authorIds;
    private List<Element> elements;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public List<Integer> getAuthorIds() { return authorIds; }
    public void setAuthorIds(List<Integer> authorIds) { this.authorIds = authorIds; }

    public List<Element> getElements() { return elements; }
    public void setElements(List<Element> elements) { this.elements = elements; }
}
