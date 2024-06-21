package com.petscreening.boatrental.pets;

import java.util.Optional;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String name;
    Double weight;
    String breed;
    Boolean vaccinated;
    Integer trainingLevel;

    protected Pet() {
    }

    public Pet(String name, Double weight, String breed, Boolean vaccinated, Integer trainingLevel) {
        this.name = name;
        this.weight = weight;
        this.breed = breed;
        this.vaccinated = vaccinated;
        this.trainingLevel = trainingLevel;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getWeight() {
        return weight;
    }

    public String getBreed() {
        return breed;
    }

    public Boolean getVaccinated() {
        return vaccinated;
    }

    public Integer getTrainingLevel() {
        return trainingLevel;
    }

    public PetRecord toPetRecord() {
        return new PetRecord(
                id,
                name,
                Optional.ofNullable(weight),
                Optional.ofNullable(breed),
                Optional.ofNullable(vaccinated),
                Optional.ofNullable(trainingLevel));
    }

}
