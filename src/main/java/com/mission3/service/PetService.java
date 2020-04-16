package com.mission3.service;

import com.mission3.model.Pet;
import com.mission3.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    private PetRepository petRepository;

    @Autowired
    public PetService(PetRepository repository) {
        this.petRepository = repository;
    }

    public List<Pet> retrievePet() {
        return (List<Pet>) petRepository.findAll();
    }

    public Optional<Pet> retrievePet(Long id) {
        return petRepository.findById(id);
    }

    public Pet createPet(Pet pet) {
        pet.setId(null);
        return petRepository.save(pet);
    }
}
