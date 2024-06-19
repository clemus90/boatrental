package com.petscreening.boatrental.pets;

import java.util.Arrays;
import java.util.List;

public record Pet(
        String id,
        String name,
        double weight,
        String breed,
        String vaccinationStatus,
        int trainingLevel) {

    private static List<Pet> pets = Arrays.asList(
            new Pet("p001", "Homero", 20, "Basset Hound", "Vaccinated", 8),
            new Pet("p002", "Mulan", 5, "Criolla", "Vaccinated", 2),
            new Pet("p003", "Coco", 10, "Cocker Spaniel", "Not-vaccinated", 1));

    public static Pet getById(String id) {
        return pets.stream()
                .filter(pet -> pet.id().equals(id))
                .findFirst()
                .orElse(null);
    }
}
