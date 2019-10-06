package com.rkyash.userDemo.service;


import com.rkyash.userDemo.dto.User;

import java.util.List;

public interface UserService {

    public List<User> getAllUsers();
    public User getUser(String id);
    public void addUser(User user);
    public User updateUser(User user);
    public User deleteUser(String id);
}
