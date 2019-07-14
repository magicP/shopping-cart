package com.zx.shoppingcart.cart.view;

import com.zx.shoppingcart.cart.model.CartItem;

public class CreateCartItemResponse {
    private CartItem cartItem;

    public CreateCartItemResponse(CartItem cartItem) {
        this.cartItem = cartItem;
    }

    public CartItem getCartItem() {
        return cartItem;
    }
}
