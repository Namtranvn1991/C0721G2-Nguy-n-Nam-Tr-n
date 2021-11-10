<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Service</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h1>Create New Service</h1>
<a href="/service_servlet">Go back</a>
<div class="wrapper ">
    <div class="main-panel">
        <!-- Navbar -->
        <!-- End Navbar -->
        <div class="content">
            <div class="container">
                <div class="row">
                    <div class="col-12 text-center">
                        <h1>create service</h1>
                    </div>
                    <c:if test='${requestScope["error_messenger"] != null}'>
                        <span class="col-12 border bg-light">${requestScope["error_messenger"]}</span>
                    </c:if>
                    <form action="/service_servlet" class="col-12" method="post">
                        <input type="hidden" name="action_service_post" value="create">
                        <div class="form-group col-12">
                            <label class="col-12 float-left">name_service</label>
                            <input type="text" name="name_service" class="form-control col-12 float-left mt-2" placeholder="Enter Name">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left">area</label>
                            <input type="number" name="area" class="form-control col-12 float-left mt-2" placeholder="0">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left">floor</label>
                            <input type="number" name="floor" class="form-control col-12 float-left mt-2" placeholder="0">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left">max_people</label>
                            <input type="number" name="max_people" class="form-control col-12 float-left mt-2" placeholder="0">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left">status</label>
                            <input type="text" name="status" class="form-control col-12 float-left mt-2" placeholder="status">
                        </div>

                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-1">typeOfRent</label>
                            <select name="idTypeOfRent" class="form-control col-12 float-left">
                                <option>typeOfRent</option>
                                <c:forEach var="typeOfRentSV" items="${typeOfRentList}">
                                    <option value="${typeOfRentSV.idTypeOfRent}"> ${typeOfRentSV.idTypeOfRent} - ${typeOfRentSV.typeOfRent} - ${typeOfRentSV.price}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-1">TypeOfService</label>
                            <select name="idTypeOfService" class="form-control col-12 float-left">
                                <option>TypeOfService</option>
                                <c:forEach var="typeOfService" items="${typeOfServiceList}">
                                    <option value="${typeOfService.idTypeOfService}"> ${typeOfService.idTypeOfService} - ${typeOfService.typeOfService} </option>
                                </c:forEach>
                            </select>
                        </div>

                        <button type="submit" class="btn btn-primary float-right">Create</button>
                        <a href="/service_servlet"><button type="button" class="btn btn-info float-right">Back</button></a>
                    </form>
                </div>
            </div>
        </div>
        <%-- Footer --%>
    </div>
</div>



<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
        integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
        crossorigin="anonymous"></script>
</body>
</html>
