<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Customer Management Application</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
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
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#Modal-${customer.id_customer}">
                        Delete
                    </button>
                </td>
            </tr>
            <div class="modal fade" id="Modal-${customer.id_customer}" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered" role="document">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h5 class="modal-title" id="exampleModalLongTitle">Confirm</h5>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <div class="modal-body">
                            Do You want to delete this customer?
                            <a href="/customer_servlet?action_customer_get=detail&id=${customer.id_customer}"><c:out value="${customer.name}"/></a>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-primary"><a href="/customer_servlet?action_customer_get=delete&id=${customer.id_customer}">Delete</a></button>
                        </div>
                    </div>
                </div>
            </div>
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
