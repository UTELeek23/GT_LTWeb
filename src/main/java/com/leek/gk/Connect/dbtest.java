package com.leek.gk.Connect;

import java.sql.*;

public class dbtest {
    private static final String URL = "jdbc:mysql://localhost:3306/giuaky_ltweb";
    private static final String USER = "root";
    private static final String PASSWORD = "Lak@2302";
    static String testUsername = "Admin";
    public static void main(String[] args) {
        String query = "SELECT * FROM users WHERE Username = ?";

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, testUsername); // Gắn giá trị vào placeholder "?"

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("UserID"));
                    System.out.println("Username: " + resultSet.getString("Username"));
                    System.out.println("Password: " + resultSet.getString("Password"));
//                    System.out.println("Role: " + resultSet.getString("role"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

