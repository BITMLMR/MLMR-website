<%@ page language="java" pageEncoding="gbk"%>

<script type="text/javascript">
<!--
var time = 3000;
var numofitems = 2;

//menu constructor
function menu(allitems,thisitem,startstate){ 
  callname= "gl"+thisitem;
  divname="subglobal"+thisitem;  
  this.numberofmenuitems = allitems;
  this.caller = document.getElementById(callname);
  this.thediv = document.getElementById(divname);
  this.thediv.style.visibility = startstate;
}

//menu methods
function ehandler(event,theobj){
 {
  var shutdiv =eval( "menuitem3.thediv");
    shutdiv.style.visibility="hidden";
  var shutdiv =eval( "menuitem6.thediv");
    shutdiv.style.visibility="hidden";
 }
  theobj.thediv.style.visibility="visible";
}
				
function closesubnav(event){
  if (event.clientY<48 || event.clientY > 107){
 // alert(event.clientY);
	var shutdiv =eval( "menuitem3.thediv");
		shutdiv.style.visibility="hidden";
	var shutdiv =eval( "menuitem6.thediv");
		shutdiv.style.visibility="hidden";
  }
}
// -->
</script>

    
<div class="skipLinks">skip to: 
	<a href="#content">page content</a> | 
	<a href="#pageNav">links on this page</a> | 
	<a href="#globalNav">site navigation</a> | 
	<a href="#siteInfo">footer (site information)</a> 
</div>
<div id="masthead">
  <h1 id="siteName">计算机视觉 Computer Vision</h1>
  <div id="utility">
	<%
	//String usename=(String)session.getAttribute("usename");
	if(session.getAttribute("usename")==null||session.getAttribute("usename").equals("")){
	%>
		<a href="<%=request.getContextPath()%>/user/login.jsp">登录</a> |  
		<a href="<%=request.getContextPath()%>/user/userRegister.jsp">注册</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<%
	}else{
	%>
		<a href="<%=request.getContextPath()%>/user/user.jsp"><%=session.getAttribute("usename") %></a>| 
		<a href="<%=request.getContextPath()%>/user/Logout.jsp">退出</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<%
	}
	%>
	  
	  <a href="#">设为首页</a> | <a href="<%=request.getContextPath()%>/public/help.jsp">帮助</a> | <a href="#">BBS讨论区</a> </div>
  <div id="globalNav"> <img alt="" src="<%=request.getContextPath()%>/image/gblnav_left.gif" height="32" width="4" id="gnl" /> 
  						<img alt="" src="<%=request.getContextPath()%>/image/glbnav_right.gif" height="32" width="4" id="gnr" />
    <div id="globalLink"> 
    	<a href="<%=request.getContextPath()%>/" id="gl1" class="glink" >首页</a>
    	<a href="<%=request.getContextPath()%>/news" id="gl2" class="glink">新闻公告</a>
    	<a href="<%=request.getContextPath()%>/course/index.jsp?channel=11" id="gl3" class="glink" onmouseover="ehandler(event,menuitem3);" onMouseOut="closesubnav(event)">课程学习</a>

    	<a href="<%=request.getContextPath()%>/source/source.jsp?channel=5" id="gl4"  class="glink">练习题</a>
    	<a href="<%=request.getContextPath()%>/source/source.jsp?channel=4" id="gl5" class="glink" >资源共享</a>
    	<a href="<%=request.getContextPath()%>/question/message.jsp" id="gl6" class="glink" onmouseover="ehandler(event,menuitem6);" onMouseOut="closesubnav(event)">问题与建议</a> 

    	<a href="<%=request.getContextPath()%>/source/source.jsp?channel=2" id="gl7" class="glink" >实验</a>
    	<a href="<%=request.getContextPath()%>/source/source.jsp?channel=3" id="gl8" class="glink" >成果展示</a>
    </div>
    <!--end globalLinks-->
    <form id="search" action="">
      <input name="searchFor" type="text" size="10" />
      <a href="#">search</a>
    </form>
  </div>
  <div id="subglobal3" class="subglobalNav"> 
  	<a href="<%=request.getContextPath()%>/course/index.jsp?channel=11">本科生课件</a> | 
  	<a href="<%=request.getContextPath()%>/course/index.jsp?channel=12">研究生课件</a> | 
  	<a href="<%=request.getContextPath()%>/course/index.jsp?channel=13">本科生作业</a> | 
  	<a href="<%=request.getContextPath()%>/course/index.jsp?channel=14">研究生作业</a> </div>
  <div id="subglobal6" class="subglobalNav"> 
  	<a href="<%=request.getContextPath()%>/question/message.jsp">问题解答</a> | 
  	<a href="<%=request.getContextPath()%>/question/suggestion.jsp">意见建议</a> </div>
</div>

<!--end pagecell1-->
<br />
<script type="text/javascript">
  <!--
	var menuitem3 = new menu(2,3,"hidden");
	var menuitem6 = new menu(2,6,"hidden");
  // -->
</script>
