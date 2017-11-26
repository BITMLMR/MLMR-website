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
  	<title>��Դ�����б�</title>
	<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
 </head>
 
<%
	//SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	//�����û����ͺ��û���
	//gender=(String)session.getAttribute("gender");
	String username=(String)session.getAttribute("usename");
	//��������
	//1��ʾcourse�γ�ѧϰ,2��ʾexperiment����ʵ��
	//3��ʾoutcome�ɹ�չʾ,4��ʾsource��Դ����
	int channel = Integer.parseInt(request.getParameter("channel"));
	//���ڷ�ҳ
	int pageNo= 1;
	try{
		pageNo=Integer.parseInt(request.getParameter("pageNo"));
	}catch(Exception e){
	}
	int pageSize = 20;
	//����ǹ���Ա����ʦ����Կ���ȫ��
	//�����ѧ��ֻ�ܿ����Լ�����Դ
	SourceService service = new SourceService();
	int totalCount = service.getSourceCountByClass(channel);
	List results = service.listSourceByClassByPage(channel,pageNo,pageSize);
	int totalPage = totalCount/pageSize+(totalCount%pageSize==0?0:1);
%>

<body leftmargin="40">
	<p>
		<a href="<%=request.getContextPath()%>/public/upload.jsp?channel=<%=channel%>&author=">�ϴ���Դ</a>
	</p>
	<table  align="center"  border=0 width="95%" class="tbcolor">
		<tr class="titletab">
			<th width="15%">�ϴ�ʱ��</th>
			<th width="50%">��Դ����</th>
			<th width="15%">����</th>
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
				<a href="#" onclick="confirmdelete(<%=source.getSource_id() %>,<%=channel %>)">ɾ��</a>
				
			<%if(source.getLegal()==0){ %>
				<a href="modify.jsp?id=<%=source.getSource_id()%>">�༭</a>
				<a href="#" onclick="confirmlegal(<%=source.getSource_id() %>,<%=channel %>)">�ȴ����</a>
			<%}else if(source.getLegal()==1){ %>
				<a>���ͨ��</a>
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
				<a href="source.jsp?pageNo=1">��һҳ</a>
				<a href="source.jsp?pageNo=<%=pageNo-1%>">��һҳ</a>
				<%}%>
				<%if(pageNo<totalPage){%>
				<a href="source.jsp?pageNo=<%=pageNo+1%>">��һҳ</a>
				<a href="source.jsp?pageNo=<%=totalPage%>">���ҳ</a>
				<%}%>
			</td>
		</tr>
	</table>
</body>
<script language="javascript">
function confirmdelete(sourceid,channel){
  if(confirm('ȷ��Ҫɾ������Դ��')){
  	location.replace('<%=request.getContextPath()%>/servlet/DeleteSource?source_id='+sourceid+'&channel='+channel);
  }
}
function confirmlegal(sourceid,channel){
  if(confirm('����Դ���ͨ����')){
  	location.replace('<%=request.getContextPath()%>/servlet/LegalSource?source_id='+sourceid+'&channel='+channel);
  }
}
</script>
</html> 