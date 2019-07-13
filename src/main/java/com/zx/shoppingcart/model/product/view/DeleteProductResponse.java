package com.zx.shoppingcart.model.product.view;

import com.zx.shoppingcart.model.product.model.Product;

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
