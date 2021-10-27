<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <h2>Danh Sách Khách Hàng</h2>
  <table border="solid 1px">
    <tr>
      <th>Tên</th>
      <th>Ngày sinh</th>
      <th>Địa Chỉ</th>
      <th>Ảnh</th>
    </tr>
    <c:forEach var="customer" items="${customerListServlet}" varStatus="loop">
        <tr>
          <td><c:out value="${customer.name}"></c:out></td>
          <td><c:out value="${customer.getBirthdayToString()}"></c:out></td>
          <td><c:out value="${customer.address}"></c:out></td>
          <td><img width="50px" src="<c:out value="${customer.img}"></c:out>"></td>
        </tr>
    </c:forEach>
  </table>
  </body>
</html>


