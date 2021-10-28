<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deleting product</title>
</head>
<body>
<h1>Delete product</h1>
<p>
    <a href="/">Back to home</a>
</p>
<form method="post">
    <h3>Are you sure?</h3>
    <fieldset>
        <legend>product information</legend>
        <table>
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
            <tr>
                <td><input type="submit" value="Delete product"></td>
                <td><a href="/">Back to home</a></td>
            </tr>
        </table>
    </fieldset>
</form>
</body>
</html>