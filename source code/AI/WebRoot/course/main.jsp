<%@page contentType="text/html; charset=gbk" language="java" %>
<%@page import="AI.service.*"%>
<%@page import="AI.vo.*"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat" %>

<html>
<%
	//ʱ����ʾ��ʽ
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//��������
	//1��ʾcourse�γ�ѧϰ,2��ʾexperiment����ʵ��
	//3��ʾoutcome�ɹ�չʾ,4��ʾsource��Դ����
	
	//�ж�type�Ƿ�Ϊ����
	String channel1 = request.getParameter("channel");
	int channel=0;
	try{
	    channel = Integer.parseInt(channel1);
	}catch(Exception e){
	}

	//ҳ�벿�֣���ҳ����
	int pageNo= 1;
	try
	{
		pageNo=Integer.parseInt(request.getParameter("pageNo"));
	}catch(Exception e){
	}
	int pageSize = 20;//ÿҳ��ʾ����
	//��������
	SourceService service = new SourceService();
	//��ȡ������������Դ��Ӧ�ĸ���������
	int totalCount = service.getAttachmentCountByChannelByLegal(channel,1);//4��ʾ��Դ����
	
	//��ҳ���г�������Դ
	List results = service.listAttachmentByChannelByLegalByPage(channel,1,pageNo,pageSize);
	//�����ܹ��ж���ҳ��
	int totalPage = totalCount/pageSize+(totalCount%pageSize==0?0:1);
%>

<body leftmargin="40">
	<br>
	<table width="90%"  border=0  align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC" >
		<tr bgcolor="#eeeeee">
		<%if(channel==11){ %>
			<th colspan='2'>�������μ�</th>
		<%}else if(channel==12){ %>
			<th colspan='2'>�о����μ�</th>
		<%}else if(channel==13){ %>
			<th colspan='2'>��������ҵ</th>
		<%}else if(channel==14){ %>
			<th colspan='2'>�о�����ҵ</th>
		<%} %>
		</tr>
		<tr bgcolor="#eeeeee">
		<th width="26%" height="23">���</th>
		<th width="54%" height="23">��Դ</th>
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
				<a href="main.jsp?pageNo=1">��һҳ</a>
				<a href="main.jsp?pageNo=<%=pageNo-1%>">��һҳ</a>
				<%}%>
				<%if(pageNo<totalPage){%>
				<a href="main.jsp?pageNo=<%=pageNo+1%>">��һҳ</a>
				<a href="main.jsp?pageNo=<%=totalPage%>">���ҳ</a>
				<%}%>
			</td>
		</tr>
	</table>
<br>
</body>
</html> 