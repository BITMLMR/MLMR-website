<%@page contentType="text/html; charset=gbk" language="java" %>
<%@page import="AI.service.*"%>
<%@page import="AI.vo.*"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat" %>

<html>
<%
	//时间显示格式
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//接收类型
	//1表示course课程学习,2表示experiment仿真实验
	//3表示outcome成果展示,4表示source资源共享
	
	//判断type是否为数字
	String channel1 = request.getParameter("channel");
	int channel=0;
	try{
	    channel = Integer.parseInt(channel1);
	}catch(Exception e){
	}

	//页码部分，分页功能
	int pageNo= 1;
	try
	{
		pageNo=Integer.parseInt(request.getParameter("pageNo"));
	}catch(Exception e){
	}
	int pageSize = 20;//每页显示数量
	//建立对象
	SourceService service = new SourceService();
	//获取符合条件的资源对应的附件的总数
	int totalCount = service.getAttachmentCountByChannelByLegal(channel,1);//4表示资源共享
	
	//按页码列出所有资源
	List results = service.listAttachmentByChannelByLegalByPage(channel,1,pageNo,pageSize);
	//计算总共有多少页码
	int totalPage = totalCount/pageSize+(totalCount%pageSize==0?0:1);
%>

<body leftmargin="40">
	<br>
	<table width="90%"  border=0  align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC" >
		<tr bgcolor="#eeeeee">
		<%if(channel==11){ %>
			<th colspan='2'>本科生课件</th>
		<%}else if(channel==12){ %>
			<th colspan='2'>研究生课件</th>
		<%}else if(channel==13){ %>
			<th colspan='2'>本科生作业</th>
		<%}else if(channel==14){ %>
			<th colspan='2'>研究生作业</th>
		<%} %>
		</tr>
		<tr bgcolor="#eeeeee">
		<th width="26%" height="23">编号</th>
		<th width="54%" height="23">资源</th>
		</tr>
		<%
			for(int i=0;i<results.size();i++)
			{
				Attachment attachment  =(Attachment)results.get(i);
		%>
		<tr bgcolor="#eeeeee">
			<td align=center><%=i+1 %></td>
			<td><a href="../<%=attachment.getAttachment_addr()%>" target="_blank">
				<%=attachment.getAttachment_name()%></a></td>
		</tr>
		<%	}//for(int i=0;i<results.size();i++)%>
		
	</table>
	<table>
		<tr>
			<td colspan="3" align="right">
				<%if(pageNo>1){%>
				<a href="main.jsp?pageNo=1">第一页</a>
				<a href="main.jsp?pageNo=<%=pageNo-1%>">上一页</a>
				<%}%>
				<%if(pageNo<totalPage){%>
				<a href="main.jsp?pageNo=<%=pageNo+1%>">下一页</a>
				<a href="main.jsp?pageNo=<%=totalPage%>">最后页</a>
				<%}%>
			</td>
		</tr>
	</table>
<br>
</body>
</html> 