<%@page contentType="text/html; charset=GBK" language="java" %>
<%@include file="../../public/check.jsp"%>
<%@page import="CV.service.*"%>
<%@page import="CV.vo.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
  	<title>������ҵ</title>
	<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
 </head>
  
<%
	//�����û����ͺ��û���
	//gender=(String)session.getAttribute("gender");
	String username=(String)session.getAttribute("usename");

	//���ڷ�ҳ
	int pageNo= 1;
	try{
		pageNo=Integer.parseInt(request.getParameter("pageNo"));
	}catch(Exception e){
	}
	int pageSize = 20;
	//��ҵ��Ŀ��������ҵ��Ŀ��ʾ�����ÿһ����Ŀ��ѯ�Ƿ����Ͻ���ҵ
	SourceService service1 = new SourceService();
	HomeworkService service2 = new HomeworkService();
	//��ҳֻ���ѧ�������ֻ��ʾ��ѧ��������
	int totalCount=0;
	List results13=null;
	List results14=null;
	//��������ҵchannel=13���о�����ҵchannel=14
	int total13=service1.getAttachmentCountByChannelByLegal(13,1);
	int total14=service1.getAttachmentCountByChannelByLegal(14,1);
	//totalCountȡ���������о����е�����ֵ
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
			<th width="50%">��������ҵ</th>
			<th width="50%">�о�����ҵ</th>
		</tr>
		<tr>
		<!--��������ҵ����,���Ĵ��벿��-->
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
		
		<!--�о�����ҵ����,���Ĵ��벿��-->
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
	<!--��ҳ����,���Ĵ��벿��-->
	<table align=left>
		<tr>
			<td colspan="3" align="right">
				<%if(pageNo>1){%>
				<a href="correction.jsp?pageNo=1">��һҳ</a>
				<a href="correction.jsp?pageNo=<%=pageNo-1%>">��һҳ</a>
				<%}%>
				<%if(pageNo<totalPage){%>
				<a href="correction.jsp?pageNo=<%=pageNo+1%>">��һҳ</a>
				<a href="correction.jsp?pageNo=<%=totalPage%>">���ҳ</a>
				<%}%>
			</td>
		</tr>
	</table>
  </body>
</html>
