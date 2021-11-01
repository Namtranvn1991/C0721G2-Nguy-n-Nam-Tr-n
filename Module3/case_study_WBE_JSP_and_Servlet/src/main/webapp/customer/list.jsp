<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
</head>
<body>
<center>
    <h1>Customer Management</h1>
    <h2>
        <a href="/customer_servlet?action_customer_get=create">Add New Customer</a>
    </h2>
</center>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Customers</h2></caption>
        <tr>
            <th>No.</th>
            <th>Name</th>
            <th>Address</th>
            <th>Type</th>
            <th>Edit/Delete</th>
        </tr>
        <c:forEach var="customer" items="${customerList}" varStatus="loop">
            <tr>
                <td><c:out value="${loop.count}"/></td>
                <td><a href="/customer_servlet?action_customer_get=detail&id=${customer.id_customer}"><c:out value="${customer.name}"/></a></td>
                <td><c:out value="${customer.address}"/></td>
                <td><c:choose>
                    <c:when test="${customer.type_customer==1}">
                        DIAMOND
                    </c:when>
                    <c:when test="${customer.type_customer==2}">
                        PLATINUM
                    </c:when>
                    <c:when test="${customer.type_customer==3}">
                        GOLD
                    </c:when>
                    <c:when test="${customer.type_customer==4}">
                        SILVER
                    </c:when>
                    <c:when test="${customer.type_customer==5}">
                        MEMBER
                    </c:when>
                </c:choose>
                </td>
                <td>
                    <a href="/customer_servlet?action_customer_get=edit&id=${customer.id_customer}">Edit</a>
                    <a href="/customer_servlet?action_customer_get=delete&id=${customer.id_customer}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
