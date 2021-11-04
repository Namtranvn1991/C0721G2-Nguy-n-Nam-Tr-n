<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Customer</title>
</head>
<body>
<h1>Create New Customer</h1>
<a href="/customer_servlet">Go back</a>
<form action="/customer_servlet" method="post">
    <input type="hidden" name="action_customer_post" value="create">
    <p>Name: <input type="text" name="name" placeholder="name" value="${customer.name}">
    <c:if test="${errorName!=null}">
        ${errorName}
    </c:if>
    </p>
    <p>birthday: <input type="date" name="birthday" value="birthday">
        <c:if test="${errorDate!=null}">
            ${errorDate}
        </c:if>
    </p>
    <p>id_card: <input type="text" name="id_card" placeholder="id_card" value="${customer.id_card}">
        <c:if test="${errorIdCard!=null}">
            ${errorIdCard}
        </c:if>
    </p>
    <p>phone_number: <input type="text" name="phone_number" placeholder="phone_number" value="${customer.phone_number}">
        <c:if test="${errorPhone!=null}">
            ${errorPhone}
        </c:if>
    </p>
    <p>address: <input type="text" name="address" value="address"> </p>
    <p>email: <input type="text" name="email" placeholder="email" value="${customer.email}">
        <c:if test="${errorEmail!=null}">
            ${errorEmail}
        </c:if>
    </p>
    <p>
        <select name="type_customer">
            <option value="1">
                Diamond
            </option>
            <option value="2">
                Platinum
            </option>
            <option value="3">
                Gold
            </option>
            <option value="4">
                Silver
            </option>
            <option value="5">
                Member
            </option>
        </select>
    </p>
    <input type="submit" value="Create">
</form>
</body>
</html>
