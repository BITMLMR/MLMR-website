<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<%@ include file="../public/meta.jsp"%>
<%@ include file="../public/check.jsp"%>
<%@ page import="AI.vo.User" %>
<%@ page import="AI.service.UserService" %>
<%@ page import="AI.util.Generator" %>
<%@ page import="java.util.*"%>


<!--�������ݿ�ʼ,���Ĵ��벿��-->
<%
	if(usename!=null){
	UserService service=new UserService();
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	service.getUser(usename);
	User user= service.getUser(usename);
%>
<div id="pagecell1">
		<div id="main">
<table align='center'>
	<tr>
	<td align="center" width="100%" colspan="2">
		<b>�û���Ϣ</b>
	</td>
	</tr>
	<tr>
		<td height=20 width="40%" align=right>�û�����</td>
		<td width="60%" align=left><a><%=user.getUsename()%></a></td>
	</tr>
	<tr>
		<td height=20 width="40%" align=right>�ǳƣ�</td>
		<td width="60%" align=left><a><%=user.getNickname()%></a></td>
	</tr>
	<tr>
		<td height=20 width="40%" align=right>��ݣ�</td>
		<td width="60%" align=left>
		<%if(user.getGender()=="0"||user.getGender().equals("0")){%><a>������</a>
		<%}else if(user.getGender()=="1"||user.getGender().equals("1")){%><a>�о���</a> 
		<%}else if(user.getGender()=="2"||user.getGender().equals("2")){%><a>��ʦ</a> 
		<%} %></td>
	</tr>
	<tr>
		<td height=20 width="40%" align=right>��¼������</td>
		<td width="60%" align=left><a><%=user.getLoginNum()%></a></td>
	</tr>
	<tr>
		<td height=20 width="40%" align=right>Email��</td>
		<td width="60%" align=left><a><%=user.getEmail() %></a></td>
	</tr>
	<tr>
		<td height=20 width="40%" align=right>ע�����ڣ�</td>
		<td width="60%" align=left><a><%=user.getRegisterdate() %></a></td>
	</tr>	
	<tr>
		<td align=center colspan=2>
		<input type=button name=button1 value="�޸���Ϣ" onclick="javascript:window.location='changeInformation.jsp'"/>
		<input type=button name=button2 value="�޸�����" onclick="javascript:window.location='changePassword.jsp'"/>
		</td>
	</tr>	
</table>
		</div>
</div>
<%} %>
