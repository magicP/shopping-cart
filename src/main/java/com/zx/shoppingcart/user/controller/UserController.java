package com.zx.shoppingcart.user.controller;

import com.zx.shoppingcart.user.model.User;
import com.zx.shoppingcart.user.model.UserDao;
import com.zx.shoppingcart.user.view.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {
    private UserDao userDao;


    public UserController(UserDao userDao) {
        this.userDao = userDao;
    }

    @GetMapping("users")
    public ResponseEntity<ListUsersResponse> listUsers(){
        List<User> users =  userDao.findAll();
        return new ResponseEntity<>(new ListUsersResponse(users), HttpStatus.OK);
    }

    @GetMapping("users/{userId}")
    public ResponseEntity<UserView> getUserById(@PathVariable long userId){
        User user = userDao.getById(userId);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new UserView(user.getId(),user.getName()),HttpStatus.OK);
    }

    @GetMapping("users/user/{userName}")
    public ResponseEntity<UserView> getUserByName(@PathVariable String userName){
        User user = userDao.getByName(userName);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(new UserView(user.getId(),user.getName()),HttpStatus.OK);
    }

    @PostMapping("users")
    public ResponseEntity<UserView> createUser(@RequestBody CreateUserRequest request){
        String name = request.getName();
        String passwd = request.getPasswd();

        User user = new User(name,passwd);
        userDao.save(user);

        return new ResponseEntity<>(new UserView(user.getId(),user.getName()),HttpStatus.CREATED);
    }


    @PutMapping("users/{userId}")
    public ResponseEntity<UserView> updateUser(@PathVariable long userId,@RequestBody UpdateUserRequest request){
        User user = userDao.getById(userId);

        if(user == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        user.setName(request.getName());
        user.setPassword(request.getPasswd());
        userDao.save(user);

        return new ResponseEntity<>(new UserView(user.getId(),user.getName()),HttpStatus.OK);
    }

}
