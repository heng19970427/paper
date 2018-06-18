<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="zr" uri="http://zr/common/" %>

<html>
<head>
    <meta content="text/html;charset=utf8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>题库管理 - 智能试卷</title>
</head>

<body>
<%--header start--%>
<jsp:include page="header.jsp"/>
<%--header end--%>
<div class="body" id="wrapper">
    <jsp:include page="showMsg.jsp"/>
    <div class="table-responsive">
        <div id="toolbar">
            <form class="form-inline">
                <div class="form-group">
                    <label for="courseName">显示科目</label>
                    <select id="courseName" class="form-control" name="c_id">
                        <option value="">全部</option>
                        <c:forEach items="${courseList}" var="course">
                            <option value="${course.c_id}">${course.courseName}</option>
                        </c:forEach>
                    </select>
                </div>
                <button class="btn btn-primary" data-toggle="modal">创建模板</button>
            </form>
        </div>
        <table class="table table-bordered"
               id="table-template"
               data-toolbar="#toolbar"
               data-search="true"
               data-show-refresh="true"
               data-show-columns="true">
            <%--<c:forEach items="${paperTempletList}" var="templet">--%>
            <%--<tr>--%>
            <%--<td>${templet.templetName}</td>--%>
            <%--<td>${templet.difficultyLevel}</td>--%>
            <%--<td><a href="#" class="btn btn-primary btn-xs" data-toggle="modal"--%>
            <%--data-target="#paperEditDialog"--%>
            <%--onclick=editTemp("${templet.pt_id}")>详情</a>--%>
            <%--</td>--%>
            <%--<td><a href="#" class="btn btn-danger btn-xs"--%>
            <%--onclick=deleteTemp("${templet.pt_id}")>删除</a></td>--%>
            <%--<td><a href="#" class="btn btn-info btn-xs" data-toggle="modal"--%>
            <%--data-target="#createPaperDialog" onclick="getPt_id('${templet.pt_id}')">生成试卷</a>--%>
            <%--</td>--%>
            <%--</tr>--%>
            <%--</c:forEach>--%>
        </table>
    </div>

    <%--模板编辑页面--%>
    <div class="modal fade" id="paperEditDialog" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel">
        <div class="modal-dialog" style="width: 1040px" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel">模板详细信息</h4>
                </div>
                <div class="modal-body">
                    <div id="editTemp1Div">
                        <form class="form-horizontal" id="editTemp1">
                            <input type="hidden" id="edit_pt_id" name="pt_id"/>
                            <div class="row">
                                <div class="form-group">
                                    <label for="edit_courseName" class="col-sm-1 control-label">科目</label>
                                    <div class="col-sm-3">
                                        <select id="edit_courseName" class="form-control"
                                                name="course.c_id">
                                            <c:forEach items="${courseList}" var="course">
                                                <option value="${course.c_id}">${course.courseName}</option>
                                            </c:forEach>
                                        </select>
                                    </div>

                                    <label for="edit_score" class="col-sm-1 control-label">总分</label>
                                    <div class="col-sm-3">
                                        <input type="input" class="form-control" id="edit_score"
                                               name="score"
                                               placeholder="总分">
                                    </div>
                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group">
                                    <label for="edit_selectQuesNum" class="col-sm-1 control-label">选择题数目</label>
                                    <div class="col-sm-3">
                                        <input type="input" class="form-control" id="edit_selectQuesNum"
                                               name="selectQuesNum"
                                               placeholder="选择题数目">
                                    </div>
                                    <label for="edit_selectQuesNum" class="col-sm-1 control-label">填空题数目</label>
                                    <div class="col-sm-3">
                                        <input type="input" class="form-control" id="edit_fillBlankQuesNum"
                                               name="fillBlankQuesNum" placeholder="总分">
                                    </div>

                                </div>
                            </div>

                            <div class="row">
                                <div class="form-group">
                                    <label for="edit_selectQuesNum" class="col-sm-1 control-label">判断题数目</label>
                                    <div class="col-sm-3">
                                        <input type="input" class="form-control" id="edit_judgeQuesNum"
                                               name="judgeQuesNum" placeholder="总分">
                                    </div>
                                    <label for="edit_selectQuesNum" class="col-sm-1 control-label">大题数目</label>
                                    <div class="col-sm-3">
                                        <input type="input" class="form-control" id="edit_bigQuesNum"
                                               name="bigQuesNum" placeholder="总分">
                                    </div>

                                </div>
                            </div>
                            <div class="row">
                                <label for="edit_selectQuesNum" class="col-sm-1 control-label">选择题分数</label>
                                <div class="col-sm-3">
                                    <input type="input" class="form-control" id="edit_selectQuesScore"
                                           name="selectQuesScore" placeholder="判断题数目">
                                </div>
                                <label for="edit_fillBlankQuesScore" class="col-sm-1 control-label">填空题分数</label>
                                <div class="col-sm-3">
                                    <input type="input" class="form-control" id="edit_fillBlankQuesScore"
                                           name="fillBlankQuesScore" placeholder="大题数目">
                                </div>
                            </div>
                            <div class="row">
                                <label for="edit_judgeQuesScore" class="col-sm-1 control-label">判断题分数</label>
                                <div class="col-sm-3">
                                    <input type="input" class="form-control" id="edit_judgeQuesScore"
                                           name="judgeQuesScore" placeholder="判断题数目">
                                </div>
                                <label for="edit_bigQuesScore" class="col-sm-1 control-label">大题分数</label>
                                <div class="col-sm-3">
                                    <input type="input" class="form-control" id="edit_bigQuesScore"
                                           name="bigQuesScore" placeholder="大题数目">
                                </div>
                            </div>

                            <div>
                                <label for="edit_templetName" class="col-sm-1 control-label">模板名称</label>
                                <div class="col-sm-3">
                                    <input type="input" class="form-control" id="edit_templetName"
                                           name="templetName" value="java普通模板" placeholder="总分">
                                </div>
                            </div>
                            <div>
                                <label for="edit_difficultyLevel" class="col-sm-1 control-label">难度系数</label>
                                <div class="col-sm-3">
                                    <input type="input" class="form-control" id="edit_difficultyLevel"
                                           name="difficultyLevel" placeholder="总分">
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm-offset-2 col-sm-10">
                                    <label>知识点占比查看</label>
                                    <button type="button" class="btn btn-default"
                                            onclick="editKnowledge1()">点击前往
                                    </button>
                                </div>
                            </div>
                        </form>
                    </div>


                    <div id="editTemp2Div" style="display: none">
                        <form id="editTemp2">
                            <table width="550px" id="editKnow">
                                <tr>
                                    <td>知识点</td>
                                    <td>选择题</td>
                                    <td>填空题</td>
                                    <td>判断题</td>
                                    <td>大题</td>
                                </tr>
                                <tr>
                                    <td>100</td>
                                    <td>100</td>
                                    <td>100</td>
                                    <td>100</td>
                                    <td>100</td>
                                </tr>
                            </table>
                        </form>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                            <button type="button" class="btn btn-primary" onclick="updatePaperTemp()">保存修改
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <%--模板编辑页面--%>

    <%--输入试卷名字--%>
    <div class="modal fade" id="createPaperDialog" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel">
        <div class="modal-dialog" style="width: 250px" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel2">请输入试卷名称</h4>
                </div>
                <div class="modal-body" style="align-self: center">
                    <input id="paperName" name="paperName"/>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <a href="#" class="btn btn-primary" onclick="createPaper()">生成试卷</a>
                </div>
            </div>
        </div>
    </div>
    <%--输入试卷名字--%>

</div>

<script type="text/javascript">
    function setKnowledge() {
        $.post("${pageContext.request.contextPath}/paperTemplate/createTemp1.do", $("#setTemp1").serialize(), function (data) {
            for (var i in data) {
                $("#setTemp2").append("<input type='hidden' name='knowledgeTemplets[" + i + "].knowledge.k_id' value='" + data[i].k_id + "' />");
                $("#setKnow").append("<tr><td>" + data[i].knowledgeName + "</td><td><input name='knowledgeTemplets[" + i + "].selectQuesNum'/></td><td><input name='knowledgeTemplets[" + i + "].fillBlankQuesNum'/></td><td><input name='knowledgeTemplets[" + i + "].judgeQuesNum'/></td><td><input name='knowledgeTemplets[" + i + "].bigQuesNum'/></td></tr>")
            }
        });
    }

    function editTemp(pt_id) {
        $.post("${pageContext.request.contextPath}/paperTemplate/editTemp.do", {"pt_id": pt_id}, function (data) {
            paperTemp = data;
            $("#edit_courseName").find("option[value = '" + data.course.c_id + "']").attr("selected", "selected");
            $("#edit_score").val(data.score);
            $("#edit_selectQuesNum").val(data.selectQuesNum);
            $("#edit_fillBlankQuesNum").val(data.fillBlankQuesNum);
            $("#edit_judgeQuesNum").val(data.judgeQuesNum);
            $("#edit_bigQuesNum").val(data.bigQuesNum);
            $("#edit_selectQuesScore").val(data.selectQuesScore);
            $("#edit_fillBlankQuesScore").val(data.fillBlankQuesScore);
            $("#edit_judgeQuesScore").val(data.judgeQuesScore);
            $("#edit_bigQuesScore").val(data.bigQuesScore);
            $("#edit_templetName").val(data.templetName);
            $("#edit_difficultyLevel").val(data.difficultyLevel);
            $("#edit_pt_id").val(pt_id);
        });
    }

    function editKnowledge1() {
        //将修改后的数据提交到服务端
        $.post("${pageContext.request.contextPath}/paperTemplate/createTemp1.do", $("#editTemp1").serialize(), function (data) {
        });
        //明天写

        //获取所有知识点模板
        var data = paperTemp.knowledgeTemplets;
        for (var i in data) {
            $("#editKnow").append("<tr><td>" + data[i].knowledge.knowledgeName + "</td><td><input name='knowledgeTemplets[" + i + "].selectQuesNum' value='" + data[i].selectQuesNum + "'/></td><td><input name='knowledgeTemplets[" + i + "].fillBlankQuesNum' value='" + data[i].fillBlankQuesNum + "'/></td><td><input name='knowledgeTemplets[" + i + "].judgeQuesNum' value='" + data[i].judgeQuesNum + "'/></td><td><input name='knowledgeTemplets[" + i + "].bigQuesNum' value='" + data[i].bigQuesNum + "'/></td></tr>")
            $("#editKnow").append("<input type='hidden' name='knowledgeTemplets[" + i + "].kt_id' value='" + data[i].kt_id + "'/>");
        }
        $("#editTemp1Div").hide();
        $("#editTemp2Div").show();
    }

    function updatePaperTemp() {
        $.post("${pageContext.request.contextPath}/paperTemplate/updateTemp", $("#editTemp2").serialize(), function (data) {
            alert("模板更新成功！");
            window.location.reload();
        });
    }

    function deleteTemp(pt_id) {
        $.post(
            "${pageContext.request.contextPath}/paperTemplate/delTemp",
            {"pt_id": pt_id},
            function (data, status) {
                if (status === 'success'){
                    if (data['code']===0){
                        alert(data['msg']);
                        refreshTable($('#courseName').val());
                    } else {
                        alert(data['error'])
                    }
                }else {
                    alert('请求服务器失败, 请稍后重试!')
                }
            }
        );
    }

    function setKnowledge2() {
        $.post("${pageContext.request.contextPath}/paperTemplate/createTemp2.do", $("#setTemp2").serialize(), function (data) {
            alert("模板创建成功！");
            window.location.reload();
        });
    }

    function getPt_id(pt_id) {
        current_pt_id = pt_id;
    }


    function createPaper() {
        var paperName = $("#paperName").val();
        var a = document.createElement('a');
        var url = "${pageContext.request.contextPath}/paper/createPaper?paperName=" + paperName + "&pt_id=" + current_pt_id + "";
        a.href = url;
        a.click();
    }

    $(document).ready(function () {
        const $table = $('#table-template');
        $table.bootstrapTable({
            columns: [{
                field: 'templetName',
                title: '模板名称'
            }, {
                field: 'difficultyLevel',
                title: '难度系数'
            }, {
                field: 'pt_id',
                title: '查看'
            }, {
                field: 'pt_id',
                title: '删除',
                formatter: delTemplateFormatter
            }, {
                field: 'pt_id',
                title: '生成试卷'
            }],
            striped: true,
            pagination: true,
            sidePagination: 'client',
            pageSize: 10,
            pageList: [10, 20, 50],
            pageNumber: 1,
            method: 'get',
            url: "${pageContext.request.contextPath}/paperTemplate/getTemps",
            onLoadError: function () {
                alert("模板列表加载数据失败, 请刷新!");
            },
            onLoadSuccess: function () {
                console.info("模板列表加载成功!");
            },
            height: getHeight()
        });

        $(window).resize(function () {
            $table.bootstrapTable('resetView', {height: getHeight()});
        });

        $('#courseName').change(function () {
            console.log($(this).val());
            refreshTable($(this).val())
        })
    });
    
    function detailFormatter(index, row) {
        return ''
    }

    function delTemplateFormatter(value, row, index) {
        return '<a href="#"><button class="btn" onclick="deleteTemp(' + row.pt_id + ')"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></a>';
    }

    function getHeight() {
        return $(window).height() - 100;
    }

    function refreshTable(c_id) {
        console.log("刷新数据, c_id="+c_id);
        if (c_id !== null) {
            $('#table-template').bootstrapTable('refresh', {query: {c_id: c_id}});
        }else {
            $('#table-template').bootstrapTable('refresh');
        }
    }
</script>
</body>

</html>
