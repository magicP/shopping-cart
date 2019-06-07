package com.zx.shoppingcart.model.product;

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
