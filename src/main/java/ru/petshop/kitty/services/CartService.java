package ru.petshop.kitty.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.petshop.kitty.entities.CartItem;
import ru.petshop.kitty.entities.Order;
import ru.petshop.kitty.entities.Pet;
import ru.petshop.kitty.repos.CartItemRepository;
import ru.petshop.kitty.repos.PetRepository;

@Service
public class CartService {
    @Autowired
    private CartItemRepository cartItemRepository;
    @Autowired
    private PetRepository petRepository;

    public Iterable<CartItem> getCartItems(){return cartItemRepository.findAll();}



    private Double summ;
    public Double getSumm(){
        this.summ = 0.0;
        Iterable<CartItem> cartItems = this.getCartItems();
        if (cartItems.spliterator().getExactSizeIfKnown() != 0) {
            cartItems.forEach((item) -> {
                this.summ += item.getPet().getPrice();
            });
            return this.summ;
        }
        else return 0.0;
    }

    public void addProduct(Integer petId){
        Pet pet = petRepository.findById(petId).get();
        CartItem cartItem = cartItemRepository.findByPet(pet);

        if(cartItem == null){
            cartItem = new CartItem();
            cartItem.setPet(pet);
        }
        cartItemRepository.save(cartItem);
    }

    public void deleteCartItems(){ cartItemRepository.deleteAll();}

    public Iterable<CartItem> getByOrder(Order order){
        return cartItemRepository.findByOrder(order);
    }

    public CartItem getByPet(Pet pet) {return cartItemRepository.findByPet(pet); }

    public void deleteProduct(int cartItemId){
        cartItemRepository.deleteById(cartItemId);
    }

    public void updateProduct(CartItem item){
        cartItemRepository.save(item);
    }

    private   String description;
    public String toString(){
        description = "";
        Iterable<CartItem> cartItems = this.getCartItems();
        String description = "";
        cartItems.forEach(item -> {
            this.description += "Товар №: " + item.getPet().getId()+ "; ";
        });
        return this.description;
    }
}
