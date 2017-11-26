<%@page contentType="text/html; charset=GBK" language="java" %>
<%@ include file="../../public/check.jsp"%>
<%@page import="CV.service.*"%>
<%@page import="CV.vo.*"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
  	<title>���Ź����б�</title>
	<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
 </head>
<%
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//�����û����ͺ��û���
	//gender=(String)session.getAttribute("gender");
	String username=(String)session.getAttribute("usename");

	//���ڷ�ҳ
	int pageNo= 1;
	try{
		pageNo=Integer.parseInt(request.getParameter("pageNo"));
	}catch(Exception e){
	}
	int pageSize = 20;

	NewsService service = new NewsService();
	int totalCount = service.getNewsCount();
	List results = service.listNewsByPage(pageNo,pageSize);
	int totalPage = totalCount/pageSize+(totalCount%pageSize==0?0:1);
%>

<body leftmargin="40">
	<p>
		<a href="<%=request.getContextPath()%>/user/news/issue.jsp">��������</a>
	</p>
	<table  align="center"  border=0 width="95%" class="tbcolor">
		<tr class="titletab">
			<th width="20%">ʱ��</th>
			<th width="40%">����</th>
			<th width="15%">����</th>
			<th width="25%">����</th>
		</tr>
		<%for(int i=0;i<results.size();i++){
			News news  =(News)results.get(i);
		%>
		<tr>
			<td><%=news.getNew_date()%></td>
			<td><a href="<%=request.getContextPath()%>/news/shownews.jsp?id=<%=news.getNew_id()%>" target="_blank">
					<%=news.getNew_title()%></a></td>
			<td><a><%=news.getNew_author() %></a></td>
			<td align=center>
		<%if(gender=="2"||gender.equals("2")||gender=="9"||gender.equals("9")){ %>
				<a href="#" onclick="confirmdelete(<%=news.getNew_id()%>)">ɾ��</a>
				<a href="modify.jsp?newid=<%=news.getNew_id()%>">�༭</a>
				
			<%if(news.getLegal()==0){ %>
				<a href="#" onclick="confirmlegal(<%=news.getNew_id()%>)">�ȴ����</a>
			<%}else if(news.getLegal()==1){ %>
				<a>���ͨ��</a>
			<%} %>
			
		<%}%>
			</td>
		</tr>
		<%}%>
	</table>
	<table align=left>
		<tr>
			<td colspan="3" align="right">
				<%if(pageNo>1){%>
				<a href="news.jsp?pageNo=1">��һҳ</a>
				<a href="news.jsp?pageNo=<%=pageNo-1%>">��һҳ</a>
				<%}%>
				<%if(pageNo<totalPage){%>
				<a href="news.jsp?pageNo=<%=pageNo+1%>">��һҳ</a>
				<a href="news.jsp?pageNo=<%=totalPage%>">���ҳ</a>
				<%}%>
			</td>
		</tr>
	</table>
</body>
<script language="javascript">
function confirmdelete(newid){
  if(confirm('ȷ��Ҫɾ����������')){
  	location.replace('<%=request.getContextPath()%>/servlet/DeleteNews?newId='+newid);
  }
}
function confirmlegal(newid){
  if(confirm('���������ͨ����')){
  	location.replace('<%=request.getContextPath()%>/servlet/LegalNews?newId='+newid);
  }
}
</script>
</html>
