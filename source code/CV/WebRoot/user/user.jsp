<%@ page contentType="text/html;charset=gbk" language="java"%>
<%@ include file="../public/check.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>�û�</title>
<%@ include file="../public/meta.jsp"%>
</head>
<body>
<div class="bodymain">
	<%@include file="../public/top.jsp"%>
		<div id="pagecell1">

	<!--pagecell1-->
  <img alt="" src="<%=request.getContextPath()%>/image/tl_curve_white.gif" height="6" width="6" id="tl" /> <img alt="" src="<%=request.getContextPath()%>/image/tr_curve_white.gif" height="6" width="6" id="tr" />
  <div id="breadCrumb"> <a href="<%=request.getContextPath()%>">��ҳ</a> / <a>��������</a> </div>
  <div id="pageName">
    <h2>��������</h2>
   </div>
   
		<div id="main">
<!--�������ݿ�ʼ,���Ĵ��벿��-->
<!--�����ڵ�λ�ô���end-->
		 <div  class="pagecell1" >
			<div class="partmainTitle"></div>
				<div class="partmain_left">
					<iframe name="user_left"  marginwidth=0 height="460" scrolling="no" width="100%" src="user_left.jsp" frameborder="0"></iframe>
				</div>
				<div class="partmain_right">
					<iframe name="user_right"  marginwidth=0 height="460" scrolling="no" width="100%" src="user_right.jsp" frameborder="0"></iframe>
		    	</div>
		</div>
		</div>
<!--�������ݹر�-->
	 <%@include file="../public/bottom.jsp"%>
	 </div>
	 
<!--body�ر�-->
</div>
</body>
</html>