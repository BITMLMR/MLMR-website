<%
String usename=(String)session.getAttribute("usename");
String gender=(String)session.getAttribute("gender");
if(usename==null||usename.equals("")||usename==""||gender==null||gender.equals("")||gender=="")
{
	String loginmsg="loginfirst";
	//response.sendRedirect("login.jsp?loginmsg="+loginmsg);
%>
<script>
parent.window.open("<%=request.getContextPath()%>/user/login.jsp?loginmsg=loginfirst","_self");
</script>
<%
}
%>
