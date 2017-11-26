<%@page contentType="text/html; charset=gb2312" language="java" %>
<%@page import="AI.service.NewsService"%>
<%@page import="AI.dao.impl.*"%>
<%@page import="AI.vo.*"%>
<%@page import="java.text.SimpleDateFormat"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<link href="./css/common.css" rel="stylesheet" type="text/css">
	<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
  	<title>新闻信息</title>
 </head>
 
<%
	String pageNo=request.getParameter("pageNo");
	int commentPageNo=1;
	
	try{
		commentPageNo =Integer.parseInt(pageNo);	
	}catch(Exception e){
		
	}

	Integer id=Integer.valueOf(request.getParameter("id"));
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
	NewsService service = new NewsService();
	
	service.setNewsDAO(new NewsDAOImpl());
	News news = service.getNews(id.intValue());
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
     <td align="center" valign=top>
	 <font size='4'>
	 <b><%=news.getNew_title()%></b>
	 </font>
     </td>
   </tr>
  <tr>
     <td align="right" >
     <font size='3'>
     <b><%=news.getNew_date()%></b>
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
         <%=news.getNew_content()%>
</td>
 </tr>
</table>
 </body>
</html> 

