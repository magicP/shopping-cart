package com.zx.shoppingcart.model.cart.model;

import com.zx.shoppingcart.model.product.model.Product;

public class Cart {
    String id;
    String name;
    Product[] products;

    public Cart(String id, String name, Product[] products) {
        this.id = id;
        this.name = name;
        this.products = products;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }
}
