<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<%@ include file="../public/meta.jsp"%>
<%@ include file="../public/check.jsp"%>
<%@ page import="AI.vo.User" %>
<%@ page import="AI.service.UserService" %>
<%@ page import="AI.util.Generator" %>
<%@ page import="java.util.*"%>


<!--主题内容开始,您的代码部分-->
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
		<b>用户信息</b>
	</td>
	</tr>
	<tr>
		<td height=20 width="40%" align=right>用户名：</td>
		<td width="60%" align=left><a><%=user.getUsename()%></a></td>
	</tr>
	<tr>
		<td height=20 width="40%" align=right>昵称：</td>
		<td width="60%" align=left><a><%=user.getNickname()%></a></td>
	</tr>
	<tr>
		<td height=20 width="40%" align=right>身份：</td>
		<td width="60%" align=left>
		<%if(user.getGender()=="0"||user.getGender().equals("0")){%><a>本科生</a>
		<%}else if(user.getGender()=="1"||user.getGender().equals("1")){%><a>研究生</a> 
		<%}else if(user.getGender()=="2"||user.getGender().equals("2")){%><a>老师</a> 
		<%} %></td>
	</tr>
	<tr>
		<td height=20 width="40%" align=right>登录次数：</td>
		<td width="60%" align=left><a><%=user.getLoginNum()%></a></td>
	</tr>
	<tr>
		<td height=20 width="40%" align=right>Email：</td>
		<td width="60%" align=left><a><%=user.getEmail() %></a></td>
	</tr>
	<tr>
		<td height=20 width="40%" align=right>注册日期：</td>
		<td width="60%" align=left><a><%=user.getRegisterdate() %></a></td>
	</tr>	
	<tr>
		<td align=center colspan=2>
		<input type=button name=button1 value="修改信息" onclick="javascript:window.location='changeInformation.jsp'"/>
		<input type=button name=button2 value="修改密码" onclick="javascript:window.location='changePassword.jsp'"/>
		</td>
	</tr>	
</table>
		</div>
</div>
<%} %>
