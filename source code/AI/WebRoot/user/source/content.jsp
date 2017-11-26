<%@page contentType="text/html; charset=gbk" language="java" %>
<%@ include file="../../public/check.jsp"%>
<%@page import="AI.service.SourceService"%>
<%@page import="AI.dao.impl.*"%>
<%@page import="AI.vo.*"%>
<%@page import="java.text.SimpleDateFormat"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<link href="./css/common.css" rel="stylesheet" type="text/css">
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
  	<title>�˹����ܽ�ѧ��վ</title>
 </head>
 
<%
	//��ȡ��ǰ��ҳ��
	String pageNo=request.getParameter("pageNo");
	int commentPageNo=1;
	try{
		commentPageNo =Integer.parseInt(pageNo);	
	}catch(Exception e){
	}
	//��ȡ��ǰ��id
	Long id=Long.valueOf(request.getParameter("id"));
	//��ʾʱ��ĸ�ʽ
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy��MM��dd��");
	SourceService service = new SourceService();

	service.setSourceDAO(new SourceDAOImpl());
	Source source = service.getSource(id.intValue());
	java.util.List attachments = service.getAttachments(new Long(id.intValue()));
	
%>

<body leftmargin="40" bgcolor="#FAFAFA">
<table  align="center"  border=0 width="90%" height="80%" cellpadding=0 cellspacing=20 bgcolor=#EFEFEF>
<TR>
 <TD bgColor=#000000 height=1></TD>
</TR>  
<tr height="10%">
 <td width="90%">
  <table  width="100%" height="20%" background="./images/left1.gif">
    <tr>
     <td align="center">
	 <font size='4'>
	 <b><%=source.getSource_title()%>(���ʴ��� )</b>
	 </font>
     </td>
   </tr>
  <tr>
     <td align="right" >
     <font size='3'>
     <b>����(<%=source.getSource_author()%>)-- <%=source.getSource_date()%></b>
     </font>
     </td>
  </tr>
  </table>
</tr>
<TR>
 <TD bgColor=#000000 height=1 width="60%"></TD>
</TR>  
<tr>
 <td colspan='4' align="left" bgColor="#CCCCCC">
         <%=source.getSource_content()%>
</td>
 </tr>
<%
	for(int i=0;i<attachments.size();i++)
	{
		Attachment attachment = (Attachment )attachments.get(i);
		if(service.isImage(attachment))
		{
%>
<tr>
	<td align="right"><%=attachment.getAttachment_name()%>
		<a href="<%=request.getContextPath()%>/servlet/download?id=<%=attachment.getAttachment_id()%>">
		<image border="0" width="200" height="100" src="<%=attachment.getAttachment_addr()%>">
		</a>
	</td>
</tr>	
<%
	}
}%>


<%for(int i=0;i<attachments.size();i++){
	Attachment attachment = (Attachment )attachments.get(i);
	if(!service.isImage(attachment))
	{
%>
	<tr>
 		<td align="right">
	 		<a href="<%=request.getContextPath()%>/servlet/download?id=<%=attachment.getAttachment_id()%>">
	 		����:<%=attachment.getAttachment_name()%></a>
 		</td>
	</tr>
<%
	}
}%>

</table>
</body>
</html> 
