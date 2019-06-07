package com.zx.shoppingcart.model.product;

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
