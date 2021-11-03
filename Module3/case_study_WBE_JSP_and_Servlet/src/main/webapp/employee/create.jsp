
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Create New Employee</title>
</head>
<body>
<h1>Create New Employee</h1>
<a href="/employee_servlet">Go back</a>
<form action="/employee_servlet" method="post">
    <input type="hidden" name="action_employee_post" value="create">
    <p>employee_code: <input type="text" name="code" value="code"></p>
    <p>Name: <input type="text" name="name" value="name"></p>
    <p>birthday: <input type="date" name="birthday" value="birthday"> </p>
    <p>id_card: <input type="text" name="id_card" value="id_card"> </p>
    <p>phone_number: <input type="text" name="phone_number" value="phone_number"> </p>
    <p>address: <input type="text" name="address" value="address"> </p>
    <p>email: <input type="text" name="email" value="email"> </p>
    <p>salary: <input type="number" step="0.01" name="salary" value="salary"> </p>
    <p>
        <select name="department">
            <option value="1">
                Bussiness
            </option>
            <option value="2">
                Technical
            </option>
            <option value="3">
                Administrative
            </option>
            <option value="4">
                Management
            </option>
            <option value="5">
                Service
            </option>
        </select>
    </p>
    <p>
        <select name="degree">
            <option value="1">
                High school graduated
            </option>
            <option value="2">
                Bachelor
            </option>
            <option value="3">
                Engineer
            </option>
            <option value="4">
                Master
            </option>
        </select>
    </p>
    <p>
        <select name="position">
            <option value="1">
                Manager
            </option>
            <option value="2">
                Deputy
            </option>
            <option value="3">
                Staff
            </option>
        </select>
    </p>
    <input type="submit" value="Create">
</form>
</body>
</html>
