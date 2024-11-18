package com.leek.gk.Service.impl;

import com.leek.gk.Service.IUserService;
import com.leek.gk.dao.IUserDao;
import com.leek.gk.dao.impl.UserDaoImpl;
import com.leek.gk.model.User;
public class UserServiceImpl implements IUserService {
    private IUserDao userDao;

    public UserServiceImpl(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User login(String username, String password) {
        User user = userDao.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
//    public static void main(String[] args) {
//        UserServiceImpl userService = new UserServiceImpl(new UserDaoImpl());
//        User user = userService.login("Admin", "123123");
//        if (user != null) {
//            System.out.println(user.isAdmin());
//        }
//        else{
//            System.out.println("not working");
//        }
//    }
}
