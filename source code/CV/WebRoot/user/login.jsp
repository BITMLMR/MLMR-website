<%@ page contentType="text/html;charset=gbk" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>用户登录</title> 
    <%@ include file="../public/meta.jsp"%>
    <style type="text/css">
<!--
.style1 {color: #0000CC;font-size: 16px;font-weight: bold;}
-->
    </style>
 <script language="JavaScript">
  function check()
{
   if(document.loginForm.usename.value=="")
   { alert("用户名不得为空！");
      document.loginForm.usename.focus();
     return (false);
   }
    if (document.loginForm.password.value=="")
   { alert("密码不得为空！");
      document.loginForm.password.focus();
     return (false);
   }
   return (true);
}
  </script>
  </head>  
  <body>
  <div class="bodymain">
<br />
	<%@include file="../public/top.jsp"%>
		<div id="pagecell1">
		<div id="main">
<!--主题内容开始,您的代码部分-->
  	<form name="loginForm" method="post" onsubmit=" return check()" action="<%=request.getContextPath()%>/servlet/Login">
  	 <%
  	String loginmsg = request.getParameter("loginmsg") ;
if(loginmsg != null && loginmsg.equals("userwrong")){
	out.print("用户名或密码错误！") ;}
else if(loginmsg != null && loginmsg.equals("loginfirst"))
	out.print("请先登录！") ;
else if(loginmsg != null && loginmsg.equals("logout"))
	out.print("已经成功退出系统！") ;
else if(loginmsg != null && loginmsg.equals("nostatus"))
	out.print("您还没有激活该账号，或者该账号还未被审核，请联系管理员！");
%>
    <table width="50%"  border="0" align="center" cellpadding="0" cellspacing="0">
      <caption>
      <span class="style1">      登 录      </span><br/>
      </caption>
      <tr align="left">
        <th width="40%" height="35" align="center" scope="row">用户名:</th>
        <td width="60%"><input name="usename" type="text" id="usename" maxlength="20"/></td>
      </tr>
      <tr align="left">
        <th height="35" align="center" scope="row">密&nbsp;&nbsp;码:</th>
        <td><input name="password" type="password" id="password" maxlength="30"/></td>
      </tr>
      <tr align="center">
        <th height="35" colspan="2" scope="row"><input type="submit" name="Submit" value="登录"/>
        <input type="button" name="Submit2" value="注册" onclick="javascript:window.location='userRegister.jsp'"/> </th>
      </tr>
    </table>
    </form>
    
 		</div>
<!--主题内容关闭-->
	 <%@include file="../public/bottom.jsp"%>
	 </div>
	 
<!--body关闭-->
</div>
  </body>
</html>
