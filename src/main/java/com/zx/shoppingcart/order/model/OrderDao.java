package com.zx.shoppingcart.order.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDao extends CrudRepository<Order,Long> {
    Order getById(long id);
    Order save(Order order);
    List<Order> findAll();
    void delete(Order order);
}

