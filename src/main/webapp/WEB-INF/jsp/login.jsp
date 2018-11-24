<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/9/11
  Time: 14:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <meta http-equiv=Content-Type content="text/html; charset=utf-8">
    <link href="${pageContext.request.contextPath}/css/style.css"
          type=text/css rel=stylesheet>
    <link href="${pageContext.request.contextPath}/css/boot-crm.css"
          type=text/css rel=stylesheet>

    <script src="${pageContext.request.contextPath}/js/jquery-1.11.3.min.js">
    </script>
    <meta content="MSHTML 6.00.2600.0" name=GENERATOR>
    <script>
        // 判断是登录账号和密码是否为空
        $().ready(function(){
            //页面DOM载入完成后执行

            //登录表单的submit事件
            $("#frmLogin").on("submit",function(){
                var usercode = $("#usercode").val();
                var password = $("#password").val();

                if(usercode==""||password==""){
                    $("#message").text("账号或密码不能为空！");
                    return false;
                }else{
                    return true;
                }
            });
        });
    </script>
</head>
<body leftMargin=0 topMargin=0 marginwidth="0" marginheight="0"
      background="${pageContext.request.contextPath}/images/rightbg.jpg">
<div ALIGN="center">
    <table border="0" width="1140px" cellspacing="0" cellpadding="0"
           id="table1">
        <tr>
            <td height="93"></td>
            <td></td>
        </tr>
        <tr>
            <td width="740" height="412">
            </td>
            <td class="login_msg" width="400" align="center">
                <!-- margin:0px auto; 控制当前标签居中 -->
                <fieldset style="width: auto; margin: 0px auto;">
                    <legend>
                        <font style="font-size:15px" face="宋体">
                            欢迎使用BOOT客户管理系统
                        </font>
                    </legend>
                    <font color="red">
                        <%-- 提示信息--%>
                        <span id="message">${msg}</span>
                    </font>
                    <%-- 提交后的位置：/WEB-INF/jsp/customer.jsp--%>
                    <form id="frmLogin" action="${pageContext.request.contextPath }/login.action" method="post">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<br /><br />
                        账&nbsp;号：<input id="usercode" type="text" name="usercode" />
                        <br /><br />
                        密&nbsp;码：<input id="password" type="password" name="password" />
                        <br /><br />
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                        <center><input type="submit" value="登录" /></center>
                    </form>
                </fieldset>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
