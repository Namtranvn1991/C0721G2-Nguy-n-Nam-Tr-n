
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="/sumServlet">
    <input type="text" name="no_1"> n1
    <input type="text" name="no_2"> n2
    <button type="submit"> sum </button>
  </form>
  <h2><%=request.getAttribute("resultFromServlet")%></h2>
  </body>
</html>
