<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/12/2021
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <p>Your Sandwich Condiments:
        <c:forEach var="condiment" items="${condiments}">
            <span>${condiment}</span>
        </c:forEach>
    </p>
</body>
</html>
