package com.zx.shoppingcart.order.view;

import com.zx.shoppingcart.order.model.Order;

public class GetOrderResponse {
    private Order order;

    public GetOrderResponse(Order order) {
        this.order = order;
    }

    public Order getOrder() {
        return order;
    }
}
