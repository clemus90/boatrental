package com.petscreening.boatrental.pets;

import java.util.List;
import java.util.Optional;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.petscreening.boatrental.pets.peteligibility.PetEligibility;

@Controller
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @QueryMapping
    public Optional<PetRecord> petById(@Argument long id) {
        return this.petService.getPetById(id);
    }

    @QueryMapping
    public List<PetRecord> eligiblePets(@Argument PetEligibility filter) {
        return this.petService.filterPet(filter);
    }

    @MutationMapping
    public PetRecord addPet(@Argument PetInput pet) {
        return this.petService.addPet(pet);
    }
}
