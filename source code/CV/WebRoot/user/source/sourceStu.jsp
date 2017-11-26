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
	//根据频道和上传资源者用户名确定显示资源，包括审核通过和未审核的 
	int totalCount = service.getSourceCountByChannelByStu(channel,username);
	List results = service.listSourceByChannelByStuByPage(channel,username,pageNo,pageSize);
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
		<%if(source.getLegal()==1){ //如果审核通过则显示已审核，不允许修改和删除%>
			<a>审核通过,不能修改和删除</a>
		<%}//if(source.getLegal()==1){
		else{//如果没有审核，则可以修改和删除%>
			<a>等待审核</a>
			<a href="#" onclick="confirmdelete(<%=source.getSource_id() %>)">删除</a>
			<a href="modify.jsp?id=<%=source.getSource_id()%>">编辑</a>
		<%} %>
			</td>
		</tr>
		<%}//for(int i=0;i<results.size();i++){%>
	</table>
	<table align=left>
		<tr>
			<td colspan="3" align="right">
				<%if(pageNo>1){%>
				<a href="sourceStu.jsp?pageNo=1">第一页</a>
				<a href="sourceStu.jsp?pageNo=<%=pageNo-1%>">上一页</a>
				<%}%>
				<%if(pageNo<totalPage){%>
				<a href="sourceStu.jsp?pageNo=<%=pageNo+1%>">下一页</a>
				<a href="sourceStu.jsp?pageNo=<%=totalPage%>">最后页</a>
				<%}%>
			</td>
		</tr>
	</table>
</body>
<script language="javascript">
function confirmdelete(sourceid){
  if(confirm('确定要删除该资源吗？')){
  	location.replace('<%=request.getContextPath()%>/servlet/DeleteSource?source_id='+sourceid);
  }
}
</script>
</html> 