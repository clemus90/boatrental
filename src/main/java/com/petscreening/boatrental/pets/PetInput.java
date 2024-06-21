package com.petscreening.boatrental.pets;

public record PetInput(
        String name,
        Double weight,
        String breed,
        Boolean vaccinated,
        Integer trainingLevel) {
    public Pet toPet() {
        return new Pet(
                name(),
                weight(),
                breed(),
                vaccinated(),
                trainingLevel());
    }
}
