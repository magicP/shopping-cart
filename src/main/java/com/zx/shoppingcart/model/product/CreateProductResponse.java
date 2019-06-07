package com.zx.shoppingcart.model.product;

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
