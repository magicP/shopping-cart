package com.zx.shoppingcart.model.product.view;

import com.zx.shoppingcart.model.product.model.Product;

public class GetProductResponse {
    private Product product;

    public GetProductResponse(Product product) {
        this.product = product;
    }

    //好像规定要写无参数构造函数，但测试去掉也可以
    public GetProductResponse() {
    }

    /**
     * get方法会被spring框架调用，必须写
     */
    public Product getProduct() {
        return product;
    }

}
