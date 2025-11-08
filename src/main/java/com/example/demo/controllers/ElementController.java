package com.example.demo.controllers;

import com.example.demo.Element;
import com.example.demo.repository.ElementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/elements")
public class ElementController {

    private final ElementRepository elementsRepository;

    @Autowired
    public ElementController(ElementRepository elementsRepository) {
        this.elementsRepository = elementsRepository;
    }

    @GetMapping
    public List<Element> getAllElements() {
        return elementsRepository.findAll();
    }

    @GetMapping("/{id}")
    public Element getElementById(@PathVariable Integer id) {
        return elementsRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Element createElement(@RequestBody Element element) {
        return elementsRepository.save(element);
    }

    @PutMapping("/{id}")
    public Element updateElement(@PathVariable Integer id, @RequestBody Element updatedElement) {
        return elementsRepository.findById(id)
                .map(element -> elementsRepository.save(updatedElement))
                .orElseGet(() -> elementsRepository.save(updatedElement));
    }

    @DeleteMapping("/{id}")
    public String deleteElement(@PathVariable Integer id) {
        if (elementsRepository.existsById(id)) {
            elementsRepository.deleteById(id);
            return "Element with ID " + id + " deleted.";
        } else {
            return "Element not found";
        }
    }
}
