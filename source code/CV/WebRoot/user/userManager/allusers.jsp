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
  	<title>�����û�</title>
	<link href="<%=request.getContextPath()%>/css/common.css" rel="stylesheet" type="text/css">
 </head>
  <%
	//���ڷ�ҳ
	int pageNo= 1;
	try{
		pageNo=Integer.parseInt(request.getParameter("pageNo"));
	}catch(Exception e){
	}
	int pageSize = 20;
	int totalCount=0;
	List results=null;
	//����ǹ���Ա����ʦ����Կ���ȫ��
	UserService service = new UserService();
	//����ǹ���Ա����������ʦ��ѧ��
	if(gender=="9"||gender.equals("9")){
		totalCount = service.getUserCount(1,1,1,0);
		results = service.listUserByGenderByPage(1,1,1,0,pageNo,pageSize);
	}
	//�������ʦ��ֻ�����ѧ��
	else if(gender=="2"||gender.equals("2")){
		totalCount = service.getUserCount(1,1,0,0);
		results = service.listUserByGenderByPage(1,1,0,0,pageNo,pageSize);
	}
	int totalPage = totalCount/pageSize+(totalCount%pageSize==0?0:1);
%>
<body leftmargin="40">

	<table  align="center"  border=0 width="95%" class="tbcolor">
		<tr class="titletab">
			<th width="20%">�û���</th>
			<th width="20%">�ǳ�</th>
			<th width="20%">���</th>
			<th width="20%">״̬</th>
			<th width="20%">����</th>
		</tr>
		<%for(int i=0;i<results.size();i++){
			User user  =(User)results.get(i);
		%>
		<tr>
			<td><%=user.getUsename()%></td>
			<td><%=user.getNickname()%></td>
			<td><%if(user.getGender()=="0"||user.getGender().equals("0")){%>������<%} %>
				<%if(user.getGender()=="1"||user.getGender().equals("1")){%>�о���<%} %>
				<%if(user.getGender()=="2"||user.getGender().equals("2")){%>��ʦ<%} %>
				<%if(user.getGender()=="9"||user.getGender().equals("9")){%>����Ա<%} %></td>
			<td><%if(user.getStatus()=="0"||user.getStatus().equals("0")){%>δ����<%} %>
				<%if(user.getStatus()=="1"||user.getStatus().equals("1")){%>����<%} %></td>
			<td align=center>
		<%if(gender=="2"||gender.equals("2")||gender=="9"||gender.equals("9")){ %>
				<a href="#" onclick="confirmdelete(<%=user.getId()%>)">ɾ��</a>
			<%if(user.getStatus()=="0"||user.getStatus().equals("0")){ %>
				<a href="#" onclick="confirmlegal(<%=user.getId()%>)">�ȴ����</a>
			<%}else if(user.getStatus()=="1"||user.getStatus().equals("1")){ %>
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
				<a href="allusers.jsp?pageNo=1">��һҳ</a>
				<a href="allusers.jsp?pageNo=<%=pageNo-1%>">��һҳ</a>
				<%}%>
				<%if(pageNo<totalPage){%>
				<a href="allusers.jsp?pageNo=<%=pageNo+1%>">��һҳ</a>
				<a href="allusers.jsp?pageNo=<%=totalPage%>">���ҳ</a>
				<%}%>
			</td>
		</tr>
	</table>
</body>
<script language="javascript">
function confirmdelete(userId){
  if(confirm('ȷ��Ҫɾ�����û���')){
  	location.replace('<%=request.getContextPath()%>/servlet/DeleteUser?userId='+userId);
  }
}
function confirmlegal(userId){
  if(confirm('���û����ͨ����')){
  	location.replace('<%=request.getContextPath()%>/servlet/LegalUser?userId='+userId);
  }
}
</script>
</html> 
