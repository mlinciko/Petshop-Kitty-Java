package ru.petshop.kitty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.petshop.kitty.entities.Pet;
import ru.petshop.kitty.entities.SimplePet;
import ru.petshop.kitty.services.PetService;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PetsRestController {
    @Autowired
    private PetService petService;

    @RequestMapping("/allpets")
    public List<Object> allPets (){
        List<Pet> pets = petService.getPets();
        List<Object> petsList = new ArrayList<>();
        for(int  i =0; i < pets.size(); i++){
            int id = pets.get(i).getId();
            String name = pets.get(i).getName();
            String price = Double.toString(pets.get(i).getPrice());
            String description = pets.get(i).getDescription();
            int petId = pets.get(i).getPetType().getId();
            String image = pets.get(i).getImage();
            petsList.add(new SimplePet(id, name, price, description, petId, image));
        }

        return petsList;
    }

}
