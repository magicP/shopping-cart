package com.zx.shoppingcart.cart.view;

import com.zx.shoppingcart.cart.model.CartItem;

public class GetCartResponse {
    private CartItem item;
    public GetCartResponse(CartItem item) {
        this.item = item;
    }

    public void setItem(CartItem item) {
        this.item = item;
    }

    public CartItem getItem() {
        return item;
    }
}
