<%@page contentType="text/html; charset=GBK" language="java" %>
<%
String msg=request.getParameter("message");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>操作失败</title>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link href="./css/common.css" rel="stylesheet" type="text/css">
</head>

<body scroll="no">
<table width="98%" height=100% border="0" cellspacing="0"
	cellpadding="0" align="center">
	<tr>
		
    <td height=25 id=location> →您的位置：操作失败</td>
	</tr>
	<tr>
		
    <td id=operation height="29"> 
      <input name="Submit332" type="button" class="input-button" value="返 回" onClick="history.go(-1)">
    </td>
	</tr>
	
  <tr>
    <td valign="top"><table width="50%" border="0" align="center" cellpadding="4" cellspacing="1" class="tbcolor">
        <tr class="titletab" id="tbcolor">
          <th align="center" id="list">&nbsp;</th>
        </tr>
        <tr>
          <td align="center" bgcolor="#FFFFFF"><p>&nbsp;</p>
            <p><font color="#FF0000">操作失败！<%=msg==null?"":msg%> </font></p>
            <p align="center">&nbsp;</p></td>
        </tr>
      </table></td>
	</tr>
	<tr> 
    <td height=25><table width="100%" border="0" align="center" cellpadding="0" cellspacing="0"  id=operation>
        <tr> 
          <td height="62">&nbsp; </td>
        </tr>
      </table></td>
  </tr>
	
</table>
</body>
</html>
