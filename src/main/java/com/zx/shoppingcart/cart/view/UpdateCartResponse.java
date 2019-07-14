package com.zx.shoppingcart.cart.view;

import com.zx.shoppingcart.cart.model.CartItem;

public class UpdateCartResponse {
    private CartItem item;

    public UpdateCartResponse(CartItem item) {
        this.item = item;
    }

    public CartItem getItem() {
        return item;
    }
}
