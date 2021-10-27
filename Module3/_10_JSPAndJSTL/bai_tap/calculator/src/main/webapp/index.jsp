<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Calculator</title>
  </head>
  <body>
  <h1>Simple Calculator</h1>
  <form action="/servlet" method="post">
    <fieldset style="width: 30%">
      <legend>Calculator</legend>
    <table>
      <tr>
        <td>
          First operand:
        </td>
        <td>
          <input type="text" name="no_1">
        </td>
      </tr>
      <tr>
        <td>
          Operator:
        </td>
        <td>
          <select name="operator">
            <option value="1">+</option>
            <option value="2">-</option>
            <option value="3">x</option>
            <option value="4">/</option>
          </select>
        </td>
      </tr>
      <tr>
        <td>
          Second operand:
        </td>
        <td>
          <input type="number" name="no_2">
        </td>
      </tr>
      <tr>
        <td>
        </td>
        <td>
          <input type="submit" value="calculate">
        </td>
      </tr>
    </table>
    </fieldset>
  </form>
  </body>
</html>
