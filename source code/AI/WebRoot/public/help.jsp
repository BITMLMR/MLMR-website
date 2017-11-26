<%@ page language="java" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>帮助</title>
<%@ include file="../public/meta.jsp"%>
</head>

<body>
<div class="bodymain">

	<%@include file="../public/top.jsp"%>
	<div id="pagecell1">
	
	<!--pagecell1-->
  <img alt="" src="<%=request.getContextPath()%>/image/tl_curve_white.gif" height="6" width="6" id="tl" /> <img alt="" src="<%=request.getContextPath()%>/image/tr_curve_white.gif" height="6" width="6" id="tr" />
  <div id="breadCrumb"> <a href="<%=request.getContextPath()%>">首页</a> / <a>帮助</a> </div>
  <div id="pageName">
    <h2>帮助</h2>
  </div>
	
		<!--您现在的位置代码start-->
		<!--您现在的位置代码end-->
	 	<div class="feature">
	 		<h3>网站基本介绍</h3>
	 		<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;新闻公告中包括人工智能中的一些新闻等信息；课件学习和平时作业在课程学习栏目下；练习题栏目中是补充作业；资源共享中是老师学生分享资源的地方；学生如果有疑问或者其他需要老师解答的问题都可以在问题与建议中留言；实验和成果展示栏目也是分享资源的地方。</p>
	 		<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;如果您是游客身份可以查看网站中的各个栏目下的课件、作业、资源和问题解答等，但是如果要上传作业、分享资源、提问问题等操作就需要注册成为会员，并且审核通过后才能进行这些操作。申请时请申请本科生、研究生身份，使用个人学号进行申请，否则不能通过审核，后果自负。当审核通过后，您可以登录该网站，登录后点击右上角您的用户名即可进入个人中心，并进行相应的操作。</p>
	 	</div>
		
	<!--主题内容关闭-->
	 <%@include file="../public/bottom.jsp"%>
	 </div>
	 
<!--body关闭-->
</div>
</body>
</html>