package com.zx.shoppingcart.product.validator;


import com.zx.shoppingcart.product.view.CreateProductRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateProductRequestValidator {

    public boolean validate(CreateProductRequest createProductRequest) {
        if (createProductRequest.getPrice() < 0)
            return false;
        return createProductRequest.getName().length() > 0;
    }
}