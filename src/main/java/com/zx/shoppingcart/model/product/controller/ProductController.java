package com.zx.shoppingcart.model.product.controller;


import com.zx.shoppingcart.model.product.model.Product;
import com.zx.shoppingcart.model.product.model.ProductDao;
import com.zx.shoppingcart.model.product.validator.CreateProductRequestValidator;
import com.zx.shoppingcart.model.product.view.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ProductController {

    private ProductDao productDao;
    private CreateProductRequestValidator createProductRequestValidator;

    public ProductController(CreateProductRequestValidator createProductRequestValidator, ProductDao productDao) {
        this.createProductRequestValidator = createProductRequestValidator;
        this.productDao = productDao;
    }

    /**
     * List products
     */
    @GetMapping("/products")
    public ResponseEntity<ListProductResponse> listProducts() {
        List<Product> products = productDao.findAll();
        return new ResponseEntity<>(new ListProductResponse(products), HttpStatus.OK);
    }

    /**
     * Get product
     */
    @GetMapping("/products/{productId}")
    public ResponseEntity<GetProductResponse> getProduct(@PathVariable long productId) {
        Product product = productDao.getById(productId);

        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(new GetProductResponse(product), HttpStatus.OK);
        }
    }

    /**
     * Create product
     */
    @PostMapping("/products")
    public ResponseEntity<CreateProductResponse> createProduct(@RequestBody CreateProductRequest createProductRequest) {
        // 实现
        boolean validate = createProductRequestValidator.validate(createProductRequest);
        if(!validate){
            //不知道用对Http状态码用对了吗？
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        Product product = productDao.save(new Product(
                createProductRequest.getName(),
                createProductRequest.getDescription(),
                createProductRequest.getPrice()));
        return new ResponseEntity<>(new CreateProductResponse(product), HttpStatus.CREATED);
    }

    /**
     * Update product
     */
    @PutMapping("/products/{productId}")
    public ResponseEntity<UpdateProductResponse> updateProduct(@PathVariable Long productId, @RequestBody UpdateProductRequest updateProductRequest) {
        Product product = productDao.getById(productId);
        if (product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        //竟然还可以这样的，数据库表的行就对应Product的一个实例
        product.setName(updateProductRequest.getName());
        product.setDescription(updateProductRequest.getDescription());
        product.setPrice(updateProductRequest.getPrice());
        productDao.save(product);
        return new ResponseEntity<>(new UpdateProductResponse(product), HttpStatus.OK);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<DeleteProductResponse> deleteProduct(@PathVariable Long productId){
        Product product = productDao.getById(productId);
        if (product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productDao.deleteById(productId);
        return new ResponseEntity<>(new DeleteProductResponse(product),HttpStatus.OK);
    }
}
