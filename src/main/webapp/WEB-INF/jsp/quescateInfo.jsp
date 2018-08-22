<%--
  Created by IntelliJ IDEA.
  User: nkxd
  Date: 2018/7/31
  Time: 21:07
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
                    <li><a href="${pageContext.request.contextPath}/knowledge/knowledgeInfo" role="tab"><span class="glyphicon glyphicon-console" aria-hidden="true"></span> 知识点信息</a></li>
                    <li  class="active"><a href="#" role="tab"><span class="glyphicon glyphicon-text-background" aria-hidden="true"></span> 题目类型信息</a></li>
                </ul>
            </div>
            <div class="col-sm-10 col-sm-offset-2 main">
                <div class="row">
                    <div class="center col-sm-4">
                        <h1 >题目类型信息</h1>
                    </div>

                    <div class="center col-sm-4">
                        科目:
                        <select>
                            <option>-- 请选择 --</option>
                        </select>
                        <button>查询</button>
                    </div>

                    <div class="col-sm-4 center top">
                        <!-- Button trigger modal -->
                        <button type="button" class="btn btn-primary btn-lg " data-toggle="modal" data-target="#myModal">
                            添加题型
                        </button>

                        <!-- Modal -->
                        <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                                        <h4 class="modal-title" id="myModalLabel">添加</h4>
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
                                <td><button type="button" class="btn btn-danger">删除</button></td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>

            </div>
        </div>
    </div>
</body>
</html>
