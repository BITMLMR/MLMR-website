<%@page contentType="text/html; charset=GBK" language="java" %>
<%@include file="../../public/check.jsp"%>
<%@page import="AI.service.*"%>
<%@page import="AI.vo.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
  	<title>批改作业</title>
	<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
 </head>
  <%
  	String sourceId=request.getParameter("sourceId");
	//接收用户类型和用户名
	//gender=(String)session.getAttribute("gender");
	String username=(String)session.getAttribute("usename");

	//用于分页
/*	int pageNo= 1;
	try{
		pageNo=Integer.parseInt(request.getParameter("pageNo"));
	}catch(Exception e){
	}
	int pageSize = 20;
*/	//作业表格信息
	HomeworkService service = new HomeworkService();
	//如果是学生则只显示该学生的问题
	int totalCount=0;
	List results=null;

	//如果是老师或者是管理员则显示全部问题
	results = service.listHomeworkBySourceId(Integer.parseInt(sourceId));
//		totalCount = service.getCount();
//		results = service.listHomeworkByPage(pageNo,pageSize);


//	int totalPage = totalCount/pageSize+(totalCount%pageSize==0?0:1);
%>
<body>
  <div align="center"> 
<br>
  <table>
  	<tr class="titletab">
		<th width="15%">用户名</th>
		<th width="35%">上交作业</th>
		<th width="35%">批改作业</th>
		<th width="15%">操作</th>
	</tr>
	<%for(int i=0;i<results.size();i++){
		Homework homework  =(Homework)results.get(i);
	%>
  	<tr>
  		<td><a><%=homework.getUsername() %></a></td>
		<td><a href="<%=request.getContextPath()%>/<%=homework.getHomework_addr()%>" target="_blank">
				<%=homework.getHomework_title()%></a>
		</td>
		<td align=center>
			<a href="<%=request.getContextPath()%>/<%=homework.getCorrection_addr()%>" target="_blank">
				<%=homework.getCorrection_title()%></a>
			<%if(homework.getCorrection_addr()==""||homework.getCorrection_addr().equals("")){ %>
			<a href="<%=request.getContextPath()%>/user/homework/uploadCorrection.jsp?hid=<%=homework.getId() %>&student=<%=homework.getUsername() %>&sourceId=<%=homework.getSource_id() %>">【上传批改】</a>
			<%} %>
		</td>
		<td><a href="<%=request.getContextPath()%>/user/homework/uploadCorrection.jsp?hid=<%=homework.getId() %>&student=<%=homework.getUsername() %>&sourceId=<%=homework.getSource_id() %>">【新批改】</a></td>
	</tr>
  	<%} %>
  </table>
  </div>
</body>
</html>
