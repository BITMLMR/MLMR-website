<%@page contentType="text/html; charset=GBK" language="java" %>
<%@include file="../../public/check.jsp"%>
<%@page import="CV.service.*"%>
<%@page import="CV.vo.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
  	<title>�ϴ�������ҵ</title>
	<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
 </head>
  
  <body>
  <%
  String hid = request.getParameter("hid");
  String teacher = (String)session.getAttribute("username");
  String student = request.getParameter("student");
  String sourceId = request.getParameter("sourceId");
   %>
    <form name='formUpload' method='post' enctype="multipart/form-data" 
		action='<%=request.getContextPath()%>/servlet/UpdateHomework' onsubmit="return checkForm(this)">
		<input type="hidden" name='hid' value='<%=hid %>'>
		<input type="hidden" name='teacher' value='<%=teacher %>'>
		<input type="hidden" name='student' value='<%=student %>'>
		<input type="hidden" name='sourceId' value='<%=sourceId %>'>
	<table  align="center"  border=0 width="90%">
		<tr><td align="center"><b>�ϴ���ҵ</b></td></tr>
		<tr><td align="center"><input type='file' name='file'></td></tr>
		<tr><td align='center'><input type='submit' value='�ύ'></td> </tr>
	</table>
	</form>
  </body>
<script type="text/javascript">
<!--
//�ж��Ƿ����˱�Ҫ��Ϣ
function checkForm(form){
	if(isEmpty(formUpload.file.value) ){
		alert("��ѡ��Ҫ�ϴ��ĸ���!");
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
