package com.leek.gk.dao.impl;
import com.leek.gk.Connect.DatabaseUtils;

import com.leek.gk.dao.IUserDao;
import com.leek.gk.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl implements IUserDao {
    @Override
    public User findByUsername(String username) {
        System.out.println(username);
        String query = "SELECT * FROM users WHERE username = ?";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, username);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    User user = new User();
                    user.setUserID(resultSet.getInt("UserID"));
                    user.setUserName(resultSet.getString("Username"));
                    user.setPassword(resultSet.getString("Password"));
                    user.setSeller(resultSet.getBoolean("isSeller"));
                    user.setAdmin(resultSet.getBoolean("isAdmin"));
                    return user;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String query = "SELECT * FROM users";
        try (Connection connection = DatabaseUtils.getConnection();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                User user = new User();
                user.setUserID(resultSet.getInt("UserID"));
                user.setUserName(resultSet.getString("Username"));
                user.setPassword(resultSet.getString("Password"));
                user.setSeller(resultSet.getBoolean("isSeller"));
                user.setAdmin(resultSet.getBoolean("isAdmin"));
                users.add(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }
//    public static void main(String[] args) {
//        UserDaoImpl userDao = new UserDaoImpl();
//        User user = userDao.findByUsername("Admin");
//
//        if (user != null) {
//            // Kiểm tra kiểu dữ liệu của password
//            System.out.println("Password: " + user.getPassword());
//            System.out.println("Type of Password: " + ((Object) user.getPassword()).getClass().getName());
//        } else {
//            System.out.println("User not found.");
//        }
//    }

}