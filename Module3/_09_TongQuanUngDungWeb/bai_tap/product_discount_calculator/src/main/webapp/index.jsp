<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/26/2021
  Time: 2:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>product_discount_calculator</title>
  </head>
  <body>
  <form action="/product_discount_calculator">
    <input type="text" name="description"> Product Description
    <input type="text" name="price"> List Price
    <input type="text" name="discount"> Discount Percent
    <input type="submit" value="Calculate Discount">

  </form>
  <h2>description: <%=request.getAttribute("description")%></h2>
  <h2>discount_amount: <%=request.getAttribute("discount_amount")%></h2>
  <h2>price_after_discount: <%=request.getAttribute("price_after_discount")%></h2>
  </body>
</html>
