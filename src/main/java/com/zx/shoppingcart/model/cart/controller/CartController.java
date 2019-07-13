package com.zx.shoppingcart.model.cart.controller;


import com.zx.shoppingcart.model.cart.view.GetCartResponse;
import com.zx.shoppingcart.model.cart.view.GetCartsResponse;
import com.zx.shoppingcart.model.cart.view.UpdateCartRequest;
import com.zx.shoppingcart.model.cart.view.UpdateCartResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @GetMapping("/carts/{cartId}")
    public ResponseEntity<GetCartResponse> getCart(@PathVariable String cartId){
        return new ResponseEntity<>(new GetCartResponse(), HttpStatus.OK);
    }

    @GetMapping("/carts")
    public ResponseEntity<GetCartsResponse> getCarts(){
        return new ResponseEntity<>(new GetCartsResponse(), HttpStatus.OK);
    }

    @PutMapping("carts/{cartId}")
    public ResponseEntity<UpdateCartResponse> updateCart(@PathVariable String cartId, @RequestBody UpdateCartRequest request){
        return new ResponseEntity<>(new UpdateCartResponse(), HttpStatus.OK);
    }

}
