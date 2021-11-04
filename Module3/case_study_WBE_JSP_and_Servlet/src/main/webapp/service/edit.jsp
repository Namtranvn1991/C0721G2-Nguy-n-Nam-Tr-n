<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Service Detail</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<center>
    <h1>Service Detail</h1>
    <h2>
        <a href="/service_servlet">Go back</a>
    </h2>
</center>
<c:if test='${requestScope["error_messenger"] != null}'>
    <span class="col-12 border bg-light">${requestScope["error_messenger"]}</span>
</c:if>
<form action="/service_servlet" class="col-12" method="post">
    <input type="hidden" name="action_service_post" value="edit">
    <input type="hidden" name="id" value="${service.id_service}">
    <div class="form-group col-12">
        <label class="col-12 float-left">name_service</label>
        <input type="text" name="name_service" class="form-control col-12 float-left mt-2"
               value="${service.name_service}" readonly>
    </div>
    <div class="form-group col-12">
        <label class="col-12 float-left">area</label>
        <input type="number" name="area" class="form-control col-12 float-left mt-2" value="${service.area}">
    </div>
    <div class="form-group col-12">
        <label class="col-12 float-left">floor</label>
        <input type="number" name="floor" class="form-control col-12 float-left mt-2" value="${service.floor}">
    </div>
    <div class="form-group col-12">
        <label class="col-12 float-left">max_people</label>
        <input type="number" name="max_people" class="form-control col-12 float-left mt-2"
               value="${service.max_people}">
    </div>
    <div class="form-group col-12">
        <label class="col-12 float-left">status</label>
        <input type="text" name="status" class="form-control col-12 float-left mt-2" value="${service.status}">
    </div>

    <div class="form-group col-12">
        <label class="col-12 float-left mt-1">typeOfRent</label>
        <select name="idTypeOfRent" class="form-control col-12 float-left">
            <c:forEach var="typeOfRentSV" items="${typeOfRentList}">
                <c:choose>
                    <c:when test="${service.getTypeOfRent().getIdTypeOfRent() == typeOfRentSV.idTypeOfRent}">
                        <option value="${typeOfRentSV.idTypeOfRent}" selected> ${typeOfRentSV.idTypeOfRent}
                            - ${typeOfRentSV.typeOfRent} - ${typeOfRentSV.price}</option>
                    </c:when>
                    <c:otherwise>
                        <option value="${typeOfRentSV.idTypeOfRent}"> ${typeOfRentSV.idTypeOfRent}
                            - ${typeOfRentSV.typeOfRent} - ${typeOfRentSV.price}</option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </div>

    <div class="form-group col-12">
        <label class="col-12 float-left mt-1">TypeOfService</label>
        <select name="idTypeOfService" class="form-control col-12 float-left">
            <c:forEach var="typeOfService" items="${typeOfServiceList}">
                <c:choose>
                    <c:when test="${service.typeOfService.idTypeOfService == typeOfService.idTypeOfService}">
                        <option value="${typeOfService.idTypeOfService}" selected> ${typeOfService.idTypeOfService} - ${typeOfService.typeOfService} </option>
                    </c:when>
                    <c:otherwise>
                        <option value="${typeOfService.idTypeOfService}"> ${typeOfService.idTypeOfService} - ${typeOfService.typeOfService} </option>
                    </c:otherwise>
                </c:choose>
            </c:forEach>
        </select>
    </div>
    <button type="submit" class="btn btn-primary float-right">Edit</button>
    <a href="/service_servlet">
        <button type="button" class="btn btn-info float-right">Back</button>
    </a>
</form>


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
