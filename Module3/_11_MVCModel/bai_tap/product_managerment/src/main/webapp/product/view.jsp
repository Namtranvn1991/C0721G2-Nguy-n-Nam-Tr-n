<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>View product</title>
</head>
<body>
<h1>product details</h1>
<p>
    <a href="/">Back to home</a>
</p>
<table border="1">
    <tr>
        <td>Name: </td>
        <td>${product.name}</td>
    </tr>
    <tr>
        <td>price: </td>
        <td>${product.price}</td>
    </tr>
    <tr>
        <td>description: </td>
        <td>${product.description}</td>
    </tr>
    <tr>
        <td>brand: </td>
        <td>${product.brand}</td>
    </tr>
</table>
</body>
</html>
