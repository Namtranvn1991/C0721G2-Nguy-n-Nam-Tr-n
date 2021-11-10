<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Contract Management Application</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.11.3/datatables.min.css"/>


</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container">
        <a href="#" class="navbar-brand d-flex align-items-center">
            <img src="https://1000logos.net/wp-content/uploads/2021/10/logo-Meta-500x281.png" style="width: 100px">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation" style="">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarNavDropdown">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="/customer_servlet" >Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/employee_servlet">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/service_servlet">Service</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/contract_servlet">Contract</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Sign in</a>
                </li>
            </ul>
        </div>

    </div>
</nav>
<center>
    <h1>Service Contract</h1>
    <h2>
        <a href="/service_servlet?action_service_get=create">Add New Contract</a>
    </h2>
</center>

<div align="center">
    <table id="serviceList" border="1" cellpadding="5">
        <caption><h2>List of service</h2></caption>
        <thead>
        <tr>
            <th>No.</th>
            <th>ContractID</th>
            <th>Customer</th>
            <th>Employee</th>
            <th>Service</th>
            <th>contract_date</th>
            <th>end_date</th>
            <th>deposit</th>
            <th>Edit/Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="contract" items="${contractList}" varStatus="loop">
            <tr>
                <td><c:out value="${loop.count}"/></td>
                <td>${contract.id_contract}</td>
                <td><a href="/customer_servlet?action_customer_get=detail&id=${contract.customer.id_customer}"><c:out value="${contract.customer.name}"/></a></td>
                <td><a href="/employee_servlet?action_employee_get=detail&id=${contract.employee.id_employee}"><c:out value="${contract.employee.name}"/></a></td>
                <td>${contract.service.name_service}</td>
                <td>${contract.contract_date}</td>
                <td>${contract.end_date}</td>
                <td>${contract.deposit}</td>
                <td>
                    <button type="button" class="btn btn-secondary"><a href="/service_servlet?action_service_get=edit&id=${service.id_service}">Edit</a></button>
                    <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#delete-${service.id_service}">
                        Delete
                    </button>

                    <div class="modal fade" id="delete-${service.id_service}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="exampleModalLongTitle">delete confirm</h5>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    Do You want to delete this service?
                                        ${service.name_service}
                                </div>
                                <div class="modal-footer">
                                    <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                    <button type="button" class="btn btn-primary"><a href="/service_servlet?action_service_get=delete&id=${service.id_service}">Delete</a></button>
                                </div>
                            </div>
                        </div>
                    </div>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<h2>
    <a href="/home">Back to Home</a>
</h2>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>

<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.11.3/datatables.min.js"></script>

<script>
    $(document).ready(function () {
        $('#serviceList').dataTable({
            "dom": 'lrtip',
            "lengthChange": false,
            "pageLength": 10
        });
    });
</script>

</body>
</html>
