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
    <meta charset="utf-8">
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

<div id="wrapper">
    <!-- Navigation -->
    <nav class="navbar navbar-default navbar-static-top" role="navigation"
         style="margin-bottom: 0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span> <span
                    class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">小智试卷 V1.0</a>
        </div>
        <!-- /.navbar-header -->

        <ul class="nav navbar-top-links navbar-right" style="padding-top: 5px">
            <li>朱老师</li>
            <li><a href="#">注销</a></li>
        </ul>
        <!-- /.navbar-top-links -->
        <div class="navbar-default sidebar" role="navigation">
            <div class="sidebar-nav navbar-collapse">

                <ul class="nav" id="side-menu">
                    <li><a href="#"><i
                            class="fa fa-edit fa-fw"></i> 题库管理</a></li>
                    <li><a href="#" class="active"><i
                            class="fa fa-dashboard fa-fw "></i> 模板管理</a></li>
                    <li><a href="#"><i
                            class="fa glyphicon glyphicon-unchecked fa-fw"></i> 试卷仓库</a></li>
                </ul>
            </div>
            <!-- /.sidebar-collapse -->
        </div>
    </nav>
        <!-- /.navbar-static-side -->
        <div id="page-wrapper">
            <div>
                <h4><p class="text-center">试卷模板</p></h4>
            </div>
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
