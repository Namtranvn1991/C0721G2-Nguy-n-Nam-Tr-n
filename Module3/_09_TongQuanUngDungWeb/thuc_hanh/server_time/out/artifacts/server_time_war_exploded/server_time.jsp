<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 10/26/2021
  Time: 11:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>server_time</title>
</head>
<body>
<form action="/timeServlet"><input type="submit" value="refresh"></form>
<h2><%=request.getAttribute("nowTime")%></h2>

</body>
</html>
