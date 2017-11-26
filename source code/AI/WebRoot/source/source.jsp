<%@ page contentType="text/html;charset=gbk" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户</title>
<%@ include file="../public/meta.jsp"%>
</head>
<body>
<div class="bodymain">
	<%@include file="../public/top.jsp"%>
		<div id="pagecell1">
<%
	//获取频道编号channel
	String channel1 = request.getParameter("channel");
	int channel=0;
	try{
	    channel = Integer.parseInt(channel1);
	}catch(Exception e){
	}
	String channelname=null;
	if(channel==2)
		channelname="实验";
	else if(channel==3)
		channelname="成果展示";
	else if(channel==4)
		channelname="资源共享";
	else if(channel==5)
		channelname="练习题";
 %>		
<!--pagecell1-->
  <img alt="" src="<%=request.getContextPath()%>/image/tl_curve_white.gif" height="6" width="6" id="tl" /> <img alt="" src="<%=request.getContextPath()%>/image/tr_curve_white.gif" height="6" width="6" id="tr" />
  <div id="breadCrumb"> <a href="<%=request.getContextPath()%>">首页</a> / <a><%=channelname %></a> </div>
  <div id="pageName">
    <h2><%=channelname %></h2>
  </div>
    
		<div id="main">
<!--主题内容开始,您的代码部分-->

<!--您现在的位置代码end-->
		 <div  class="pagecell1" >
			<div class="partmainTitle"></div>
				<div class="partmain_left">
					<iframe name="source_left"  marginwidth=0 height="460" scrolling="yes" width="100%" src="source_left.jsp?channel=<%=channel %>" frameborder="0"></iframe>
				</div>
				<div class="partmain_right">
					<iframe name="source_right"  marginwidth=0 height="460" scrolling="no" width="100%" src="source_right.jsp?channel=<%=channel %>" frameborder="0"></iframe>
		    	</div>
		</div>
		</div>
<!--主题内容关闭-->
	 <%@include file="../public/bottom.jsp"%>
	 </div>
	 
<!--body关闭-->
</div>
</body>
</html>