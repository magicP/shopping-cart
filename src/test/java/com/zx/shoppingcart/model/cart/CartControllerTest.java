package com.zx.shoppingcart.model.cart;

import com.zx.shoppingcart.model.cart.controller.CartController;
import com.zx.shoppingcart.model.cart.view.GetCartResponse;
import com.zx.shoppingcart.model.cart.view.GetCartsResponse;
import com.zx.shoppingcart.model.cart.view.UpdateCartRequest;
import com.zx.shoppingcart.model.cart.view.UpdateCartResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class CartControllerTest {
    private CartController controller;

    @Before
    public void setup(){
        controller = new CartController();
    }

    @Test
    public void shouldGetCart(){
        String cartId = "test";
        ResponseEntity<GetCartResponse> response = controller.getCart(cartId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void shouldGetCarts(){
        ResponseEntity<GetCartsResponse> response = controller.getCarts();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void shouldUpdateCart(){
        String cartId = "test";
        UpdateCartRequest request = new UpdateCartRequest();
        ResponseEntity<UpdateCartResponse> response = controller.updateCart(cartId, request);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
