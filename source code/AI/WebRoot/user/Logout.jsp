<%@ page language="java" import="java.util.*" pageEncoding="gbk"%><%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
//取出session对象的属性集，并存放在Enumeration类的实例names中
Enumeration names = session.getAttributeNames() ;
//循环判断names中是否还有元素
while (names.hasMoreElements())
{
	//若有元素，在session将其删除
	String element = (String)names.nextElement() ;
	session.removeAttribute(element) ;
}
//重定向到login.jsp页面，并传递参数。
String loginmsg = "logout" ;
response.sendRedirect("login.jsp?loginmsg="+loginmsg);
 %>
