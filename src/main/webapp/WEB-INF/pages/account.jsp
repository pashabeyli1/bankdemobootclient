<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fuadpashabeyli
  Date: 5/17/23
  Time: 20:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Customer List</title>
</head>
<body>
<c:choose>
    <c:when test="${not empty msg}">
        <label style="color: red">${msg}</label>
    </c:when>
    <c:otherwise>
        <table border="1" style="width: 100%">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Account No</th>
                <th>Iban</th>
                <th>Currency</th>
                <th>Branch Code</th>
                <th>Customer Fullname</th>
            </tr>
            <c:forEach items="${result}" var="r">
                <tr>
                    <td>${r.id}</td>
                    <td>${r.name}</td>
                    <td>${r.accountNo}</td>
                    <td>${r.iban}</td>
                    <td>${r.currency}</td>
                    <td>${r.branchCode}</td>
                    <td>${r.respCustomer.name} ${r.respCustomer.surname}</td>
                </tr>
            </c:forEach>
        </table>

    </c:otherwise>
</c:choose>


</body>
</html>
