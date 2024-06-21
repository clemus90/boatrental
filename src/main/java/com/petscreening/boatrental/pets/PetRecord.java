package com.petscreening.boatrental.pets;

public record PetRecord(
        Long id,
        String name,
        Double weight,
        String breed,
        Boolean vaccinated,
        Integer trainingLevel) {
}
