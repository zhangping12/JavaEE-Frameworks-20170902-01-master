<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-04-09
  Time: 23:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>sign up page</title>
</head>
<body>
<h1>sign up page</h1>
<form action="/user/signUp" method="post">
    <input name="username" placeholder="Username"><br>
    <input type="password" name="password" placeholder="Password"><br>
    <input type="submit" value="Sign up">
</form>
</body>
</html>
