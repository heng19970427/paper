<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="zr" uri="http://zr/common/" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>题库管理 - 智能试卷</title>
</head>

<body>

<%--header start--%>
<jsp:include page="header.jsp"/>
<%--header end--%>
<div class="body" id="wrapper">
    <%--show msg--%>
    <jsp:include page="showMsg.jsp"/>
    <%--show msg--%>
    <div id="page-wrapper">
        <div class="row">
            <div class="col-lg-12">
                <ul class="nav nav-tabs">
                    <li role="presentation" class="active"><a href="#quesManage" aria-controls="quesManage" role="tab"
                                                              data-toggle="tab">题库管理</a></li>
                    <li role="presentation" class="dropdown">
                        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true"
                           aria-expanded="false">
                            增加试题<span class="caret"></span>
                        </a>
                        <ul class="dropdown-menu">
                            <li><a href="#addOne" role="tab" data-toggle="tab">单题添加 </a></li>
                            <li><a href="#addMany" role="tab" data-toggle="tab">批量导入</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
            <!-- /.col-lg-12 -->
        </div>
        <!-- /.row -->
        <div class="tab-content">
            <!-- 单题添加 -->
            <div role="tabpanel" class="tab-pane" id="addOne">
                <form id="add_form">
                    <div class="form-group">
                        <label for="edit_courseName" class="control-label">科目</label>
                        <select class="form-control" id="add_courseName" placeholder="科目" name="course.c_id">
                            <c:forEach items="${courseList}" var="course">
                                <option value="${course.c_id}" ${course.c_id==quesSub ? 'selected':''}>${course.courseName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="edit_category" class="control-label">题目类型</label>
                        <select class="form-control" id="add_category" name="probCate.p_id">
                            <c:forEach items="${cateList}" var="cate">
                                <option value="${cate.p_id}" ${cate.p_id==probQues ? 'selected':''}>${cate.category}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="edit_qcName" class="control-label">具体类型</label>
                        <select class="form-control" id="add_qcName" name="quesCate.q_id">

                        </select>

                    </div>
                    <div class="form-group">
                        <label for="add_title">试题名称</label>
                        <input class="form-control" id="add_title" name="title" placeholder="试题名称">
                    </div>

                    <div class="form-group">
                        <label for="add_knowledge">知识点</label>
                        <select class="form-control" id="add_knowledge" name="probCate.k_id">
                            <c:forEach items="${knowledgeList}" var="know">
                                <option value="${know.k_id}">${know.knowledgeName}</option>
                            </c:forEach>
                        </select>
                    </div>

                    <div class="form-group">
                        <label for="add_blankNum">空的个数(可选)</label>
                        <input class="form-control" id="add_blankNum" placeholder="空的个数">
                    </div>

                    <div class="form-group">
                        <label for="add_difficultyLevel">难度系数</label>
                        <input class="form-control" id="add_difficultyLevel" name="difficultyLevel" placeholder="难度系数">
                    </div>
                    <div class="form-group">
                        <label for="add_answer">答案</label>
                        <input class="form-control" id="add_answer" name="answer" placeholder="答案">
                    </div>
                    <div class="form-group">
                        <label for="add_answer">试题来源</label>
                        <input class="form-control" id="description" name="description" placeholder="试题来源">
                    </div>
                    <button type="button" class="btn btn-primary" onclick="addQuestion()">导入题库</button>
                </form>

            </div>
            <!-- /单题添加 -->
            <!-- 批量导入 -->
            <div role="tabpanel" class="tab-pane" id="addMany">批量导入
                <form action="/paper/question/tempDownload" id="addManyForm" method="post">
                    <div class="form-group" style="padding-left: 10px">
                        <label for="quesSub">试题科目</label>
                        <select class="form-control" id="addMany_quesSub" placeholder="试题科目" name="quesSub">
                            <option value="">--请选择--</option>
                            <c:forEach items="${courseList}" var="course">
                                <option value="${course.c_id}" ${course.c_id==quesSub ? 'selected':''}>${course.courseName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="checkbox" id="addMany_qcNameDiv">
                        <label>
                            <input name="checkall1" type="checkbox" value="0" onClick="checkAllBox(this);"/>全选<br>
                        </label>
                    </div>
                    <div>
                        <label>
                            <a href="#" onclick=tempDownload()>模板下载</a>
                        </label>
                    </div>

                </form>
                <form action="/paper/question/excelUpload" id="fileUpload" enctype="multipart/form-data" method="post">
                    <div class="form-group" style="padding-left: 10px">
                        <label for="excelUpload_quesSub">试题科目</label>
                        <select class="form-control" id="excelUpload_quesSub" placeholder="试题科目" name="quesSub">
                            <option value="">--请选择--</option>
                            <c:forEach items="${courseList}" var="course">
                                <option value="${course.c_id}" ${course.c_id==quesSub ? 'selected':''}>${course.courseName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="InputFile">请选择要导入的Excel文件</label>
                        <input type="file" name="excel" id="InputFile">
                        <p class="help-block">可先根据需要生成excel模板，再导入</p>
                    </div>
                    <div>
                        <input type="submit" value="文件上传"/>
                    </div>
                </form>

            </div>
            <!--/ 批量导入 -->
            <div role="tabpanel" class="panel panel-default tab-pane active" id="quesManage">
                <div class="panel-body">
                    <form class="form-inline" action="${pageContext.request.contextPath }/question/list" method="get">
                        <div class="form-group" style="padding-left: 10px">
                            <label for="quesName">试题名称</label>
                            <input type="text" class="form-control" id="quesName" value="${quesName}" name="quesName">
                        </div>
                        <div class="form-group" style="padding-left: 10px">
                            <label for="quesSub">试题科目</label>
                            <select class="form-control" id="quesSub" placeholder="试题科目" name="quesSub">
                                <option value="">--请选择--</option>
                                <c:forEach items="${courseList}" var="course">
                                    <option value="${course.c_id}" ${course.c_id==quesSub ? 'selected':''}>${course.courseName}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group" style="padding-left: 10px">
                            <label for="quesCate">试题类型</label>
                            <select class="form-control" id="quesCate" name="probQues">
                                <option value="">--请选择--</option>
                                <c:forEach items="${cateList}" var="cate">
                                    <option value="${cate.p_id}" ${cate.p_id==probQues ? 'selected':''}>${cate.category}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="form-group" style="padding-left: 10px">
                            <label for="category">具体类型</label>
                            <select class="form-control" id="category" name="category">
                                <option value="">--请选择--</option>
                            </select>
                        </div>
                        <span style="padding-left: 10px">
								<button type="submit" class="btn btn-primary">查询</button>
							</span>
                    </form>
                </div>


                <div class="row">
                    <div class="col-lg-12">
                        <div class="panel panel-default">
                            <div class="panel-heading">试题信息列表</div>
                            <!-- /.panel-heading -->
                            <table class="table table-bordered table-striped">
                                <thead>
                                <tr>
                                    <th>ID</th>
                                    <th colspan="2">题干</th>
                                    <th>答案</th>
                                    <th>来源</th>
                                    <th>难度系数</th>
                                    <th>操作</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${page.rows}" var="row">
                                    <tr>
                                        <td>${row.id}</td>
                                        <td colspan="2">${row.title}</td>
                                        <td>${row.answer}</td>
                                        <td>${row.description}</td>
                                        <td>${row.difficultyLevel}</td>

                                        <td align="center">
                                            <a href="#" class="btn btn-primary btn-xs" data-toggle="modal"
                                               data-target="#customerEditDialog"
                                               onclick=editQues("${row.p_id}","${row.id}")>详情</a>
                                            <a href="#" class="btn btn-danger btn-xs"
                                               onclick=deleteQues("${row.p_id}","${row.id}")>删除</a>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <div class="col-md-12 text-right">
                                <zr:page url="${pageContext.request.contextPath }/question/list"/>
                            </div>

                            <!-- /.panel-body -->
                        </div>
                        <!-- /.panel -->
                    </div>
                    <!-- /.col-lg-12 -->
                </div>
            </div>
        </div>
    </div>
    <!-- /#page-wrapper -->

</div>

<!-- 试题编辑对话框 -->
<div class="modal fade" id="customerEditDialog" tabindex="-1" role="dialog"

     aria-labelledby="myModalLabel">
    <div class="modal-dialog" style="width: 1040px" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">试题详细信息</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" id="edit_question_form">
                    <input type="hidden" id="edit_ques_id" name="id"/>
                    <div class="form-group">
                        <label for="edit_title" class="col-sm-1 control-label">试题名称</label>
                        <div class="col-sm-11">
                            <input type="text" class="form-control" id="edit_title" placeholder="试题名称" name="title">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit_courseName" class="col-sm-1 control-label">科目</label>
                        <div class="col-sm-11">
                            <select class="form-control" id="edit_courseName" placeholder="科目" name="course.c_id">
                                <c:forEach items="${courseList}" var="course">
                                    <option value="${course.c_id}" ${course.c_id==quesSub ? 'selected':''}>${course.courseName}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit_category" class="col-sm-1 control-label">题目类型</label>
                        <div class="col-sm-11">
                            <select class="form-control" id="edit_category" name="probCate.p_id">
                                <c:forEach items="${cateList}" var="cate">
                                    <option value="${cate.p_id}" ${cate.p_id==probQues ? 'selected':''}>${cate.category}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit_qcName" class="col-sm-1 control-label">具体类型</label>
                        <div class="col-sm-11">
                            <select class="form-control" id="edit_qcName" name="quesCate.q_id">

                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit_knowledge" class="col-sm-1 control-label">知识点</label>
                        <div class="col-sm-11">
                            <input type="text" class="form-control" id="edit_knowledge" placeholder="知识点"
                                   name="knowledge.knowledgeName">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit_difficultyLevel" class="col-sm-1 control-label">难度系数</label>
                        <div class="col-sm-11">
                            <input type="text" class="form-control" id="edit_difficultyLevel" placeholder="难度系数"
                                   name="difficultyLevel">
                        </div>
                    </div>
                    <div class="form-group" id="edit_blankNumDiv" style="display:none">
                        <label for="edit_blankNum" class="col-sm-1 control-label">空的个数</label>
                        <div class="col-sm-11">
                            <input type="text" class="form-control" id="edit_blankNum" placeholder="空的个数"
                                   name="blankNum">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit_answer" class="col-sm-1 control-label">答案</label>
                        <div class="col-sm-11">
                            <input type="text" class="form-control" id="edit_answer" placeholder="答案" name="answer">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="edit_description" class="col-sm-1 control-label">试题来源</label>
                        <div class="col-sm-11">
                            <input type="text" class="form-control" id="edit_description" placeholder="试题来源"
                                   name="description">
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary" onclick="updateQuestion()">保存修改</button>
            </div>
        </div>
    </div>

</div>
<!-- /#wrapper -->

<script type="text/javascript">


    $(function () {
        //科目发生改变
        $("#quesSub").change(function () {
            var sub = $("#quesSub option:selected").val();
            var probCate = $("#quesCate option:selected").val();
            $("#category option:gt(0)").remove();
            $.ajax({
                type: "get",
                url: "${pageContext.request.contextPath}/question/getQuesCate",
                data:
                    {
                        "quesSub": sub,
                        "probQues": probCate
                    },
                success: function (data) {
                    for (var i in data[0]) {
                        //创建文本节点
                        var quesCate = data[0][i].qcName
                        var textSub = document.createTextNode(quesCate);
                        //创建option节点
                        var op = document.createElement("option");
                        //修改option的value
                        $(op).val(data[0][i].q_id);
                        $(op).append(textSub);
                        $(op).appendTo("#category");
                    }
                }
            });
        })
    })

    $(function () {
        //弹出层科目发生改变
        $("#edit_courseName").change(function () {
            var sub = $("#edit_courseName option:selected").val();
            var probCate = $("#edit_category option:selected").val();
            $("#edit_qcName option").remove();
            $.ajax({
                type: "get",
                url: "${pageContext.request.contextPath}/question/getQuesCate",
                data:
                    {
                        "quesSub": sub,
                        "probQues": probCate
                    },
                success: function (data) {
                    for (var i in data[0]) {
                        //创建文本节点
                        var quesCate = data[0][i].qcName
                        var textSub = document.createTextNode(quesCate);
                        //创建option节点
                        var op = document.createElement("option");
                        //修改option的value
                        $(op).val(data[0][i].q_id);
                        $(op).append(textSub);
                        $(op).appendTo("#edit_qcName");
                    }
                }
            });
        })
    })

    $(function () {
        //添加页面科目发生改变
        $("#add_courseName").change(function () {
            var sub = $("#add_courseName option:selected").val();
            var probCate = $("#add_category option:selected").val();
            $("#add_qcName option").remove();
            $.ajax({
                type: "get",
                url: "${pageContext.request.contextPath}/question/getQuesCate",
                data:
                    {
                        "quesSub": sub,
                        "probQues": probCate
                    },
                success: function (data) {
                    for (var m = 0; m < 2; m++) {
                        for (var i in data) {
                            //创建文本节点
                            var quesCate = data[m][i].qcName
                            var textSub = document.createTextNode(quesCate);
                            //创建option节点
                            var op = document.createElement("option");
                            //修改option的value
                            if (m == 0) {
                                $(op).val(data[m][i].q_id);
                                $(op).append(textSub);
                                $(op).appendTo("#add_qcName");
                            }
                            else {
                                $(op).val(data[m][i].k_id);
                                $(op).append(textSub);
                                $(op).appendTo("#add_knowledge");
                            }

                        }
                    }

                }
            });
        })
    })


    $(function () {
        //题目类型发生改变
        $("#quesCate").change(function () {
            var sub = $("#quesSub option:selected").val();
            var probCate = $("#quesCate option:selected").val();
            $("#category option:gt(0)").remove();
            $.ajax({
                type: "get",
                url: "${pageContext.request.contextPath}/question/getQuesCate",
                data:
                //"{quesSub:'"+sub+"',probQues:'"+probCate+"'}",
                //data:{"quesSub":sub},
                    {
                        "quesSub": sub,
                        "probQues": probCate
                    },
                success: function (data) {
                    for (var i in data) {
                        //创建文本节点
                        var quesCate = data[i].qcName
                        var textSub = document.createTextNode(quesCate);
                        //创建option节点
                        var op = document.createElement("option");
                        //修改option的value
                        $(op).val(data[i].q_id);
                        $(op).append(textSub);
                        $(op).appendTo("#category");
                    }
                }
            });
        })
    })


    $(function () {
        //弹出层题目类型发生改变
        $("#edit_category", "#add_category").change(function () {
            var sub = $("#edit_courseName option:selected").val();
            var probCate = $("#edit_category option:selected").val();
            $("#edit_qcName option").remove();
            $.ajax({
                type: "get",
                url: "${pageContext.request.contextPath}/question/getQuesCate",
                data:
                    {
                        "quesSub": sub,
                        "probQues": probCate
                    },
                success: function (data) {
                    for (var i in data) {
                        //创建文本节点
                        var quesCate = data[i].qcName
                        var textSub = document.createTextNode(quesCate);
                        //创建option节点
                        var op = document.createElement("option");
                        //修改option的value
                        $(op).val(data[i].q_id);
                        $(op).append(textSub);
                        $(op).appendTo("#edit_qcName");
                    }
                }
            });
        })
    })

    $(function () {
        //添加页面题目类型发生改变
        $("#add_category").change(function () {
            var sub = $("#add_courseName option:selected").val();
            var probCate = $("#add_category option:selected").val();
            $("#add_qcName option").remove();
            $.ajax({
                type: "get",
                url: "${pageContext.request.contextPath}/question/getQuesCate",
                data:
                //"{quesSub:'"+sub+"',probQues:'"+probCate+"'}",
                //data:{"quesSub":sub},
                    {
                        "quesSub": sub,
                        "probQues": probCate
                    },
                success: function (data) {
                    for (var m = 0; m < 2; m++) {
                        for (var i in data) {
                            //创建文本节点
                            var quesCate = data[m][i].qcName
                            var textSub = document.createTextNode(quesCate);
                            //创建option节点
                            var op = document.createElement("option");
                            //修改option的value
                            if (m == 0) {
                                $(op).val(data[m][i].q_id);
                                alert(data[m][i].q_id)
                                $(op).append(textSub);
                                $(op).appendTo("#add_qcName");
                            }
                        }
                    }

                }
            });
        })
    })

    //删除试题
    function deleteQues(p_id, id) {
        if (confirm('确实要删除该题目吗?')) {
            $.post("${pageContext.request.contextPath}/question/deleteQues", {"p_id": p_id, "id": id}, function (data) {
                alert("试题删除更新成功！");
                window.location.reload();
            });
        }
    }

    //ajax获取试题信息
    function editQues(p_id, id) {
        $("#edit_blankNumDiv").hide();
        $.ajax({
            type: "get",
            url: "${pageContext.request.contextPath}/question/editQuesInfo",
            data: {"p_id": p_id, "id": id},
            success: function (data) {
                if (data.probCate.p_id == "1") {
                    $("#edit_ques_id").val(data.s_id);
                    $("#edit_title").val(data.title);
                    $("#edit_courseName").val(data.course.c_id);
                    $("#edit_category").val(data.probCate.p_id);
                    $("#edit_qcName ").val(data.quesCate.q_id);
                    $("#edit_knowledge").val(data.knowledge.knowledgeName);
                    $("#edit_difficultyLevel").val(data.difficultyLevel);
                    $("#edit_answer").val(data.answer);
                    $("#edit_description").val(data.description);
                }
                if (data.probCate.p_id == "2") {
                    $("#edit_ques_id").val(data.f_id);
                    $("#edit_blankNum").val(data.blankNum);
                    $("#edit_blankNumDiv").show();
                    $("#edit_title").val(data.title);
                    $("#edit_courseName").val(data.course.c_id);
                    $("#edit_category").val(data.probCate.p_id);
                    $("#edit_qcName ").val(data.quesCate.q_id);
                    $("#edit_knowledge").val(data.knowledge.knowledgeName);
                    $("#edit_difficultyLevel").val(data.difficultyLevel);
                    $("#edit_answer").val(data.answer);
                    $("#edit_description").val(data.description);
                }
                if (data.probCate.p_id == "3") {
                    $("#edit_ques_id").val(data.j_id);
                    $("#edit_title").val(data.title);
                    $("#edit_courseName").val(data.course.c_id);
                    $("#edit_category").val(data.probCate.p_id);
                    $("#edit_qcName ").val(data.quesCate.q_id);
                    $("#edit_knowledge").val(data.knowledge.knowledgeName);
                    $("#edit_difficultyLevel").val(data.difficultyLevel);
                    $("#edit_answer").val(data.answer);
                    $("#edit_description").val(data.description);
                }
                if (data.probCate.p_id == "4") {
                    $("#edit_ques_id").val(data.b_id);
                    $("#edit_title").val(data.title);
                    $("#edit_courseName").val(data.course.c_id);
                    $("#edit_category").val(data.probCate.p_id);
                    $("#edit_qcName ").val(data.quesCate.q_id);
                    $("#edit_knowledge").val(data.knowledge.knowledgeName);
                    $("#edit_difficultyLevel").val(data.difficultyLevel);
                    $("#edit_answer").val(data.answer);
                    $("#edit_description").val(data.description);
                }
            }
        });
    }

    //跟新试题
    function updateQuestion() {

        $.post("${pageContext.request.contextPath}/question/updateQuestion", $("#edit_question_form").serialize(), function (data) {
            alert("试题信息更新成功！");
            window.location.reload();
        });
    }

    function addQuestion() {
        $.post("${pageContext.request.contextPath}/question/addQuestion", $("#add_form").serialize(), function (data) {
            alert("试题添加成功！");
            window.location.reload();
        });
    }

    //显示试题具体类型
    $(function () {
        $("#addMany_quesSub").change(function () {
            var c_id = $("#addMany_quesSub option:selected").val();
            $.post("${pageContext.request.contextPath}/question/showQuesCate", {"c_id": c_id}, function (data) {
                $("#addMany_qcNameDiv").empty();
                for (var i in data) {
                    $("#addMany_qcNameDiv").append("&nbsp&nbsp<input type=checkbox name=addMany_qcName value='" + data[i].q_id + "'FieldCount/>" + data[i].qcName + "&nbsp&nbsp&nbsp&nbsp");
                }
                $("#addMany_qcNameDiv").append("<input name=checkall1 type=checkbox value=0 onClick=checkAllBox(this);//>全选<br>");
            });
        })
    })


    //试题类型全选

    function checkAllBox(obj) {
        var answer = document.getElementsByName("addMany_qcName");
        if (obj.checked == true) {
            for (var i = 0; i < answer.length; i++) {
                answer[i].checked = true;
            }

        } else {
            for (var i = 0; i < answer.length; i++) {
                answer[i].checked = false;
            }
        }
    }

    //试题类型前台检查
    function checkData() {
        var answer = document.getElementsByName("addMany_qcName");
        var flag = false;
        for (var i = 0; i < income.length; i++) {
            if (income[i].checked == true) {
                flag = true;
                break;
            }
        }
        if (!flag) {
            alert("请至少选择一项");
        }
        return flag;
    }


    //根据条件下载模板
    function tempDownload() {

        var checkID = [];
        $("input[name='addMany_qcName']:checked").each(function (i) {
            checkID.push($(this).val());
        })
        $("#addManyForm").submit();
    }
</script>

</body>

</html>
