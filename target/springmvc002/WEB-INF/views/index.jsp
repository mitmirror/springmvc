<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="UTF-8">
    <title>Basic DataGrid - jQuery EasyUI Demo</title>
    <link rel="stylesheet" type="text/css" href="./js/jquery-easyui-1.7.0/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="./js/jquery-easyui-1.7.0/themes/icon.css">
    <script type="text/javascript" src="./js/jquery-easyui-1.7.0/jquery.min.js"></script>
    <script type="text/javascript" src="./js/jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="./js/jquery-easyui-1.7.0/locale/easyui-lang-zh_CN.js"></script>
    <script>
        var url;
        //删除用户
        function deleteUser(){
            var row=$('#dg').datagrid('getSelected');
            if(row){
                $.messager.confirm("系统提示","您确定要删除这条记录吗?",function(r){
                    if(r){
                        $.post('user!delete',{delId:row.id},function(result){
                            if(result.success){
                                $.messager.alert("系统提示","已成功删除这条记录!");
                                $("#dg").datagrid("reload");
                            }else{
                                $.messager.alert("系统提示",result.errorMsg);
                            }
                        },'json');
                    }
                });
            }
        }

        //新建用户
        function newUser(){
            $("#dlg").dialog('open').dialog('setTitle','添加用户');
            $('#fm').form('clear');
            url='staffController.do?saveStaff';
        }
        
        //编辑用户
        function editUser(){
            var row=$('#dg').datagrid('getSelected');
            if(row){
                $("#dlg").dialog('open').dialog('setTitle','编辑用户');
                $("#name").val(row.name);
                $("#phone").val(row.phone);
                $("#email").val(row.email);
                $("#qq").val(row.qq);
                url='user!save?id='+row.id;
            }
        }
        
        //dailog页面保存用户，新建和编辑都用到
        function saveUser(){
            $('#fm').form('submit',{
                url:url,
                onSubmit:function(){
                    return $(this).form('validate');
                },
                success:function(result){
                    var result=eval('('+result+')');
                    if(result.errorMsg){
                        $.messager.alert("系统提示",result.errorMsg);
                        return;
                    }else{
                        $.messager.alert("系统提示","保存成功");
                        $('#dlg').dialog('close');
                        $("#dg").datagrid("reload");
                    }
                }
            });
        }
        
        //批量导入数据，打开dialog
        function openUploadFileDialog(){
            $("#dlg2").dialog('open').dialog('setTitle','批量导入数据');
        }
        
        //下载批量导入模板
        //userExporTemplate.xls位于WebContent/template/下面
        //一个纯的js来下载模板
        function downloadTemplate(){
            window.open('template/userExporTemplate.xls');
        }
        
        //上传Excel文件，交给后台解析
        function uploadFile(){
            $("#uploadForm").form("submit",{
                success:function(result){
                    var result=eval('('+result+')');
                    if(result.errorMsg){
                        $.messager.alert("系统提示",result.errorMsg);
                    }else{
                        $.messager.alert("系统提示","上传成功");
                        $("#dlg2").dialog("close");
                        $("#dg").datagrid("reload");
                    }
                }
            });
        }
    </script>
</head>
<body>
    <!-- table列表 -->
    <table id="dg" title="用户管理" class="easyui-datagrid" style="width:800px;height:365px"
            url="staffController.do?staffList"
            toolbar="#toolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
                <th field="staffId" width="50" >编号</th>
                <th field="staffName" width="50">姓名</th>
                <th field="staffSex" width="50">性别</th>
                <th field="staffAge" width="50">年龄</th>
                <th field="position" width="50">职位</th>
                <th field="staffAddress" width="50">住址</th>
                <th field="staffPhone" width="50">电话</th>
                <th field="password" width="50">密码</th>
            </tr>
        </thead>
    </table>
    <!-- 一排操作按钮 -->
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">添加用户</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">编辑用户</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="deleteUser()">删除用户</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-export" plain="true" onclick="exportUser()">导出用户</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-export" plain="true" onclick="exportUser2()">用模版导出用户</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-import" plain="true" onclick="openUploadFileDialog()">用模版批量导入数据</a>
    </div>
    
    <!-- 新建、编辑用户的dialog -->
    <div id="dlg" class="easyui-dialog" style="width:400px;height:250px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons">
        <form id="fm"  method="post">
            <table cellspacing="10px;">
                <tr>
                    <td>姓名：</td>
                    <td><input id="name"  name="staffName" class="easyui-validatebox" required="true" style="width: 200px;"></td>
                </tr>
                <tr>
                    <td>ID：</td>
                    <td><input id="id"  name="staffId" class="easyui-validatebox" required="true" style="width: 200px;"></td>
                </tr>
                <tr>
                    <td>Password：</td>
                    <td><input id="password"  name="password" class="easyui-validatebox" required="true" style="width: 200px;"></td>
                </tr>
                <tr>
                    <td>性别：</td>
                    <td><input id="sex" name="staffSex" class="easyui-validatebox" required="true" style="width: 200px;"></td>
                </tr>
                <tr>
                    <td>年龄：</td>
                    <td><input id="age" name="staffAge" class="easyui-validatebox" required="true" style="width: 200px;"></td>
                </tr>
                <tr>
                    <td>职位：</td>
                    <td><input id="position" name="position" class="easyui-validatebox" required="true" style="width: 200px;"></td>
                </tr>
                <tr>
                    <td>住址：</td>
                    <td><input id="address" name="staffAddress" class="easyui-validatebox" required="true" style="width: 200px;"></td>
                </tr>
                <tr>
                    <td>电话：</td>
                    <td><input id="limit" name="staffphone" class="easyui-validatebox" required="true" style="width: 200px;"></td>
                </tr>
            </table>
        </form>
    </div>
    
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveUser()">保存</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">关闭</a>
    </div>
    
    <!-- 批量导入数据模板Excel 的dialog -->
    <div id="dlg2" class="easyui-dialog" style="width:400px;height:180px;padding:10px 20px"
            closed="true" buttons="#dlg-buttons2">
        <form id="uploadForm" action="user!upload" method="post" enctype="multipart/form-data">
            <table>
                <tr>
                    <td>下载模版：</td>
                    <td><a href="javascript:void(0)" class="easyui-linkbutton"  onclick="downloadTemplate()">导入模版</a></td>
                </tr>
                <tr>
                    <td>上传文件：</td>
                    <td><input type="file" name="userUploadFile"></td>
                </tr>
            </table>
        </form>
    </div>
    
    <div id="dlg-buttons2">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="uploadFile()">上传</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg2').dialog('close')">关闭</a>
    </div>
</body>
</html>