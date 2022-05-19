package ru.petshop.kitty.entities;

import javax.persistence.*;

@Entity(name="cart_item")
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name="pet_id")
    private Pet pet;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    public CartItem(){}
    public void setId(int id) {
        this.id = id;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public int getId() {
        return id;
    }

    public Pet getPet() {
        return pet;
    }

    public Order getOrder() {
        return order;
    }
}
