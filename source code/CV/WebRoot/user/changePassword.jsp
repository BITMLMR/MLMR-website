<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<%@ include file="../public/meta.jsp"%>
<%@ include file="../public/check.jsp"%>
<%@ page import="CV.vo.User" %>
<%@ page import="CV.service.UserService" %>
<%@ page import="java.util.*"%>
<%
	UserService service=new UserService();
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	service.getUser(usename);
	User user= service.getUser(usename);
%>

  <script language="JavaScript">
  function check()
{
   if(document.form1.oldp.value=="")
   { alert("������ԭʼ���룡");
      document.form1.oldp.focus();
     return (false);
   }
    if (document.form1.newp1.value=="")
   { alert("���������룡");
      document.form1.newp1.focus();
     return (false);
   }
   if (document.form1.newp2.value=="")
   { alert("���������룡");
      document.form1.newp2.focus();
     return (false);
   }
   if (document.form1.newp1.value!=document.form1.newp2.value)
   { alert("�����������벻һ�£�");
      document.form1.newp2.focus();
     return (false);
   }
   if(form1.newp1.value.length<6 || form1.newp1.value.length>16)
   { alert("���볤�Ȳ�������6���ַ������ö���16���ַ���");
	return (false);
	}
   return (true);
}
  </script>

<div id="pagecell1">
		<div id="main">
<!--�������ݿ�ʼ,���Ĵ��벿��-->
<form name="form1" action='<%=request.getContextPath()%>/servlet/ModifyUserPassword' method="post" onsubmit=" return check()">
<table align='center'>
	<tr>
	<td align="center" width="100%" colspan="2">
		<b>�û���<%=user.getUsename() %></b>
		<input type='hidden' name='usename' value="<%=user.getUsename() %>"/>
	</td>
	</tr>
	<tr>
		<td height=20 width="40%" align=right>ԭʼ����</td>
		<td width="60%" align=left><input type='password' name='oldp'"/></td>
	</tr>
	<tr>
		<td height=20 width="40%" align=right>������</td>
		<td width="60%" align=left><input type='password' name='newp1'/></td>
	</tr>	
	<tr>
		<td height=20 width="40%" align=right>ȷ������</td>
		<td width="60%" align=left><input type='password' name='newp2'/></td>
	</tr>
	<tr>
    	<td colspan="2" align="center">
      <input type="submit" name="Submit" value="�ύ"/>
      <input type="reset" name="Submit2" value="ȡ��"/>
		</td>
  	</tr>
</table>
</form>
</div></div>