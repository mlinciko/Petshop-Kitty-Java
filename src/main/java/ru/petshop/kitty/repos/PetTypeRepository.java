package ru.petshop.kitty.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.petshop.kitty.entities.PetType;

@Repository
public interface PetTypeRepository extends CrudRepository<PetType, Integer> {
}
