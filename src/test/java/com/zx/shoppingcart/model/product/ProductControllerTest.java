package com.zx.shoppingcart.model.product;

import com.zx.shoppingcart.model.product.controller.ProductController;
import com.zx.shoppingcart.model.product.model.ProductDao;
import com.zx.shoppingcart.model.product.validator.CreateProductRequestValidator;
import com.zx.shoppingcart.model.product.view.*;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import static org.junit.Assert.assertEquals;

public class ProductControllerTest {
    private ProductController controller;
    ProductDao productDao;
    CreateProductRequestValidator validator;

    @Before
    public void setup(){
        controller = new ProductController(validator,productDao);
    }

    @Test
    public void shouldListProducts(){
        ResponseEntity<ListProductResponse> response = controller.listProducts();
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void shouldGetProduct(){
        int productId = 1;
        ResponseEntity<GetProductResponse> response = controller.getProduct(productId);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void shouldCreateProduct(){
        CreateProductRequest request = new CreateProductRequest();
        ResponseEntity<CreateProductResponse> response = controller.createProduct(request);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void shouldUpdateProduct(){
        long productId = 1;
        UpdateProductRequest request = new UpdateProductRequest();
        ResponseEntity<UpdateProductResponse> response = controller.updateProduct(productId,request);
        assertEquals(HttpStatus.OK, response.getStatusCode());
    }

//    @Test
//    public void shouldDeleteProduct(){
//        long productId = 1;
//        ResponseEntity<DeleteProductResponse> response = controller.deleteProduct(productId);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
}
