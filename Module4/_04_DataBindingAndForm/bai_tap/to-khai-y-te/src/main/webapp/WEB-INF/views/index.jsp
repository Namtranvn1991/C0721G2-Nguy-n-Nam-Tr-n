<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Mail config</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>
<center>To khai y te</center>
<form:form action="/send_declaration" modelAttribute="medicalDeclarationForm">
    <div class="container">
        <div class="form-row">
            <div class="col-md-12 mb-3">
                <label for="name">Name</label>
                <form:input path="name" class="form-control" id="name"></form:input>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-4 mb-3">
                <label for="birthday">birthday</label>
                <form:input type="date" path="birthday" class="form-control" id="birthday"></form:input>
            </div>
            <div class="col-md-4 mb-3">
                <label for="gender">gender</label>
                <form:select type="date" path="gender" class="form-control" id="gender">
                    <form:options items="${gender}"></form:options>
                </form:select>
            </div>
            <div class="col-md-4 mb-3">
                <label for="country">country</label>
                <form:select type="text" path="country" class="form-control" id="country">
                    <form:options items="${countries}"></form:options>
                </form:select>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <label for="idCard">idCard</label>
                <form:input path="idCard" class="form-control" id="idCard"></form:input>
            </div>
        </div>
        <div class="form-row">
            <div class="col">
                <label for="transferBy">Thong tin di lai</label>
                <table>
                    <tr>
                        <td>
                            <form:radiobuttons path="transferBy" id="transferBy" items="${transferBy}"></form:radiobuttons>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-6 mb-3">
                <label for="vehicleNumber">vehicleNumber</label>
                <form:input type="text" path="vehicleNumber" class="form-control" id="vehicleNumber"></form:input>
            </div>
            <div class="col-md-6 mb-3">
                <label for="seatNumber">seatNumber</label>
                <form:input type="text" path="seatNumber" class="form-control" id="seatNumber"></form:input>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-6 mb-3">
                <label for="departAt">departAt</label>
                <form:input type="date" path="departAt" class="form-control" id="departAt"></form:input>
            </div>
            <div class="col-md-6 mb-3">
                <label for="arriveBy">arriveBy</label>
                <form:input type="date" path="arriveBy" class="form-control" id="arriveBy"></form:input>
            </div>
        </div>
        <div class="form-row">
            <div class="col mb-3">
                <label for="whereToGoIn14Days">whereToGoIn14Days</label>
                <form:input path="whereToGoIn14Days" class="form-control" id="whereToGoIn14Days"></form:input>
            </div>
        </div>
        <div class="form-row">Dia chi lien lac</div>
        <div class="form-row">
            <div class="col-md-4 mb-3">
                <label for="province">province</label>
                <form:select type="text" path="province" class="form-control" id="province">
                    <form:options items="${province}"></form:options>
                </form:select>
            </div>
            <div class="col-md-4 mb-3">
                <label for="district">district</label>
                <form:input type="text" path="district" class="form-control" id="district"></form:input>
            </div>
            <div class="col-md-4 mb-3">
                <label for="ward">ward</label>
                <form:input type="text" path="ward" class="form-control" id="ward"></form:input>
            </div>
        </div>
        <div class="form-row">
            <div class="col mb-3">
                <label for="houseNumber">dia chi</label>
                <form:input path="houseNumber" class="form-control" id="houseNumber"></form:input>
            </div>
        </div>
        <div class="form-row">
            <div class="col-md-6 mb-3">
                <label for="phone">phone</label>
                <form:input type="text" path="phone" class="form-control" id="phone"></form:input>
            </div>
            <div class="col-md-6 mb-3">
                <label for="email">email</label>
                <form:input type="text" path="email" class="form-control" id="email"></form:input>
            </div>
        </div>
        <div class="form-row">Trong vòng 14 ngày qua, Anh/Chị có thấy xuất hiện các dấu hiệu</div>
        <div class="form-row">
            <div class="col-md-6">
                <table class="table">
                    <tr >
                        <th class="col-md-8">
                            Trieu chung
                        </th>
                        <th class="col-md-2 text-center">
                            co
                        </th>
                        <th class="col-md-8 text-center">
                            khong
                        </th>
                    </tr>
                    <tr>
                        <td>Sot</td>
                        <td class="text-center">
                            <form:radiobutton path="fever" value="${true}"></form:radiobutton>
                        </td>
                        <td class="text-center">
                            <form:radiobutton path="fever" value="${false}" checked="checked"></form:radiobutton>
                        </td>
                    </tr>
                    <tr>
                        <td >cough</td>
                        <td class="text-center">
                            <form:radiobutton path="cough" value="${true}"></form:radiobutton>
                        </td>
                        <td class="text-center">
                            <form:radiobutton path="cough" value="${false}" checked="checked"></form:radiobutton>
                        </td>
                    </tr>
                    <tr>
                        <td>difficultyOfBreathing</td>
                        <td class="text-center">
                            <form:radiobutton path="difficultyOfBreathing" value="${true}"></form:radiobutton>
                        </td>
                        <td class="text-center">
                            <form:radiobutton path="difficultyOfBreathing" value="${false}" checked="checked"></form:radiobutton>
                        </td>
                    </tr>
                    <tr>
                        <td>soreThroat</td>
                        <td class="text-center">
                            <form:radiobutton path="soreThroat" value="${true}"></form:radiobutton>
                        </td>
                        <td class="text-center">
                            <form:radiobutton path="soreThroat" value="${false}" checked="checked"></form:radiobutton>
                        </td>
                    </tr>
                </table>
            </div>
            <div class="col-md-6">
                <table class="table">
                    <tr>
                        <th class="col-md-8">
                            Trieu chung
                        </th>
                        <th class="col-md-2 text-center">
                            co
                        </th>
                        <th class="col-md-2 text-center">
                            khong
                        </th>
                    </tr>
                    <tr>
                        <td>vomiting</td>
                        <td class="text-center">
                            <form:radiobutton path="vomiting" value="${true}"></form:radiobutton>
                        </td>
                        <td class="text-center">
                            <form:radiobutton path="vomiting" value="${false}" checked="checked"></form:radiobutton>
                        </td>
                    </tr>
                    <tr>
                        <td>diarrhea</td>
                        <td class="text-center">
                            <form:radiobutton path="diarrhea" value="${true}"></form:radiobutton>
                        </td>
                        <td class="text-center">
                            <form:radiobutton path="diarrhea" value="${false}" checked="checked"></form:radiobutton>
                        </td>
                    </tr>
                    <tr>
                        <td>skinHaemorrhage</td>
                        <td class="text-center">
                            <form:radiobutton path="skinHaemorrhage" value="${true}"></form:radiobutton>
                        </td>
                        <td class="text-center">
                            <form:radiobutton path="skinHaemorrhage" value="${false}" checked="checked"></form:radiobutton>
                        </td>
                    </tr>
                    <tr>
                        <td>rash</td>
                        <td class="text-center">
                            <form:radiobutton path="rash" value="${true}"></form:radiobutton>
                        </td>
                        <td class="text-center">
                            <form:radiobutton path="rash" value="${false}" checked="checked"></form:radiobutton>
                        </td>
                    </tr>
                </table>
            </div>
        </div>
        <div class="form-row">Lich su phoi nhiem</div>
        <table class="table col-md-12">
            <tr>
                <th class="col-md-8">
                </th>
                <th class="col-md-2 text-center">
                    co
                </th>
                <th class="col-md-8 text-center">
                    khong
                </th>
            </tr>
            <tr>
                <td>Den Trang trai</td>
                <td class="text-center">
                    <form:radiobutton path="visitAny" value="${true}"></form:radiobutton>
                </td>
                <td class="text-center">
                    <form:radiobutton path="visitAny" value="${false}" checked="checked"></form:radiobutton>
                </td>
            </tr>
            <tr>
                <td>Tiep xuc nguoi benh</td>
                <td class="text-center">
                    <form:radiobutton path="careFor" value="${true}"></form:radiobutton>
                </td>
                <td class="text-center">
                    <form:radiobutton path="careFor" value="${false}" checked="checked"></form:radiobutton>
                </td>
            </tr>
        </table>
    </div>
    <button type="submit">Goi to khai</button>
</form:form>

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>
