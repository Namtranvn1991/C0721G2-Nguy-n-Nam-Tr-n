<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Dictionary</title>
  </head>
  <body>
  <h1>Dictionary</h1>
  <form action="/search" method="get">
      <input type="text" name="input" placeholder="input">
      <input type="submit" value="submit">
  </form>
        <p>${output}</p>

  <c:if test="${error==1}">
      <script>alert("Not found")</script>
  </c:if>
  </body>
</html>
