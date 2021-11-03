<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Employee Management Application</title>
</head>
<body>
<center>
    <h1>Employee Management</h1>
    <h2>
        <a href="/employee_servlet?action_employee_get=create">Add New Employee</a>
    </h2>
</center>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of Employee</h2></caption>
        <tr>
            <th>No.</th>
            <th>Employee Code</th>
            <th>Name</th>
            <th>Address</th>
            <th>Department</th>
            <th>Edit/Delete</th>
        </tr>
        <c:forEach var="employee" items="${employeeList}" varStatus="loop">
            <tr>
                <td><c:out value="${loop.count}"/></td>
                <td><a href="/employee_servlet?action_employee_get=detail&id=${employee.id_employee}"><c:out value="${employee.employee_code}"/></a></td>
                <td><a href="/employee_servlet?action_employee_get=detail&id=${employee.id_employee}"><c:out value="${employee.name}"/></a></td>
                <td><c:out value="${employee.address}"/></td>
                <td><c:choose>
                    <c:when test="${employee.department==1}">
                        Bussiness
                    </c:when>
                    <c:when test="${employee.department==2}">
                        Technical
                    </c:when>
                    <c:when test="${employee.department==3}">
                        Administrative
                    </c:when>
                    <c:when test="${employee.department==4}">
                        Management
                    </c:when>
                    <c:when test="${employee.department==5}">
                        Service
                    </c:when>
                </c:choose>
                </td>
                <td>
                    <a href="/employee_servlet?action_employee_get=edit&id=${employee.id_employee}">Edit</a>
                    <a href="/employee_servlet?action_employee_get=delete&id=${employee.id_employee}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<h2>
    <a href="/home">Back to Home</a>
</h2>
</body>
</html>
