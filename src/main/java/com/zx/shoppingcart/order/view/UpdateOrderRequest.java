package com.zx.shoppingcart.order.view;

public class UpdateOrderRequest {
    private long quantity;
    private String status;
    private String address;

    public UpdateOrderRequest(long quantity, String status, String address) {
        this.quantity = quantity;
        this.status = status;
        this.address = address;
    }

    public long getQuantity() {
        return quantity;
    }

    public String getStatus() {
        return status;
    }

    public String getAddress() {
        return address;
    }
}
