<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>
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
    <form:form action="/edit" method="post" modelAttribute="mailConfig">
        <form:input type="hidden" path="language" value="${mailConfig.language}"></form:input>
        <form:input type="hidden" path="page_size" value="${mailConfig.page_size}"></form:input>
        <form:input type="hidden" path="spams_filter" value="${mailConfig.spams_filter}"></form:input>
        <form:input type="hidden" path="signature" value="${mailConfig.signature}"></form:input>
        <input type="submit" value="edit">
    </form:form>
</body>
</html>
