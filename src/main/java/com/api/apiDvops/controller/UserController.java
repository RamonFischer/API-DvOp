package com.api.apiDvops.controller;

import com.api.apiDvops.entity.User;
import com.api.apiDvops.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "users")
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

    @DeleteMapping("/{email}")
    @Transactional
    public ResponseEntity<?> deleteUser(@PathVariable String email ){
        userService.deleteEmail(email);
        return ResponseEntity.status(204).build();
    }

}
