package com.example.demo;

public abstract interface Element {
    public Element parent = null;
    void print();
    void add(Element element);
    void remove(Element element);
    int get(Element element);

    public Element getParent();
    public void setParent(Element element);
}
