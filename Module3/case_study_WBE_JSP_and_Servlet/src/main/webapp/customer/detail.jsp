<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Detail</title>
</head>
<body>
<center>
    <h1>Customer Detail</h1>
    <h2>
        <a href="/customer_servlet">Go back</a>
    </h2>
</center>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Customers</h2></caption>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>birthday</th>
            <th>id_card</th>
            <th>phone_number</th>
            <th>address</th>
            <th>type_customer</th>
            <th>Edit/Delete</th>
        </tr>
        <tr>
            <td>${customer.name}</td>
            <td>${customer.email}</td>
            <td>${customer.birthday}</td>
            <td>${customer.id_card}</td>
            <td>${customer.phone_number}</td>
            <td>${customer.address}</td>
            <td>${customer.type_customer}</td>
            <td>
                <a href="/customer_servlet?action_customer_get=edit&id=${customer.id_customer}">Edit</a>
                <a href="/customer_servlet?action_customer_get=delete&id=${customer.id_customer}">Delete</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>