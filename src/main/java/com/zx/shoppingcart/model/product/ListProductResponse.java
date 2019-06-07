package com.zx.shoppingcart.model.product;

import java.util.ArrayList;

public class ListProductResponse {
    private ArrayList<Product> products;

    public ListProductResponse(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }
}
