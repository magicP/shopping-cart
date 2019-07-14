package com.zx.shoppingcart.product.view;

import com.zx.shoppingcart.product.model.Product;

import java.util.List;

public class ListProductResponse {
    private List<Product> products;

    public ListProductResponse(List<Product> products) {
        this.products = products;
    }

    public List<Product> getProducts() {
        return products;
    }
}
