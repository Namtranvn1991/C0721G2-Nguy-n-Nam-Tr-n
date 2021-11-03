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

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Employee</h2></caption>
        <tr>
            <th>Code</th>
            <th>Name</th>
            <th>Email</th>
            <th>birthday</th>
            <th>id_card</th>
            <th>phone_number</th>
            <th>address</th>
            <th>position</th>
            <th>degree</th>
            <th>department</th>
            <th>salary</th>
            <th>Edit/Delete</th>
        </tr>
        <tr>
            <td>${employee.employee_code}</td>
            <td>${employee.name}</td>
            <td>${employee.email}</td>
            <td>${employee.birthday}</td>
            <td>${employee.id_card}</td>
            <td>${employee.phone_number}</td>
            <td>${employee.address}</td>
            <td>${employee.position}</td>
            <td>${employee.degree}</td>
            <td>${employee.department}</td>
            <td>${employee.salary}</td>
            <td>
                <a href="/employee_servlet?action_employee_get=edit&id=${employee.id_employee}">Edit</a>
                <a href="/employee_servlet?action_employee_get=delete&id=${employee.id_employee}">Delete</a>
            </td>
        </tr>
    </table>
</div>
</body>
</html>