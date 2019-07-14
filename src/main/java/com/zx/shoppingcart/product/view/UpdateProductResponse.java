package com.zx.shoppingcart.product.view;

import com.zx.shoppingcart.product.model.Product;

public class UpdateProductResponse {
    private Product product;

    public UpdateProductResponse(Product product) {
        this.product = product;
    }
    public UpdateProductResponse(){}

    public Product getProduct() {
        return product;
    }

}
