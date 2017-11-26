<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@page import="AI.service.*"%>
<%@page import="AI.vo.*"%>
<%@page import="java.util.List"%>
<%
	//获取资源所属tree概念树的tid
	int tid = 0;
	try{
		tid = Integer.parseInt(request.getParameter("tid"));
	}catch(Exception e){
	}
	//获取频道编号channel
	//判断channel是否为数字
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
	//获取资源总数量
	int totalCount = service.getSourceCountByChannelByLegal(channel,1);//4表示资源共享
	//按页码列出所有资源
	//List results = service.listSourceByClassByLegalByPage(channel,1,pageNo,pageSize);
	//根据tree_id列表所有channel的资源，并按页码分页
	List results = service.listSourceByChannelByLegalByTreeByPage(channel,1,tid,pageNo,pageSize);
	//计算总共有多少页码
	int totalPage = totalCount/pageSize+(totalCount%pageSize==0?0:1);
 %>
	<table width="90%"  border=0  align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC" >
		<tr bgcolor="#eeeeee">
		<th width="26%" height="23">时间</th>
		<th width="54%" height="23">标题</th>
		<th width="20%" height="23">作者</th>
		</tr>
		<%
			for(int i=0;i<results.size();i++)
			{
				Source source  =(Source)results.get(i);
		%>
		<tr bgcolor="#ffffff">
			<td align=center><%=source.getSource_date()%></td>
			<td><a href="content.jsp?id=<%=source.getSource_id()%>" target="_blank">
				<%=source.getSource_title()%></a></td>
			<td align=center><%=source.getSource_author()%></td>
		</tr>
		<%	}//for(int i=0;i<results.size();i++)%>
		
	</table>
	<table>
		<tr>
			<td colspan="3" align="right">
				<%if(pageNo>1){%>
				<a href="source_right.jsp?pageNo=1">第一页</a>
				<a href="source_right.jsp?pageNo=<%=pageNo-1%>">上一页</a>
				<%}%>
				<%if(pageNo<totalPage){%>
				<a href="source_right.jsp?pageNo=<%=pageNo+1%>">下一页</a>
				<a href="source_right.jsp?pageNo=<%=totalPage%>">最后页</a>
				<%}%>
			</td>
		</tr>
	</table>

