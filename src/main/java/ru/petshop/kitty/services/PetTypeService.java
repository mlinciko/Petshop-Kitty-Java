package ru.petshop.kitty.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.petshop.kitty.entities.Pet;
import ru.petshop.kitty.entities.PetType;
import ru.petshop.kitty.repos.PetTypeRepository;

@Service
public class PetTypeService {
    @Autowired
    private PetTypeRepository petTypeRepository;

    public Iterable<PetType> getTypes(){
        return petTypeRepository.findAll();
    }

    public String getType(Pet pet){
        return petTypeRepository.findById(pet.getPetType().getId()).get().getType();
    }
}
