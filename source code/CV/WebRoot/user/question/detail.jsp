<%@page contentType="text/html; charset=gb2312" language="java" %>
<%@include file="../../public/check.jsp"%>
<%@page import="CV.service.MessageService"%>
<%@page import="CV.dao.impl.*"%>
<%@page import="CV.vo.*"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
  	<title>���⼰�ظ�</title>
 </head>
 
<%
	Integer mid=Integer.valueOf(request.getParameter("mid"));
	MessageService service = new MessageService();
	service.setMessageDAO(new MessageDAOImpl());
	Message mess = service.getMessage(mid.intValue());
%>

<body leftmargin="40" bgcolor="#FAFAFA">
<table  align="center"  border=0 width="90%" height="80%" cellpadding=0 cellspacing=20 bgcolor=#EFEFEF>
	<TR>
		<TD bgColor=#000000 height=1></TD>
	</TR>  
	<tr height="10%"><td width="90%">
	  <table  width="100%" height="20%" background="<%=request.getContextPath()%>/image/left1.gif">
	  	<tr>
	    	<td align="center" valign=top><font size='4'><b>���ʼ��ظ�</b></font></td>
	  	</tr>
	  	<tr>
	     	<td align="right" ><font size='3'><b><%=mess.getQuestion_time()%></b></font></td>
	  	</tr>
	  </table>
	</tr>
	<TR>
		<TD bgColor=#000000 height=1 width="60%"></TD>
	</TR>
	<TR>
		<TD height=20><b>������Ŀ��<%=mess.getTitle() %></b></TD>
	</TR>
	<tr>
		<td colspan='4' align="left" bgColor="#CCCCCC">
			����ʱ�䣺<%=mess.getQuestion_time()%><br>
			�����ˣ�<%=mess.getUsename() %><br>
			�������ݣ�<%=mess.getQuestion()%>
		</td>
	</tr>
	<tr>
		<td colspan='4' align="left" bgColor="#CCCCCC">
		<%if(!mess.getAnswer().equals("")){ %>
			�ظ�ʱ�䣺<%=mess.getAnswer_time()%><br>
			�ظ��ˣ�<%=mess.getTeacher() %><br>
			�ظ����ݣ�<%=mess.getAnswer()%>
		<%}else out.print("��ʱû�лظ���"); %>
		</td>
	</tr>
</table>
 </body>
</html> 

