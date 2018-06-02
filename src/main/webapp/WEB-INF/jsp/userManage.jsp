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
    <div class="table-responsive">
        <table class="table table-bordered">
            <tr>
                <th>用户名</th>
                <th>用户角色</th>
                <th>更改密码</th>
                <th>更改角色</th>
                <th>删除用户</th>
            </tr>
            <c:forEach items="${users}" var="u">
                <tr>
                    <td>${u.userName}</td>
                    <td>${u.roleName}</td>
                    <td><a href="#"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a></td>
                    <td><a href="#"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a></td>
                    <td><a href="#"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
