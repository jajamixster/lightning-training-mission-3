package com.mission3.controller;

import com.mission3.model.Pet;
import com.mission3.service.PetService;
import org.apache.coyote.Response;
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

    //TODO mapping this with object and return nested array instead of list
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

    //TODO return Requestbody
    @PutMapping("/{id}")
    public ResponseEntity<?> putPet(@PathVariable Long id, @Valid @RequestBody Pet body) {
        Optional<Pet> pet = petService.updatePet(id, body);
        if(!pet.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePet(@PathVariable Long id) {
        if(!petService.deletePet(id)) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().build();
    }
}
