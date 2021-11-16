<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EDIT</title>
</head>
<body>
<h1>EDIT</h1>
<form:form action="/save_config" method="post" modelAttribute="mailConfig">
    <table>
        <tr>
            <td>
                Languages:
            </td>
            <td>
                <form:select path="language">
                    <form:options items="${languageList}" value="${mailConfig.language}"></form:options>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>
                Page size:
            </td>
            <td>Show
                <form:select path="page_size">
                    <form:options items="${pageSizeList}" value="${mailConfig.page_size}"></form:options>
                </form:select>
                emails per page
            </td>
        </tr>
        <tr>
            <td>
                Spams filter:
            </td>
            <td>
                <form:checkbox path="spams_filter" value="${mailConfig.spams_filter}"></form:checkbox>Enable spams filter
            </td>
        </tr>
        <tr>
            <td>
                Signature:
            </td>
            <td>
                <form:textarea path="signature" value="${mailConfig.signature}"></form:textarea>
            </td>
        </tr>

        <tr>
            <td></td>
            <td>
                <button type="submit">Save</button>
                <button onclick="location.href='/'" type="button">Cancel</button>
            </td>
        </tr>

    </table>
</form:form>
</body>
</html>
