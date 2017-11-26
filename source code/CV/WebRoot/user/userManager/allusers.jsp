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
  	<title>管理用户</title>
	<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
 </head>
  <%
	//用于分页
	int pageNo= 1;
	try{
		pageNo=Integer.parseInt(request.getParameter("pageNo"));
	}catch(Exception e){
	}
	int pageSize = 20;
	int totalCount=0;
	List results=null;
	//如果是管理员和老师则可以看到全部
	UserService service = new UserService();
	//如果是管理员则可以审核老师和学生
	if(gender=="9"||gender.equals("9")){
		totalCount = service.getUserCount(1,1,1,0);
		results = service.listUserByGenderByPage(1,1,1,0,pageNo,pageSize);
	}
	//如果是老师则只能审核学生
	else if(gender=="2"||gender.equals("2")){
		totalCount = service.getUserCount(1,1,0,0);
		results = service.listUserByGenderByPage(1,1,0,0,pageNo,pageSize);
	}
	int totalPage = totalCount/pageSize+(totalCount%pageSize==0?0:1);
%>
<body leftmargin="40">

	<table  align="center"  border=0 width="95%" class="tbcolor">
		<tr class="titletab">
			<th width="20%">用户名</th>
			<th width="20%">昵称</th>
			<th width="20%">身份</th>
			<th width="20%">状态</th>
			<th width="20%">操作</th>
		</tr>
		<%for(int i=0;i<results.size();i++){
			User user  =(User)results.get(i);
		%>
		<tr>
			<td><%=user.getUsename()%></td>
			<td><%=user.getNickname()%></td>
			<td><%if(user.getGender()=="0"||user.getGender().equals("0")){%>本科生<%} %>
				<%if(user.getGender()=="1"||user.getGender().equals("1")){%>研究生<%} %>
				<%if(user.getGender()=="2"||user.getGender().equals("2")){%>老师<%} %>
				<%if(user.getGender()=="9"||user.getGender().equals("9")){%>管理员<%} %></td>
			<td><%if(user.getStatus()=="0"||user.getStatus().equals("0")){%>未激活<%} %>
				<%if(user.getStatus()=="1"||user.getStatus().equals("1")){%>激活<%} %></td>
			<td align=center>
		<%if(gender=="2"||gender.equals("2")||gender=="9"||gender.equals("9")){ %>
				<a href="#" onclick="confirmdelete(<%=user.getId()%>)">删除</a>
			<%if(user.getStatus()=="0"||user.getStatus().equals("0")){ %>
				<a href="#" onclick="confirmlegal(<%=user.getId()%>)">等待审核</a>
			<%}else if(user.getStatus()=="1"||user.getStatus().equals("1")){ %>
				<a>审核通过</a>
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
				<a href="allusers.jsp?pageNo=1">第一页</a>
				<a href="allusers.jsp?pageNo=<%=pageNo-1%>">上一页</a>
				<%}%>
				<%if(pageNo<totalPage){%>
				<a href="allusers.jsp?pageNo=<%=pageNo+1%>">下一页</a>
				<a href="allusers.jsp?pageNo=<%=totalPage%>">最后页</a>
				<%}%>
			</td>
		</tr>
	</table>
</body>
<script language="javascript">
function confirmdelete(userId){
  if(confirm('确定要删除该用户吗？')){
  	location.replace('<%=request.getContextPath()%>/servlet/DeleteUser?userId='+userId);
  }
}
function confirmlegal(userId){
  if(confirm('该用户审核通过吗？')){
  	location.replace('<%=request.getContextPath()%>/servlet/LegalUser?userId='+userId);
  }
}
</script>
</html> 
