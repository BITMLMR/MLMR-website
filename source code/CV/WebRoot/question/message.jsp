<%@page contentType="text/html; charset=GBK" language="java" %>
<%@page import="CV.service.*"%>
<%@page import="CV.vo.*"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@ page language="java" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  	<title>������</title>
  	<%@ include file="../public/meta.jsp"%>
 </head>
<body>
<div class="bodymain">

	<%@include file="../public/top.jsp"%>
	<div id="pagecell1">
	
	<!--pagecell1-->
  <img alt="" src="<%=request.getContextPath()%>/image/tl_curve_white.gif" height="6" width="6" id="tl" /> <img alt="" src="<%=request.getContextPath()%>/image/tr_curve_white.gif" height="6" width="6" id="tr" />
  <div id="breadCrumb"> <a href="<%=request.getContextPath()%>">��ҳ</a> / <a>������</a> </div>
  <div id="pageName">
    <h2>������</h2>
   </div>
   
		<!--�����ڵ�λ�ô���start-->
		<!--�����ڵ�λ�ô���end-->
		 <div  class="partmain" > 
			<%
				//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				
				int pageNo= 1;
				try{
				pageNo=Integer.parseInt(request.getParameter("pageNo"));
				}catch(Exception e){
				}
				int pageSize = 10;
				
				MessageService service = new MessageService();
				int totalCount = service.getMessageCount();
				List results = service.listMessageByPage(pageNo,pageSize);
				int totalPage = totalCount/pageSize+(totalCount%pageSize==0?0:1);
			%>
	
			<div align="center">
				<p><a href="<%=request.getContextPath()%>/user/user.jsp">����/����</a></p>
			</div>
			<%for(int i=0;i<results.size();i++){
					Message mess  =(Message)results.get(i);
			%>
			<table align="center" width="773" border="1" cellspacing="0" bordercolor="#000000" bgcolor="#eeeeee">
		  	<tr>
		    	<td height="23" colspan="2">&nbsp;&nbsp;<a><b>���⣺</b></a><%=mess.getTitle()%></td>
		  	</tr>
		  	<tr>
			    <td width="200"><a><b>���ʣ�</b></a><br /><%=mess.getQuestion_time() %><br/>�����ˣ�<%=mess.getUsename()%></td>
			    <td width="573">&nbsp;<%=mess.getQuestion()%></td>
		  	</tr>
		  	<%
		  	if(mess.getAnswer()!=""&&!mess.getAnswer().equals("")&&mess.getAnswer()!=null){//����лظ���ѻظ���Ϣ���
		  	 %>
		  	<tr>
			    <td><a><b>���</b></a><br /><%=mess.getAnswer_time() %><br/>����ˣ�<%=mess.getTeacher()%></td>
			    <td><%=mess.getAnswer()%></td>
		  	</tr>
		  	<%} %>
			</table><br/>
			<%}%>
	
		<table align="center">
			<tr>
			<td colspan="3" align="right">
			<%if(pageNo>1){%>
			<a href="message.jsp?pageNo=1">��һҳ</a>
			<a href="message.jsp?pageNo=<%=pageNo-1%>">��һҳ</a>
			<%}%>
			<%if(pageNo<totalPage){%>
			<a href="message.jsp?pageNo=<%=pageNo+1%>">��һҳ</a>
			<a href="message.jsp?pageNo=<%=totalPage%>">���ҳ</a>
			<%}%>
			</td>
			</tr>
		</table>
	</div>
	<!--�������ݹر�-->
	 <%@include file="../public/bottom.jsp"%>
	 </div>
	 
<!--body�ر�-->
</div>
</body>
</html>