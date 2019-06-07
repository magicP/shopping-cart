package com.zx.shoppingcart.model.order;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @PostMapping("/orders")
    ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderRequest request){
        return new ResponseEntity<>(new CreateOrderResponse(), HttpStatus.CREATED);
    }

    @PutMapping("/orders/{orderId}")
    ResponseEntity<CancelOrderResponse> cancelOrder(@PathVariable String orderId){
        return new ResponseEntity<>(new CancelOrderResponse(), HttpStatus.OK);
    }
}
