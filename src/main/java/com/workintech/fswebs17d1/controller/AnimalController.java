package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/workintech/animal")
public class AnimalController {
    private Map<Integer, Animal> animals;

    public AnimalController(){
        this.animals = new HashMap<>();
    }

    @GetMapping
    public List<Animal> getAnimals(){
        return new ArrayList<>(animals.values());
    }

    @GetMapping("/{id}")
    public Animal getAnimalId(@PathVariable ("id") int id){
        if(id<0){
            System.out.println("Geçersiz id girdiniz.Id 0 dan küçük olamaz. Girdiğiniz ID= "+ id);
            return null;

        }
        return this.animals.get(id);
    }

    @PostMapping
    public void addAnimal(@RequestBody Animal animal){
        this.animals.put(animal.getId(),animal);
    }

    @PutMapping("/{id}")
    public Animal updateAnimal(@PathVariable ("id") int id, @RequestBody Animal newAnimal){
        this.animals.replace(id,newAnimal);
        return this.animals.get(id);
    }

    @DeleteMapping("/{id}")
    public void deleteAnimal(@PathVariable ("id") int id){
        this.animals.remove(id);
    }

}
