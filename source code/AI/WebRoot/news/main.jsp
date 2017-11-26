<%@page contentType="text/html; charset=gbk" language="java" %>
<%@page import="AI.service.*"%>
<%@page import="AI.vo.*"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat" %>

<html>
 <head>
  	<title>���Ź���</title>
 </head>
 
<%
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	int pageNo= 1;
	try{
		pageNo=Integer.parseInt(request.getParameter("pageNo"));
	}catch(Exception e){
	}
	int pageSize = 20;
	
	NewsService service = new NewsService();
	int totalCount = service.getNewsCountByLegal();
	List results = service.listNewsByLegalByPage(1,pageNo,pageSize);
	//List results = service.listAllNews();
	int totalPage = totalCount/pageSize+(totalCount%pageSize==0?0:1);
%>

<body leftmargin="40">
<br>
	<table  width="90%"  border=0  align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC" class="tbcolor">

		<tr bgcolor="#eeeeee">
			<th width="26%" height="23">����ʱ��</th>
			<th width="54%" height="23">���ű���</th>
			<th width="20%" height="23">��������</th>
		</tr>
		<%
			for(int i=0;i<results.size();i++){
				News news  =(News)results.get(i);
		%>
		<tr bgcolor="#eeeeee">
			<td align=center><%=news.getNew_date()%></td>
			<td align=left>
				<a href="shownews.jsp?id=<%=news.getNew_id()%>" target="_blank"><%=news.getNew_title()%></a></td>
			<td align=center><%=news.getNew_author()%></td>
		</tr>
		<%}//for(int i=0;i<results.size();i++)%>
	</table>
	<table>
		<tr>
			<td colspan="3" align="right">
				<%if(pageNo>1){%>
				<a href="main.jsp?pageNo=1">��һҳ</a>
				<a href="main.jsp?pageNo=<%=pageNo-1%>">��һҳ</a>
				<%}%>
				<%if(pageNo<totalPage){%>
				<a href="main.jsp?pageNo=<%=pageNo+1%>">��һҳ</a>
				<a href="main.jsp?pageNo=<%=totalPage%>">���ҳ</a>
				<%}%>
			</td>
		</tr>
	</table>
<br>
</body>
</html> 