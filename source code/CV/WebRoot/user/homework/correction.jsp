<%@page contentType="text/html; charset=GBK" language="java" %>
<%@include file="../../public/check.jsp"%>
<%@page import="CV.service.*"%>
<%@page import="CV.vo.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
  	<title>批改作业</title>
	<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
 </head>
  
<%
	//接收用户类型和用户名
	//gender=(String)session.getAttribute("gender");
	String username=(String)session.getAttribute("usename");

	//用于分页
	int pageNo= 1;
	try{
		pageNo=Integer.parseInt(request.getParameter("pageNo"));
	}catch(Exception e){
	}
	int pageSize = 20;
	//作业题目，根据作业题目显示，针对每一个题目查询是否有上交作业
	SourceService service1 = new SourceService();
	HomeworkService service2 = new HomeworkService();
	//本页只针对学生，因此只显示该学生的问题
	int totalCount=0;
	List results13=null;
	List results14=null;
	//本科生作业channel=13，研究生作业channel=14
	int total13=service1.getAttachmentCountByChannelByLegal(13,1);
	int total14=service1.getAttachmentCountByChannelByLegal(14,1);
	//totalCount取本科生和研究生中的最大的值
	totalCount=total13;
	if(total14>total13){
		totalCount=total14;
	}
	results13 = service1.listAttachmentByChannelByLegalByPage(13,1,pageNo,pageSize);
	results14 = service1.listAttachmentByChannelByLegalByPage(14,1,pageNo,pageSize);

	int totalPage = totalCount/pageSize+(totalCount%pageSize==0?0:1);
%>

<body leftmargin="40">
    <table  align="center"  border=0 width="95%" class="tbcolor">
		<tr class="titletab">
			<th width="50%">本科生作业</th>
			<th width="50%">研究生作业</th>
		</tr>
		<tr>
		<!--本科生作业部分,您的代码部分-->
		<td>
			<table  align="center"  border=0 width="95%" class="tbcolor">
				<%for(int i=0;i<results13.size();i++){
					Attachment attachment  =(Attachment)results13.get(i);
				%>
				<tr>
					<td><a href="<%=request.getContextPath()%>/user/homework/correct.jsp?sourceId=<%=attachment.getSource_id() %>" target="_blank">
					<%=attachment.getAttachment_name()%></a></td>
				</tr>
				<%} %>
			</table>
		</td>
		
		<!--研究生作业部分,您的代码部分-->
		<td>
			<table  align="center"  border=0 width="95%" class="tbcolor">
				<%for(int i=0;i<results14.size();i++){
					Attachment attachment  =(Attachment)results14.get(i);
				%>
				<tr>
					<td><a href="<%=request.getContextPath()%>/user/homework/correct.jsp?sourceId=<%=attachment.getSource_id() %>" target="_blank">
					<%=attachment.getAttachment_name()%></a></td>
				</tr>
				<%} %>
			</table>
		</td>
		</tr>
	</table>
	<!--翻页部分,您的代码部分-->
	<table align=left>
		<tr>
			<td colspan="3" align="right">
				<%if(pageNo>1){%>
				<a href="correction.jsp?pageNo=1">第一页</a>
				<a href="correction.jsp?pageNo=<%=pageNo-1%>">上一页</a>
				<%}%>
				<%if(pageNo<totalPage){%>
				<a href="correction.jsp?pageNo=<%=pageNo+1%>">下一页</a>
				<a href="correction.jsp?pageNo=<%=totalPage%>">最后页</a>
				<%}%>
			</td>
		</tr>
	</table>
  </body>
</html>
