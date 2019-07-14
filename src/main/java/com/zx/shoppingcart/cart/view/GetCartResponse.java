package com.zx.shoppingcart.cart.view;

import com.zx.shoppingcart.cart.model.CartItem;

public class GetCartResponse {
    private CartItem cartItem;
    public GetCartResponse(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    public CartItem getCartItem() {
        return cartItem;
    }
}
