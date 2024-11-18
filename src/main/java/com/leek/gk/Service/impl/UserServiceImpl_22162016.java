package com.leek.gk.Service.impl;

import com.leek.gk.Service.IUserService;
import com.leek.gk.dao.IUserDao;
import com.leek.gk.model.User_22162016;
public class UserServiceImpl_22162016 implements IUserService {
    private IUserDao userDao;

    public UserServiceImpl_22162016(IUserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User_22162016 login(String username, String password) {
        User_22162016 user = userDao.findByUsername(username);
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
