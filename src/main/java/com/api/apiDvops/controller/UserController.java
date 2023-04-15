package com.api.apiDvops.controller;

import com.api.apiDvops.DAO.UserInterface;
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

    @Autowired
    private UserInterface userInterface;

    @GetMapping(value = "/aa")
    public ResponseEntity<List<User>> userlist2(){
        return ResponseEntity.ok(userService.listAll());
    }

    
    @PostMapping(value = "/post")
    public /*ResponseEntity<User>*/ String createUser(@RequestBody User newUser){
        return "foi!";
        //return ResponseEntity.status(201).body(userService.addUser(newUser));
    }

    /*@PutMapping
    public ResponseEntity<User> editUser(@RequestBody User newUser){
        User user = userInterface.save(newUser);
        return ResponseEntity.ok(user);
    }*/

    @DeleteMapping("/delete")
    @Transactional
    public String deleteUser(@PathVariable String email ){
        userService.deleteEmail(email);
        userInterface.deleteAll();
        return email;
    }
}
