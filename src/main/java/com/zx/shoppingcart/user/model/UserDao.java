package com.zx.shoppingcart.user.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends CrudRepository<User,Long> {
    User getById(long id);
    User save(User user);
    List<User> findAll();
    void delete(User user);
    User getByName(String name);
}
