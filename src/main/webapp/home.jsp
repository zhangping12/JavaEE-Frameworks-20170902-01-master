<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-04-11
  Time: 21:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>home page</title>
    <script>
        function del() {
            return confirm('REMOVE?');
        }
    </script>
</head>
<body>
<c:if test="${sessionScope.user eq null}">
    <c:redirect url="index.jsp"/>
</c:if>
<h1>home page</h1>
${sessionScope.user.username}
<p><a href="/user/signOut">Sign out</a></p>
<hr>
<form action="/book/create" method="post">
    <input name="title" placeholder="Title"><br>
    <input name="price" placeholder="Price"><br>
    <input name="amount" placeholder="Amount"><br>
    <input name="pubTime" placeholder="Publish time"><br>
    <input type="submit" value="Create"><br>
</form>
<hr>
<table border="1">
    <tr>
        <th>COUNT</th>
        <th>TITLE</th>
        <th>PRICE</th>
        <th>AMOUNT</th>
        <th>PUBLISH DATE</th>
        <th colspan="2">OPERATIONS</th>
    </tr>
    <c:forEach var="book" items="${sessionScope.books}" varStatus="vs">
        <tr>
            <td>${vs.count}</td>
            <td>${book.title}</td>
            <td>${book.price}</td>
            <td>${book.amount}</td>
            <td>${book.pubTime}</td>
            <td><a href="/book/queryById/${book.id}">EDIT</a></td>
            <td><a href="/book/remove/${book.id}" onclick="return del()">REMOVE</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
