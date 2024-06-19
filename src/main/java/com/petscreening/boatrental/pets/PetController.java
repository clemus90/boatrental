package com.petscreening.boatrental.pets;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class PetController {
    @QueryMapping
    public Pet petById(@Argument String id) {
        return Pet.getById(id);
    }
}
