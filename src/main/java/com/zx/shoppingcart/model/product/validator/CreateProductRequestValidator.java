package com.zx.shoppingcart.model.product.validator;


import com.zx.shoppingcart.model.product.view.CreateProductRequest;
import org.springframework.stereotype.Component;

@Component
public class CreateProductRequestValidator {

    public boolean validate(CreateProductRequest createProductRequest) {
        if (createProductRequest.getPrice() < 0)
            return false;
        if (createProductRequest.getName().length() <= 0)
            return false;

        return true;
    }
}