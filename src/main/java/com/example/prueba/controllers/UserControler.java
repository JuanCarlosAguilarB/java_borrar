package com.example.prueba.controllers;

import com.example.prueba.models.User;
import com.example.prueba.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserControler {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/users")
    public List<User> findAll() {
        return userService.findAll();
    }

    @PostMapping(value = "/users")
    public User save(User user) {
        return userService.save(user);
    }

    @PutMapping(value = "/users/")
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(userService.findById(id));
    }

}
