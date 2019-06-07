//package com.zx.shoppingcart.model.product;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//
//import static org.junit.Assert.assertEquals;
//
//public class ProductControllerTest {
//    private ProductController controller;
//    ProductDao productDao;
//
//    @Before
//    public void setup(){
//        controller = new ProductController(productDao);
//    }
//
//    @Test
//    public void shouldListProducts(){
//        ResponseEntity<ListProductResponse> response = controller.listProducts();
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
//
//    @Test
//    public void shouldGetProduct(){
//        int productId = 1;
//        ResponseEntity<GetProductResponse> response = controller.getProduct(productId);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
//
//    @Test
//    public void shouldCreateProduct(){
//        CreateProductRequest request = new CreateProductRequest();
//        ResponseEntity<CreateProductResponse> response = controller.createProduct(request);
//        assertEquals(HttpStatus.CREATED, response.getStatusCode());
//    }
//
//    @Test
//    public void shouldUpdateProduct(){
//        UpdateProductRequest request = new UpdateProductRequest();
//        ResponseEntity<UpdateProductResponse> response = controller.updateProduct(request);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
//
//    @Test
//    public void shouldDeleteProduct(){
//        String productId = "test";
//        ResponseEntity<DeleteProductResponse> response = controller.deleteProduct(productId);
//        assertEquals(HttpStatus.OK, response.getStatusCode());
//    }
//}
