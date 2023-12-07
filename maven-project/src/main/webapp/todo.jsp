<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.sql.*" %>
<html>
<head>
    <title>To-Do List</title>
</head>
<body>
    <h2>To-Do List</h2>
    <ul>
        <% 
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1/todo_list_db?user=root&password=password");
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM todo_list_items");

                while (rs.next()) {
                    out.println("<li>" + rs.getString("task") + " - <form method='POST' action='todo'><input type='hidden' name='action' value='delete'/><input type='hidden' name='task' value='" + rs.getInt("id") + "'/><input type='submit' value='Delete'/></form></li>");
                }

                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </ul>
    <a href="index.jsp">Back to Add Task</a>
</body>
</html>
