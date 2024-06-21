package com.petscreening.boatrental.pets.peteligibility;

import java.util.Set;

public record BreedCriteria(
        Set<String> breedSet,
        Boolean exclude) {

    public boolean breedInSet(String breed) {
        return breedSet().contains(breed) ^ exclude();
    }
}
