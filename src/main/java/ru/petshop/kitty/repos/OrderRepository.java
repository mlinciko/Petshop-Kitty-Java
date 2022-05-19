package ru.petshop.kitty.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.petshop.kitty.entities.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
    public Order findByFirstName(@Param("firstName") String firstName);
}
