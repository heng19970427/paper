<%--
  Created by IntelliJ IDEA.
  User: Xiaoliu
  Date: 2018/5/31
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
                <li><a href="#">${sessionScope.user.userName}</a></li>
                <li><a href="${pageContext.request.contextPath}/user/logout">注销</a></li>
            </ul>
        </div>
    </div>
</nav>
