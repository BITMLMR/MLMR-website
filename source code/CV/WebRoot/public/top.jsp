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
  <h1 id="siteName">������Ӿ� Computer Vision</h1>
  <div id="utility">
	<%
	//String usename=(String)session.getAttribute("usename");
	if(session.getAttribute("usename")==null||session.getAttribute("usename").equals("")){
	%>
		<a href="<%=request.getContextPath()%>/user/login.jsp">��¼</a> |  
		<a href="<%=request.getContextPath()%>/user/userRegister.jsp">ע��</a> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<%
	}else{
	%>
		<a href="<%=request.getContextPath()%>/user/user.jsp"><%=session.getAttribute("usename") %></a>| 
		<a href="<%=request.getContextPath()%>/user/Logout.jsp">�˳�</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<%
	}
	%>
	  
	  <a href="#">��Ϊ��ҳ</a> | <a href="<%=request.getContextPath()%>/public/help.jsp">����</a> | <a href="#">BBS������</a> </div>
  <div id="globalNav"> <img alt="" src="<%=request.getContextPath()%>/image/gblnav_left.gif" height="32" width="4" id="gnl" /> 
  						<img alt="" src="<%=request.getContextPath()%>/image/glbnav_right.gif" height="32" width="4" id="gnr" />
    <div id="globalLink"> 
    	<a href="<%=request.getContextPath()%>/" id="gl1" class="glink" >��ҳ</a>
    	<a href="<%=request.getContextPath()%>/news" id="gl2" class="glink">���Ź���</a>
    	<a href="<%=request.getContextPath()%>/course/index.jsp?channel=11" id="gl3" class="glink" onmouseover="ehandler(event,menuitem3);" onMouseOut="closesubnav(event)">�γ�ѧϰ</a>

    	<a href="<%=request.getContextPath()%>/source/source.jsp?channel=5" id="gl4"  class="glink">��ϰ��</a>
    	<a href="<%=request.getContextPath()%>/source/source.jsp?channel=4" id="gl5" class="glink" >��Դ����</a>
    	<a href="<%=request.getContextPath()%>/question/message.jsp" id="gl6" class="glink" onmouseover="ehandler(event,menuitem6);" onMouseOut="closesubnav(event)">�����뽨��</a> 

    	<a href="<%=request.getContextPath()%>/source/source.jsp?channel=2" id="gl7" class="glink" >ʵ��</a>
    	<a href="<%=request.getContextPath()%>/source/source.jsp?channel=3" id="gl8" class="glink" >�ɹ�չʾ</a>
    </div>
    <!--end globalLinks-->
    <form id="search" action="">
      <input name="searchFor" type="text" size="10" />
      <a href="#">search</a>
    </form>
  </div>
  <div id="subglobal3" class="subglobalNav"> 
  	<a href="<%=request.getContextPath()%>/course/index.jsp?channel=11">�������μ�</a> | 
  	<a href="<%=request.getContextPath()%>/course/index.jsp?channel=12">�о����μ�</a> | 
  	<a href="<%=request.getContextPath()%>/course/index.jsp?channel=13">��������ҵ</a> | 
  	<a href="<%=request.getContextPath()%>/course/index.jsp?channel=14">�о�����ҵ</a> </div>
  <div id="subglobal6" class="subglobalNav"> 
  	<a href="<%=request.getContextPath()%>/question/message.jsp">������</a> | 
  	<a href="<%=request.getContextPath()%>/question/suggestion.jsp">�������</a> </div>
</div>

<!--end pagecell1-->
<br />
<script type="text/javascript">
  <!--
	var menuitem3 = new menu(2,3,"hidden");
	var menuitem6 = new menu(2,6,"hidden");
  // -->
</script>
