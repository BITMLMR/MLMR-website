<%@ page contentType="text/html;charset=gbk" %>
<%@ page import="AI.vo.User" %>
<%@ page import="AI.service.UserService" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gbk">
<title>�˹�������վ</title>
<%@ include file="../public/meta.jsp"%>
</head>
<body>
<div class="bodymain">

	<%@include file="../public/top.jsp"%>
		<div id="pagecell1">
		<div id="main">
<!--�������ݿ�ʼ,���Ĵ��벿��-->
<%
	String usename=request.getParameter("usename");
	String validateCode=request.getParameter("validateCode");
	UserService userService=new UserService();	
	if(userService.validateUser(usename,validateCode)){
%>
		<center><font color="Blue">�����ʺ��Ѿ�������ڿ��Ե�¼�ˣ�</font><a href="login.jsp">��½</a></center>
<%
	}else{
%>
		<center><font color="red"><a>��֤ʧ��!</a></font></center>
<%	
	}
%>
		</div>
<!--�������ݹر�-->
	 <%@include file="../public/bottom.jsp"%>
	 </div>
	 
<!--body�ر�-->
</div>
</body>
</html>