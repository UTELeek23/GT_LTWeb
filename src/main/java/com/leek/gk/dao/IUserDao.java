package com.leek.gk.dao;
import com.leek.gk.model.User_22162016;

import java.util.List;

public interface IUserDao {
    User_22162016 findByUsername(String username);
    List<User_22162016> findAll();
}
