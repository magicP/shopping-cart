package com.zx.shoppingcart.model.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 不知道状态码是否准确
 */
@RestController
public class ProductController {
    private ProductDao productDao;

    public ProductController(ProductDao productDao) {
        this.productDao = productDao;
    }

    @GetMapping("/products")
    ResponseEntity<ListProductResponse> listProducts(){
        ArrayList<Product> products;
        try {
            products = productDao.list();
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new ListProductResponse(products), HttpStatus.OK);
    }


    @GetMapping("/products/{productId}")
    ResponseEntity<GetProductResponse> getProduct(@PathVariable int productId){
        Product product;
        try {
            product = productDao.getById(productId);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        if(product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new GetProductResponse(product), HttpStatus.OK);

    }

    @PostMapping("/products")
    ResponseEntity<CreateProductResponse> createProduct(@RequestBody CreateProductRequest request){
        Product product = null;
        try {
            product = productDao.getById(request.getId());
            if(product == null){
                product = productDao.create(new Product(request.getId(),
                        request.getName(),
                        request.getDescription(),
                        request.getPrice()));
            }else{
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<>(new CreateProductResponse(product), HttpStatus.CREATED);
    }

    @PutMapping("/products/{productId}")
    ResponseEntity<UpdateProductResponse> updateProduct(@PathVariable int productId,@RequestBody UpdateProductRequest request){
        Product product = null;
        try {
            product = productDao.getById(productId);
            if(product == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }else {
                product = productDao.update(new Product(request.getId(),
                        request.getName(),
                        request.getDescription(),
                        request.getPrice()));
                return new ResponseEntity<>(new UpdateProductResponse(product), HttpStatus.OK);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @DeleteMapping("/products/{productId}")
    ResponseEntity<DeleteProductResponse> deleteProduct(@PathVariable int productId){
        Product product = null;
        try {
            product = productDao.getById(productId);
            if(product == null){
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            productDao.deleteById(productId);
        } catch (SQLException e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new DeleteProductResponse(product),HttpStatus.OK);
    }
}
