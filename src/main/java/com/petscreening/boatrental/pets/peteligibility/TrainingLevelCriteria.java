package com.petscreening.boatrental.pets.peteligibility;

import java.util.Optional;

public record TrainingLevelCriteria(
        Optional<Integer> lowerBound,
        Optional<Integer> upperBound) {

    public boolean isLevelInRange(int level) {
        boolean aboveLower = lowerBound.map(lb -> lb <= level).orElse(true);
        boolean belowUpper = upperBound.map(ub -> ub >= level).orElse(true);
        return aboveLower && belowUpper;
    }
}
