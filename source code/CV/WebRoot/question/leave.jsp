<%@page contentType="text/html; charset=GBK" language="java" %>
<%--  <%@include file="../../public/check.jsp"%> --%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>意见建议</title>
<%@ include file="../public/meta.jsp"%>
</head>

<body>
<div class="bodymain">
	<%@include file="../public/top.jsp"%>
	<div id="pagecell1">
	
	<!--pagecell1-->
  <img alt="" src="<%=request.getContextPath()%>/image/tl_curve_white.gif" height="6" width="6" id="tl" /> <img alt="" src="<%=request.getContextPath()%>/image/tr_curve_white.gif" height="6" width="6" id="tr" />
  <div id="breadCrumb"> <a href="<%=request.getContextPath()%>">首页</a> / <a>意见建议</a> </div>
  <div id="pageName">
    <h2>意见建议</h2>
   </div>
   <!--您现在的位置代码start-->
		<!--您现在的位置代码end-->
		 <div  class="partmain" >
		 <form name='form1' method='post' action='<%=request.getContextPath()%>/servlet/AddSuggestion'>
 	

	<table  align="left"  border=0 width="90%">
		<tr>
		 <td colspan="2" align="center"><b>请写下您的意见或者建议</b></td>
		</tr>
		<tr>
		 <td colspan='2' align="center">
		     <textarea name='content' style="width:100%; height:80px"></textarea>
		 </td>
		 </tr>
		<tr>
			<td colspan=2 align='center'><input type='submit' value='匿名提交'></td>
		</tr>
	</table>
	 </form>
		 
		 
		 
		 
		 	</div>
		
		
	<!--主题内容关闭-->
	 <%@include file="../public/bottom.jsp"%>
	 </div>
	 
<!--body关闭-->
</div>
</body>

<script language="javascript1.2">newConfig('question1')</script>

</html> 