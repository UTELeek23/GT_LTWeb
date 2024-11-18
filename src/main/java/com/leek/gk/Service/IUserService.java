package com.leek.gk.Service;
import com.leek.gk.model.User;

public interface IUserService {
    User login(String username, String password);
}
