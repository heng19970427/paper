<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: nkxd
  Date: 2018/7/31
  Time: 21:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <jsp:include page="header.jsp" />
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-2 sidebar">
                <ul class="nav nav-sidebar center">
                    <li><a href="${pageContext.request.contextPath}/course/courseInfo" role="tab"><span class="glyphicon glyphicon-education" aria-hidden="true"></span> 科目信息</a></li>
                    <li class="active" ><a href="${pageContext.request.contextPath}/knowledge/knowledgeInfo" role="tab"><span class="glyphicon glyphicon-console" aria-hidden="true"></span> 知识点信息</a></li>
                    <li><a href="${pageContext.request.contextPath}/quescate/quescateInfo" role="tab"><span class="glyphicon glyphicon-text-background" aria-hidden="true"></span> 题目类型信息</a></li>
                </ul>
            </div>
            <div class="col-sm-10 col-sm-offset-2 main">
                <div class="row">
                    <div class="center col-sm-4">
                        <h1 >知识点信息</h1>
                    </div>
                    <div class="col-sm-4">
                        <form action="${pageContext.request.contextPath}/knowledge/knowledgeInfo" class="form-inline">
                            <label for="courseNameSelect">科目选择</label>
                            <select class="form-control" id="courseNameSelect" name="c_id">
                                <option value="">--请选择--</option>
                                <c:forEach items="${courseList}" var="course">
                                    <option value="${course.c_id}">${course.courseName}</option>
                                </c:forEach>
                            </select>

                            <button type="submit" class="btn btn-default">查询</button>
                        </form>
                    </div>
                    <div class="col-sm-4 center top">
                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-primary btn-lg " data-toggle="modal" data-target="#myModal">
                            添加科目知识点
                        </button>

                        <!-- Modal -->
                        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times</span></button>
                                        <h4 class="modal-title" id="myModalLabel">添加知识点</h4>
                                    </div>
                                    <form id="courseForm">
                                        <div class="modal-body">
                                            <label for="courseNameSelect_add">科目选择</label>
                                            <select class="form-control" id="courseNameSelect_add" name="course.c_id">
                                                <option value="">--请选择--</option>
                                                <c:forEach items="${courseList}" var="course">
                                                    <option value="${course.c_id}">${course.courseName}</option>
                                                </c:forEach>
                                            </select>
                                            <div class="form-group">
                                                <label for="knowledgeName">知识点名称</label>
                                                <input type="text" class="form-control" name="knowledgeName" id="knowledgeName"
                                                       placeholder="知识点名称">
                                            </div>
                                        </div>

                                        <div class="modal-footer">
                                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                            <button type="button" class="btn btn-primary" onclick="addKnowledge()">添加</button>
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
                            <td>所属科目</td>
                            <td>知识点名称</td>
                            <td>操作</td>
                        </tr>
                        <c:forEach items="${knowledgeList}" var="knowledge">
                            <tr>
                                <td>${knowledge.k_id}</td>
                                <td>${knowledge.course.courseName}</td>
                                <td>${knowledge.knowledgeName}</td>
                                <td><button type="button" class="btn btn-danger" onclick="deleteKnowledge('${knowledge.k_id}')">删除</button></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

            </div>
        </div>
    </div>

    <script type="text/javascript">

        function addKnowledge() {
            $.get(
                "${pageContext.request.contextPath}/knowledge/addKnowledge",
                $("#courseForm").serialize(),
                function (data) {
                    alert("试题添加成功！");
                    window.location.reload();
                }
            );
        }

        function deleteKnowledge(k_id) {
            if (confirm('确实要删除该题目吗?')){
                $.post("${pageContext.request.contextPath}/knowledge/deleteKnowledge", {"k_id": k_id}, function (data) {
                    alert("科目删除更新成功！");
                    window.location.reload();
                });
            }
        }
    </script>
</body>
</html>
