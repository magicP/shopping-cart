package com.zx.shoppingcart.order.controller;

import com.zx.shoppingcart.order.view.CancelOrderResponse;
import com.zx.shoppingcart.order.view.CreateOrderRequest;
import com.zx.shoppingcart.order.view.CreateOrderResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {
    @PostMapping("/orders")
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderRequest request){
        return new ResponseEntity<>(new CreateOrderResponse(), HttpStatus.CREATED);
    }

    @PutMapping("/orders/{orderId}")
    public ResponseEntity<CancelOrderResponse> cancelOrder(@PathVariable String orderId){
        return new ResponseEntity<>(new CancelOrderResponse(), HttpStatus.OK);
    }
}
