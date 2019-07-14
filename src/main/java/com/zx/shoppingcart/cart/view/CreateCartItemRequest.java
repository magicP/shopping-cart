package com.zx.shoppingcart.cart.view;

public class CreateCartItemRequest {
    private long userId;
    private long productId;
    private long quantity;

    public CreateCartItemRequest( long userId, long productId, long quantity) {
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
    }


    public long getProductId() {
        return productId;
    }

    public long getQuantity() {
        return quantity;
    }

    public long getUserId() {
        return userId;
    }
}
