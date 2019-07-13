package com.zx.shoppingcart.model.product.view;

import com.zx.shoppingcart.model.product.model.Product;

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
