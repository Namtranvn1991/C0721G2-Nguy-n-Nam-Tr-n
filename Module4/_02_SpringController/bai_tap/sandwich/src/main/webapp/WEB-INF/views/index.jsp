<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/12/2021
  Time: 3:44 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Sandwich Condiments</title>
  </head>
  <body>
  <h1>
    Sandwich Condiments
  </h1>
  <form action="/save">
    Sandwich Condiments<br/>
    <label><input name="condiments" value="lettuce" type="checkbox"/>lettuce</label> <br/>
    <label><input name="condiments" value="tomato" type="checkbox"/>tomato</label> <br/>
    <label><input name="condiments" value="mustard" type="checkbox"/>mustard</label> <br/>
    <label><input name="condiments" value="sprouts" type="checkbox"/>sprouts</label> <br/>
    <input type="submit" value="save">
  </form>
  </body>
</html>
