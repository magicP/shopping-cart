package com.zx.shoppingcart.order.view;

import com.zx.shoppingcart.order.model.Order;

public class CreateOrderResponse {
    private Order order;

    public CreateOrderResponse(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
