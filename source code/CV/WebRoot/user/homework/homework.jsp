<%@page contentType="text/html; charset=GBK" language="java" %>
<%@include file="../../public/check.jsp"%>
<%@page import="CV.service.*"%>
<%@page import="CV.vo.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
  	<title>ƽʱ��ҵ</title>
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
	List results=null;
	//���������ʾ��Ӧ����ҵ����������ҵchannel=13���о�����ҵchannel=14
	if(gender=="0"||gender.equals("0")){
		totalCount = service1.getAttachmentCountByChannelByLegal(13,1);//��������ҵƵ����13
		results = service1.listAttachmentByChannelByLegalByPage(13,1,pageNo,pageSize);
	}else if(gender=="1"||gender.equals("1")){
		totalCount = service1.getAttachmentCountByChannelByLegal(14,1);//�о�����ҵƵ����14
		results = service1.listAttachmentByChannelByLegalByPage(14,1,pageNo,pageSize);
	}
	System.out.println(totalCount+gender);
	int totalPage = totalCount/pageSize+(totalCount%pageSize==0?0:1);
%>

<body leftmargin="40">
    <table  align="center"  border=0 width="95%" class="tbcolor">
		<tr class="titletab">
			<th width="25%">��ҵ��Ŀ</th>
			<th width="25%">�Ͻ���ҵ</th>
			<th width="25%">������ҵ</th>
			<th width="25%">��ע��Ϣ</th>
		</tr>
		<%for(int i=0;i<results.size();i++){
			Attachment attachment  =(Attachment)results.get(i);
		%>
		<tr>
				<td><a href="<%=request.getContextPath()%>/<%=attachment.getAttachment_addr()%>" target="_blank">
					<%=attachment.getAttachment_name()%></a></td>
					
			<%//Ѱ�Ҷ�Ӧ��ҵ��Ŀ������Ͻ���ҵ
			int sourceId = attachment.getSource_id();
			List results2=service2.listHomeworkByUserBySourceId(username,sourceId);
			//������ڼ�¼�����Ѿ��ϴ�����ҵ��:
			if(results2.size()>0){
				Homework homework = (Homework) results2.get(0);//ÿ����ҵÿ���û�ֻ��Ӧһ����ҵ��¼
			 %>
			<td><a href="<%=request.getContextPath()%>/<%=homework.getHomework_addr()%>" target="_blank">
					<%=homework.getHomework_title()%></a>
				<%if(homework.getHomework_addr()==""||homework.getHomework_addr().equals("")){ %>
				<a href="uploadHomework.jsp?sourceId=<%=sourceId %>&username=<%=username %>">���ϴ���ҵ��</a>
				<%} %>
			</td>
			<td align=center>
				<a href="<%=request.getContextPath()%>/<%=homework.getCorrection_addr()%>" target="_blank">
					<%=homework.getCorrection_title()%></a>
				<%if(homework.getCorrection_addr()==""||homework.getCorrection_addr().equals("")){ %>
				<a>����δ���ġ�</a>
				<%} %>
			</td>
			<td align="center">
				<%if(homework.getCorrection_addr()==""||homework.getCorrection_addr().equals("")){ %>
				<a href="uploadHomework.jsp?sourceId=<%=sourceId %>&username=<%=username %>">���ϴ��°汾��ҵ��</a>
				<%}else{ %>
				<a>��ʦ�Ѿ����ģ��������ϴ���</a>
				<%} %>
			</td>
			<%}//if(results2.size()>0)//Homework %>
			
			
			<%//��������ڼ�¼������û���ϴ�����ҵ��:
			if(results2.size()==0){%>
			<td>
				<a href="uploadHomework.jsp?sourceId=<%=sourceId %>&username=<%=username %>">���ϴ���ҵ��</a>
			</td>
			<td align=center><a>����δ���ġ�</a></td>
			<td align="center">
				<a href="uploadHomework.jsp?sourceId=<%=sourceId %>&username=<%=username %>">���ϴ���ҵ��</a>
			</td>
			<%}//if(results2.size()==0)//Homework %>
				
		</tr>
		<%}//for(int i=0;i<results.size();i++)//Attachment%>
	</table>
	<table align=left>
		<tr>
			<td colspan="3" align="right">
				<%if(pageNo>1){%>
				<a href="homework.jsp?pageNo=1">��һҳ</a>
				<a href="homework.jsp?pageNo=<%=pageNo-1%>">��һҳ</a>
				<%}%>
				<%if(pageNo<totalPage){%>
				<a href="homework.jsp?pageNo=<%=pageNo+1%>">��һҳ</a>
				<a href="homework.jsp?pageNo=<%=totalPage%>">���ҳ</a>
				<%}%>
			</td>
		</tr>
	</table>
  </body>
</html>
