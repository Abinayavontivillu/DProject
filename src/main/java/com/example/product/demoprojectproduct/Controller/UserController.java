package com.example.product.demoprojectproduct.Controller;


import com.example.product.demoprojectproduct.Model.User;
import com.example.product.demoprojectproduct.Service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String id) {
        User user=userService.getUserById(id);
       return user!=null? ResponseEntity.ok(user):ResponseEntity.notFound().build();
    }
    @PostMapping
    public ResponseEntity<User> addUser(@Valid @RequestBody User user) {

        User createdUser = userService.addUser(user);
        return ResponseEntity.ok(createdUser);

    }



    @PutMapping("/{userId}")
    public User updateUser(@PathVariable String userId, @Valid @RequestBody User user) {
        return userService.updateUser(userId, user);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }
}
