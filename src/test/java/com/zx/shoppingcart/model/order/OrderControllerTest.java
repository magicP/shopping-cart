package com.zx.shoppingcart.model.order;

import com.zx.shoppingcart.model.order.controller.OrderController;
import com.zx.shoppingcart.model.order.view.CancelOrderResponse;
import com.zx.shoppingcart.model.order.view.CreateOrderRequest;
import com.zx.shoppingcart.model.order.view.CreateOrderResponse;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.Assert.assertEquals;

public class OrderControllerTest {

    private OrderController controller;

    @Before
    public void setup(){
        controller = new OrderController();
    }

    @Test
    public void shouldCreateOrder(){
        CreateOrderRequest request = new CreateOrderRequest();
        ResponseEntity<CreateOrderResponse> response = controller.createOrder(request);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void shouldCancelOrder(){
        String orderId = "test";
        ResponseEntity<CancelOrderResponse> response = controller.cancelOrder(orderId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }
}
