package com.zx.shoppingcart.cart.view;

import com.zx.shoppingcart.cart.model.CartItem;

import java.util.List;

public class GetCartsResponse {
    private List<CartItem> cartItems;

    public GetCartsResponse(List<CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public List<CartItem> getCartItems() {
        return cartItems;
    }
}
