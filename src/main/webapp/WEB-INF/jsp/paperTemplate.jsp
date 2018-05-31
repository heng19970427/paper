<%@ page language="java" contentType="text/html; charset=UTF-8"
        pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="zr" uri="http://zr/common/" %>
<%
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
        + path + "/";
        %>
        <!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta content="text/html;charset=utf8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>题库管理</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="<%=basePath%>css/metisMenu.min.css" rel="stylesheet">

    <!-- DataTables CSS -->
    <link href="<%=basePath%>css/dataTables.bootstrap.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="<%=basePath%>css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet"
          type="text/css">
    <link href="<%=basePath%>css/boot-crm.css" rel="stylesheet"
          type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

<%--header start--%>
<jsp:include page="header.jsp"/>
<%--header end--%>
<div id="wrapper" class="body">
    <%--show msg--%>
    <jsp:include page="showMsg.jsp"/>
    <%--show msg--%>
        <div id="page-wrapper">
            <h1 class="page-header" style="text-align: center">模板管理</h1>
            <form class="form-horizontal">
                <div class="row">
                    <div class="form-group">
                        <label for="courseName" class="col-sm-1 control-label">科目</label>
                        <div class="col-sm-3">
                            <select id="courseName" class="form-control">
                                <option selected>666</option>
                            </select>
                        </div>

                        <label for="score" class="col-sm-1 control-label">总分</label>
                        <div class="col-sm-3">
                            <input type="input" class="form-control" id="score" placeholder="总分">
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="form-group">
                        <label for="selectQuesNum" class="col-sm-1 control-label">选择题数目</label>
                        <div class="col-sm-3">
                            <input type="input" class="form-control" id="selectQuesNum" placeholder="总分">
                        </div>
                        <label for="selectQuesNum" class="col-sm-1 control-label">填空题数目</label>
                        <div class="col-sm-3">
                            <input type="input" class="form-control" id="fillBlankQuesNum" placeholder="总分">
                        </div>

                    </div>
                </div>
                <div class="row">
                    <label for="selectQuesNum" class="col-sm-1 control-label">判断题数目</label>
                    <div class="col-sm-3">
                        <input type="input" class="form-control" id="judgeQuesNum" placeholder="总分">
                    </div>
                    <label for="bigQuesNum" class="col-sm-1 control-label">大题数目</label>
                    <div class="col-sm-3">
                        <input type="input" class="form-control" id="bigQuesNum" placeholder="总分">
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <label>知识点占比设置</label>
                        <button type="submit" class="btn btn-default">点击前往</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
        <!-- /#wrapper -->

        <!-- jQuery -->
    <script src="<%=basePath%>js/jquery.min.js"></script>

            <!-- Bootstrap Core JavaScript -->
    <script src="<%=basePath%>js/bootstrap.min.js"></script>

            <!-- Metis Menu Plugin JavaScript -->
    <script src="<%=basePath%>js/metisMenu.min.js"></script>

            <!-- DataTables JavaScript -->
    <script src="<%=basePath%>js/jquery.dataTables.min.js"></script>
    <script src="<%=basePath%>js/dataTables.bootstrap.min.js"></script>

            <!-- Custom Theme JavaScript -->
    <script src="<%=basePath%>js/sb-admin-2.js"></script>



</body>

        </html>
