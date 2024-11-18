package com.leek.gk.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtils {
    // Thông tin kết nối
    private static final String URL = "jdbc:mysql://localhost:3306/giuaky_ltweb";
    private static final String USER = "root";
    private static final String PASSWORD = "Lak@2302";

    // Phương thức để lấy kết nối
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Unable to connect to the database");
        }
    }

    // Kiểm tra kết nối
    public static void main(String[] args) {
        try (Connection connection = getConnection()) {
            System.out.println("Kết nối thành công!");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Kết nối thất bại!");
        }
    }
}
