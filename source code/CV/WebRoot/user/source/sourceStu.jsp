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
	//����Ƶ�����ϴ���Դ���û���ȷ����ʾ��Դ���������ͨ����δ��˵� 
	int totalCount = service.getSourceCountByChannelByStu(channel,username);
	List results = service.listSourceByChannelByStuByPage(channel,username,pageNo,pageSize);
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
		<%if(source.getLegal()==1){ //������ͨ������ʾ����ˣ��������޸ĺ�ɾ��%>
			<a>���ͨ��,�����޸ĺ�ɾ��</a>
		<%}//if(source.getLegal()==1){
		else{//���û����ˣ�������޸ĺ�ɾ��%>
			<a>�ȴ����</a>
			<a href="#" onclick="confirmdelete(<%=source.getSource_id() %>)">ɾ��</a>
			<a href="modify.jsp?id=<%=source.getSource_id()%>">�༭</a>
		<%} %>
			</td>
		</tr>
		<%}//for(int i=0;i<results.size();i++){%>
	</table>
	<table align=left>
		<tr>
			<td colspan="3" align="right">
				<%if(pageNo>1){%>
				<a href="sourceStu.jsp?pageNo=1">��һҳ</a>
				<a href="sourceStu.jsp?pageNo=<%=pageNo-1%>">��һҳ</a>
				<%}%>
				<%if(pageNo<totalPage){%>
				<a href="sourceStu.jsp?pageNo=<%=pageNo+1%>">��һҳ</a>
				<a href="sourceStu.jsp?pageNo=<%=totalPage%>">���ҳ</a>
				<%}%>
			</td>
		</tr>
	</table>
</body>
<script language="javascript">
function confirmdelete(sourceid){
  if(confirm('ȷ��Ҫɾ������Դ��')){
  	location.replace('<%=request.getContextPath()%>/servlet/DeleteSource?source_id='+sourceid);
  }
}
</script>
</html> 