<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/31/2021
  Time: 8:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Customer</title>
</head>
<body>
<h1>Create New Customer</h1>
<a href="/customer_servlet">Go back</a>
<form action="/customer_servlet" method="post">
    <input type="hidden" name="action_customer_post" value="create">
    <p>Name: <input type="text" name="name" value="name"></p>
    <p>birthday: <input type="date" name="birthday" value="birthday"> </p>
    <p>id_card: <input type="text" name="id_card" value="id_card"> </p>
    <p>phone_number: <input type="text" name="phone_number" value="phone_number"> </p>
    <p>address: <input type="text" name="address" value="address"> </p>
    <p>email: <input type="text" name="email" value="email"> </p>
    <p>
        <select name="type_customer">
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
    </p>
    <input type="submit" value="Create">
</form>
</body>
</html>
