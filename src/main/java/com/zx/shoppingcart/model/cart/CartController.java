package com.zx.shoppingcart.model.cart;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

    @GetMapping("/carts/{cartId}")
    ResponseEntity<GetCartResponse> getCart(@PathVariable String cartId){
        return new ResponseEntity<>(new GetCartResponse(), HttpStatus.OK);
    }

    @GetMapping("/carts")
    ResponseEntity<GetCartsResponse> getCarts(){
        return new ResponseEntity<>(new GetCartsResponse(), HttpStatus.OK);
    }

    @PutMapping("carts/{cartId}")
    ResponseEntity<UpdateCartResponse> updateCart(@PathVariable String cartId,@RequestBody UpdateCartRequest request){
        return new ResponseEntity<>(new UpdateCartResponse(), HttpStatus.OK);
    }

}
