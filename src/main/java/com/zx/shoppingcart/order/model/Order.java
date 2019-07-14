package com.zx.shoppingcart.order.model;



public class Order {
    private String id;
    private double totalPrice;

    public Order(String id, double totalPrice) {
        this.id = id;
        this.totalPrice = totalPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
