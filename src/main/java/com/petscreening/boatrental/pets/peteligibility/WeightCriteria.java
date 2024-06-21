package com.petscreening.boatrental.pets.peteligibility;

import java.util.Optional;

public record WeightCriteria(
        Optional<Double> lowerBound,
        Optional<Double> upperBound) {

}
