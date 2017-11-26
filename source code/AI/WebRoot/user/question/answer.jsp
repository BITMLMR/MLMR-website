<%@page contentType="text/html; charset=GBK" language="java" %>
<%@include file="../../public/check.jsp"%>
<%@page import="AI.service.MessageService"%>
<%@page import="AI.vo.*"%>
<%@page import="java.text.SimpleDateFormat" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
  	<title>回复提问</title>
  	<script language="javascript1.2" src="<%=request.getContextPath()%>/js/editor.js" type="text/javascript"></script>
  	<script language="Javascript1.2">browserControl()</script>
  	<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
 </head>
 
<%
	Integer mid=Integer.valueOf(request.getParameter("mid"));
	MessageService service = new MessageService();
	Message mess = service.getMessage(mid.intValue());
%>

<body leftmargin="40">
<form name="form1" action='<%=request.getContextPath()%>/servlet/AnswerMessage' method="post" >
	<input type="hidden" name='mid' value="<%=mess.getMid()%>">
	<input type="hidden" name='teacher' value='<%=session.getAttribute("usename") %>'>
	<table  align="left"  border=0 width="90%">
		<tr>
			<td colspan="1" align="center"><b>提问/留言</b></td>
		</tr>
		<tr>
			<td colspan='1' align="center">
			    <textarea name="question" style="width:100%; height:80"><%=mess.getQuestion()%></textarea>
			 </td> 
		</tr>
	 	<tr><td colspan="1" align="center"><b>回复</b></td></tr>
		<tr><td colspan='1' align="center">
	         <textarea name="answer" style="width:80%; height:80"><%=mess.getAnswer() %></textarea>
	 	</td></tr>
		<tr>
			<td colspan=4 align='center'><input type='submit' value='提交'></td>
		</tr>
	</table>
</form>
</body>

<script language="javascript1.2">newConfig('answer1')</script>

</html> 