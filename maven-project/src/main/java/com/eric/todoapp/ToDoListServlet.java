package com.eric.todoapp;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

public class ToDoListServlet extends HttpServlet {
    private Connection conn;

    public void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/todo_list_db?user=root&password=password");
            System.out.println("Database connection established");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doGet called");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/todo.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doPost called - Action: " + request.getParameter("action"));
        String task = request.getParameter("task");
        String action = request.getParameter("action");

        try {
            if ("add".equals(action)) {
                addTask(task);
            } else if ("delete".equals(action)) {
                deleteTask(Integer.parseInt(task));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("todo.jsp");
    }

    private void addTask(String task) {
        String insertQuery = "INSERT INTO todo_list_items (task) VALUES (?)";
        try (PreparedStatement pstmt = conn.prepareStatement(insertQuery)) {
            pstmt.setString(1, task);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void deleteTask(int id) {
        String deleteQuery = "DELETE FROM todo_list_items WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(deleteQuery)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
