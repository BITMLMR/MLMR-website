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
  	<title>问题及回复</title>
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
	    	<td align="center" valign=top><font size='4'><b>提问及回复</b></font></td>
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
		<TD height=20><b>问题题目：<%=mess.getTitle() %></b></TD>
	</TR>
	<tr>
		<td colspan='4' align="left" bgColor="#CCCCCC">
			提问时间：<%=mess.getQuestion_time()%><br>
			提问人：<%=mess.getUsename() %><br>
			提问内容：<%=mess.getQuestion()%>
		</td>
	</tr>
	<tr>
		<td colspan='4' align="left" bgColor="#CCCCCC">
		<%if(!mess.getAnswer().equals("")){ %>
			回复时间：<%=mess.getAnswer_time()%><br>
			回复人：<%=mess.getTeacher() %><br>
			回复内容：<%=mess.getAnswer()%>
		<%}else out.print("暂时没有回复！"); %>
		</td>
	</tr>
</table>
 </body>
</html> 

