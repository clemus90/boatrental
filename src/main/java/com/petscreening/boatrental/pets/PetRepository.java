package com.petscreening.boatrental.pets;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.petscreening.boatrental.pets.peteligibility.BreedCriteria;
import com.petscreening.boatrental.pets.peteligibility.TrainingLevelCriteria;
import com.petscreening.boatrental.pets.peteligibility.VaccinationCriteria;
import com.petscreening.boatrental.pets.peteligibility.WeightCriteria;

public interface PetRepository extends JpaRepository<Pet, Long>, JpaSpecificationExecutor<Pet> {
    interface Specs {
        static Specification<Pet> petWeightInRange(WeightCriteria weightCriteria) {
            return (root, query, builder) -> {
                var lower = weightCriteria.lowerBound().orElse(0.0);
                return weightCriteria.upperBound()
                        .map(u -> builder.between(root.get(Pet_.weight), lower, u))
                        .orElse(builder.ge(root.get(Pet_.weight), lower));
            };
        }

        static Specification<Pet> petVaccinationComplies(VaccinationCriteria vaccinationCriteria) {
            return (root, query, builder) -> builder.equal(root.get(Pet_.vaccinated),
                    vaccinationCriteria.isVaccinated());
        }

        static Specification<Pet> petBreedInSet(BreedCriteria breedCriteria) {
            return (root, query, builder) -> {
                var contains = root.get(Pet_.breed).in(breedCriteria.breedSet());
                if (breedCriteria.exclude()) {
                    return builder.not(contains);
                } else {
                    return contains;
                }
            };
        }

        static Specification<Pet> petTrainingLevelInRange(TrainingLevelCriteria trainingLevelCriteria) {
            return (root, query, builder) -> {
                var lower = trainingLevelCriteria.lowerBound().orElse(1);
                var upper = trainingLevelCriteria.upperBound().orElse(1);
                return builder.between(root.get(Pet_.trainingLevel), lower, upper);
            };
        }
    }
}
