<%@page contentType="text/html; charset=GBK" language="java" %>
<%@include file="check.jsp"%>
<%@page import="AI.service.*"%>
<%@page import="AI.vo.*"%>
<%@page import="java.util.List"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
 <head>
	<meta http-equiv="Content-Type" content="text/html; charset=gbk">
  	<title>������Դ��Ϣ</title>
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
 	//��������
	//1��ʾcourse�γ�ѧϰ,2��ʾexperiment����ʵ��
	//3��ʾoutcome�ɹ�չʾ,4��ʾsource��Դ����
	int channel = Integer.parseInt(request.getParameter("channel"));
	//�����Ƕ�ȡ���ݿ��еĸ�����
	TreeService service = new TreeService();
	List results = service.listAllTree();
%>
<body leftmargin="40">
<!-- �����Ǵ����ݿ��ж��������ͽṹ -->
<div id="left">
	<div class="dtree">
	
		<p><a href="javascript: d.openAll();">open all</a> | <a href="javascript: d.closeAll();">close all</a></p>
	
		<script type="text/javascript">
			<!--
			d = new dTree('d');
			d.add(0,-1,'�˹�����');
	
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

<!-- �����Ǽ���Ҫ�ϴ����ļ��Ļ������Ժ͸��� -->
<div id="right">
	<form name='formUpload' method='post' enctype="multipart/form-data" 
		action='<%=request.getContextPath()%>/servlet/AddSource' onsubmit="return checkForm(this)">
		
		<input type="hidden" name='type' value="0">		<%-- source��ʾ��Դ���� --%>
		<input type="hidden" name='legal' value="0">		<%-- 1��ʾ���ͨ�� --%>
		<input type="hidden" name='tree_id' id='tree_id' value=''>
		<input type="hidden" name='source_author' value='<%=usename %>'>

	<table  align="left"  border=0 width="90%">
	<tr>
		<td colspan="2" align="center"><b>�ϴ���Դ</b></td>
	</tr>
	<tr>
	 	<td width='90' align='left'><label>��Դ���ƣ�</label></td>
	 	<td>
	 		<input type="text" id ='source_title' name ='source_title' style="width:100%"></td>
	</tr>
	<tr>
		<td width='90' align="left"><label>��Դ������</label></td>
	 	<td align="center">
	         <textarea name="source_content" style="width:100%; height:80"></textarea>
	 	</td>
	</tr>
	<tr>
		<td width='90' align="left"><label>������Ŀ��</label></td>
		<td><select name="channel" onchange="getC()">
				<option value="" selected>��ѡ��</option>
			<%
			gender=(String)session.getAttribute("gender");
			//0-->������;1-->�о���
			if(gender=="2"||gender.equals("2")||gender=="9"||gender.equals("9")){
			%>
			    <option value="11" >�������μ�</option>
			    <option value="12">�о����μ�</option>
			    <option value="13">��������ҵ</option>
			    <option value="14">�о�����ҵ</option>
			    <option value="5">��ϰ��</option>
			<%} %>
			    <option value="4">��Դ����</option>
			    <option value="2">ʵ��</option>
			    <option value="3">�ɹ�չʾ</option>
			  </select></td>
	</tr>
	<tr id='typetr' style="display:none ">
		<td width='90' align="left"><label>�μ����ͣ�</label></td>
		<td>  
			<label><input type="radio" name="type1" value="1" />ʹ�ÿμ�</label>
			<label><input type="radio" name="type2" value="2" />�ɿμ�</label> 
			<label><input type="radio" name="type3" value="3" />�ο��μ�</label> 
		</td>
	</tr>
	
	<tr><td colspan="2"><a href="javascript:addfujian()">��Ӹ���</a></td></tr>
	<tr id='fujian1' style="display: none">
		 <td>����1:</td>
		 <td id="file1"><input type='file' name='file1' id='file1'>&nbsp;<a href='javascript:deletefujian(file1)'>ɾ��</a></td>
	</tr>
	<tr id='fujian2' style="display: none">
		 <td>����2:</td>
		 <td id="file2"><input type='file' name='file2' id='file2'>&nbsp;<a href='javascript:deletefujian(file2)'>ɾ��</a></td>
	</tr>
	<tr id='fujian3' style="display: none">
		 <td>����3:</td>
		 <td id="file3"><input type='file' name='file3' id='file3'>&nbsp;<a href='javascript:deletefujian(file3)'">ɾ��</a></td>
	</tr>
	<tr id='fujian4' style="display: none">
		 <td>����4:</td>
		 <td id="file4"><input type='file' name='file4' id='file4'>&nbsp;<a href='javascript:deletefujian(file4)'>ɾ��</a></td>
	</tr>
	<tr id='fujian5' style="display: none">
		 <td>����5:</td>
		 <td id="file5"><input type='file' name='file5' id='file5'>&nbsp;<a href='javascript:deletefujian(file5)'>ɾ��</a></td>
	</tr>
	<tr>
		<td colspan=2 align='center'><input type='submit' value='�ύ' onclick='tree()'></td> 
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


//�ж��Ƿ����˱�Ҫ��Ϣ
function checkForm(form){
	if(isEmpty(formUpload.source_title.value) ){
		alert("����д��Դ����!");
		document.formUpload.source_title.focus();
		return false;
	}
	if(isEmpty(formUpload.channel.value) ){
		alert("��ѡ���ϴ���Ŀ!");
		document.formUpload.channel.focus();
		return false;
	}
	//alert(document.getElementById("type1").checked);
	if((formUpload.channel.value=='11'||formUpload.channel.value=='12')
	&&document.getElementById("type1").checked==false
	&&document.getElementById("type2").checked==false
	&&document.getElementById("type3").checked==false){
		alert("��ѡ��μ�����!");
		//document.formUpload.type2.focus();
		return false;
	}
	//���μ�����ֵ��ֵ��type
	if(document.getElementById("type1").checked==true){
		document.getElementById("type").value=document.getElementById("type1").value;
	}
	if(document.getElementById("type2").checked==true){
		document.getElementById("type").value=document.getElementById("type2").value;
	}
	if(document.getElementById("type3").checked==true){
		document.getElementById("type").value=document.getElementById("type3").value;
	}
	//������ǿμ���typeֵ��ΪĬ��ֵ0
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
	//alert(dtd.options[dtd.options.selectedIndex].value);//��Ҫ����option��ֵ 
	//alert(dtd.options[dtd.options.selectedIndex].innerHTML);//���option����ʾֵ 
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
		alert("��������ϴ�5��������");
	}
	
} 

function deletefujian(fujian){
	if(fujian.id=="file1"){
		document.getElementById("file1").innerHTML="<input type='file' name='file1' id='file1'>&nbsp;<a href='javascript:deletefujian(file1)'>ɾ��</a>"; 
		fujian1.style.display="none";
	}else if(fujian.id=="file2"){
		document.getElementById("file2").innerHTML="<input type='file' name='file2' id='file2'>&nbsp;<a href='javascript:deletefujian(file2)'>ɾ��</a>"; 
		fujian2.style.display="none";
	}else if(fujian.id=="file3"){
		document.getElementById("file3").innerHTML="<input type='file' name='file3' id='file3'>&nbsp;<a href='javascript:deletefujian(file3)'>ɾ��</a>"; 
		fujian3.style.display="none";
	}else if(fujian.id=="file4"){
		document.getElementById("file4").innerHTML="<input type='file' name='file4' id='file4'>&nbsp;<a href='javascript:deletefujian(file4)'>ɾ��</a>"; 
		fujian4.style.display="none";
	}else if(fujian.id=="file5"){
		document.getElementById("file5").innerHTML="<input type='file' name='file5' id='file5'>&nbsp;<a href='javascript:deletefujian(file5)'>ɾ��</a>"; 
		fujian5.style.display="none";
	}
}
//-->
</script> 

<script language="javascript1.2">sourceConfig('source_content')</script>

</html> 