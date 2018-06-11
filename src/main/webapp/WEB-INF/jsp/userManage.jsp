<%--
  Created by IntelliJ IDEA.
  User: Xiaoliu
  Date: 2018/6/1
  Time: 20:02
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户管理</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<script>
    $(document).ready(function () {
        const $table = $('#table-users');
        const $form = $('#form');
        $table.bootstrapTable({
            columns: [
                {
                    field: 'u_id',
                    title: 'id'
                },
                {
                    field: 'userName',
                    title: '用户名'
                },
                {
                    field: 'roleName',
                    title: '用户角色'
                },
                {
                    field: 'note',
                    title: '备注'
                },
                {
                    field: 'update',
                    title: '更改信息',
                    formatter: updateUserInfoFormatter
                },
                {
                    field: 'del',
                    title: '删除用户',
                    formatter: delUserFormatter
                }
            ],
            striped: true,
            pagination: true,
            sidePagination: 'client',
            pageSize: 10,
            pageList: [10, 20, 50],
            pageNumber: 1,
            method: 'get',
            url: "${pageContext.request.contextPath}/user/man/getAllUser",
            sortName: 'u_id',
            sortOrder: 'asc',
            onLoadError: function () {
                alert("用户列表加载数据失败, 请刷新!");
            },
            onLoadSuccess: function () {
                console.info("用户列表加载成功!");
            },
            height: getHeight()
        });

        $(window).resize(function () {
            $table.bootstrapTable('resetView', {
                height: getHeight()
            });
        });

        $.fn.bootstrapValidator.DEFAULT_OPTIONS = $.extend({},$.fn.bootstrapValidator.DEFAULT_OPTIONS, {
                excluded: [':disabled', ':hidden', ':not(:visible)'],
                live: 'enabled',
                submitButtons: 'button[id="submit"]',
                message: '输入值不合法',
                feedbackIcons: {
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
            });

        $('#modal-user').on('show.bs.modal', function (event) {
            const btn = $(event.relatedTarget);
            const act = btn.data('act');
            const btn_submit = $('#submit');
            if (act === 'add') {
                $('#modal-title').text('添加用户');
                $('#password-label').attr('placeholder', '请输入密码');
                AddformValidator();
                btn_submit.unbind();
                btn_submit.click(function () {
                    addUser();
                })
            } else if (act === 'update') {
                $('#modal-title').text('更新用户信息');
                $('#password-label').attr('placeholder', '无需更改请留空');
                $('#password-label').val('');
                UpdateformValidator();
                const userName = btn.data('name');
                const u_id = btn.data('uid');
                const r_id = btn.data('rid');
                const note = btn.data('note');
                $('#user-name-label').val(userName);
                $('#uid').val(u_id);
                $('#note').val(note);
                if (r_id === 1)
                    $('#role-teacher').attr('checked', true);
                else
                    $('#role-manager').attr('checked', true);
                btn_submit.unbind();
                $('#submit').click(function () {
                    updateUser();
                })
            }
        });

        $('#modal-user').on('hidden.bs.modal', function () {
            $form.data('bootstrapValidator').destroy();
            $('#reset').trigger('click');
        })
    });

    function AddformValidator() {
        const $form = $('#form');
        $form.bootstrapValidator({
            fields: {
                userName: {
                    message: '用户名不合法',
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        },
                        stringLength: {
                            min: 2,
                            max: 30,
                            message: '请输入2到30个字符'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_\. \u4e00-\u9fa5 @]+$/,
                            message: '用户名只能由字母、数字、点、下划线、@和汉字组成'
                        }
                    }
                },
                r_id: {
                    feedbackIcons: false,
                    validators: {
                        notEmpty: {
                            message: '必须选择一个角色'
                        }
                    }
                },
                password:{
                    notEmpty:{
                        message: '密码不能为空'
                    },
                    stringLength:{
                        min:6,
                        max:32,
                        message: '密码长度为6-32位'
                    }
                },
                note:{
                    stringLength:{
                        min:0,
                        max:255,
                        message: '备注信息最多为255个字符'
                    }
                }
            }
        });
    }
    function UpdateformValidator() {
        const $form = $('#form');
        $form.bootstrapValidator({
            fields: {
                userName: {
                    message: '用户名不合法',
                    validators: {
                        notEmpty: {
                            message: '用户名不能为空'
                        },
                        stringLength: {
                            min: 2,
                            max: 30,
                            message: '请输入2到30个字符'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_\. \u4e00-\u9fa5 @]+$/,
                            message: '用户名只能由字母、数字、点、下划线、@和汉字组成'
                        }
                    }
                },
                r_id: {
                    feedbackIcons: false,
                    validators: {
                        notEmpty: {
                            message: '必须选择一个角色'
                        }
                    }
                },
                note:{
                    stringLength:{
                        min:0,
                        max:255,
                        message: '备注信息最多为255个字符'
                    }
                }
            }
        });
    }

    function refreshTable() {
        console.log("刷新数据");
        $('#table-users').bootstrapTable('refresh');
    }

    function updateUserInfoFormatter(value, row, index) {
        return [
            '<a href="#"><button class="btn" data-toggle="modal" data-act="update" data-target="#modal-user" data-name="',
            row.userName,
            '" data-uid="',
            row.u_id,
            '" data-rid="',
            row.r_id,
            '" data-note="',
            row.note,
            '"> <span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></button></a>'
        ].join('');
    }

    function delUserFormatter(value, row, index) {
        return '<a href="#"><button class="btn" onclick="delUser(this)" data-uid="'+row.u_id
            +'"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></button></a>';
    }

    function updateUser() {
        const $form = $('#form');
        let bv = $form.data('bootstrapValidator').validate();
        if (bv.isValid()) {
            let formjson = JSON.stringify($form.serializeJSON());
            console.log(formjson);
            $.ajax({
                contentType:'application/json',
                dataType: 'json',
                type:'post',
                url:"${pageContext.request.contextPath}/user/man/updateUser",
                data:formjson,
                success:function (data) {
                    if (data['code'] === 0) {
                        alert(data['msg']);
                        refreshTable();
                    }else {
                        alert(data['error'])
                    }
                },
                error:function () {
                    alert('请求失败!')
                }
            });
            $('#modal-user').modal('hide');
        }
    }

    function addUser() {
        const $form = $('#form');
        let bv = $form.data('bootstrapValidator').validate();
        if (bv.isValid()) {
            let formJson = JSON.stringify($form.serializeJSON());
            console.log(formJson);
            $.ajax({
                contentType:'application/json',
                dataType: 'json',
                type:'POST',
                url:"${pageContext.request.contextPath}/user/man/addUser",
                data:formJson,
                success:function (data) {
                    if (data['code'] === 0) {
                        alert(data['msg']);
                        refreshTable();
                    }else {
                        alert(data['error'])
                    }
                },
                error:function () {
                    alert('请求失败!')
                }
            });
            $('#modal-user').modal('hide');
        }
    }

    function delUser(btn) {
        let uid = $(btn).data('uid');
        $.ajax({
            type: 'post',
            url:"${pageContext.request.contextPath}/user/man/delUserByUID",
            data:{u_id: uid},
            success:function (data) {
                if (data['code'] === 0) {
                    alert(data['msg']);
                    refreshTable();
                } else {
                    alert(data['error'])
                }
            },
            error:function () {
                alert('请求失败!')
            }
        });
    }

    function getHeight() {
        return $(window).height() - 100;
    }

    function trim(ele) {
        let name = ele.value;
        ele.value = name.replace(/\s/g, "");
    }
</script>
<div class="body">
    <jsp:include page="showMsg.jsp"/>
    <div class="table-responsive">
        <div id="toolbar">
            <button class="btn btn-primary"
                    data-toggle="modal"
                    data-target="#modal-user"
                    data-act="add">
                添加用户
            </button>
        </div>
        <table class="table"
               id="table-users"
               data-toolbar="#toolbar"
               data-search="true"
               data-show-refresh="true"
               data-show-columns="true">
        </table>
    </div>
</div>
<div class="modal fade" id="modal-user" tabindex="-1" role="dialog" aria-labelledby="model-title"
     aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
                <form id="form">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                        &times;
                    </button>
                    <h4 class="modal-title" id="modal-title">
                        添加用户
                    </h4>
                </div>
                <div class="modal-body">
                    <input type="hidden" id="uid" name="u_id" value="1">
                    <div class="form-group" id="username">
                        <label for="user-name-label">用户名</label>
                        <input type="text" class="form-control" id="user-name-label" name="userName" placeholder="用户名"
                               onchange="trim(this)" required value="">
                        <span id="help1" class="help-block"></span>
                    </div>
                    <div class="form-group" id="password">
                        <label for="password-label">密码</label>
                        <input type="password" id="password-label" class="form-control" name="password"
                               placeholder="请输入密码" value="">
                    </div>
                    <div class="form-group">
                        <label for="role-radio">角色</label>
                        <div id="role-radio" class="form-control">
                            <label class="radio-inline">
                                <input type="radio" value="2" id="role-manager" name="r_id"> 管理员
                            </label>
                            <label class="radio-inline">
                                <input type="radio" value="1" id="role-teacher" name="r_id"> 老师
                            </label>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="note">备注</label>
                        <textarea name="note" id="note" class="form-control" maxlength="255"></textarea>
                    </div>
                </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                        <button type="reset" id="reset" class="btn btn-danger">重置</button>
                        <button type="submit" id="submit" class="btn btn-primary">提交</button>
                    </div>
                </form>
        </div>
    </div>
</div>
</body>
</html>
