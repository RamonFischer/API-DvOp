package com.api.apiDvops.service;

import com.api.apiDvops.DAO.UserInterface;
import com.api.apiDvops.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserInterface repository;

    public List<User> listAll(){
        List<User> users = (List<User>) repository.findAll();
        return users;
    }

    public User addUser(User user){
        return repository.save(user);
    }

    public void deleteEmail(String email){
        repository.deleteByEmail(email);
    }
}
