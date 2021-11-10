<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books Management Application</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<center>
    <h1>Borrow Books list</h1>
</center>

<div align="center">
    <table border="1" cellpadding="5">
        <caption><h2>List of borrow book</h2></caption>
        <tr>
            <th>No.</th>
            <th>code_borrow_book</th>
            <th>id_book</th>
            <th>id_student</th>
            <th>status</th>
            <th>day_borrow</th>
            <th>day_give_back</th>
            <th>Edit/Delete</th>
        </tr>
        <c:forEach var="borrow" items="${borrowBooks}" varStatus="loop">
            <tr>
                <td><c:out value="${loop.count}"/></td>
                <td><c:out value="${borrow.code_borrow_book}"/></td>
                <td><c:out value="${borrow.book.code_book}"/></td>
                <td><c:out value="${borrow.student.name_student}"/></td>
                <td><c:out value="${borrow.status}"/></td>
                <td><c:out value="${borrow.date_borrow}"/></td>
                <td><c:out value="${borrow.date_give_back}"/></td>
                </td>
                <td>
                    <a href="/borrow_servlet?action_borrow_get=edit&id=${book.id_book}">Borrow</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<h2>
    <a href="/home">Back to Home</a>
</h2>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
