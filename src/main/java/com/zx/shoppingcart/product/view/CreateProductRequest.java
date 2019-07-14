package com.zx.shoppingcart.product.view;

public class CreateProductRequest {

    private int id;
    private String name;
    private String description;
    private double price;


    public CreateProductRequest(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public CreateProductRequest(){}

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

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
