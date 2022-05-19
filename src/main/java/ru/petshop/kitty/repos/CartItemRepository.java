package ru.petshop.kitty.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.petshop.kitty.entities.CartItem;
import ru.petshop.kitty.entities.Order;
import ru.petshop.kitty.entities.Pet;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {
    public CartItem findByPet(Pet pet);
    public Iterable<CartItem> findByOrder(Order order);
}
