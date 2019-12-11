package org.apache.jsp.WEB_002dINF.views;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.AnnotationProcessor _jsp_annotationprocessor;

  public Object getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_annotationprocessor = (org.apache.AnnotationProcessor) getServletConfig().getServletContext().getAttribute(org.apache.AnnotationProcessor.class.getName());
  }

  public void _jspDestroy() {
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n");
      out.write("<title>Person Manager</title>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- 引入jquery-->\r\n");
      out.write("<script type=\"text/javascript\" src=\"./js/jquery-easyui-1.7.0/jquery.min.js\"></script>\r\n");
      out.write("   <!-- 引入EasyUI -->\r\n");
      out.write("  <script type=\"text/javascript\" src=\"./js/jquery-easyui-1.7.0/jquery.easyui.min.js\"></script>\r\n");
      out.write("  <!-- 引入EasyUI的中文国际化js，让EasyUI支持中文 -->\r\n");
      out.write("  <script type=\"text/javascript\" src=\"./js/jquery-easyui-1.7.0/locale/easyui-lang-zh_CN.js\"></script>\r\n");
      out.write(" <!-- 引入EasyUI的样式文件-->\r\n");
      out.write("  <link rel=\"stylesheet\" href=\"./js/jquery-easyui-1.7.0/themes/default/easyui.css\" type=\"text/css\"/>\r\n");
      out.write("  <!-- 引入EasyUI的图标样式文件-->\r\n");
      out.write("   <link rel=\"stylesheet\" href=\"./js/jquery-easyui-1.7.0/themes/icon.css\" type=\"text/css\"/>\r\n");
      out.write("  \r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("  \r\n");
      out.write("    \r\n");
      out.write("    <table id=\"dg\" title=\"用户信息\" class=\"easyui-datagrid\" style=\"width:100%;height:950px\"\r\n");
      out.write("          url=\"staffController.do?staffList\"\r\n");
      out.write("            toolbar=\"#toolbar\" pagination=\"true\"\r\n");
      out.write("            rownumbers=\"true\" fitColumns=\"true\" singleSelect=\"true\">\r\n");
      out.write("        <thead>\r\n");
      out.write("            <tr>\r\n");
      out.write("                <th field=\"staffId\" width=\"50\">编号</th>\r\n");
      out.write("                <th field=\"staffName\" width=\"50\">姓名</th>\r\n");
      out.write("                <th field=\"staffAge\" width=\"50\">年龄</th>\r\n");
      out.write("                <th field=\"staffSex\" width=\"50\">性别</th>\r\n");
      out.write("                <th field=\"staffAddress\" width=\"50\">住址</th>\r\n");
      out.write("                <th field=\"staffPhone\" width=\"50\">电话</th>\r\n");
      out.write("                <th field=\"position\" width=\"50\">职位</th>\r\n");
      out.write("              \r\n");
      out.write("            </tr>\r\n");
      out.write("        </thead>\r\n");
      out.write("    </table>\r\n");
      out.write("    <div id=\"toolbar\">\r\n");
      out.write("        <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" iconCls=\"icon-add\" plain=\"true\" onclick=\"newUser()\">新增用户</a>\r\n");
      out.write("        <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" iconCls=\"icon-edit\" plain=\"true\" onclick=\"editUser()\">修改用户</a>\r\n");
      out.write("        <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" iconCls=\"icon-remove\" plain=\"true\" onclick=\"destroyUser()\">删除用户</a>\r\n");
      out.write("    </div>\r\n");
      out.write("    \r\n");
      out.write("    <div id=\"dlg\" class=\"easyui-dialog\" style=\"width:400px\" data-options=\"closed:true,modal:true,border:'thin',buttons:'#dlg-buttons'\">\r\n");
      out.write("        <form id=\"fm\" method=\"post\" novalidate style=\"margin:0;padding:20px 50px\">\r\n");
      out.write("            <h3>用户信息</h3>\r\n");
      out.write("            <div style=\"margin-bottom:10px\">\r\n");
      out.write("          \t\t<input name=\"staffId\" id=\"staffId\" class=\"text\"  type=\"hidden\"  label=\"id\" style=\"width:o\"  disabled=\"true\" > \r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"margin-bottom:10px\">\r\n");
      out.write("                <input name=\"staffName\" class=\"easyui-textbox\" required=\"true\" label=\"name\" style=\"width:100%\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"margin-bottom:10px\">\r\n");
      out.write("                <input name=\"staffAge\" id=\"staffAge\"   class=\"easyui-numberbox\" required=\"true\" label=\"age\" style=\"width:100%\" />\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"margin-bottom:10px\">\r\n");
      out.write("                <select name=\"staffSex\" id=\"staffSex\" class=\"easyui-combobox\" required=\"true\" label=\"sex\" style=\"width:100%\" data-options=\"editable:false,panelHeight:'auto'\">\r\n");
      out.write("                \t<option value=\"男\">男</option>\r\n");
      out.write("                \t<option value=\"女\">女</option>\r\n");
      out.write("                </select>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"margin-bottom:10px\">\r\n");
      out.write("                <input name=\"staffAddress\" class=\"easyui-textbox\" required=\"true\" label=\"address\" style=\"width:100%\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"margin-bottom:10px\">\r\n");
      out.write("                <input name=\"staffPhone\" id=\"staffPhone\" class=\"easyui-textbox\" required=\"true\" label=\"phone\" style=\"width:100%\">\r\n");
      out.write("            </div>\r\n");
      out.write("            <div style=\"margin-bottom:10px\">\r\n");
      out.write("                <select name=\"position\" class=\"easyui-combobox\" required=\"true\" label=\"position\" style=\"width:100%\" data-options=\"editable:false,panelHeight:'auto'\">\r\n");
      out.write("                \t<option value=\"普通员工\">普通员工</option>\r\n");
      out.write("                \t<option value=\"技术员工\">技术员工</option>\r\n");
      out.write("                \t<option value=\"管理人员\">管理人员</option>\r\n");
      out.write("                </select>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    <div id=\"dlg-buttons\">\r\n");
      out.write("        <a href=\"javascript:void(0)\" class=\"easyui-linkbutton c6\" iconCls=\"icon-ok\" onclick=\"saveUser()\" style=\"width:90px\">Save</a>\r\n");
      out.write("        <a href=\"javascript:void(0)\" class=\"easyui-linkbutton\" iconCls=\"icon-cancel\" onclick=\"javascript:$('#dlg').dialog('close')\" style=\"width:90px\">Cancel</a>\r\n");
      out.write("    </div>\r\n");
      out.write("    <script type=\"text/javascript\">\r\n");
      out.write("        var url;\r\n");
      out.write("        function newUser(){\r\n");
      out.write("            $('#dlg').dialog('open').dialog('center').dialog('setTitle','New User');\r\n");
      out.write("            $('#fm').form('clear');\r\n");
      out.write("            url='staffController.do?saveStaff';\r\n");
      out.write("            \t\t\t\t\t\t\t\t//personController.do?add\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        function editUser(){\r\n");
      out.write("            var row = $('#dg').datagrid('getSelected');\r\n");
      out.write("            if (row){\r\n");
      out.write("                $('#dlg').dialog('open').dialog('center').dialog('setTitle','Edit User');\r\n");
      out.write("                $('#fm').form('load',row);\r\n");
      out.write("       \r\n");
      out.write("                url='staffController.do?updateStaff';\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        function saveUser(){\r\n");
      out.write("        \t\r\n");
      out.write("        \t$(\"input[name=staffId]\").attr(\"disabled\",false);\r\n");
      out.write("        \t\r\n");
      out.write("        \t//验证年龄输入\r\n");
      out.write("        \tvar ageVerify=document.getElementById(\"staffAge\").value;\r\n");
      out.write("        \tif(/\\D/.test(ageVerify)){\r\n");
      out.write("        \t     alert(\"年龄只能输入数字！\");\r\n");
      out.write("\t       \t     return;\r\n");
      out.write("        \t }else if(ageVerify>100){\r\n");
      out.write("        \t\t alert(\"年龄输入违法\");\r\n");
      out.write("        \t\t return;\r\n");
      out.write("        \t }\r\n");
      out.write("        \t\r\n");
      out.write("        \t//验证手机号输入\r\n");
      out.write("        \tvar phoneVerify= /(^(([0\\+]\\d{2,3}-)?(0\\d{2,3})-)(\\d{7,8})(-(\\d{3,}))?$)|(^(([0\\+]\\d{2,3})?(0\\d{2,3}))(\\d{7,8})((\\d{3,}))?$)|(^0{0,1}1[3|4|5|6|7|8|9][0-9]{9}$)/;\r\n");
      out.write("        \tvar phoneNum=document.getElementById(\"staffPhone\").value;\r\n");
      out.write("        \tif($(\"#staffPhone\").val()==\"\"){\r\n");
      out.write("        \t\talert(\"请输入手机号\");\r\n");
      out.write("        \t\treturn;\r\n");
      out.write("        \t}\r\n");
      out.write("        \telse if(!phoneVerify.test(phoneNum)){\r\n");
      out.write("        \t\talert(\"请输入正确的手机号\");\r\n");
      out.write("        \t\treturn;\r\n");
      out.write("        \t}\r\n");
      out.write("        \t\r\n");
      out.write("        \t\r\n");
      out.write("        \t$('#fm').form('submit',{\r\n");
      out.write("                url: url,\r\n");
      out.write("                onSubmit: function(){\r\n");
      out.write("                    return $(this).form('validate');\r\n");
      out.write("                },\r\n");
      out.write("                success: function(result){\r\n");
      out.write("                    var result = eval('('+result+')');\r\n");
      out.write("                    if (result.errorMsg){\r\n");
      out.write("                        $.messager.show({\r\n");
      out.write("                            title: 'Error',\r\n");
      out.write("                            msg: result.errorMsg\r\n");
      out.write("                        });\r\n");
      out.write("                    } else {\r\n");
      out.write("                        $('#dlg').dialog('close');        // close the dialog\r\n");
      out.write("                        $('#dg').datagrid('reload');    // reload the user data\r\n");
      out.write("                    }\r\n");
      out.write("                }\r\n");
      out.write("            });\r\n");
      out.write("        }\r\n");
      out.write("    \r\n");
      out.write("        \r\n");
      out.write("        function destroyUser(){\r\n");
      out.write("            var row = $('#dg').datagrid('getSelected');\r\n");
      out.write("            if (row){\r\n");
      out.write("                $.messager.confirm('确认','确定删除吗吗？',function(r){\r\n");
      out.write("                    if (r){\r\n");
      out.write("                        $.post('staffController.do?deleteStaff',{id:row.staffId},function(result){\r\n");
      out.write("                            if (result.success){\r\n");
      out.write("                                $('#dg').datagrid('reload');    // reload the user data\r\n");
      out.write("                            } else {\r\n");
      out.write("                                $.messager.show({    // show error message\r\n");
      out.write("                                    title: 'Error',\r\n");
      out.write("                                    msg: result.errorMsg\r\n");
      out.write("                                });\r\n");
      out.write("                            }\r\n");
      out.write("                        },'json');\r\n");
      out.write("                    }\r\n");
      out.write("                });\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
