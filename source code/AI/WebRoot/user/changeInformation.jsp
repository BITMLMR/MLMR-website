<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<%@ include file="../public/meta.jsp"%>
<%@ include file="../public/check.jsp"%>
<%@ page import="AI.vo.User" %>
<%@ page import="AI.service.UserService" %>
<%@ page import="java.util.*"%>
<%
	UserService service=new UserService();
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	service.getUser(usename);
	User user= service.getUser(usename);
%>

 <script language="JavaScript">
  function check()
{
   if (document.form1.email.value=="")
   { alert("������email��");
      document.form1.email.focus();
     return (false);
   }
   return (true);
}
 </script> 

<div id="pagecell1">
		<div id="main">
<!--�������ݿ�ʼ,���Ĵ��벿��-->
<form name="form1" action='<%=request.getContextPath()%>/servlet/ModifyUserInfo' method="post" onsubmit=" return check()">
<table align='center'>
	<tr>
	<td align="center" width="100%" colspan="2">
		<b>��Ա��<%=user.getUsename() %></b>
		<input type='hidden' name='usename' value="<%=user.getUsename() %>">
	</td>
	</tr>
	<tr>
		<td height=20 width="40%" align=right>�ǳƣ�</td>
		<td width="60%" align=left><input type='text' name='realName'" value="<%=user.getNickname()%>"></td>
	</tr>
	<tr>
		<td height=20 width="40%" align=right>��ݣ�</td>
		<td><p> <label><%if(user.getGender()=="0"||user.getGender().equals("0")){ %> ������<%} %></label>
        <label><%if(user.getGender()=="1"||user.getGender().equals("1")){ %> �о���<%} %></label>
        <label><%if(user.getGender()=="2"||user.getGender().equals("2")){ %> ��ʦ<%} %></label>
        <label><%if(user.getGender()=="9"||user.getGender().equals("9")){ %> ��������Ա<%} %></label><br>
    </p></td>
    <td>&nbsp;</td>
	</tr>	
	<tr>
		<td height=20 width="40%" align=right>Email��</td>
		<td width="60%" align=left><input type='text' name='email'" value="<%=user.getEmail() %>"></td>
	</tr>
	<tr>
    	<td colspan="2" align="center">
      <input type="submit" name="Submit" value="�ύ"/>
      <input type="reset" name="Submit2" value="ȡ��"/>
		</td>
  	</tr>	
</table>
</form>
		</div>
</div>
