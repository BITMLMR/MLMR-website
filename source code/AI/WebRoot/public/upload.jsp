<%@page contentType="text/html; charset=GBK" language="java" %>
<%@include file="check.jsp"%>
<%@page import="AI.service.*"%>
<%@page import="AI.vo.*"%>
<%@page import="java.util.List"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
  	<title>新增资源信息</title>
  	<script language="Javascript1.2">browserControl()</script>
  	<link rel="StyleSheet" href="<%=request.getContextPath()%>/css/dtree.css" type="text/css"/>
  	<script type="text/javascript" src="<%=request.getContextPath()%>/js/dtree.js"></script>
 </head>
 
<style type="text/css">
<!--

#left {
	float: left;
	height: 500px;
	width: 30%;
}
#right {
	float: left;
	height: 500px;
	width: 70%;
}
-->
</style>
 <%
 	//接收类型
	//1表示course课程学习,2表示experiment仿真实验
	//3表示outcome成果展示,4表示source资源共享
	int channel = Integer.parseInt(request.getParameter("channel"));
	//下面是读取数据库中的概念树
	TreeService service = new TreeService();
	List results = service.listAllTree();
%>
<body leftmargin="40">
<!-- 下面是从数据库中读出的树型结构 -->
<div id="left">
	<div class="dtree">
	
		<p><a href="javascript: d.openAll();">open all</a> | <a href="javascript: d.closeAll();">close all</a></p>
	
		<script type="text/javascript">
			<!--
			d = new dTree('d');
			d.add(0,-1,'人工智能');
	
	<%for(int i=0;i<results.size();i++){
		Tree tree  =(Tree)results.get(i);%>
			
			d.add(<%=tree.getTreeId()%>,<%=tree.getParentId()%>,'authority','<%=tree.getTreeId()%>','<%=tree.getTreeName()%>');
		
	<%}%>
			document.write(d);
			
			d.closeAll();
			//-->
		</script>
	
	</div>

</div>

<!-- 下面是即将要上传的文件的基本属性和附件 -->
<div id="right">
	<form name='formUpload' method='post' enctype="multipart/form-data" 
		action='<%=request.getContextPath()%>/servlet/AddSource' onsubmit="return checkForm(this)">
		
		<input type="hidden" name='type' value="0">		<%-- source表示资源共享 --%>
		<input type="hidden" name='legal' value="0">		<%-- 1表示审核通过 --%>
		<input type="hidden" name='tree_id' id='tree_id' value=''>
		<input type="hidden" name='source_author' value='<%=usename %>'>

	<table  align="left"  border=0 width="90%">
	<tr>
		<td colspan="2" align="center"><b>上传资源</b></td>
	</tr>
	<tr>
	 	<td width='90' align='left'><label>资源名称：</label></td>
	 	<td>
	 		<input type="text" id ='source_title' name ='source_title' style="width:100%"></td>
	</tr>
	<tr>
		<td width='90' align="left"><label>资源描述：</label></td>
	 	<td align="center">
	         <textarea name="source_content" style="width:100%; height:80"></textarea>
	 	</td>
	</tr>
	<tr>
		<td width='90' align="left"><label>所属栏目：</label></td>
		<td><select name="channel" onchange="getC()">
				<option value="" selected>请选择</option>
			<%
			gender=(String)session.getAttribute("gender");
			//0-->本科生;1-->研究生
			if(gender=="2"||gender.equals("2")||gender=="9"||gender.equals("9")){
			%>
			    <option value="11" >本科生课件</option>
			    <option value="12">研究生课件</option>
			    <option value="13">本科生作业</option>
			    <option value="14">研究生作业</option>
			    <option value="5">练习题</option>
			<%} %>
			    <option value="4">资源共享</option>
			    <option value="2">实验</option>
			    <option value="3">成果展示</option>
			  </select></td>
	</tr>
	<tr id='typetr' style="display:none ">
		<td width='90' align="left"><label>课件类型：</label></td>
		<td>  
			<label><input type="radio" name="type1" value="1" />使用课件</label>
			<label><input type="radio" name="type2" value="2" />旧课件</label> 
			<label><input type="radio" name="type3" value="3" />参考课件</label> 
		</td>
	</tr>
	
	<tr><td colspan="2"><a href="javascript:addfujian()">添加附件</a></td></tr>
	<tr id='fujian1' style="display: none">
		 <td>附件1:</td>
		 <td id="file1"><input type='file' name='file1' id='file1'>&nbsp;<a href='javascript:deletefujian(file1)'>删除</a></td>
	</tr>
	<tr id='fujian2' style="display: none">
		 <td>附件2:</td>
		 <td id="file2"><input type='file' name='file2' id='file2'>&nbsp;<a href='javascript:deletefujian(file2)'>删除</a></td>
	</tr>
	<tr id='fujian3' style="display: none">
		 <td>附件3:</td>
		 <td id="file3"><input type='file' name='file3' id='file3'>&nbsp;<a href='javascript:deletefujian(file3)'">删除</a></td>
	</tr>
	<tr id='fujian4' style="display: none">
		 <td>附件4:</td>
		 <td id="file4"><input type='file' name='file4' id='file4'>&nbsp;<a href='javascript:deletefujian(file4)'>删除</a></td>
	</tr>
	<tr id='fujian5' style="display: none">
		 <td>附件5:</td>
		 <td id="file5"><input type='file' name='file5' id='file5'>&nbsp;<a href='javascript:deletefujian(file5)'>删除</a></td>
	</tr>
	<tr>
		<td colspan=2 align='center'><input type='submit' value='提交' onclick='tree()'></td> 
	</tr>
	</table>
	</form>
	
</div>	
	
</body>

<script type="text/javascript">
<!--
function tree(){
	var count = 0;
	var obj = document.all.authority;	
	var tree = '';
	//alert(obj.length);
	for(i=0;i<obj.length;i++){
		if(obj[i].checked){					
			//alert(obj[i].value + tree);
			tree = tree+'/'+ obj[i].value+'/';
			count ++;				
		}
	}
	document.getElementById("tree_id").value = tree;
}


//判断是否添了必要信息
function checkForm(form){
	if(isEmpty(formUpload.source_title.value) ){
		alert("请填写资源名称!");
		document.formUpload.source_title.focus();
		return false;
	}
	if(isEmpty(formUpload.channel.value) ){
		alert("请选择上传栏目!");
		document.formUpload.channel.focus();
		return false;
	}
	//alert(document.getElementById("type1").checked);
	if((formUpload.channel.value=='11'||formUpload.channel.value=='12')
	&&document.getElementById("type1").checked==false
	&&document.getElementById("type2").checked==false
	&&document.getElementById("type3").checked==false){
		alert("请选择课件类型!");
		//document.formUpload.type2.focus();
		return false;
	}
	//将课件类型值赋值给type
	if(document.getElementById("type1").checked==true){
		document.getElementById("type").value=document.getElementById("type1").value;
	}
	if(document.getElementById("type2").checked==true){
		document.getElementById("type").value=document.getElementById("type2").value;
	}
	if(document.getElementById("type3").checked==true){
		document.getElementById("type").value=document.getElementById("type3").value;
	}
	//如果不是课件则type值仍为默认值0
	if((formUpload.channel.value!='11'||formUpload.channel.value!='12')){
		document.getElementById("type").value='0';
	}
	return true;
}
function isEmpty(str){
	if(str==null || str.length==0)
		return true;
	else 
		return false;
}

function getC(){ 
	var dtd=document.getElementById("channel"); 
	//alert(dtd.options[dtd.options.selectedIndex].value);//需要设置option的值 
	//alert(dtd.options[dtd.options.selectedIndex].innerHTML);//获得option的显示值 
	if(dtd.options[dtd.options.selectedIndex].value=='11'||dtd.options[dtd.options.selectedIndex].value=='12'){
		typetr.style.display="";
	}else{
		typetr.style.display="none";
	}
}

function addfujian(){
	if(fujian1.style.display=="none"){
		fujian1.style.display="";
	}else if(fujian2.style.display=="none"){
		fujian2.style.display="";
	}else if(fujian3.style.display=="none"){
		fujian3.style.display="";
	}else if(fujian4.style.display=="none"){
		fujian4.style.display="";
	}else if(fujian5.style.display=="none"){
		fujian5.style.display="";
	}else{
		alert("最多允许上传5个附件！");
	}
	
} 

function deletefujian(fujian){
	if(fujian.id=="file1"){
		document.getElementById("file1").innerHTML="<input type='file' name='file1' id='file1'>&nbsp;<a href='javascript:deletefujian(file1)'>删除</a>"; 
		fujian1.style.display="none";
	}else if(fujian.id=="file2"){
		document.getElementById("file2").innerHTML="<input type='file' name='file2' id='file2'>&nbsp;<a href='javascript:deletefujian(file2)'>删除</a>"; 
		fujian2.style.display="none";
	}else if(fujian.id=="file3"){
		document.getElementById("file3").innerHTML="<input type='file' name='file3' id='file3'>&nbsp;<a href='javascript:deletefujian(file3)'>删除</a>"; 
		fujian3.style.display="none";
	}else if(fujian.id=="file4"){
		document.getElementById("file4").innerHTML="<input type='file' name='file4' id='file4'>&nbsp;<a href='javascript:deletefujian(file4)'>删除</a>"; 
		fujian4.style.display="none";
	}else if(fujian.id=="file5"){
		document.getElementById("file5").innerHTML="<input type='file' name='file5' id='file5'>&nbsp;<a href='javascript:deletefujian(file5)'>删除</a>"; 
		fujian5.style.display="none";
	}
}
//-->
</script> 

<script language="javascript1.2">sourceConfig('source_content')</script>

</html> 