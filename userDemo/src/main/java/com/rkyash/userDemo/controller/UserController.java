package com.rkyash.userDemo.controller;

import com.rkyash.userDemo.dto.EntityOperation;
import com.rkyash.userDemo.dto.User;
import com.rkyash.userDemo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    EntityOperation ret;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable String id) {
        return userService.getUser(id);
    }


    @ApiOperation(value = "Save User data", response = EntityOperation.class)
    @PostMapping("/user")
    public ResponseEntity<EntityOperation> addUser(@RequestBody User user) {
        ret = new EntityOperation();
        userService.addUser(user);
        ret.setId(user.getId());
        ret.setSuccess(true);
        ret.setMessage("Successfully Saved");

        return ResponseEntity.ok(ret);
    }

    @PutMapping("/user")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/user/{id}")
    public User deleteUser(@PathVariable String id) {
        return userService.deleteUser(id);
    }


}
