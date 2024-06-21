package com.petscreening.boatrental.pets;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.petscreening.boatrental.pets.peteligibility.PetEligibility;

@Service
public class PetService {
    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public Optional<PetRecord> getPetById(long id) {
        return this.petRepository.findById(id).map(Pet::toPetRecord);
    }

    public List<PetRecord> filterPet(PetEligibility filter) {
        List<Specification<Pet>> specs = Arrays.asList(
                filter.weight().map(PetRepository.Specs::petWeightInRange),
                filter.vaccination().map(PetRepository.Specs::petVaccinationComplies),
                filter.breed().map(PetRepository.Specs::petBreedInSet),
                filter.trainingLevel().map(PetRepository.Specs::petTrainingLevelInRange))
                .stream()
                .flatMap(Optional::stream)
                .collect(Collectors.toList());

        if (specs.isEmpty()) {
            return petRepository.findAll().stream().map(Pet::toPetRecord).collect(Collectors.toList());
        } else {
            Specification<Pet> conjunction = specs.get(0);
            for (Specification<Pet> s : specs.subList(1, specs.size())) {
                conjunction = conjunction.and(s);
            }
            return petRepository.findAll(conjunction).stream().map(Pet::toPetRecord).collect(Collectors.toList());

        }
    }

    public PetRecord addPet(PetInput petInput) {
        var savedPet = petRepository.save(petInput.toPet());
        return savedPet.toPetRecord();
    }
}
