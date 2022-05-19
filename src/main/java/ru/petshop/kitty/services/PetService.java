package ru.petshop.kitty.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.petshop.kitty.entities.Pet;
import ru.petshop.kitty.entities.PetType;
import ru.petshop.kitty.repos.PetRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PetService {
    @Autowired
    private PetRepository petRepository;

    public List<Pet> getPets() { return (List<Pet>) petRepository.findAll(); }
    public Iterable<Pet> getPets(int type){
        return petRepository.findByPetType(new PetType(type));
    }

    public Iterable<Pet> getFilteredPets(int type, String age, String price){
        List<Pet> filteredPets = new ArrayList<>();
        this.getPets(type).forEach(pet -> {
            Double petAge;
            if(pet.getAge().contains("месяц"))
                petAge = Double.parseDouble(pet.getAge().split(" ")[0])/10;
            else petAge = Double.parseDouble(pet.getAge().split(" ")[0]);
            if (petAge <= Double.parseDouble(age) && pet.getPrice() <= Double.parseDouble(price)) {
                filteredPets.add(pet);
            }
        });
        return filteredPets;
    }

    public Pet getPet(int id){
        return petRepository.findById(id).get();
    }

    //возвращает список объектов с одинаковым типом, указанным у объекта в аргументе
    public Iterable<Pet> getByPetType(Pet pet){
        return petRepository.findByPetType(new PetType(pet.getPetType().getId()));
    }

    //возвращает список из четырех объектов определенного типа
    public Iterable<Pet> getOtherPets(Pet pet){
        Iterable<Pet> pets = this.getByPetType(pet);
        List<Pet> petsList = new ArrayList<>();
        pets.forEach( item -> { petsList.add(item); } );
        return petsList.subList(0, 4);
    }
}
