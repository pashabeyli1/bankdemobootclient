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
               <th>Surname</th>
               <th>Address</th>
               <th>Pin</th>
               <th>Seria</th>
               <th>Date of birth</th>
               <th>Phone</th>
               <th>Cif</th>
               <th>Hesablara bax</th>
           </tr>
         <c:forEach items="${result}" var="r">
             <tr>
                 <td>${r.customerId}</td>
                 <td>${r.name}</td>
                 <td>${r.surname}</td>
                 <td>${r.address}</td>
                 <td>${r.pin}</td>
                 <td>${r.seria}</td>
                 <td>${r.dob}</td>
                 <td>${r.phone}</td>
                 <td>${r.cif}</td>
                 <td><a href="${pageContext.request.contextPath}/GetAccountList/${r.customerId}"><input type="button" value="Hesablara bax"></a></td>
             </tr>
         </c:forEach>
       </table>

    </c:otherwise>
</c:choose>


</body>
</html>
