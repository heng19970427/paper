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
<div class="body" id="wrapper">
<div id="page-wrapper">

    <div>
        <!-- Nav tabs -->
        <ul class="nav nav-tabs" role="tablist">
            <li role="presentation" class="active"><a href="#allTemp" aria-controls="home" role="tab" data-toggle="tab">所有模板</a></li>
            <li role="presentation" ><a href="#templetCreate" aria-controls="profile" role="tab" data-toggle="tab">创建模板</a></li>
            <li role="presentation"><a href="#knowlidgeTemp" aria-controls="messages" role="tab" data-toggle="tab">知识点占比</a></li>
        </ul>

        <!-- Tab panes -->
        <div class="tab-content">
            <%--查看所有模板--%>
            <div role="tabpanel" class="tab-pane active" id="allTemp">
                <div class="form-group">
                    <label for="courseName" class="col-sm-1 control-label">科目</label>
                    <div class="col-sm-5">
                        <form action="${pageContext.request.contextPath }/paperTemplate/showTemp.do">
                            <div class="col-sm-5">
                                <select id="courseName1" class="form-control" name="c_id">
                                    <option value="">--请选择--</option>
                                    <c:forEach items="${courseList}" var="course">
                                        <option value="${course.c_id}">${course.courseName}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div>
                                <button type="submit">查询</button>
                            </div>
                        </form>
                    </div>
                </div>
                <br/><br/><br/>
                <div>
                    <table width="550px">
                        <tr>
                            <td>模板名称</td>
                            <td>难度系数</td>
                            <td>查看</td>
                            <td>删除</td>
                            <td>生成试卷</td>
                        </tr>
                        <c:forEach items="${paperTempletList}" var="templet">
                            <tr>
                                <td>${templet.templetName}</td>
                                <td>${templet.difficultyLevel}</td>
                                <td>
                                    <a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#paperEditDialog" onclick=editTemp("${templet.pt_id}")>详情</a>
                                </td>
                                <td><a href="#" class="btn btn-danger btn-xs" onclick=deleteTemp("${templet.pt_id}")>删除</a></td>
                                <td><a href="#" class="btn btn-info btn-xs" data-toggle="modal" data-target="#createPaperDialog" onclick="getPt_id('${templet.pt_id}')">生成试卷</a></td>
                            </tr>
                        </c:forEach>
                    </table>

                </div>

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
                                                <select id="edit_courseName" class="form-control" name="course.c_id">
                                                    <c:forEach items="${courseList}" var="course">
                                                        <option value="${course.c_id}">${course.courseName}</option>
                                                    </c:forEach>
                                                </select>
                                            </div>

                                            <label for="score" class="col-sm-1 control-label">总分</label>
                                            <div class="col-sm-3">
                                                <input type="input" class="form-control" id="edit_score" name="score" placeholder="总分">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="form-group">
                                            <label for="selectQuesNum" class="col-sm-1 control-label">选择题数目</label>
                                            <div class="col-sm-3">
                                                <input type="input" class="form-control" id="edit_selectQuesNum" name="selectQuesNum" placeholder="总分">
                                            </div>
                                            <label for="selectQuesNum" class="col-sm-1 control-label">填空题数目</label>
                                            <div class="col-sm-3">
                                                <input type="input" class="form-control" id="edit_fillBlankQuesNum" name="fillBlankQuesNum" placeholder="总分">
                                            </div>

                                        </div>
                                    </div>

                                    <div class="row">
                                        <div class="form-group">
                                            <label for="selectQuesNum" class="col-sm-1 control-label">判断题数目</label>
                                            <div class="col-sm-3">
                                                <input type="input" class="form-control" id="edit_judgeQuesNum" name="judgeQuesNum" placeholder="总分">
                                            </div>
                                            <label for="selectQuesNum" class="col-sm-1 control-label">大题数目</label>
                                            <div class="col-sm-3">
                                                <input type="input" class="form-control" id="edit_bigQuesNum" name="bigQuesNum" placeholder="总分">
                                            </div>

                                        </div>
                                    </div>
                                    <div class="row">
                                        <label for="selectQuesNum" class="col-sm-1 control-label">选择题分数</label>
                                        <div class="col-sm-3">
                                            <input type="input" class="form-control" id="edit_selectQuesScore" name="selectQuesScore" placeholder="判断题数目">
                                        </div>
                                        <label for="fillBlankQuesScore" class="col-sm-1 control-label">填空题分数</label>
                                        <div class="col-sm-3">
                                            <input type="input" class="form-control" id="edit_fillBlankQuesScore" name="fillBlankQuesScore" placeholder="大题数目">
                                        </div>
                                    </div>
                                    <div class="row">
                                        <label for="judgeQuesScore" class="col-sm-1 control-label">判断题分数</label>
                                        <div class="col-sm-3">
                                            <input type="input" class="form-control" id="edit_judgeQuesScore" name="judgeQuesScore" placeholder="判断题数目">
                                        </div>
                                        <label for="bigQuesScore" class="col-sm-1 control-label">大题分数</label>
                                        <div class="col-sm-3">
                                            <input type="input" class="form-control" id="edit_bigQuesScore" name="bigQuesScore" placeholder="大题数目">
                                        </div>
                                    </div>

                                    <div>
                                        <label for="templetName" class="col-sm-1 control-label">模板名称</label>
                                        <div class="col-sm-3">
                                            <input type="input" class="form-control" id="edit_templetName" name="templetName" value="java普通模板" placeholder="总分">
                                        </div>
                                    </div>
                                    <div>
                                        <label for="difficultyLevel" class="col-sm-1 control-label">难度系数</label>
                                        <div class="col-sm-3">
                                            <input type="input" class="form-control" id="edit_difficultyLevel" name="difficultyLevel" placeholder="总分">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="col-sm-offset-2 col-sm-10">
                                            <label>知识点占比查看</label>
                                            <button type="button" class="btn btn-default" onclick="editKnowledge1()">点击前往</button>
                                        </div>
                                    </div>
                                </form>
                            </div>


                            <div id="editTemp2Div" style="display: none">
                                <form id="editTemp2" >
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
                                    <button type="button" class="btn btn-primary" onclick="updatePaperTemp()">保存修改</button>
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
                                <input id="paperName" name="paperName" />
                            </div>
                            <div class="modal-footer">
                                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                                <a href="#" class="btn btn-primary" onclick="createPaper()">生成试卷</a>
                            </div>
                        </div>
                    </div>
                </div>
            <%--输入试卷名字--%>

            <%--模板创建--%>
            <div role="tabpanel" class="tab-pane" id="templetCreate">
                <div>
                    <h4><p class="text-center">试卷模板</p></h4>
                </div>
                <form class="form-horizontal" id="setTemp1">
                    <div class="row">
                        <div class="form-group">
                            <label for="courseName" class="col-sm-1 control-label">科目</label>
                            <div class="col-sm-3">
                                <select id="courseName" class="form-control" name="course.c_id">
                                    <c:forEach items="${courseList}" var="course">
                                        <option value="${course.c_id}">${course.courseName}</option>
                                    </c:forEach>
                                </select>
                            </div>

                            <label for="score" class="col-sm-1 control-label">总分</label>
                            <div class="col-sm-3">
                                <input type="input" class="form-control" id="score" name="score" value="100" placeholder="总分">
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group">
                            <label for="selectQuesNum" class="col-sm-1 control-label">选择题数目</label>
                            <div class="col-sm-3">
                                <input type="input" class="form-control" id="selectQuesNum" name="selectQuesNum" value="15" placeholder="总分">
                            </div>
                            <label for="selectQuesNum" class="col-sm-1 control-label">填空题数目</label>
                            <div class="col-sm-3">
                                <input type="input" class="form-control" id="fillBlankQuesNum" name="fillBlankQuesNum" value="10" placeholder="总分">
                            </div>

                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group">
                            <label for="selectQuesNum" class="col-sm-1 control-label">判断题数目</label>
                            <div class="col-sm-3">
                                <input type="input" class="form-control" id="judgeQuesNum" name="judgeQuesNum" value="10" placeholder="总分">
                            </div>
                            <label for="selectQuesNum" class="col-sm-1 control-label">大题数目</label>
                            <div class="col-sm-3">
                                <input type="input" class="form-control" id="bigQuesNum" name="bigQuesNum" value="1" placeholder="总分">
                            </div>

                        </div>
                    </div>
                    <div class="row">
                        <label for="selectQuesNum" class="col-sm-1 control-label">选择题分数</label>
                        <div class="col-sm-3">
                            <input type="input" class="form-control" id="selectQuesScore" name="selectQuesScore" value="3" placeholder="判断题数目">
                        </div>
                        <label for="fillBlankQuesScore" class="col-sm-1 control-label">填空题分数</label>
                        <div class="col-sm-3">
                            <input type="input" class="form-control" id="fillBlankQuesScore" name="fillBlankQuesScore" value="3" placeholder="大题数目">
                        </div>
                    </div>
                    <div class="row">
                        <label for="judgeQuesScore" class="col-sm-1 control-label">判断题分数</label>
                        <div class="col-sm-3">
                            <input type="input" class="form-control" id="judgeQuesScore" name="judgeQuesScore" value="1" placeholder="判断题数目">
                        </div>
                        <label for="bigQuesScore" class="col-sm-1 control-label">大题分数</label>
                        <div class="col-sm-3">
                            <input type="input" class="form-control" id="bigQuesScore" name="bigQuesScore" value="15" placeholder="大题数目">
                        </div>
                    </div>

                    <div>
                        <label for="templetName" class="col-sm-1 control-label">模板名称</label>
                        <div class="col-sm-3">
                            <input type="input" class="form-control" id="templetName" name="templetName" value="java普通模板" placeholder="总分">
                        </div>
                    </div>
                    <div>
                        <label for="difficultyLevel" class="col-sm-1 control-label">难度系数</label>
                        <div class="col-sm-3">
                            <input type="input" class="form-control" id="difficultyLevel" name="difficultyLevel" value="3" placeholder="总分">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-sm-10">
                            <label>知识点占比设置</label>
                            <button type="button" class="btn btn-default" onclick="setKnowledge()">点击前往</button>
                        </div>
                    </div>
                </form>
            </div>
            <%--模板创建--%>

            <%--知识点占比--%>
            <div role="tabpanel" class="tab-pane" id="knowlidgeTemp">
                <form id="setTemp2">
                    <table width="550px" id="setKnow">
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
                    <button type="button" class="btn btn-default" onclick="setKnowledge2()">提交</button>
                </form>

            </div>

            <%--知识点占比--%>
            <div role="tabpanel" class="tab-pane" id="settings">


            </div>
        </div>

    </div>

</div>
</div>        <!-- /#wrapper -->

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
    <script type="text/javascript">
        //存储paperTemplet的json字符串
        var paperTemp="";

        //当前模板id
        var current_pt_id;
    function setKnowledge() {
        $.post("<%=basePath%>paperTemplate/createTemp1.do",$("#setTemp1").serialize(),function(data){

        });
    }

    function editTemp(pt_id) {
        $.post("<%=basePath%>paperTemplate/editTemp.do",{"pt_id":pt_id},function(data){
            paperTemp=data;
            $("#edit_courseName").find("option[value = '"+data.course.c_id+"']").attr("selected","selected");
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

    function editKnowledge1(){
        //将修改后的数据提交到服务端
        $.post("<%=basePath%>paperTemplate/createTemp1.do",$("#editTemp1").serialize(),function(data){
        });
        //明天写

        //获取所有知识点模板
        var data=paperTemp.knowledgeTemplets;
            for(var i in data){
                $("#editKnow").append("<tr><td>"+data[i].knowledge.knowledgeName+"</td><td><input name='knowledgeTemplets["+i+"].selectQuesNum' value='"+data[i].selectQuesNum+"'/></td><td><input name='knowledgeTemplets["+i+"].fillBlankQuesNum' value='"+data[i].fillBlankQuesNum+"'/></td><td><input name='knowledgeTemplets["+i+"].judgeQuesNum' value='"+data[i].judgeQuesNum+"'/></td><td><input name='knowledgeTemplets["+i+"].bigQuesNum' value='"+data[i].bigQuesNum+"'/></td></tr>")
                $("#editKnow").append("<input type='hidden' name='knowledgeTemplets["+i+"].kt_id' value='"+data[i].kt_id+"'/>");
            }
            $("#editTemp1Div").hide();
            $("#editTemp2Div").show();
    }

       function updatePaperTemp() {
           $.post("<%=basePath%>paperTemplate/updateTemp",$("#editTemp2").serialize(),function(data){
               alert("模板更新成功！");
               window.location.reload();
           });
       }

    function deleteTemp(pt_id) {
        $.post("<%=basePath%>paperTemplate/delTemp.do",{"pt_id":pt_id},function(data){
            window.location.reload();
        });
    }
    function setKnowledge2() {
        $.post("<%=basePath%>paperTemplate/createTemp2.do",$("#setTemp2").serialize(),function(data){
            alert("模板创建成功！");
            window.location.reload();
        });
    }

        function getPt_id(pt_id){
            current_pt_id=pt_id;
        }


        function createPaper(){
            var paperName=$("#paperName").val();
            var a = document.createElement('a');
            var url = "<%=basePath%>paper/createPaper?paperName='"+paperName+"'&pt_id='"+current_pt_id+"'";
            a.href=url;
            a.click();
        }

    $(document).ready(function(){
        $('#paperEditDialog').modal('show');
    })
</script>
</body>

        </html>
