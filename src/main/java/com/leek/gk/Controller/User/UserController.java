package com.leek.gk.Controller.User;

import com.leek.gk.Connect.DatabaseUtils;
import com.leek.gk.dao.impl.UserDaoImpl;
import com.leek.gk.model.User;
import com.leek.gk.Service.IUserService;
import com.leek.gk.Service.impl.UserServiceImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.Console;
import java.io.IOException;

@WebServlet("/login")
public class UserController extends HttpServlet {
    private IUserService userService;

    @Override
    public void init() throws ServletException {
        userService = new UserServiceImpl(new UserDaoImpl());
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Chuyển hướng đến trang đăng nhập
        request.getRequestDispatcher("/views/user/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.login(username, password);
        if (user != null) {
            request.getSession().setAttribute("user", user);
            if (user.isAdmin()) {
                response.sendRedirect("/admin/dashboard");
            } else {
                response.sendRedirect("/user/home");
            }
        } else {
            response.sendRedirect("/views/user/login.jsp?error=invalid");
        }
    }
}

