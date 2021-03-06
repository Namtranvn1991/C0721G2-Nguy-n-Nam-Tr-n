<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Product managerment</title>
</head>
<body>
<h2>List product</h2>
<p>
    <a href="/">Back to home</a>
</p>
<form action="/product_servlet" method="post">
    <input type="hidden" name="actionUser" value="search">
    <input type="text" name="nameSearch" value="Enter name">
    <input type="submit" value="search">
</form>
<table border="1">
    <tr>
        <th>No</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Brand</th>
        <td>Edit</td>
        <td>Delete</td>
    </tr>
    <c:forEach var="product" items='${searchList}' varStatus="loop">
        <tr>
            <td><a href="/product_servlet?actionUser=view?id=${product.id}"><c:out value="${loop.count}"></c:out></a></td>
            <td><a href="/product_servlet?actionUser=view?id=${product.id}"><c:out value="${product.name}"></c:out></a></td>
            <td><c:out value="${product.price}"></c:out></td>
            <td><c:out value="${product.description}"></c:out></td>
            <td><c:out value="${product.brand}"></c:out></td>
            <td><a href="/product_servlet?actionUser=edit&id=${product.id}">Edit</a></td>
            <td><a href="/product_servlet?actionUser=delete&id=${product.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
