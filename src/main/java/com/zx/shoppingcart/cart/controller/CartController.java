package com.zx.shoppingcart.cart.controller;


import com.zx.shoppingcart.cart.model.CartItem;
import com.zx.shoppingcart.cart.model.CartItemDao;
import com.zx.shoppingcart.cart.view.*;
import com.zx.shoppingcart.product.model.Product;
import com.zx.shoppingcart.product.model.ProductDao;
import com.zx.shoppingcart.user.model.User;
import com.zx.shoppingcart.user.model.UserDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    private UserDao userDao;
    private CartItemDao cartItemDao;
    private ProductDao productDao;

    public CartController(UserDao userDao, CartItemDao cartItemDao, ProductDao productDao) {
        this.userDao = userDao;
        this.cartItemDao = cartItemDao;
        this.productDao = productDao;
    }

    /**
     *get by id
     */
    @GetMapping("/cartItems/{cartItemId}")
    public ResponseEntity<GetCartResponse> getCartItem(@PathVariable Long cartItemId){
        CartItem cartItem = cartItemDao.getById(cartItemId);
        if (cartItem == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(new GetCartResponse(cartItem), HttpStatus.OK);
    }

    /**
     *
     * get cart item lists
     *
     */
    @GetMapping("/cartItems")
    public ResponseEntity<GetCartsResponse> getCartItems(){
        List<CartItem> cartItems = cartItemDao.findAll();
        return new ResponseEntity<>(new GetCartsResponse(cartItems), HttpStatus.OK);
    }


    /**
     * create cart item
     */
    @PostMapping("/cartItems")
    public ResponseEntity<CreateCartItemResponse> createCartItem(@RequestBody CreateCartItemRequest request){

        User user = userDao.getById(request.getUserId());
        Product product = productDao.getById(request.getProductId());
        long quantity = request.getQuantity();

        CartItem cartItem = new CartItem(user,product,quantity);
        cartItemDao.save(cartItem);

        return new ResponseEntity<>(new CreateCartItemResponse(cartItem),HttpStatus.CREATED);
    }

    /**
     * update cart item
     */
    @PutMapping("cartItems/{cartItemId}")
    public ResponseEntity<UpdateCartResponse> updateCartItem(@PathVariable Long cartItemId, @RequestBody UpdateCartRequest request){
        CartItem item = cartItemDao.getById(cartItemId);

        if(item == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        item.setQuantity(request.getQuantity());
        cartItemDao.save(item);

        return new ResponseEntity<>(new UpdateCartResponse(item), HttpStatus.OK);
    }

    /**
     * delete cart item
     */

    @DeleteMapping("cartItems/cartItemId")
    public ResponseEntity deleteCartItem(@PathVariable long cartItemId){
        CartItem cartItem = cartItemDao.getById(cartItemId);

        if(cartItem == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        cartItemDao.delete(cartItem);

        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
