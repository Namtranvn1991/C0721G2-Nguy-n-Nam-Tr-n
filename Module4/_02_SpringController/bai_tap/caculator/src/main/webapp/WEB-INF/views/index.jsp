<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/12/2021
  Time: 4:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/cal" method="get">
    <input type="text" name="number1" placeholder="number 1">
    <input type="text" name="number2" placeholder="number 2">
    <input type="submit" name="cal" value="add">
    <input type="submit" name="cal" value="sub">
    <input type="submit" name="cal" value="multi">
    <input type="submit" name="cal" value="div">
  </form>
  <p>${result}</p>
  </body>
</html>
