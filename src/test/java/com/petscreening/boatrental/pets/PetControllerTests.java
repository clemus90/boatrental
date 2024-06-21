package com.petscreening.boatrental.pets;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest(PetController.class)
public class PetControllerTests {

    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void shouldGetThirdPet() {
        this.graphQlTester
                .documentName("petDetails")
                .variable("id", 3)
                .execute()
                .path("petById")
                .matchesJson("""
                        	{
                        	  "id": "p003",
                        	  "name": "Coco",
                        	  "weight": 10,
                        	  "breed": "Cocker Spaniel",
                        	  "vaccinationStatus": "Not-vaccinated",
                        	  "trainingLevel": 1
                        	}
                        """);
    }
}
