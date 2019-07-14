package com.zx.shoppingcart.order.view;

import com.zx.shoppingcart.order.model.Order;

import java.util.List;

public class ListOrdersResponse {
    List<Order> orderList;

    public ListOrdersResponse(List<Order> orderList) {
        this.orderList = orderList;
    }

    public List<Order> getOrderList() {
        return orderList;
    }
}
