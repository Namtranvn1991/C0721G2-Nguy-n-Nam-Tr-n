<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Borrow book</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<h1>Borrow book</h1>
<a href="/book_servlet">Go back</a>
<div class="wrapper ">
    <div class="main-panel">
        <!-- Navbar -->
        <!-- End Navbar -->
        <div class="content">
            <div class="container">
                <div class="row">
                    <div class="col-12 text-center">
                        <h1>borrow</h1>
                    </div>
                    <c:if test='${requestScope["error_messenger"] != null}'>
                        <span class="col-12 border bg-light">${requestScope["error_messenger"]}</span>
                    </c:if>
                    <form action="/borrow_servlet" class="col-12" method="post">
                        <input type="hidden" name="action_borrow_post" value="create">
                        <div class="form-group col-12">
                            <label class="col-12 float-left">Ma muon sach</label>
                            <input type="text" name="code_borrow" class="form-control col-12 float-left mt-2" placeholder="Enter code">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left">Ten sach</label>
                            <input type="number" name="id_book" class="form-control col-12 float-left mt-2" value="${book.id_book}" readonly placeholder="${book.name_book}">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left mt-1">Ten hoc sinh</label>
                            <select name="id_student" class="form-control col-12 float-left">
                                <option>Ten hoc sinh</option>
                                <c:forEach var="student" items="${studentList}">
                                    <option value="${student.id_student}"> ${student.name_student}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left">Ngay muon</label>
                            <input type="date" name="date_borrow" class="form-control col-12 float-left mt-2">
                        </div>
                        <div class="form-group col-12">
                            <label class="col-12 float-left">Ngay tra</label>
                            <input type="date" name="date_give_back" class="form-control col-12 float-left mt-2">
                        </div>


                        <button type="submit" class="btn btn-primary float-right">Create</button>
                        <a href="/book_servlet"><button type="button" class="btn btn-info float-right">Back</button></a>
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

