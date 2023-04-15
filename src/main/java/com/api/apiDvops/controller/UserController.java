package com.api.apiDvops.controller;

import ch.qos.logback.core.model.Model;
import com.api.apiDvops.DAO.UserInterface;
import com.api.apiDvops.entity.User;
import com.api.apiDvops.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserInterface userInterface;

    @GetMapping("/")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @GetMapping(value = "/get")
    public ResponseEntity<List<User>> userlist(){
        return ResponseEntity.ok(userService.listAll());
    }

    @PostMapping(value = "/post")
    public ResponseEntity<User> createUser(@RequestBody User newUser){
        return ResponseEntity.status(201).body(userService.addUser(newUser));
    }

    @DeleteMapping("/delete")
    @Transactional
    public String deleteUser(@PathVariable String email ){
        userService.deleteEmail(email);
        userInterface.deleteAll();
        return email;
    }
}
