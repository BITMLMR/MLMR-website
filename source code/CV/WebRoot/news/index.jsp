<%@ page language="java" pageEncoding="gbk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>�����б�</title>
<%@ include file="../public/meta.jsp"%>
</head>

<body>
<div class="bodymain">

	<%@include file="../public/top.jsp"%>
	<div id="pagecell1">
	
	<!--pagecell1-->
  <img alt="" src="<%=request.getContextPath()%>/image/tl_curve_white.gif" height="6" width="6" id="tl" /> <img alt="" src="<%=request.getContextPath()%>/image/tr_curve_white.gif" height="6" width="6" id="tr" />
  <div id="breadCrumb"> <a href="<%=request.getContextPath()%>">��ҳ</a> / <a>���Ź���</a> </div>
  <div id="pageName">
    <h2>���Ź���</h2>
  </div>
	
		<!--�����ڵ�λ�ô���start-->
		<!--�����ڵ�λ�ô���end-->
		 <div  class="partmain" >
			<%@ include file="main.jsp" %>
		</div>
		
	<!--�������ݹر�-->
	 <%@include file="../public/bottom.jsp"%>
	 </div>
	 
<!--body�ر�-->
</div>
</body>
</html>
