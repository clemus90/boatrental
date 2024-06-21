package com.petscreening.boatrental.pets.peteligibility;

import java.util.OptionalInt;

public record TrainingLevelCriteria(
        OptionalInt lowerBound,
        OptionalInt upperBound) {
}
