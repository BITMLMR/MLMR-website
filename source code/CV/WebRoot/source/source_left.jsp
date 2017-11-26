<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@page import="CV.service.*"%>
<%@page import="CV.vo.*"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat" %>
<link href="/css/common.css" rel="stylesheet" type="text/css">
<link rel="StyleSheet" href="../css/dtree.css" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dtree.js"></script>
 <%
	//获取频道编号channel
	String channel = request.getParameter("channel");
	//下面是读取数据库中的概念树
	TreeService service = new TreeService();
	List results = service.listAllTree();
%>
<!-- 下面是从数据库中读出的树型结构 -->
<div id="left">
	<div class="dtree">
	
		<p><a href="javascript: d.openAll();">打开所有</a> | <a href="javascript: d.closeAll();">关闭所有</a></p>
	
		<script type="text/javascript">
			<!--
			d = new dTree('d');
			d.add(0,-1,'计算机视觉','','','','','source_right.jsp?channel=<%=channel%>','查看资源','source_right');
	
	<%for(int i=0;i<results.size();i++){
		Tree tree  =(Tree)results.get(i);%>
			
			d.add(<%=tree.getTreeId()%>,<%=tree.getParentId()%>,'<%=tree.getTreeName()%>','<%=tree.getTreeId()%>','<%=tree.getTreeName()%>','','','source_right.jsp?channel=<%=channel%>&tid=<%=tree.getTreeId()%>','查看资源','source_right');
		
	<%}%>
			document.write(d);
			
			d.closeAll();
			//-->
		</script>
	
	</div>

</div>

