<%@page contentType="text/html; charset=GBK" language="java" %>
<%@include file="../../public/check.jsp"%>
<%@page import="AI.service.*"%>
<%@page import="AI.vo.*"%>
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

	MessageService service = new MessageService();
	//如果是学生则只显示该学生的问题
	int totalCount=0;
	List results=null;
	if(gender=="0"||gender.equals("0")||gender=="1"||gender.equals("1")){
		totalCount = service.getMessageCountByUsename(username);
		results = service.listMessageByUsename(username,pageNo,pageSize);
	}
	//如果是老师或者是管理员则显示全部问题
	else if(gender=="2"||gender.equals("2")||gender=="9"||gender.equals("9")){
		totalCount = service.getMessageCount();
		results = service.listMessageByPage(pageNo,pageSize);
	}
	int totalPage = totalCount/pageSize+(totalCount%pageSize==0?0:1);
%>

<body leftmargin="40">

	<p>
	<%//如果是学生则可以提问
	if(gender=="0"||gender.equals("0")||gender=="1"||gender.equals("1")){ %>
		<a href="<%=request.getContextPath()%>/user/question/ask.jsp?username=<%=username %>">提问问题</a>
	<%} %>
	</p>
	<table  align="center"  border=0 width="95%" class="tbcolor">
		<tr class="titletab">
			<th width="15%">提问时间</th>
			<th width="50%">标题</th>
			<th width="15%">操作</th>
		</tr>
		<%for(int i=0;i<results.size();i++){
			Message message  =(Message)results.get(i);
		%>
		<tr>
			<td><%=message.getQuestion_time()%></td>
			<td><a href="detail.jsp?mid=<%=message.getMid()%>" target="_blank">
					<%=message.getTitle()%></a>
				<%if(message.getAnswer()==""||message.getAnswer().equals("")){ %>
				<a>【等待回复】</a>
				<%} %>
			</td>
			<td align=center>
				<a href="#" onclick="confirmdelete(<%=message.getMid()%>)">删除</a>
			<%if(gender=="0"||gender.equals("0")||gender=="1"||gender.equals("1")){ %>
				<a href="modify.jsp?mid=<%=message.getMid()%>">编辑问题</a>
			<%} %>
			<%if(gender=="2"||gender.equals("2")||gender=="9"||gender.equals("9")){ %>
				<a href="answer.jsp?mid=<%=message.getMid()%>">
				<%if(message.getAnswer()==""||message.getAnswer().equals("")){ %>
				【等待回复】
				<%}else{ %>
				编辑回复
				<%} %>
				</a>
			<%} %>
			</td>
		</tr>
		<%}%>
	</table>
	<table align=left>
		<tr>
			<td colspan="3" align="right">
				<%if(pageNo>1){%>
				<a href="question.jsp?pageNo=1">第一页</a>
				<a href="question.jsp?pageNo=<%=pageNo-1%>">上一页</a>
				<%}%>
				<%if(pageNo<totalPage){%>
				<a href="question.jsp?pageNo=<%=pageNo+1%>">下一页</a>
				<a href="question.jsp?pageNo=<%=totalPage%>">最后页</a>
				<%}%>
			</td>
		</tr>
	</table>
</body>
<script language="javascript">
function confirmdelete(mid){
  if(confirm('确定要删除该提问吗？')){
  	location.replace('<%=request.getContextPath()%>/servlet/DeleteMessage?mid='+mid);
  }
}
</script>
</html> 