package com.mission3.controller;

import com.mission3.model.Pet;
import com.mission3.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("v1/pets")
public class PetController {

    @Autowired
    PetService petService;

    //TO-DO mapping this with object and return nested array instead of list
    @GetMapping
    public List<Pet> getPet() {
        //return HTTP200 if there are any data in Database, else return empty array
        return petService.retrievePet();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPet(@PathVariable Long id) {
        Optional<Pet> pet = petService.retrievePet(id);
        if(!pet.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pet);
    }

    @PostMapping
    public ResponseEntity<?> postPet(@Valid @RequestBody Pet body) {
        Pet pet = petService.createPet(body);
        //if create successfully return HTTP201 created, else return HTTP404 not found
        return ResponseEntity.status(HttpStatus.CREATED).body(pet);
    }
}
