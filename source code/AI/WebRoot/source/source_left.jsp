<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@page import="AI.service.*"%>
<%@page import="AI.vo.*"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat" %>
<link href="/css/common.css" rel="stylesheet" type="text/css">
<link rel="StyleSheet" href="../css/dtree.css" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/js/dtree.js"></script>
 <%
	//��ȡƵ�����channel
	String channel = request.getParameter("channel");
	//�����Ƕ�ȡ���ݿ��еĸ�����
	TreeService service = new TreeService();
	List results = service.listAllTree();
%>
<!-- �����Ǵ����ݿ��ж��������ͽṹ -->
<div id="left">
	<div class="dtree">
	
		<p><a href="javascript: d.openAll();">open all</a> | <a href="javascript: d.closeAll();">close all</a></p>
	
		<script type="text/javascript">
			<!--
			d = new dTree('d');
			d.add(0,-1,'�˹�����','','','','','source_right.jsp?channel=<%=channel%>','�鿴��Դ','source_right');
	
	<%for(int i=0;i<results.size();i++){
		Tree tree  =(Tree)results.get(i);%>
			
			d.add(<%=tree.getTreeId()%>,<%=tree.getParentId()%>,'<%=tree.getTreeName()%>','<%=tree.getTreeId()%>','<%=tree.getTreeName()%>','','','source_right.jsp?channel=<%=channel%>&tid=<%=tree.getTreeId()%>','�鿴��Դ','source_right');
		
	<%}%>
			document.write(d);
			
			d.closeAll();
			//-->
		</script>
	
	</div>

</div>

