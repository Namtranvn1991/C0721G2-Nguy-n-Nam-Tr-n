<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Product managerment</title>
  </head>
  <body>
  <h2>List product</h2>
  <a href="/product_servlet?actionUser=create"> Create new product</a>
  <br>
  <a href="/product_servlet?actionUser=search"> search product</a>
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
    <c:forEach var="product" items='${products}' varStatus="loop">
      <tr>
        <td><a href="/product_servlet?actionUser=view&id=${product.id}"><c:out value="${loop.count}"></c:out></a></td>
        <td><a href="/product_servlet?actionUser=view&id=${product.id}"><c:out value="${product.name}"></c:out></a></td>
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
