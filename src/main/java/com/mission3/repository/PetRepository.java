package com.mission3.repository;

import com.mission3.model.Pet;
import org.springframework.data.repository.CrudRepository;


//This will be auto implemented by Spring into a Bean called petRepository

public interface PetRepository extends CrudRepository<Pet, Long> {
}
