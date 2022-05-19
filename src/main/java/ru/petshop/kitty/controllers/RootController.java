package ru.petshop.kitty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.petshop.kitty.entities.Pet;
import ru.petshop.kitty.entities.PetType;
import ru.petshop.kitty.repos.PetTypeRepository;
import ru.petshop.kitty.services.CartService;
import ru.petshop.kitty.services.PetService;
import ru.petshop.kitty.services.PetTypeService;

import java.util.List;


@Controller
public class RootController {
    @Autowired
    private PetTypeService petTypeService;
    @Autowired
    private PetService petService;
    @Autowired
    private CartService cartService;

    @GetMapping(path = "/")
    public String root(Model model){
        model.addAttribute("types", petTypeService.getTypes());
        return "index";
    }

    @GetMapping(path="/cats")
    public String cats(Model model, String age, String price){
        Iterable<Pet> pets;
        boolean showMessage = false;

        if (age == null || age.equals("0"))
            age = "15";
        if (price == null || price.equals("0"))
            price = "10000";

        pets =  petService.getFilteredPets(1, age, price);

        if(pets.spliterator().getExactSizeIfKnown() == 0)
            showMessage = true;
        model.addAttribute("pets", pets);
        model.addAttribute("showMessage", showMessage);
        model.addAttribute("type", "cats");
        return "pets";
    }

    @GetMapping(path="/dogs")
    public String dogs(Model model, String age, String price){
        Iterable<Pet> pets;
        boolean showMessage = false;

        if (age == null || age.equals("0"))
            age = "15";
        if (price == null || price.equals("0"))
            price = "10000";

        pets =  petService.getFilteredPets(2, age, price);

        if(pets.spliterator().getExactSizeIfKnown() == 0)
            showMessage = true;
        model.addAttribute("pets", pets);
        model.addAttribute("showMessage", showMessage);
        model.addAttribute("type", "dogs");
        return "pets";
    }

    @GetMapping(path="/rodents")
    public String rodents(Model model, String age, String price){
        Iterable<Pet> pets;
        boolean showMessage = false;

        if (age == null || age.equals("0"))
            age = "15";
        if (price == null || price.equals("0"))
            price = "10000";

        pets =  petService.getFilteredPets(3, age, price);

        if(pets.spliterator().getExactSizeIfKnown() == 0)
            showMessage = true;
        model.addAttribute("pets", pets);
        model.addAttribute("showMessage", showMessage);
        model.addAttribute("type", "rodents");
        return "pets";
    }

    @GetMapping(path="/parrots")
    public String parrots(Model model, String age, String price){
        Iterable<Pet> pets;
        boolean showMessage = false;

        if (age == null || age.equals("0"))
            age = "15";
        if (price == null || price.equals("0"))
            price = "10000";

        pets =  petService.getFilteredPets(4, age, price);

        if(pets.spliterator().getExactSizeIfKnown() == 0)
            showMessage = true;
        model.addAttribute("pets", pets);
        model.addAttribute("showMessage", showMessage);
        model.addAttribute("type", "parrots");
        return "pets";
    }
    @RequestMapping("/tomain")
    public String toMain(){
        cartService.deleteCartItems();
        return "redirect:/";
    }
}
