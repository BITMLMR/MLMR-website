<%@ page contentType="text/html;charset=gbk" %>
<%@ page import="AI.vo.User" %>
<%@ page import="AI.service.UserService" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>人工智能网站</title>
<%@ include file="../public/meta.jsp"%>
</head>
<body>
<div class="bodymain">

	<%@include file="../public/top.jsp"%>
		<div id="pagecell1">
		<div id="main">
<!--主题内容开始,您的代码部分-->
<%
	String usename=request.getParameter("usename");
	String validateCode=request.getParameter("validateCode");
	UserService userService=new UserService();	
	if(userService.validateUser(usename,validateCode)){
%>
		<center><font color="Blue">您的帐号已经激活，现在可以登录了！</font><a href="login.jsp">登陆</a></center>
<%
	}else{
%>
		<center><font color="red"><a>验证失败!</a></font></center>
<%	
	}
%>
		</div>
<!--主题内容关闭-->
	 <%@include file="../public/bottom.jsp"%>
	 </div>
	 
<!--body关闭-->
</div>
</body>
</html>