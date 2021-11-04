<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Search Employee Application</title>
</head>
<body>
<center>
    <h1>Employee Search</h1>
</center>
    <div>
        <form action="/employee_servlet" method="post">
            <input type="hidden" name="action_employee_post" value="search">
            <input name="nameSearch" placeholder="nameSearch">
            <input name="addressSearch" placeholder="addressSearch">
            <input name="phoneSearch" placeholder="phoneSearch">
            <input type="submit" value="Search">
        </form>
    </div>
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
        <c:forEach var="employee" items="${listSearch}" varStatus="loop">
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
    <a href="/employee_servlet">Back</a>
</h2>
</body>
</html>