<%@page contentType="text/html; charset=GBK" language="java" %>
<%@ include file="../../public/check.jsp"%>
<%@page import="CV.service.*"%>
<%@page import="CV.vo.*"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
  	<title>资源共享列表</title>
	<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
 </head>
 
<%
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//接收用户类型和用户名
	//gender=(String)session.getAttribute("gender");
	String username=(String)session.getAttribute("usename");
	//接收类型
	//1表示course课程学习,2表示experiment仿真实验
	//3表示outcome成果展示,4表示source资源共享
	int channel = Integer.parseInt(request.getParameter("channel"));
	//用于分页
	int pageNo= 1;
	try{
		pageNo=Integer.parseInt(request.getParameter("pageNo"));
	}catch(Exception e){
	}
	int pageSize = 20;
	//如果是管理员和老师则可以看到全部
	//如果是学生只能看到自己的资源
	SourceService service = new SourceService();
	int totalCount = service.getSourceCountByClass(channel);
	List results = service.listSourceByClassByPage(channel,pageNo,pageSize);
	int totalPage = totalCount/pageSize+(totalCount%pageSize==0?0:1);
%>

<body leftmargin="40">
	<p>
		<a href="<%=request.getContextPath()%>/public/upload.jsp?channel=<%=channel%>&author=">上传资源</a>
	</p>
	<table  align="center"  border=0 width="95%" class="tbcolor">
		<tr class="titletab">
			<th width="15%">上传时间</th>
			<th width="50%">资源名称</th>
			<th width="15%">操作</th>
		</tr>
		<%for(int i=0;i<results.size();i++){
			Source source  =(Source)results.get(i);
		%>
		<tr>
			<td><%=source.getSource_date()%></td>
			<td><a href="content.jsp?id=<%=source.getSource_id()%>" target="_blank">
					<%=source.getSource_title()%></a></td>
			<td align=center>
		<%if(gender=="2"||gender.equals("2")||gender=="9"||gender.equals("9")){ %>
				<a href="#" onclick="confirmdelete(<%=source.getSource_id() %>,<%=channel %>)">删除</a>
				
			<%if(source.getLegal()==0){ %>
				<a href="modify.jsp?id=<%=source.getSource_id()%>">编辑</a>
				<a href="#" onclick="confirmlegal(<%=source.getSource_id() %>,<%=channel %>)">等待审核</a>
			<%}else if(source.getLegal()==1){ %>
				<a>审核通过</a>
			<%} %>
		<%}%>
			</td>
		</tr>
		<%}%>
	</table>
	<table align=left>
		<tr>
			<td colspan="3" align="right">
				<%if(pageNo>1){%>
				<a href="source.jsp?pageNo=1">第一页</a>
				<a href="source.jsp?pageNo=<%=pageNo-1%>">上一页</a>
				<%}%>
				<%if(pageNo<totalPage){%>
				<a href="source.jsp?pageNo=<%=pageNo+1%>">下一页</a>
				<a href="source.jsp?pageNo=<%=totalPage%>">最后页</a>
				<%}%>
			</td>
		</tr>
	</table>
</body>
<script language="javascript">
function confirmdelete(sourceid,channel){
  if(confirm('确定要删除该资源吗？')){
  	location.replace('<%=request.getContextPath()%>/servlet/DeleteSource?source_id='+sourceid+'&channel='+channel);
  }
}
function confirmlegal(sourceid,channel){
  if(confirm('该资源审核通过吗？')){
  	location.replace('<%=request.getContextPath()%>/servlet/LegalSource?source_id='+sourceid+'&channel='+channel);
  }
}
</script>
</html> 