<%@ page contentType="text/html;charset=gbk" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
  <head>
    <title>�û���¼</title> 
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
   { alert("�û�������Ϊ�գ�");
      document.loginForm.usename.focus();
     return (false);
   }
    if (document.loginForm.password.value=="")
   { alert("���벻��Ϊ�գ�");
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
<!--�������ݿ�ʼ,���Ĵ��벿��-->
  	<form name="loginForm" method="post" onsubmit=" return check()" action="<%=request.getContextPath()%>/servlet/Login">
  	 <%
  	String loginmsg = request.getParameter("loginmsg") ;
if(loginmsg != null && loginmsg.equals("userwrong")){
	out.print("�û������������") ;}
else if(loginmsg != null && loginmsg.equals("loginfirst"))
	out.print("���ȵ�¼��") ;
else if(loginmsg != null && loginmsg.equals("logout"))
	out.print("�Ѿ��ɹ��˳�ϵͳ��") ;
else if(loginmsg != null && loginmsg.equals("nostatus"))
	out.print("����û�м�����˺ţ����߸��˺Ż�δ����ˣ�����ϵ����Ա��");
%>
    <table width="50%"  border="0" align="center" cellpadding="0" cellspacing="0">
      <caption>
      <span class="style1">      �� ¼      </span><br/>
      </caption>
      <tr align="left">
        <th width="40%" height="35" align="center" scope="row">�û���:</th>
        <td width="60%"><input name="usename" type="text" id="usename" maxlength="20"/></td>
      </tr>
      <tr align="left">
        <th height="35" align="center" scope="row">��&nbsp;&nbsp;��:</th>
        <td><input name="password" type="password" id="password" maxlength="30"/></td>
      </tr>
      <tr align="center">
        <th height="35" colspan="2" scope="row"><input type="submit" name="Submit" value="��¼"/>
        <input type="button" name="Submit2" value="ע��" onclick="javascript:window.location='userRegister.jsp'"/> </th>
      </tr>
    </table>
    </form>
    
 		</div>
<!--�������ݹر�-->
	 <%@include file="../public/bottom.jsp"%>
	 </div>
	 
<!--body�ر�-->
</div>
  </body>
</html>
