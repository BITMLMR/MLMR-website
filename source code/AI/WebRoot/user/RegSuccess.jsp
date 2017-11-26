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
	<br>
		<center><font color="Blue">注册成功</font></center><br>
		<center><font color="Red">请登录注册邮箱激活账号！并等待管理员审核，审核通过后即可使用！</font></center>
	<br>
		</div>
<!--主题内容关闭-->
	 <%@include file="../public/bottom.jsp"%>
	 </div>
	 
<!--body关闭-->
</div>
</body>
</html>