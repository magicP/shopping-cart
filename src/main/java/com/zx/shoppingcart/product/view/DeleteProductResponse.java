package com.zx.shoppingcart.product.view;

import com.zx.shoppingcart.product.model.Product;

public class DeleteProductResponse {
    private Product product;
    public DeleteProductResponse(Product product) {
        this.product = product;
    }
    public DeleteProductResponse(){}


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
