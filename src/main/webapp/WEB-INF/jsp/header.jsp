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
<%--bootstrapTable--%>
<link href="https://cdn.bootcss.com/bootstrap-table/1.12.1/bootstrap-table.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/bootstrap-table/1.12.1/bootstrap-table.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-table/1.12.1/locale/bootstrap-table-zh-CN.min.js"></script>
<%--bootstrap-validator--%>
<link href="https://cdn.bootcss.com/bootstrap-validator/0.5.3/css/bootstrapValidator.min.css" rel="stylesheet">
<script src="https://cdn.bootcss.com/bootstrap-validator/0.5.3/js/bootstrapValidator.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap-validator/0.5.3/js/language/zh_CN.min.js"></script>
<%--serializejson--%>
<script src="https://cdn.bootcss.com/jquery.serializeJSON/2.9.0/jquery.serializejson.min.js"></script>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/adminCss.css">
<%--css and js end--%>

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
                <li><a href="${pageContext.request.contextPath}/subject/">科目管理</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <c:if test="${sessionScope.user.r_id == 2}">
                    <li><a href="${pageContext.request.contextPath}/user/man/userManage">用户管理</a></li>
                </c:if>
                <li><a href="#">${sessionScope.user.userName}</a></li>
                <li><a href="${pageContext.request.contextPath}/user/logout">注销</a></li>
            </ul>
        </div>
    </div>
</nav>
