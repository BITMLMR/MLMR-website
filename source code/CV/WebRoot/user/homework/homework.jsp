<%@page contentType="text/html; charset=GBK" language="java" %>
<%@include file="../../public/check.jsp"%>
<%@page import="CV.service.*"%>
<%@page import="CV.vo.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
  	<title>平时作业</title>
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
	List results=null;
	//根据身份显示对应的作业，本科生作业channel=13，研究生作业channel=14
	if(gender=="0"||gender.equals("0")){
		totalCount = service1.getAttachmentCountByChannelByLegal(13,1);//本科生作业频道是13
		results = service1.listAttachmentByChannelByLegalByPage(13,1,pageNo,pageSize);
	}else if(gender=="1"||gender.equals("1")){
		totalCount = service1.getAttachmentCountByChannelByLegal(14,1);//研究生作业频道是14
		results = service1.listAttachmentByChannelByLegalByPage(14,1,pageNo,pageSize);
	}
	System.out.println(totalCount+gender);
	int totalPage = totalCount/pageSize+(totalCount%pageSize==0?0:1);
%>

<body leftmargin="40">
    <table  align="center"  border=0 width="95%" class="tbcolor">
		<tr class="titletab">
			<th width="25%">作业题目</th>
			<th width="25%">上交作业</th>
			<th width="25%">批改作业</th>
			<th width="25%">备注信息</th>
		</tr>
		<%for(int i=0;i<results.size();i++){
			Attachment attachment  =(Attachment)results.get(i);
		%>
		<tr>
				<td><a href="<%=request.getContextPath()%>/<%=attachment.getAttachment_addr()%>" target="_blank">
					<%=attachment.getAttachment_name()%></a></td>
					
			<%//寻找对应作业题目下面的上交作业
			int sourceId = attachment.getSource_id();
			List results2=service2.listHomeworkByUserBySourceId(username,sourceId);
			//如果存在记录，即已经上传了作业则:
			if(results2.size()>0){
				Homework homework = (Homework) results2.get(0);//每个作业每个用户只对应一个作业记录
			 %>
			<td><a href="<%=request.getContextPath()%>/<%=homework.getHomework_addr()%>" target="_blank">
					<%=homework.getHomework_title()%></a>
				<%if(homework.getHomework_addr()==""||homework.getHomework_addr().equals("")){ %>
				<a href="uploadHomework.jsp?sourceId=<%=sourceId %>&username=<%=username %>">【上传作业】</a>
				<%} %>
			</td>
			<td align=center>
				<a href="<%=request.getContextPath()%>/<%=homework.getCorrection_addr()%>" target="_blank">
					<%=homework.getCorrection_title()%></a>
				<%if(homework.getCorrection_addr()==""||homework.getCorrection_addr().equals("")){ %>
				<a>【还未批改】</a>
				<%} %>
			</td>
			<td align="center">
				<%if(homework.getCorrection_addr()==""||homework.getCorrection_addr().equals("")){ %>
				<a href="uploadHomework.jsp?sourceId=<%=sourceId %>&username=<%=username %>">【上传新版本作业】</a>
				<%}else{ %>
				<a>老师已经批改，不能再上传了</a>
				<%} %>
			</td>
			<%}//if(results2.size()>0)//Homework %>
			
			
			<%//如果不存在记录，即还没有上传了作业则:
			if(results2.size()==0){%>
			<td>
				<a href="uploadHomework.jsp?sourceId=<%=sourceId %>&username=<%=username %>">【上传作业】</a>
			</td>
			<td align=center><a>【还未批改】</a></td>
			<td align="center">
				<a href="uploadHomework.jsp?sourceId=<%=sourceId %>&username=<%=username %>">【上传作业】</a>
			</td>
			<%}//if(results2.size()==0)//Homework %>
				
		</tr>
		<%}//for(int i=0;i<results.size();i++)//Attachment%>
	</table>
	<table align=left>
		<tr>
			<td colspan="3" align="right">
				<%if(pageNo>1){%>
				<a href="homework.jsp?pageNo=1">第一页</a>
				<a href="homework.jsp?pageNo=<%=pageNo-1%>">上一页</a>
				<%}%>
				<%if(pageNo<totalPage){%>
				<a href="homework.jsp?pageNo=<%=pageNo+1%>">下一页</a>
				<a href="homework.jsp?pageNo=<%=totalPage%>">最后页</a>
				<%}%>
			</td>
		</tr>
	</table>
  </body>
</html>
