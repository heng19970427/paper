<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nkxd
  Date: 2018/7/30
  Time: 17:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>科目详情</title>
    <style>
        .top{
            padding-top: 20px;
        }
        .center{
            text-align: center;
        }
    </style>
</head>
<body>
    <jsp:include page="header.jsp" />
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-2 sidebar">
                <ul class="nav nav-sidebar center">
                    <li class="active"><a href="#" role="tab"><span class="glyphicon glyphicon-education" aria-hidden="true"></span> 科目信息</a></li>
                    <li ><a href="${pageContext.request.contextPath}/knowledge/knowledgeInfo" role="tab"><span class="glyphicon glyphicon-console" aria-hidden="true"></span> 知识点信息</a></li>
                    <li><a href="${pageContext.request.contextPath}/quescate/quescateInfo" role="tab"><span class="glyphicon glyphicon-text-background" aria-hidden="true"></span> 题目类型信息</a></li>
                </ul>
            </div>
            <div class="col-sm-10 col-sm-offset-2 main">
                <div class="row">
                    <div class="center col-sm-6">
                        <h1 >科目信息</h1>
                    </div>

                    <div class="col-sm-6 top">
                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-primary btn-lg " data-toggle="modal" data-target="#myModal">
                            添加科目
                        </button>

                        <!-- Modal -->
                        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="myModalLabel">添加科目</h4>
                                    </div>
                                    <form id="courseForm">

                                        <div class="modal-body">
                                            <div class="form-group">
                                                <label for="courseName">科目名称</label>
                                                <input type="text" class="form-control" name="courseName" id="courseName"
                                                       placeholder="科目名称">
                                            </div>
                                        </div>

                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                            <button type="button" class="btn btn-primary" onclick="addCourse()">添加</button>
                                        </div>

                                    </form>


                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div>
                    <hr/>
                    <table class="table table-striped table-hover">
                        <tr>
                            <td>编号</td>
                            <td>科目</td>
                            <td>知识点数目</td>
                            <td>题型数目</td>
                            <td colspan="2">操作</td>
                        </tr>
                        <c:forEach items="${courseList}" var="course">
                            <tr>
                                <td>${course.c_id}</td>
                                <td>${course.courseName}</td>
                                <td>${KnowledgeSize}</td>
                                <td>${quesCateSize}</td>
                                <td><button type="button" class="btn btn-info">详情</button></td>
                                <td><button type="button" onclick="deleteCourse('${course.c_id}')" class="btn btn-danger">删除</button></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

            </div>
        </div>
    </div>
<script type="text/javascript">
    function addCourse() {
            $.get(
            "${pageContext.request.contextPath}/course/addCourse",
                $("#courseForm").serialize(),
                function (data) {
                    alert("试题添加成功！");
                    window.location.reload();
                }
        );
    }

    function deleteCourse(c_id) {
        if (confirm('确实要删除该题目吗?')){
            $.post("${pageContext.request.contextPath}/course/deleteCourse", {"c_id": c_id}, function (data) {
                alert("科目删除更新成功！");
                window.location.reload();
            });
        }
    }
</script>
</body>
</html>
