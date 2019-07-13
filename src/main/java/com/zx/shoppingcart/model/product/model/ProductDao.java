package com.zx.shoppingcart.model.product.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
   hibernate会帮忙生成这些接口的实现
 */
@Repository
public interface ProductDao extends CrudRepository<Product,Long> {

    Product getById(Long id);

    List<Product> findAll();

    Product save(Product product);

    void deleteById(Long id);
}
