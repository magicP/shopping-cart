package com.zx.shoppingcart.user.view;

import com.zx.shoppingcart.user.model.User;

import java.util.List;

public class ListUsersResponse{
    private List<User> users;

    public ListUsersResponse(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return users;
    }
}
