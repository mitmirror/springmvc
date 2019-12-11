<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Person Manager</title>





<!-- 引入jquery-->
<script type="text/javascript" src="./js/jquery-easyui-1.7.0/jquery.min.js"></script>
   <!-- 引入EasyUI -->
  <script type="text/javascript" src="./js/jquery-easyui-1.7.0/jquery.easyui.min.js"></script>
  <!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->
  <script type="text/javascript" src="./js/jquery-easyui-1.7.0/locale/easyui-lang-zh_CN.js"></script>
 <!-- 引入EasyUI的样式文件-->
  <link rel="stylesheet" href="./js/jquery-easyui-1.7.0/themes/default/easyui.css" type="text/css"/>
  <!-- 引入EasyUI的图标样式文件-->
   <link rel="stylesheet" href="./js/jquery-easyui-1.7.0/themes/icon.css" type="text/css"/>
  
</head>
<body>
  
    
    <table id="dg" title="用户信息" class="easyui-datagrid" style="width:100%;height:950px"
          url="staffController.do?staffList"
            toolbar="#toolbar" pagination="true"
            rownumbers="true" fitColumns="true" singleSelect="true">
        <thead>
            <tr>
                <th field="staffId" width="50">编号</th>
                <th field="staffName" width="50">姓名</th>
                <th field="staffAge" width="50">年龄</th>
                <th field="staffSex" width="50">性别</th>
                <th field="staffAddress" width="50">住址</th>
                <th field="staffPhone" width="50">电话</th>
                <th field="position" width="50">职位</th>
              
            </tr>
        </thead>
    </table>
    <div id="toolbar">
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newUser()">新增用户</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editUser()">修改用户</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyUser()">删除用户</a>
    </div>
    
    <div id="dlg" class="easyui-dialog" style="width:400px" data-options="closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'">
        <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
            <h3>用户信息</h3>
            <div style="margin-bottom:10px">
          		<input name="staffId" id="staffId" class="text"  type="hidden"  label="id" style="width:o"  disabled="true" > 
            </div>
            <div style="margin-bottom:10px">
                <input name="staffName" class="easyui-textbox" required="true" label="name" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="staffAge" id="staffAge"   class="easyui-numberbox" required="true" label="age" style="width:100%" />
            </div>
            <div style="margin-bottom:10px">
                <select name="staffSex" id="staffSex" class="easyui-combobox" required="true" label="sex" style="width:100%" data-options="editable:false,panelHeight:'auto'">
                	<option value="男">男</option>
                	<option value="女">女</option>
                </select>
            </div>
            <div style="margin-bottom:10px">
                <input name="staffAddress" class="easyui-textbox" required="true" label="address" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <input name="staffPhone" id="staffPhone" class="easyui-textbox" required="true" label="phone" style="width:100%">
            </div>
            <div style="margin-bottom:10px">
                <select name="position" class="easyui-combobox" required="true" label="position" style="width:100%" data-options="editable:false,panelHeight:'auto'">
                	<option value="普通员工">普通员工</option>
                	<option value="技术员工">技术员工</option>
                	<option value="管理人员">管理人员</option>
                </select>
            </div>
            
        </form>
    </div>
    <div id="dlg-buttons">
        <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveUser()" style="width:90px">Save</a>
        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
    </div>
    <script type="text/javascript">
        var url;
        function newUser(){
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','New User');
            $('#fm').form('clear');
            url='staffController.do?saveStaff';
            								//personController.do?add
        }
        
        
        function editUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $('#dlg').dialog('open').dialog('center').dialog('setTitle','Edit User');
                $('#fm').form('load',row);
       
                url='staffController.do?updateStaff';
            }
        }
        
        
        function saveUser(){
        	
        	$("input[name=staffId]").attr("disabled",false);
        	
        	//验证年龄输入
        	var ageVerify=document.getElementById("staffAge").value;
        	if(/\D/.test(ageVerify)){
        	     alert("年龄只能输入数字！");
	       	     return;
        	 }else if(ageVerify>100){
        		 alert("年龄输入违法");
        		 return;
        	 }
        	
        	//验证手机号输入
        	var phoneVerify= /(^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$)|(^(([0\+]\d{2,3})?(0\d{2,3}))(\d{7,8})((\d{3,}))?$)|(^0{0,1}1[3|4|5|6|7|8|9][0-9]{9}$)/;
        	var phoneNum=document.getElementById("staffPhone").value;
        	if($("#staffPhone").val()==""){
        		alert("请输入手机号");
        		return;
        	}
        	else if(!phoneVerify.test(phoneNum)){
        		alert("请输入正确的手机号");
        		return;
        	}
        	
        	
        	$('#fm').form('submit',{
                url: url,
                onSubmit: function(){
                    return $(this).form('validate');
                },
                success: function(result){
                    var result = eval('('+result+')');
                    if (result.errorMsg){
                        $.messager.show({
                            title: 'Error',
                            msg: result.errorMsg
                        });
                    } else {
                        $('#dlg').dialog('close');        // close the dialog
                        $('#dg').datagrid('reload');    // reload the user data
                    }
                }
            });
        }
    
        
        function destroyUser(){
            var row = $('#dg').datagrid('getSelected');
            if (row){
                $.messager.confirm('确认','确定删除吗吗？',function(r){
                    if (r){
                        $.post('staffController.do?deleteStaff',{id:row.staffId},function(result){
                            if (result.success){
                                $('#dg').datagrid('reload');    // reload the user data
                            } else {
                                $.messager.show({    // show error message
                                    title: 'Error',
                                    msg: result.errorMsg
                                });
                            }
                        },'json');
                    }
                });
            }
        }
    </script>
</body>
</html>