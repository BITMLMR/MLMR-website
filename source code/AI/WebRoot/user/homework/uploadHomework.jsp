<%@page contentType="text/html; charset=GBK" language="java" %>
<%@include file="../../public/check.jsp"%>
<%@page import="AI.service.*"%>
<%@page import="AI.vo.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
  	<title>上传作业</title>
	<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
 </head>
  
  <body>
  <%
  String username = request.getParameter("username");
  String sourceId = request.getParameter("sourceId");
   %>
    <form name='formUpload' method='post' enctype="multipart/form-data" 
		action='<%=request.getContextPath()%>/servlet/AddHomework' onsubmit="return checkForm(this)">
		<input type="hidden" name='sourceId' value='<%=sourceId %>'>
		<input type="hidden" name='username' value='<%=username %>'>
	<table  align="center"  border=0 width="90%">
		<tr><td align="center"><b>上传作业</b></td></tr>
		<tr><td align="center"><input type='file' name='file'></td></tr>
		<tr><td align='center'><input type='submit' value='提交'></td> </tr>
	</table>
	</form>
  </body>
<script type="text/javascript">
<!--
//判断是否添了必要信息
function checkForm(form){
	if(isEmpty(formUpload.file.value) ){
		alert("请选择要上传的附件!");
		document.formUpload.file.focus();
		return false;
	}
	return true;
}
function isEmpty(str){
	if(str==null || str.length==0)
		return true;
	else 
		return false;
}

//-->
</script> 
</html>
