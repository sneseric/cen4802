<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>To-Do List</title>
</head>
<body>
    <h2>To-Do List</h2>
    <form method="POST" action="todo">
        <input type="text" name="task" />
        <input type="submit" value="Add Task" />
        <input type="hidden" name="action" value="add" />
    </form>
    <hr/>
    <form method="GET" action="todo">
        <input type="submit" value="View To-Do List" />
    </form>
</body>
</html>
