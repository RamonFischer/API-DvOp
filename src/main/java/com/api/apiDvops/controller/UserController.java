package com.api.apiDvops.controller;

import com.api.apiDvops.entity.User;
import com.api.apiDvops.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/get")
    public ResponseEntity<List<User>> userlist(){
        return ResponseEntity.ok(userService.listAll());
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User newUser){
        return ResponseEntity.status(201).body(userService.addUser(newUser));
    }

    /*@PutMapping
    public ResponseEntity<User> editUser(@RequestBody User newUser){
        User user = userInterface.save(newUser);
        return ResponseEntity.ok(user);
    }*/

    @DeleteMapping("/delete/{email}")
    @Transactional
    public String deleteUser(@PathVariable String email ){
        userService.deleteEmail(email);
        return email;
    }

}
