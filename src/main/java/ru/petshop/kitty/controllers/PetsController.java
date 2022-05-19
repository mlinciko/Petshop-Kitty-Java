package ru.petshop.kitty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.petshop.kitty.services.CartService;
import ru.petshop.kitty.services.PetService;
import ru.petshop.kitty.services.PetTypeService;

@Controller
@RequestMapping(value={"/cats", "/dogs", "/rodents", "/parrots"})
public class PetsController {
    @Autowired
    private PetTypeService petTypeService;
    @Autowired
    private PetService petService;
    @Autowired
    private CartService cartService;


    @RequestMapping("/pet-details")
    public String petsDetails(
            @RequestParam(name="id", required=true) int id, Model model){
        boolean isAtCart = false;
        if(cartService.getByPet(petService.getPet(id)) != null){
            isAtCart = true;
        }
        model.addAttribute("pet", petService.getPet(id));
        model.addAttribute("others", petService.getOtherPets(petService.getPet(id)));
        model.addAttribute("type", petTypeService.getType(petService.getPet(id)));
        model.addAttribute("isAtCart",isAtCart);
        return "pet-details";
    }
}
