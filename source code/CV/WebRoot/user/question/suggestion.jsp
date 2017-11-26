<%@page contentType="text/html; charset=GBK" language="java" %>
<%@include file="../../public/check.jsp"%>
<%@page import="CV.service.*"%>
<%@page import="CV.vo.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
  	<title>提问问题</title>
	<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
 </head>
 
<%
	//接收用户类型和用户名
	//String gender = request.getParameter("gender");
	//String username = request.getParameter("username");
	//String gender=(String)session.getAttribute("gender");
	String username=(String)session.getAttribute("usename");

	//用于分页
	int pageNo= 1;
	try{
		pageNo=Integer.parseInt(request.getParameter("pageNo"));
	}catch(Exception e){
	}
	int pageSize = 20;

	SuggestionService service = new SuggestionService();
	//如果是学生则只显示该学生的问题
	int totalCount=0;
	List results=null;
	if(gender=="0"||gender.equals("0")||gender=="1"||gender.equals("1")){
		totalCount = service.getCountByUser(username);
		results = service.listSuggettionByUserByPage(username,pageNo,pageSize);
	}
	//如果是老师或者是管理员则显示全部问题
	else if(gender=="2"||gender.equals("2")||gender=="9"||gender.equals("9")){
		totalCount = service.getCount();
		results = service.listSuggestionByPage(pageNo,pageSize);
	}
	int totalPage = totalCount/pageSize+(totalCount%pageSize==0?0:1);
%>

  

<body leftmargin="40">

	<p>	
	<%//如果是学生则可以留下意见建议
	if(gender=="0"||gender.equals("0")||gender=="1"||gender.equals("1")){ %>
		<a href="<%=request.getContextPath()%>/user/question/leave.jsp?username=<%=username %>">意见建议</a>
	<%} %>
	</p>
	
	
	<table  align="center"  border=0 width="95%" class="tbcolor">
		<tr class="titletab">
			<th width="15%">时间</th>
			<th width="50%">内容</th>
			<th width="15%">操作</th>
		</tr>
		<%for(int i=0;i<results.size();i++){
			Suggestion suggestion  =(Suggestion)results.get(i);
		%>
		<tr>
			<td><%=suggestion.getTime()%></td>
			<td><a>
					<%=suggestion.getContent()%></a>
			</td>
			<td align=center>
				<a href="#" onclick="confirmdelete(<%=suggestion.getId()%>)">删除</a>
			<%if(gender=="0"||gender.equals("0")||gender=="1"||gender.equals("1")){ %>
				<a href="#">编辑问题</a>
			<%} %>
			</td>
		</tr>
		<%}%>
	</table>
	<table align=left>
		<tr>
			<td colspan="3" align="right">
				<%if(pageNo>1){%>
				<a href="suggestion.jsp?pageNo=1">第一页</a>
				<a href="suggestion.jsp?pageNo=<%=pageNo-1%>">上一页</a>
				<%}%>
				<%if(pageNo<totalPage){%>
				<a href="suggestion.jsp?pageNo=<%=pageNo+1%>">下一页</a>
				<a href="suggestion.jsp?pageNo=<%=totalPage%>">最后页</a>
				<%}%>
			</td>
		</tr>
	</table>
</body>
<script language="javascript">
function confirmdelete(sid){
  if(confirm('确定要删除该提问吗？')){
  	location.replace('<%=request.getContextPath()%>/servlet/DeleteSuggestion?sid='+sid);
  }
}
</script>
</html> 