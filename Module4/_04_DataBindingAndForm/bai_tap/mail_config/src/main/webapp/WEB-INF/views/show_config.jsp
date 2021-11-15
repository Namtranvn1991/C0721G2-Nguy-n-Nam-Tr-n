<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 11/15/2021
  Time: 10:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Config</title>
</head>
<body>
    <h1>Config</h1>
    <p>Language: ${mailConfig.language}</p>
    <p>page_size: ${mailConfig.page_size}</p>
    <p>spams_filter: ${mailConfig.spams_filter}</p>
    <p>signature: ${mailConfig.signature}</p>
</body>
</html>
