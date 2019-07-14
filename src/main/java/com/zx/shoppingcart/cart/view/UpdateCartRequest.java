package com.zx.shoppingcart.cart.view;


public class UpdateCartRequest {
   private long quantity;

    public UpdateCartRequest(long quantity) {
        this.quantity = quantity;
    }

    public long getQuantity() {
        return quantity;
    }
}
