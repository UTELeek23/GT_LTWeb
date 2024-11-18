package com.leek.gk.dao;
import com.leek.gk.model.User;

import java.util.List;

public interface IUserDao {
    User findByUsername(String username);
    List<User> findAll();
}
