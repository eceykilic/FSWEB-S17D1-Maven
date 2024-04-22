package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech/animal")
public class AnimalController {

    private Map<Integer, Animal> animals = new HashMap();

    @Value("${project.developer.fullname}")
    private String fullName;

    @Value("${course.name}")
    private String courseName;

    @GetMapping("")
    public List<Animal> findAll() {
        return animals.values().stream().toList();
    }

    @GetMapping("/{id}")
    public Animal getAnimalsById(@PathVariable int id) {
        return animals.get(id);
    }

    @PostMapping("")
    public Animal save(@RequestBody Animal animal) {
        animals.put(animal.getId(), animal);
        return animal;
    }

    @PutMapping("/{id}")
    public Animal save(@PathVariable int id, @RequestBody Animal animal) {
        animals.put(id, animal);
        return animal;
    }

    @DeleteMapping("/{id}")
    public Animal remove(@PathVariable int id) {
        Animal animal = animals.get(id);
        animals.remove(id);
        return animal;
    }

    @PostConstruct
    public void loadAll() {
        System.out.println("postconstruct çalıştı");
        this.animals = new HashMap<>();
        this.animals.put(1, new Animal(1, "maymun"));
        System.out.println("animalsMap = " + animals);
        System.out.println("fullName= " + fullName + " --- " + "courseName= " + courseName);
    }

}