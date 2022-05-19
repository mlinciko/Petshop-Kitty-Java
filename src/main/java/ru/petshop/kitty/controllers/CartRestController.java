package ru.petshop.kitty.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.petshop.kitty.services.CartService;

@RestController
public class CartRestController {
    @Autowired
    private CartService cartService;

    @RequestMapping("/cart/add/{id}")
    public String addPetToCart(@PathVariable("id") Integer petId){
        cartService.addProduct(petId);
        return "Added successfully";
    }
}
