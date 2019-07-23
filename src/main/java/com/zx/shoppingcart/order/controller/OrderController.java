package com.zx.shoppingcart.order.controller;

import com.zx.shoppingcart.order.model.Order;
import com.zx.shoppingcart.order.model.OrderDao;
import com.zx.shoppingcart.order.view.*;
import com.zx.shoppingcart.product.model.Product;
import com.zx.shoppingcart.product.model.ProductDao;
import com.zx.shoppingcart.user.model.User;
import com.zx.shoppingcart.user.model.UserDao;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class OrderController {
    private OrderDao orderDao;
    private ProductDao productDao;
    private UserDao userDao;

    public OrderController(OrderDao orderDao, ProductDao productDao, UserDao userDao) {
        this.orderDao = orderDao;
        this.productDao = productDao;
        this.userDao = userDao;
    }

    /**
     * list orders
     */
    @GetMapping("orders")
    public ResponseEntity<ListOrdersResponse> listOrders(){
        List<Order> orderList = orderDao.findAll();
        return new ResponseEntity<>(new ListOrdersResponse(orderList),HttpStatus.OK);
    }

    /**
     * get order by id
     */
    @GetMapping("orders/{orderId}")
    public ResponseEntity<GetOrderResponse> getOrder(@PathVariable long orderId){
        Order order = orderDao.getById(orderId);
        if(order == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new GetOrderResponse(order),HttpStatus.OK);
    }


    /**
     * create order
     */
    @PostMapping("/orders")
    public ResponseEntity<CreateOrderResponse> createOrder(@RequestBody CreateOrderRequest request){
        User user = userDao.getById(request.getUserId());
        Product product = productDao.getById(request.getProductId());
        long quantity = request.getQuantity();
        String status = request.getStatus();
        String address = request.getAddress();

        Order order = new Order(user,product,quantity,status,address);
        orderDao.save(order);

        return new ResponseEntity<>(new CreateOrderResponse(order), HttpStatus.CREATED);
    }


    /**
     *
     * update order
     */
    @PutMapping("/orders/{orderId}")
    public ResponseEntity<CancelOrderResponse> updateOrder(@PathVariable long orderId,@RequestBody UpdateOrderRequest request){
        Order order = orderDao.getById(orderId);
        if(order == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        order.setQuantity(request.getQuantity());
        order.setStatus(request.getStatus());
        order.setAddress(request.getAddress());

        orderDao.save(order);

        return new ResponseEntity<>(new CancelOrderResponse(), HttpStatus.OK);
    }

    @DeleteMapping("/orders/orderId")
    public ResponseEntity deleteOrder(@PathVariable long orderId){
        Order order = orderDao.getById(orderId);
        if (order == null){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        orderDao.delete(order);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
