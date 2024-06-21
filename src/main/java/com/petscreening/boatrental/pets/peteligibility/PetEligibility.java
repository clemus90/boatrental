package com.petscreening.boatrental.pets.peteligibility;

import java.util.Optional;

public record PetEligibility(
        Optional<WeightCriteria> weight,
        Optional<VaccinationCriteria> vaccination,
        Optional<BreedCriteria> breed,
        Optional<TrainingLevelCriteria> trainingLevel) {
}
