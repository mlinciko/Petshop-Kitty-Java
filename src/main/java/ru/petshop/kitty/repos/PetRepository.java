package ru.petshop.kitty.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.petshop.kitty.entities.Pet;
import ru.petshop.kitty.entities.PetType;

import java.util.List;

@Repository
public interface PetRepository extends CrudRepository<Pet, Integer> {
    List<Pet> findByPetType(@Param("active") PetType petType);
    List<Pet> findByName(String name);
}
