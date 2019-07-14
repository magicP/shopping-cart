package com.zx.shoppingcart.product.view;

import com.zx.shoppingcart.product.model.Product;

public class CreateProductResponse {
    private Product product;

    public CreateProductResponse(Product product) {
        this.product = product;
    }
    public CreateProductResponse(){}

    public Product getProduct() {
        return product;
    }

}
