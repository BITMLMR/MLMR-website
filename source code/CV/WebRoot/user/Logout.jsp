<%@ page language="java" import="java.util.*" pageEncoding="gbk"%><%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
//ȡ��session��������Լ����������Enumeration���ʵ��names��
Enumeration names = session.getAttributeNames() ;
//ѭ���ж�names���Ƿ���Ԫ��
while (names.hasMoreElements())
{
	//����Ԫ�أ���session����ɾ��
	String element = (String)names.nextElement() ;
	session.removeAttribute(element) ;
}
//�ض���login.jspҳ�棬�����ݲ�����
String loginmsg = "logout" ;
response.sendRedirect("login.jsp?loginmsg="+loginmsg);
 %>
