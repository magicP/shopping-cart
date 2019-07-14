package com.zx.shoppingcart.product.view;

public class UpdateProductRequest {
    private int id;
    private String name;
    private String description;
    private double price;


    public UpdateProductRequest(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public UpdateProductRequest() {

    }

    /**
     * 这些ｇet方法会被spring框架调用
     * @return
     */
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }
}
