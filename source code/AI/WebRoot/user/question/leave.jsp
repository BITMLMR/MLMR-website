<%@page contentType="text/html; charset=GBK" language="java" %>
<%@include file="../../public/check.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
  	<title>意见建议</title>
  	<script language="javascript1.2" src="<%=request.getContextPath()%>/js/editor.js" type="text/javascript"></script>
  	<script language="Javascript1.2">browserControl()</script>
  	<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
 </head>
 
<body leftmargin="40">
	<form name='form1' method='post' action='<%=request.getContextPath()%>/servlet/AddSuggestion'>
	<input type="hidden" name="username" value="<%=session.getAttribute("usename") %>">
	<table  align="left"  border=0 width="90%">
		<tr>
		 <td colspan="2" align="center"><b>请写下您的意见或者建议</b></td>
		</tr>
		<tr>
		 <td colspan='2' align="center">
		     <textarea name='content' style="width:100%; height:80px"></textarea>
		 </td>
		 </tr>
		<tr>
			<td colspan=2 align='center'><input type='submit' value='提交'></td>
		</tr>
	</table>
	 </form>
</body>

<script language="javascript1.2">newConfig('question1')</script>

</html> 