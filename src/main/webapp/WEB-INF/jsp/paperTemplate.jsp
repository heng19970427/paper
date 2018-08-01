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
    <style>
        #editKnow tr td input {
            width: 50px;
            border-radius: 5px;
        }
    </style>
</head>

<body>
<%--header start--%>
<jsp:include page="header.jsp"/>
<%--header end--%>
<div class="body" id="wrapper">
    <jsp:include page="showMsg.jsp"/>
    <div class="table-responsive">
        <div id="toolbar">
            <div class="form-inline">
                <div class="form-group">
                    <label for="courseName">显示科目</label>
                    <select id="courseName" class="form-control" name="c_id">
                        <option value="">全部</option>
                        <c:forEach items="${courseList}" var="course">
                            <option value="${course.c_id}">${course.courseName}</option>
                        </c:forEach>
                    </select>
                </div>
                <button class="btn btn-primary"
                        data-toggle="modal"
                        data-target="#modal-createTemp"
                        data-act="create">
                    创建模板
                </button>
            </div>
        </div>
        <table class="table table-bordered"
               id="table-template"
               data-toolbar="#toolbar"
               data-search="true"
               data-show-refresh="true"
               data-show-columns="true">
        </table>
    </div>

    <%--模板编辑页面--%>
    <div class="modal fade" id="modal-createTemp" tabindex="-1" role="dialog" aria-labelledby="modal-createLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="modal-createLabel">模板详细信息</h4>
                </div>
                <form id="form-Temp">
                <div class="modal-body">
                        <div id="hidden-input">
                            <input type="hidden" id="edit_pt_id" name="pt_id"/>
                        </div>

                        <div class="form-group">
                            <label for="edit_templetName">模板名称</label>
                            <input type="input" class="form-control" id="edit_templetName" name="templetName"
                                   placeholder="模板名称">
                        </div>

                        <div class="form-group">
                            <label for="edit_courseName">科目</label>
                            <select id="edit_courseName" class="form-control"
                                    name="course.c_id" onchange="setKnowledge(this)">
                                <option value="">请选择科目</option>
                                <c:forEach items="${courseList}" var="course">
                                    <option value="${course.c_id}">${course.courseName}</option>
                                </c:forEach>
                            </select>
                        </div>

                        <div class="form-group">
                            <label for="edit_score">总分</label>
                            <input type="number" class="form-control" id="edit_score" name="score" placeholder="总分">
                        </div>

                        <div class="form-inline">
                            <label for="edit_selectQuesNum">选择题数目</label>
                            <input type="number" class="form-control" id="edit_selectQuesNum" name="selectQuesNum"
                                   placeholder="选择题数目">

                            <label for="edit_selectQuesNum">填空题数目</label>
                            <input type="number" class="form-control" id="edit_fillBlankQuesNum" name="fillBlankQuesNum"
                                   placeholder="填空题数目">

                            <label for="edit_selectQuesNum">判断题数目</label>
                            <input type="number" class="form-control" id="edit_judgeQuesNum" name="judgeQuesNum"
                                   placeholder="判断题数目">

                            <label for="edit_selectQuesNum">大题数目&nbsp;&nbsp;&nbsp;</label>
                            <input type="number" class="form-control" id="edit_bigQuesNum" name="bigQuesNum"
                                   placeholder="大题数目">
                        </div>

                        <div class="form-inline">
                            <label for="edit_selectQuesNum">选择题分数</label>
                            <input type="number" class="form-control" id="edit_selectQuesScore" name="selectQuesScore"
                                   placeholder="选择题分数" onchange="onChangeScore()">

                            <label for="edit_fillBlankQuesScore">填空题分数</label>
                            <input type="number" class="form-control" id="edit_fillBlankQuesScore"
                                   name="fillBlankQuesScore" placeholder="填空题分数" onchange="onChangeScore()">

                            <label for="edit_judgeQuesScore">判断题分数</label>
                            <input type="number" class="form-control" id="edit_judgeQuesScore" name="judgeQuesScore"
                                   placeholder="判断题分数" onchange="onChangeScore()">

                            <label for="edit_bigQuesScore">大题分数&nbsp;&nbsp;&nbsp;</label>
                            <input type="number" class="form-control" id="edit_bigQuesScore" name="bigQuesScore"
                                   placeholder="大题分数" onchange="onChangeScore()">
                        </div>

                        <div class="form-group">
                            <label for="edit_difficultyLevel">难度系数</label>
                            <input type="number" class="form-control" id="edit_difficultyLevel" name="difficultyLevel"
                                   placeholder="难度系数">
                        </div>
                        <div class="form-group">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <td>知识点</td>
                                        <td>选择题(<span id="score_select">100</span>分)</td>
                                        <td>填空题(<span id="score_blank">100</span>分)</td>
                                        <td>判断题(<span id="score_judge">100</span>分)</td>
                                        <td>大题(<span id="score_big">100</span>分)</td>
                                    </tr>
                                </thead>
                                <tbody id="editKnow">

                                </tbody>
                            </table>
                        </div>

                </div>
                <div class="modal-footer">
                    <button type="reset" class="btn btn-danger" id="reset">重置</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                    <button type="button" class="btn btn-primary" id="btn-submit">保存</button>
                </div>
                </form>
            </div>
        </div>
    </div>
    <%--模板编辑页面--%>

    <%--输入试卷名字--%>
    <div class="modal fade" id="createPaperDialog" tabindex="-1" role="dialog"
         aria-labelledby="modal-createLabel">
        <div class="modal-dialog" style="width: 250px" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                    <h4 class="modal-title" id="myModalLabel2">创建试卷</h4>
                </div>
                <form action="${pageContext.request.contextPath}/paper/createPaper" method="post">
                    <div class="modal-body" style="align-self: center">
                        <input type="hidden" name="pt_id" id="createPaper-ptid">
                        <div class="form-group">
                            <label for="paperName">试卷名称</label>
                            <input class="form-control" id="paperName" name="paperName"/>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="submit" class="btn btn-primary">生成试卷</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <%--输入试卷名字--%>

</div>

<script type="text/javascript">
    function setKnowledge() {
        let c_id = $('#edit_courseName').val();
        $.ajax({
            method: 'POST',
            url: "${pageContext.request.contextPath}/paperTemplate/getKnowledgeList",
            data: {c_id: c_id},
            async: false,
            success: function (data) {
                $('#editKnow').html('');
                console.log(data);
                console.info('更新知识点');
                data.forEach(function (item, index) {
                    $("#editKnow").append("<tr><td>" + item.knowledgeName + "</td><td><input type='number' id='select"+item.k_id+"' name='knowledgeTemplets[" + index + "].selectQuesNum'/>个</td><td><input type='number' id='blank"+item.k_id+"' name='knowledgeTemplets[" + index + "].fillBlankQuesNum'/>个</td><td><input type='number' id='judge"+item.k_id+"' name='knowledgeTemplets[" + index + "].judgeQuesNum'/>个</td><td><input type='number' id='big"+item.k_id+"' name='knowledgeTemplets[" + index + "].bigQuesNum'/>个</td></tr>")
                    $("#hidden-input").append("<input type='hidden' name='knowledgeTemplets[" + index + "].knowledge.k_id' value='" + item.k_id + "' />");
                })
            }
        });
    }

    function saveTemp() {
        $.post(
            "${pageContext.request.contextPath}/paperTemplate/createTemp",
            $('#form-Temp').serialize(),
            function (data, status) {
                if (status === 'success') {
                    if (data['code'] === 0) {
                        alert(data['msg']);
                        refreshTable($('#courseName').val());
                    } else {
                        alert(data['error'])
                    }
                    $('#modal-createTemp').modal('hide');
                } else {
                    alert('请求服务器失败, 请稍后重试!')
                }
            }
        )
    }

    function editTemp(pt_id) {
        $.post("${pageContext.request.contextPath}/paperTemplate/editTemp", {"pt_id": pt_id}, function (data) {
            console.log(data);
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
            onChangeScore();
            setKnowledge();
            let kl = data.knowledgeTemplets;
            kl.forEach(function (item, index) {
                let k_id = item['knowledge']['k_id'];
                $('#select'+k_id).val(item['selectQuesNum']);
                $('#blank'+k_id).val(item['fillBlankQuesNum']);
                $('#judge'+k_id).val(item['judgeQuesNum']);
                $('#big'+k_id).val(item['bigQuesNum']);
            })
        });
    }

    function onChangeScore() {
        $('#score_select').text($('#edit_selectQuesScore').val());
        $('#score_judge').text($('#edit_judgeQuesScore').val());
        $('#score_blank').text($('#edit_fillBlankQuesScore').val());
        $('#score_big').text($('#edit_bigQuesScore').val());
    }

    function updatePaperTemp() {
        $.post("${pageContext.request.contextPath}/paperTemplate/updateTemp",
            $("#form-Temp").serialize(),
            function (data) {
                if (status === 'success') {
                    if (data['code'] === 0) {
                        alert(data['msg']);
                        refreshTable($('#courseName').val());
                    } else {
                        alert(data['error'])
                    }
                    $('#modal-createTemp').modal('hide');
                } else {
                    alert('请求服务器失败, 请稍后重试!')
                }
        });
    }

    function deleteTemp(pt_id) {
        $.post(
            "${pageContext.request.contextPath}/paperTemplate/delTemp",
            {"pt_id": pt_id},
            function (data, status) {
                if (status === 'success') {
                    if (data['code'] === 0) {
                        alert(data['msg']);
                        refreshTable($('#courseName').val());
                    } else {
                        alert(data['error'])
                    }
                } else {
                    alert('请求服务器失败, 请稍后重试!')
                }
            }
        );
    }

    function createPaper(pt_id) {
        $('#btn-saveTemp').click(function () {
            saveTemp()
        });
        $('#createPaper-ptid').val(pt_id)
    }

    function tempDetail(pt_id) {
        editTemp(pt_id);
    }

    $(document).ready(function () {
        const $table = $('#table-template');
        const $modal = $('#modal-createTemp');
        $table.bootstrapTable({
            columns: [{
                field: 'pt_id',
                title: '模板ID'
            }, {
                field: 'templetName',
                title: '模板名称'
            }, {
                field: 'difficultyLevel',
                title: '难度系数'
            }, {
                field: 'pt_id',
                title: '查看',
                formatter: updateTempFormatter
            }, {
                field: 'pt_id',
                title: '删除',
                formatter: delTemplateFormatter
            }, {
                field: 'pt_id',
                title: '生成试卷',
                formatter: createPaperFormatter
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
        });

        $modal.on('hidden.bs.modal', function () {
            $('#reset').trigger('click');
        });

        const btn_submit = $('#btn-submit');
        $modal.on('shown.bs.modal', function (event) {
            let btn = $(event.relatedTarget);
            let act = btn.data('act');
            if (act === 'create') {
                btn_submit.click(function () {
                    saveTemp();
                })
            }else if (act === 'update') {
                btn_submit.click(function () {
                    updatePaperTemp();
                })
            }
        })
    });

    function detailFormatter(index, row) {
        return ''
    }

    function delTemplateFormatter(value, row, index) {
        return '<a href="#" onclick="deleteTemp(' + row.pt_id + ')"><button class="btn"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></a>';
    }

    function createPaperFormatter(value, row, index) {
        return '<a href="#" data-toggle="modal" data-target="#createPaperDialog" onclick="createPaper(' + row.pt_id + ')"><button class="btn"><span class="glyphicon glyphicon-arrow-down" aria-hidden="true"></span></button></a>';
    }

    function updateTempFormatter(value, row, index) {
        return '<a href="#" data-toggle="modal" data-target="#modal-createTemp" data-act="update" onclick="tempDetail(' + row.pt_id + ')"><button class="btn"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button></a>';
    }

    function getHeight() {
        return $(window).height() - 100;
    }

    function refreshTable(c_id) {
        console.log("刷新数据, c_id=" + c_id);
        if (c_id !== null) {
            $('#table-template').bootstrapTable('refresh', {query: {c_id: c_id}});
        } else {
            $('#table-template').bootstrapTable('refresh');
        }
    }
</script>
</body>

</html>
