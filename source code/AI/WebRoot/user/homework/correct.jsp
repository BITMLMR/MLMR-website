<%@page contentType="text/html; charset=GBK" language="java" %>
<%@include file="../../public/check.jsp"%>
<%@page import="AI.service.*"%>
<%@page import="AI.vo.*"%>
<%@page import="java.util.List"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
  	<title>������ҵ</title>
	<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
 </head>
  <%
  	String sourceId=request.getParameter("sourceId");
	//�����û����ͺ��û���
	//gender=(String)session.getAttribute("gender");
	String username=(String)session.getAttribute("usename");

	//���ڷ�ҳ
/*	int pageNo= 1;
	try{
		pageNo=Integer.parseInt(request.getParameter("pageNo"));
	}catch(Exception e){
	}
	int pageSize = 20;
*/	//��ҵ�����Ϣ
	HomeworkService service = new HomeworkService();
	//�����ѧ����ֻ��ʾ��ѧ��������
	int totalCount=0;
	List results=null;

	//�������ʦ�����ǹ���Ա����ʾȫ������
	results = service.listHomeworkBySourceId(Integer.parseInt(sourceId));
//		totalCount = service.getCount();
//		results = service.listHomeworkByPage(pageNo,pageSize);


//	int totalPage = totalCount/pageSize+(totalCount%pageSize==0?0:1);
%>
<body>
  <div align="center"> 
<br>
  <table>
  	<tr class="titletab">
		<th width="15%">�û���</th>
		<th width="35%">�Ͻ���ҵ</th>
		<th width="35%">������ҵ</th>
		<th width="15%">����</th>
	</tr>
	<%for(int i=0;i<results.size();i++){
		Homework homework  =(Homework)results.get(i);
	%>
  	<tr>
  		<td><a><%=homework.getUsername() %></a></td>
		<td><a href="<%=request.getContextPath()%>/<%=homework.getHomework_addr()%>" target="_blank">
				<%=homework.getHomework_title()%></a>
		</td>
		<td align=center>
			<a href="<%=request.getContextPath()%>/<%=homework.getCorrection_addr()%>" target="_blank">
				<%=homework.getCorrection_title()%></a>
			<%if(homework.getCorrection_addr()==""||homework.getCorrection_addr().equals("")){ %>
			<a href="<%=request.getContextPath()%>/user/homework/uploadCorrection.jsp?hid=<%=homework.getId() %>&student=<%=homework.getUsername() %>&sourceId=<%=homework.getSource_id() %>">���ϴ����ġ�</a>
			<%} %>
		</td>
		<td><a href="<%=request.getContextPath()%>/user/homework/uploadCorrection.jsp?hid=<%=homework.getId() %>&student=<%=homework.getUsername() %>&sourceId=<%=homework.getSource_id() %>">�������ġ�</a></td>
	</tr>
  	<%} %>
  </table>
  </div>
</body>
</html>
