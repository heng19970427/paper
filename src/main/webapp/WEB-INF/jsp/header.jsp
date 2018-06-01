<%--
  Created by IntelliJ IDEA.
  User: Xiaoliu
  Date: 2018/5/31
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%--css and js start--%>
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
<!-- Bootstrap Core JavaScript -->
<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
<!-- Metis Menu Plugin JavaScript -->
<script src="${pageContext.request.contextPath}/js/metisMenu.min.js"></script>
<!-- DataTables JavaScript -->
<script src="${pageContext.request.contextPath}/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/js/dataTables.bootstrap.min.js"></script>
<!-- Custom Theme JavaScript -->
<%--<script src="${pageContext.request.contextPath}/js/sb-admin-2.js"></script>--%>
<!-- Bootstrap Core CSS -->
<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet">
<!-- MetisMenu CSS -->
<link href="${pageContext.request.contextPath}/css/metisMenu.min.css" rel="stylesheet">
<!-- DataTables CSS -->
<link href="${pageContext.request.contextPath}/css/dataTables.bootstrap.css" rel="stylesheet">
<!-- Custom CSS -->
<%--<link href="${pageContext.request.contextPath}/css/sb-admin-2.css" rel="stylesheet">--%>
<!-- Custom Fonts -->
<link href="${pageContext.request.contextPath}/css/font-awesome.min.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/boot-crm.css" rel="stylesheet" type="text/css">
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
<![endif]-->
<%--css and js end--%>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminCss.css">
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#navcollapse">
                <span class="sr-only">toggle</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">小智试卷 V1.0</a>
        </div>
        <div class="collapse navbar-collapse" id="navcollapse">
            <ul class="nav navbar-nav navbar-left">
                <li><a href="${pageContext.request.contextPath}/question/list">题库管理</a></li>
                <li><a href="${pageContext.request.contextPath}/paperTemplate/showTemp">模板管理</a></li>
                <li><a href="#">试卷仓库</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <jsp:useBean id="user" beanName="user" scope="session" type="com.zr.pojo.User"/>
                <c:if test="${user.roleName == 'manager'}">
                    <li><a href="${pageContext.request.contextPath}/user/userManage">用户管理</a></li>
                </c:if>
                <li><a href="#">${user.userName}</a></li>
                <li><a href="${pageContext.request.contextPath}/user/logout">注销</a></li>
            </ul>
        </div>
    </div>
</nav>
