<%@page contentType="text/html; charset=GBK" language="java" %>
<%@ include file="../../public/check.jsp"%>
<%@page import="AI.service.SourceService"%>
<%@page import="AI.vo.*"%>
<%@page import="java.text.SimpleDateFormat" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
  	<title>修改资源</title>
  	<script language="javascript1.2" src="<%=request.getContextPath()%>/js/editor.js" type="text/javascript"></script>
  	<script language="Javascript1.2">browserControl()</script>
  	<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
 </head>
 
<%
	Integer id=Integer.valueOf(request.getParameter("id"));
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	SourceService service = new SourceService();
	Source source = service.getSource(id.intValue());
	//java.util.List attachments = service.getAttachments(id.longValue());

%>

<body leftmargin="40">
<form name="form1" action='<%=request.getContextPath()%>/servlet/ModifySource'
enctype="multipart/form-data"  method="post">
<input type="hidden" name='source_id' value="<%=source.getSource_id()%>">
<table  align="left"  border=0 width="90%">

<tr>
 <td colspan="4" align="center"><b>编辑资源</b></td>
</tr>

<tr>
 <td width="90" align='right'>资源标题</td>
 <td width="350"><input type="text" name ='source_title' style="width:100%" value='<%=source.getSource_title()%>'> </td>
  <td width="150" align='right'>显示时间</td>
 <td><input name='source_date' value="<%=source.getSource_date()!=null?source.getSource_date():""%>"></td>

</tr>
<tr>
 <td colspan='4' align="center">
         <textarea name="source_content" style="width:100%; height:80"><%=source.getSource_content()%></textarea>
 </td>
 </tr>
<tr>
<td colspan=4 align='center'><input type='submit' value='提交'></td>
</tr>
</table>
</form>
</body>

<script language="javascript1.2">sourceConfig('source_content')</script>

</html> 