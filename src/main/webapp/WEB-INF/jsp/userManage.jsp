<%--
  Created by IntelliJ IDEA.
  User: Xiaoliu
  Date: 2018/6/1
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="body">
    <jsp:include page="showMsg.jsp"/>
    <table>
        <th>用户名</th>
        <th>用户角色</th>
        <c:forEach items="${users}" var="u">
            <tr>
                <td>${u.userName}</td>
                <td>${u.roleName}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
