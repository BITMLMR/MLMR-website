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
   { alert("请输入原始密码！");
      document.form1.oldp.focus();
     return (false);
   }
    if (document.form1.newp1.value=="")
   { alert("请输入密码！");
      document.form1.newp1.focus();
     return (false);
   }
   if (document.form1.newp2.value=="")
   { alert("请输入密码！");
      document.form1.newp2.focus();
     return (false);
   }
   if (document.form1.newp1.value!=document.form1.newp2.value)
   { alert("两次输入密码不一致！");
      document.form1.newp2.focus();
     return (false);
   }
   if(form1.newp1.value.length<6 || form1.newp1.value.length>16)
   { alert("密码长度不得少于6个字符，不得多于16个字符！");
	return (false);
	}
   return (true);
}
  </script>

<div id="pagecell1">
		<div id="main">
<!--主题内容开始,您的代码部分-->
<form name="form1" action='<%=request.getContextPath()%>/servlet/ModifyUserPassword' method="post" onsubmit=" return check()">
<table align='center'>
	<tr>
	<td align="center" width="100%" colspan="2">
		<b>用户：<%=user.getUsename() %></b>
		<input type='hidden' name='usename' value="<%=user.getUsename() %>"/>
	</td>
	</tr>
	<tr>
		<td height=20 width="40%" align=right>原始密码</td>
		<td width="60%" align=left><input type='password' name='oldp'"/></td>
	</tr>
	<tr>
		<td height=20 width="40%" align=right>新密码</td>
		<td width="60%" align=left><input type='password' name='newp1'/></td>
	</tr>	
	<tr>
		<td height=20 width="40%" align=right>确认密码</td>
		<td width="60%" align=left><input type='password' name='newp2'/></td>
	</tr>
	<tr>
    	<td colspan="2" align="center">
      <input type="submit" name="Submit" value="提交"/>
      <input type="reset" name="Submit2" value="取消"/>
		</td>
  	</tr>
</table>
</form>
</div></div>