package com.petscreening.boatrental.pets;

import java.util.Optional;

public record PetRecord(
        Long id,
        String name,
        Optional<Double> weight,
        Optional<String> breed,
        Optional<Boolean> vaccinated,
        Optional<Integer> trainingLevel) {
}
