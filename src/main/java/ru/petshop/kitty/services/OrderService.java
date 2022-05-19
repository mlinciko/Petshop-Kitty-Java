package ru.petshop.kitty.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.petshop.kitty.entities.Order;
import ru.petshop.kitty.repos.OrderRepository;

import java.util.Optional;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

    public void addOrder(Order order){
        orderRepository.save(order);
    }
    public Order getByFirstName(String name){
        return orderRepository.findByFirstName(name);
    }
    public Optional<Order> getById(int id){
        return orderRepository.findById(id);
    }
}
