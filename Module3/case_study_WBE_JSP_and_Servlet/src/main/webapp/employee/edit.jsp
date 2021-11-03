<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Detail</title>
</head>
<body>
<center>
    <h1>Employee Detail</h1>
    <h2>
        <a href="/employee_servlet">Go back</a>
    </h2>
</center>
<form action="/employee_servlet" method="post">
    <input type="hidden" name="action_employee_post" value="edit">
    <input type="hidden" name="code" value="${employee.employee_code}">
    <input type="hidden" name="id" value="${employee.id_employee}">
<div align="center">
    <table border="1" cellpadding="5">
        <tr>
            <th>Code</th>
            <th>Name</th>
            <th>Email</th>
            <th>birthday</th>
            <th>id_card</th>
            <th>phone_number</th>
            <th>address</th>
            <th>salary</th>
            <th>degree</th>
            <th>department</th>
            <th>position</th>
        </tr>
        <tr>
            <td>${employee.employee_code}</td>
            <td><input type="text" name="name" value="${employee.name}"></td>
            <td><input type="text" name="email" value="${employee.email}"></td>
            <td><input type="date" name="birthday" value="${employee.birthday}"></td>
            <td><input type="text" name="id_card" value="${employee.id_card}"></td>
            <td><input type="text" name="phone_number" value="${employee.phone_number}"></td>
            <td><input type="text" name="address" value="${employee.address}"></td>
            <td><input type="text" name="salary" value="${employee.salary}"></td>
            <td><select name="position">
                <option value="1">
                    Manager
                </option>
                <option value="2">
                    Deputy
                </option>
                <option value="3">
                    Staff
                </option>
            </select>
            </td>
            <td><select name="degree">
                <option value="1">
                    High school graduated
                </option>
                <option value="2">
                    Bachelor
                </option>
                <option value="3">
                    Engineer
                </option>
                <option value="4">
                    Master
                </option>
            </select>
            </td>
            <td><select name="department">
                <option value="1">
                    Bussiness
                </option>
                <option value="2">
                    Technical
                </option>
                <option value="3">
                    Administrative
                </option>
                <option value="4">
                    Management
                </option>
                <option value="5">
                    Service
                </option>
            </select>
            </td>
        </tr>
    </table>
    <input type="submit" value="Edit Employee">
</div>
</form>
</body>
</html>
