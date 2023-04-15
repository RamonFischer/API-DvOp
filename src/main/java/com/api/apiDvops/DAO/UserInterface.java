package com.api.apiDvops.DAO;

import com.api.apiDvops.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserInterface extends CrudRepository<User, Integer> {
     String deleteByEmail(String email);
}
