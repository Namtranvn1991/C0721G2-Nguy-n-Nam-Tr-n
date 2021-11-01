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
<form action="/customer_servlet" method="post">
    <input type="hidden" name="action_customer_post" value="edit">
    <input type="hidden" name="id" value="${customer.id_customer}">
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
        </tr>
        <tr>
            <td><input type="text" name="name" value="${customer.name}"></td>
            <td><input type="text" name="email" value="${customer.email}"></td>
            <td><input type="date" name="birthday" value="${customer.birthday}"></td>
            <td><input type="text" name="id_card" value="${customer.id_card}"></td>
            <td><input type="text" name="phone_number" value="${customer.phone_number}"></td>
            <td><input type="text" name="address" value="${customer.address}"></td>
            <td><select name="type_customer">
                <option value="1">
                    Diamond
                </option>
                <option value="2">
                    Platinum
                </option>
                <option value="3">
                    Gold
                </option>
                <option value="4">
                    Silver
                </option>
                <option value="5">
                    Member
                </option>
            </select>
            </td>
        </tr>
    </table>
    <input type="submit" value="Edit customer">
</div>
</form>
</body>
</html>
