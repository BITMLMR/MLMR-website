<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@page import="AI.service.*"%>
<%@page import="AI.vo.*"%>
<%@page import="java.util.List"%>
<%
	//��ȡ��Դ����tree��������tid
	int tid = 0;
	try{
		tid = Integer.parseInt(request.getParameter("tid"));
	}catch(Exception e){
	}
	//��ȡƵ�����channel
	//�ж�channel�Ƿ�Ϊ����
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
	//��ȡ��Դ������
	int totalCount = service.getSourceCountByChannelByLegal(channel,1);//4��ʾ��Դ����
	//��ҳ���г�������Դ
	//List results = service.listSourceByClassByLegalByPage(channel,1,pageNo,pageSize);
	//����tree_id�б�����channel����Դ������ҳ���ҳ
	List results = service.listSourceByChannelByLegalByTreeByPage(channel,1,tid,pageNo,pageSize);
	//�����ܹ��ж���ҳ��
	int totalPage = totalCount/pageSize+(totalCount%pageSize==0?0:1);
 %>
	<table width="90%"  border=0  align="center" cellpadding="0" cellspacing="1" bgcolor="#CCCCCC" >
		<tr bgcolor="#eeeeee">
		<th width="26%" height="23">ʱ��</th>
		<th width="54%" height="23">����</th>
		<th width="20%" height="23">����</th>
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
				<a href="source_right.jsp?pageNo=1">��һҳ</a>
				<a href="source_right.jsp?pageNo=<%=pageNo-1%>">��һҳ</a>
				<%}%>
				<%if(pageNo<totalPage){%>
				<a href="source_right.jsp?pageNo=<%=pageNo+1%>">��һҳ</a>
				<a href="source_right.jsp?pageNo=<%=totalPage%>">���ҳ</a>
				<%}%>
			</td>
		</tr>
	</table>

