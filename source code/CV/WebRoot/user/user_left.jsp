<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@ include file="../public/check.jsp"%>
<div>
    <ul>
        <li><a href="<%=request.getContextPath()%>/user/information.jsp" target="user_right">������Ϣ</a></li>
        <li><a href="<%=request.getContextPath()%>/user/changeInformation.jsp" target="user_right">�޸ĸ�����Ϣ</a></li>
        <li><a href="<%=request.getContextPath()%>/user/changePassword.jsp" target="user_right">�޸�����</a></li>
    </ul>
    <%
	//String gender=(String)session.getAttribute("gender");
	String username=(String)session.getAttribute("usename");
	//0-->������;1-->�о���
	if(gender=="0"||gender.equals("0")||gender=="1"||gender.equals("1")){
	%>
	<ul>
        <!--��������ѧ���� -->
        <li><a href="<%=request.getContextPath()%>/user/homework/homework.jsp" target="user_right">����ҵ</a></li>
        <li><a href="<%=request.getContextPath()%>/user/source/sourceStu.jsp?channel=4" target="user_right">��Դ����</a></li>
        <li><a href="<%=request.getContextPath()%>/user/question/question.jsp" target="user_right">����</a></li>
        <li><a href="<%=request.getContextPath()%>/user/question/suggestion.jsp" target="user_right">����</a></li>
    </ul>
	<%}else if(gender=="2"||gender.equals("2")){//2-->��ʦ %>
	<ul>
        <!--����������ʦ�� -->
        <li><a href="<%=request.getContextPath()%>/user/news/news.jsp" target="user_right">��������</a></li>
        
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=11" target="user_right">�������μ�</a></li>
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=12" target="user_right">�о����μ�</a></li>
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=13" target="user_right">��������ҵ</a></li>
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=14" target="user_right">�о�����ҵ</a></li>
        
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=5" target="user_right">�ϴ�ϰ��</a></li>
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=4" target="user_right">��Դ����</a></li>
        <li><a href="<%=request.getContextPath()%>/user/homework/correction.jsp" target="user_right">������ҵ</a></li>
        <li><a href="<%=request.getContextPath()%>/user/question/question.jsp" target="user_right">�ظ�����</a></li>
        <li><a href="<%=request.getContextPath()%>/user/question/suggestion.jsp" target="user_right">�鿴����</a></li>
    </ul>
    <ul>
    	<li><a href="<%=request.getContextPath()%>/user/userManager/allusers.jsp" target="user_right">����ѧ��</a></li>
    </ul>
	<%}else if(gender=="9"||gender.equals("9")){//9-->��������Ա %>
	<ul>
        <!--�������ǳ�������Ա�� -->
        <li><a href="<%=request.getContextPath()%>/user/news/news.jsp" target="user_right">��������</a></li>
        
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=11" target="user_right">�������μ�</a></li>
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=12" target="user_right">�о����μ�</a></li>
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=13" target="user_right">��������ҵ</a></li>
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=14" target="user_right">�о�����ҵ</a></li>
        
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=5" target="user_right">�ϴ�ϰ��</a></li>
        <li><a href="<%=request.getContextPath()%>/user/source/source.jsp?channel=4" target="user_right">��Դ����</a></li>
        <li><a href="<%=request.getContextPath()%>/user/homework/correction.jsp" target="user_right">������ҵ</a></li>
        <li><a href="<%=request.getContextPath()%>/user/question/question.jsp" target="user_right">�ظ�����</a></li>
        <li><a href="<%=request.getContextPath()%>/user/question/suggestion.jsp" target="user_right">�鿴����</a></li>
    </ul>
    <ul>
    	<li><a href="<%=request.getContextPath()%>/user/userManager/allusers.jsp" target="user_right">�����û�</a></li>
    	<li><a href="<%=request.getContextPath()%>/user/tree/tree.jsp" target="user_right">���������</a></li>
    </ul>
	<%} %>

    <ul>   
        <li><a href="Logout.jsp" target="_top">�˳�</a></li>
    </ul>
</div>

