<%@ page contentType="text/html;charset=gbk" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>�û�ע��</title>
<%@ include file="../public/meta.jsp"%>
<script src="../js/cun.js" type="text/javascript"></script>
<script type="text/javascript">
//��֤�û���
	var req;//����ȫ�ֱ���req
	//���������������������֤��������֤�û����Ƿ�Ϸ�
	function UserNameCheck()
	{
	var username = document.getElementById('username').value;//��ȡ�ı����ֵ
	//alert(username);
		//ָ�������͵�url��ַ�Ͳ���
         var url = "<%=request.getContextPath()%>/servlet/PreCheckReg?username=" + escape(username);

         if (window.XMLHttpRequest) {

             req = new XMLHttpRequest();//����XMLHttpRequest����

         }else if (window.ActiveXObject) {

             req = new ActiveXObject("Microsoft.XMLHTTP");

         }

        if(req){

            req.open("GET", url, true);//���������������

             req.onreadystatechange = callback;//ָ���ص�����

            req.send(null);        

         }	
	
	}	
	//�ص�����
	function callback() {
	
    if (req.readyState == 4) {//�жϽ��յ�����Ӧ��״̬,�����4��ʾ�������

        if (req.status == 200) {

                 parseMessage();//�յ����������ݺ���н���

                 // update the HTML DOM based on whether or not message is valid

        }else{//��Ӧδ���سɹ�ʱ��ҳ���еĴ���

            alert ("Not able to retrieve description" + req.statusText);

        }       

    }
    else
    {
    	document.getElementById("check_username").innerHTML = "������֤�û���....";
    }
   }
    
   function parseMessage() {//�Է������ݽ��н���
   
    var xmlDoc = req.responseXML.documentElement;//xmlDoc��������Ž��յ���XML��ʽ������
    
    var node = xmlDoc.getElementsByTagName('info');//��ȡXML�����еĽڵ�
    //����<span>����е�HTML����
    document.getElementById('check_username').innerHTML = node[0].firstChild.nodeValue;
    
    
	}
//��֤�û�������
 
//��֤����
   	var req2;//����ȫ�ֱ���req
	//���������������������֤��������֤�û����Ƿ�Ϸ�
	function EmailCheck()
	{
	var email = document.getElementById('email').value;//��ȡ�ı����ֵ
	//alert(username);
		//ָ�������͵�url��ַ�Ͳ���
         var url2 = "<%=request.getContextPath()%>/servlet/PreCheckEmail?email=" + escape(email);

         if (window.XMLHttpRequest) {

             req2 = new XMLHttpRequest();//����XMLHttpRequest����

         }else if (window.ActiveXObject) {

             req2 = new ActiveXObject("Microsoft.XMLHTTP");

         }

        if(req2){

            req2.open("GET", url2, true);//���������������

             req2.onreadystatechange = callback2;//ָ���ص�����

            req2.send(null);        

         }	
	
	}	
	//�ص�����
	function callback2() {
	
    if (req2.readyState == 4) {//�жϽ��յ�����Ӧ��״̬,�����4��ʾ�������

        if (req2.status == 200) {

                 parseMessage2();//�յ����������ݺ���н���

                 // update the HTML DOM based on whether or not message is valid

        }else{//��Ӧδ���سɹ�ʱ��ҳ���еĴ���

            alert ("Not able to retrieve description" + req2.statusText);

        }       

    }
    else
    {
    	document.getElementById("check_email").innerHTML = "������֤����....";
    }
   }
   
   
   function parseMessage2() {//�Է������ݽ��н���
   
    var xmlDoc = req2.responseXML.documentElement;//xmlDoc��������Ž��յ���XML��ʽ������
    
    var node = xmlDoc.getElementsByTagName('info');//��ȡXML�����еĽڵ�
    //����<span>����е�HTML����
    document.getElementById('check_email').innerHTML = node[0].firstChild.nodeValue;
	}
//��֤�������	
	
	function Form_Submit()
	{
		if(regForm.username.value=="")//���û����Ƿ�Ϊ�ս�����֤
		{
		 alert("�û�������Ϊ��!");
		 return false;
		}
		else if(regForm.password.value=="")//�������Ƿ�Ϊ�ս�����֤
		{
		 alert("���벻��Ϊ��!");
		 return false;
		}
		else if(regForm.password.value!=regForm.repassword.value)//��֤��������������Ƿ�ƥ��
		{
		alert("������������벻һ��!");
		 return false;
		}
		regForm.submit();//�ύ��
	}
	
	</script>
</head>

<body>
<div class="bodymain">

	<%@include file="../public/top.jsp"%>
		<div id="pagecell1">
		<div id="main">
<!--�������ݿ�ʼ,���Ĵ��벿��-->

	<form name="regForm" method="post" onsubmit="return checkForm(this)"
	action="<%=request.getContextPath()%>/servlet/Register">
	<table width="80%"  border="0" align="center" cellpadding="2" cellspacing="0" >
	<caption>
	<font color="blue" style="font-size: 20px">�û�ע��</font><br/></caption>
	
	  <tr bgcolor="#EFEFEF">
	    <td width="25%" align="right">*&nbsp;�û���:</td>
	    <td width="75%" colspan="2" valign="bottom">
	      <input name="username" type="text" id="username" size="20" maxlength="50" onBlur="UserNameCheck()"/>
	      <span id="check_username"></span></td>
	  </tr>

	  
	  <tr><td>�ܡ���:</td>
	    <td><input name="password" type="password" id="password" size="20" maxlength="50"/></td>
	    <td>*(���볤��Ϊ6��16λ��������ĸ��Сд����¼�����������ĸ�����֡������ַ���ɡ�)</td>
	  </tr>
	  
	  <tr bgcolor="#EFEFEF">
	    <td height="40" valign="middle">����ȷ��:</td>
	    <td><input name="confirmPassword" type="password" id="confirmPassword" size="20" maxlength="50"/></td>
	    <td>*(������һ�飬�Ա�ȷ�ϣ�) </td>
	  </tr>
	  
	  <tr><td valign="middle">�����ʼ�:</td>
	    <td><input name="email" type="text" size="20" maxlength="50" onBlur="EmailCheck()"/></td>
	    <td><span id="check_email"></span>*(����������ȷ��E-mail��ַ��<font color="#cc0000">�������������ѯ</font>��)</td>
	  </tr>
	  
	  <tr bgcolor="#EFEFEF"><td align="right">�� ��:</td>
	    <td colspan="2"><p> <label><input type="radio" name="gender" value="0" checked/>������</label>
	        <label><input type="radio" name="gender" value="1"/>�о���</label>
	        <label><input type="radio" name="gender" value="2"/>��ʦ</label><br/>
	    </p></td>
	  </tr>
	  
	  <tr>
	    <td align="right" valign="middle"><div align="right">������ʾ����:</div></td>
	    <td ><input name="question" type="text" size="20" maxlength="50"/></td>
	    <td>*(�ʺ���֤�Լ����ڰ����һ����룡)</td>
	  </tr>
	  
	  <tr bgcolor="#EFEFEF">
	    <td valign="middle"><div align="right">��ʾ�����:</div></td>
	    <td ><input name="answer" type="text"  size="20" maxlength="50"/></td>
	    <td bgcolor="#EFEFEF">*(�һ�����Ĵ𰸣�)</td>
	  </tr>
	  
	  <tr>
	    <td align="right">�� ��:</td>
	    <td><input name="realName" type="text"id="realName" size="20" maxlength="50"/></td>
	    <td>&nbsp;</td>
	  </tr>
	  
	  <tr>
	    <td colspan="3" align="center">
	      <input type="submit" name="Submit" value="�ύ"/>
	      <input type="button" name="Submit2" value="��¼" onclick="javascript:window.location='login.jsp'"/>
		</td>
	  </tr>
	</table>
	</form>
		</div>
<!--�������ݹر�-->
	 <%@include file="../public/bottom.jsp"%>
	 </div>
	 
<!--body�ر�-->
</div>

<script language="JavaScript">
	function checkForm(form){
		if(isEmpty(form.username.value) || isEmpty(form.password.value) 
		|| isEmpty(form.confirmPassword.value) || isEmpty(form.email.value) 
		|| isEmpty(form.question.value) || isEmpty(form.answer.value) ){
			alert("�뽫��������д����!");
			return false;
		}
		if(form.password.value!=form.confirmPassword.value){
			alert("�������벻ƥ��!");
			return false;
		}
		if(form.password.value.length<6 || form.password.value.length>16){
			alert("���볤�Ȳ�������6���ַ������ö���16���ַ���");
			return false;
		}
		return true;
	}
	function isEmpty(str){
		if(str==null || str.length==0)
			return true;
		else 
			return false;
	}
</script>
</body>
</html>


