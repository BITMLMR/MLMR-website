<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ include file="../public/check.jsp"%>
<div>
    <ul>
        <li><a href="<%=request.getContextPath()%>/user/information.jsp" target="user_right">个人信息</a></li>
        <li><a href="<%=request.getContextPath()%>/user/changeInformation.jsp" target="user_right">修改个人信息</a></li>
        <li><a href="<%=request.getContextPath()%>/user/changePassword.jsp" target="user_right">修改密码</a></li>
    </ul>
    <%
	//String gender=(String)session.getAttribute("gender");
	String username=(String)session.getAttribute("usename");
	//0-->本科生;1-->研究生
	if(gender=="0"||gender.equals("0")||gender=="1"||gender.equals("1")){
	%>
	<ul>
        <!--如果身份是学生则： -->
        <li><a href="<%=request.getContextPath()%>/user/homework/homework.jsp" target="user_right">交作业</a></li>
        <li><a href="<%=request.getContextPath()%>/user/source/sourceStu.jsp?channel=4" target="user_right">资源共享</a></li>
        <li><a href="<%=request.getContextPath()%>/user/question/question.jsp" target="user_right">提问</a></li>
        <li><a href="<%=request.getContextPath()%>/user/question/suggestion.jsp" target="user_right">留言</a></li>
    </ul>
	<%}else if(gender=="2"||gender.equals("2")){//2-->老师 %>
	<ul>
        <!--如果身份是老师则： -->
        <li><a href="<%=request.getContextPath()%>/user/news/news.jsp" target="user_right">发布公告</a></li>
        
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=11" target="user_right">本科生课件</a></li>
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=12" target="user_right">研究生课件</a></li>
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=13" target="user_right">本科生作业</a></li>
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=14" target="user_right">研究生作业</a></li>
        
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=5" target="user_right">上传习题</a></li>
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=4" target="user_right">资源共享</a></li>
        <li><a href="<%=request.getContextPath()%>/user/homework/correction.jsp" target="user_right">批改作业</a></li>
        <li><a href="<%=request.getContextPath()%>/user/question/question.jsp" target="user_right">回复提问</a></li>
        <li><a href="<%=request.getContextPath()%>/user/question/suggestion.jsp" target="user_right">查看留言</a></li>
    </ul>
    <ul>
    	<li><a href="<%=request.getContextPath()%>/user/userManager/allusers.jsp" target="user_right">管理学生</a></li>
    </ul>
	<%}else if(gender=="9"||gender.equals("9")){//9-->超级管理员 %>
	<ul>
        <!--如果身份是超级管理员则： -->
        <li><a href="<%=request.getContextPath()%>/user/news/news.jsp" target="user_right">发布公告</a></li>
        
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=11" target="user_right">本科生课件</a></li>
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=12" target="user_right">研究生课件</a></li>
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=13" target="user_right">本科生作业</a></li>
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=14" target="user_right">研究生作业</a></li>
        
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=5" target="user_right">上传习题</a></li>
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=4" target="user_right">资源共享</a></li>
        <li><a href="<%=request.getContextPath()%>/user/homework/correction.jsp" target="user_right">批改作业</a></li>
        <li><a href="<%=request.getContextPath()%>/user/question/question.jsp" target="user_right">回复提问</a></li>
        <li><a href="<%=request.getContextPath()%>/user/question/suggestion.jsp" target="user_right">查看留言</a></li>
    </ul>
    <ul>
    	<li><a href="<%=request.getContextPath()%>/user/userManager/allusers.jsp" target="user_right">管理用户</a></li>
    	<li><a href="<%=request.getContextPath()%>/user/tree/tree.jsp" target="user_right">管理概念树</a></li>
    </ul>
	<%} %>

    <ul>   
        <li><a href="Logout.jsp" target="_top">退出</a></li>
    </ul>
</div>

