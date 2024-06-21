package com.petscreening.boatrental.pets.peteligibility;

import java.util.Optional;

public record WeightCriteria(
        Optional<Double> lowerBound,
        Optional<Double> upperBound) {

    public boolean isWeightInRange(double weight) {
        boolean aboveLower = lowerBound.map(lb -> lb <= weight).orElse(true);
        boolean belowUpper = upperBound.map(ub -> ub >= weight).orElse(true);
        return aboveLower && belowUpper;
    }
}
