<%@page contentType="text/html; charset=GBK" language="java" %>
<%@page import="CV.service.*"%>
<%@page import="CV.vo.*"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@ page language="java" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
  	<title>问题解答</title>
  	<%@ include file="../public/meta.jsp"%>
 </head>
<body>
<div class="bodymain">

	<%@include file="../public/top.jsp"%>
	<div id="pagecell1">
	
	<!--pagecell1-->
  <img alt="" src="<%=request.getContextPath()%>/image/tl_curve_white.gif" height="6" width="6" id="tl" /> <img alt="" src="<%=request.getContextPath()%>/image/tr_curve_white.gif" height="6" width="6" id="tr" />
  <div id="breadCrumb"> <a href="<%=request.getContextPath()%>">首页</a> / <a>问题解答</a> </div>
  <div id="pageName">
    <h2>问题解答</h2>
   </div>
   
		<!--您现在的位置代码start-->
		<!--您现在的位置代码end-->
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
				<p><a href="<%=request.getContextPath()%>/user/user.jsp">提问/留言</a></p>
			</div>
			<%for(int i=0;i<results.size();i++){
					Message mess  =(Message)results.get(i);
			%>
			<table align="center" width="773" border="1" cellspacing="0" bordercolor="#000000" bgcolor="#eeeeee">
		  	<tr>
		    	<td height="23" colspan="2">&nbsp;&nbsp;<a><b>标题：</b></a><%=mess.getTitle()%></td>
		  	</tr>
		  	<tr>
			    <td width="200"><a><b>提问：</b></a><br /><%=mess.getQuestion_time() %><br/>提问人：<%=mess.getUsename()%></td>
			    <td width="573">&nbsp;<%=mess.getQuestion()%></td>
		  	</tr>
		  	<%
		  	if(mess.getAnswer()!=""&&!mess.getAnswer().equals("")&&mess.getAnswer()!=null){//如果有回复则把回复信息输出
		  	 %>
		  	<tr>
			    <td><a><b>解答：</b></a><br /><%=mess.getAnswer_time() %><br/>解答人：<%=mess.getTeacher()%></td>
			    <td><%=mess.getAnswer()%></td>
		  	</tr>
		  	<%} %>
			</table><br/>
			<%}%>
	
		<table align="center">
			<tr>
			<td colspan="3" align="right">
			<%if(pageNo>1){%>
			<a href="message.jsp?pageNo=1">第一页</a>
			<a href="message.jsp?pageNo=<%=pageNo-1%>">上一页</a>
			<%}%>
			<%if(pageNo<totalPage){%>
			<a href="message.jsp?pageNo=<%=pageNo+1%>">下一页</a>
			<a href="message.jsp?pageNo=<%=totalPage%>">最后页</a>
			<%}%>
			</td>
			</tr>
		</table>
	</div>
	<!--主题内容关闭-->
	 <%@include file="../public/bottom.jsp"%>
	 </div>
	 
<!--body关闭-->
</div>
</body>
</html>