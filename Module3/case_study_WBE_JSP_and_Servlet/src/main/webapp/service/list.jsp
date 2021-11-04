<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Service Management Application</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.11.3/datatables.min.css"/>


</head>
<body>
<center>
    <h1>Service Management</h1>
    <h2>
        <a href="/service_servlet?action_service_get=create">Add New Service</a>
    </h2>
</center>

<div align="center">
    <table id="serviceList" border="1" cellpadding="5">
        <caption><h2>List of service</h2></caption>
        <thead>
        <tr>
            <th>No.</th>
            <th>name_service</th>
            <th>area</th>
            <th>floor</th>
            <th>max_people</th>
            <th>status</th>
            <th>typeOfRent</th>
            <th>typeOfService</th>
            <th>Edit/Delete</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="service" items="${serviceList}" varStatus="loop">
            <tr>
                <td><c:out value="${loop.count}"/></td>
                <td>${service.name_service}</td>
                <td>${service.area}</td>
                <td>${service.floor}</td>
                <td>${service.max_people}</td>
                <td>${service.status}</td>
                <td>${service.typeOfRent.typeOfRent}</td>
                <td>${service.typeOfService.typeOfService}</td>
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
