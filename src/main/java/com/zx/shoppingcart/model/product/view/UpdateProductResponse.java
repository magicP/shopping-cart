package com.zx.shoppingcart.model.product.view;

import com.zx.shoppingcart.model.product.model.Product;

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
