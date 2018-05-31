<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<html>
    <head>
        <!-- Bootstrap Core CSS -->
        <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">

        <!-- MetisMenu CSS -->
        <link href="<%=basePath%>css/metisMenu.min.css" rel="stylesheet">

        <!-- DataTables CSS -->
        <link href="<%=basePath%>css/dataTables.bootstrap.css" rel="stylesheet">
    </head>
<body class=text-muted">
    <%--show msg--%>
    <jsp:include page="showMsg.jsp"/>
    <%--show msg--%>
    <div class="container">
        <div class="form-group" style="padding-top: 150px">
            <p class="text-primary" style="text-align: center;font-size: 25px">智能试卷</p>
        </div>
        <form action="<%=basePath%>user/login" id="loginForm" method="post">
            <div class="jumbotron" style="width: 60%;margin: 0 auto">
                <div class="form-group">
                    <label for="username">帐 号</label>
                    <input type="text" class="form-control" id="username" name="userName" placeholder="请输入账号">
                </div>
                <div class="form-group">
                    <label for="password">密 码</label>
                    <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
                </div>
                <div class="form-group">
                    <button class="btn btn-success btn-block form-control" type="submit">登  录</button>
                </div>
            </div>
        </form>

    </div>


    <!-- jQuery -->
    <script src="<%=basePath%>js/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=basePath%>js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=basePath%>js/metisMenu.min.js"></script>

    <!-- DataTables JavaScript -->
    <script src="<%=basePath%>js/jquery.dataTables.min.js"></script>
    <script src="<%=basePath%>js/dataTables.bootstrap.min.js"></script>
</body>
</html>
