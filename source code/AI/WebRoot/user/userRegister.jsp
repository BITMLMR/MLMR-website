<%@ page contentType="text/html;charset=gbk" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>用户注册</title>
<%@ include file="../public/meta.jsp"%>
<script src="../js/cun.js" type="text/javascript"></script>
<script type="text/javascript">
//验证用户名
	var req;//定义全局变量req
	//函数用来向服务器发送验证请求，来验证用户名是否合法
	function UserNameCheck()
	{
	var username = document.getElementById('username').value;//获取文本框的值
	//alert(username);
		//指定请求发送的url地址和参数
         var url = "<%=request.getContextPath()%>/servlet/PreCheckReg?username=" + escape(username);

         if (window.XMLHttpRequest) {

             req = new XMLHttpRequest();//建立XMLHttpRequest对象

         }else if (window.ActiveXObject) {

             req = new ActiveXObject("Microsoft.XMLHTTP");

         }

        if(req){

            req.open("GET", url, true);//向服务器发送请求

             req.onreadystatechange = callback;//指定回调函数

            req.send(null);        

         }	
	
	}	
	//回调函数
	function callback() {
	
    if (req.readyState == 4) {//判断接收到的响应的状态,如果是4表示加载完毕

        if (req.status == 200) {

                 parseMessage();//收到服务器数据后进行解析

                 // update the HTML DOM based on whether or not message is valid

        }else{//响应未加载成功时，页面中的代码

            alert ("Not able to retrieve description" + req.statusText);

        }       

    }
    else
    {
    	document.getElementById("check_username").innerHTML = "正在验证用户名....";
    }
   }
    
   function parseMessage() {//对返回数据进行解析
   
    var xmlDoc = req.responseXML.documentElement;//xmlDoc变量来存放接收到的XML格式的数据
    
    var node = xmlDoc.getElementsByTagName('info');//获取XML数据中的节点
    //设置<span>标记中的HTML代码
    document.getElementById('check_username').innerHTML = node[0].firstChild.nodeValue;
    
    
	}
//验证用户名结束
 
//验证邮箱
   	var req2;//定义全局变量req
	//函数用来向服务器发送验证请求，来验证用户名是否合法
	function EmailCheck()
	{
	var email = document.getElementById('email').value;//获取文本框的值
	//alert(username);
		//指定请求发送的url地址和参数
         var url2 = "<%=request.getContextPath()%>/servlet/PreCheckEmail?email=" + escape(email);

         if (window.XMLHttpRequest) {

             req2 = new XMLHttpRequest();//建立XMLHttpRequest对象

         }else if (window.ActiveXObject) {

             req2 = new ActiveXObject("Microsoft.XMLHTTP");

         }

        if(req2){

            req2.open("GET", url2, true);//向服务器发送请求

             req2.onreadystatechange = callback2;//指定回调函数

            req2.send(null);        

         }	
	
	}	
	//回调函数
	function callback2() {
	
    if (req2.readyState == 4) {//判断接收到的响应的状态,如果是4表示加载完毕

        if (req2.status == 200) {

                 parseMessage2();//收到服务器数据后进行解析

                 // update the HTML DOM based on whether or not message is valid

        }else{//响应未加载成功时，页面中的代码

            alert ("Not able to retrieve description" + req2.statusText);

        }       

    }
    else
    {
    	document.getElementById("check_email").innerHTML = "正在验证邮箱....";
    }
   }
   
   
   function parseMessage2() {//对返回数据进行解析
   
    var xmlDoc = req2.responseXML.documentElement;//xmlDoc变量来存放接收到的XML格式的数据
    
    var node = xmlDoc.getElementsByTagName('info');//获取XML数据中的节点
    //设置<span>标记中的HTML代码
    document.getElementById('check_email').innerHTML = node[0].firstChild.nodeValue;
	}
//验证邮箱结束	
	
	function Form_Submit()
	{
		if(regForm.username.value=="")//对用户名是否为空进行验证
		{
		 alert("用户名不能为空!");
		 return false;
		}
		else if(regForm.password.value=="")//对密码是否为空进行验证
		{
		 alert("密码不能为空!");
		 return false;
		}
		else if(regForm.password.value!=regForm.repassword.value)//验证两次输入的密码是否匹配
		{
		alert("两次输入的密码不一致!");
		 return false;
		}
		regForm.submit();//提交表单
	}
	
	</script>
</head>

<body>
<div class="bodymain">

	<%@include file="../public/top.jsp"%>
		<div id="pagecell1">
		<div id="main">
<!--主题内容开始,您的代码部分-->

	<form name="regForm" method="post" onsubmit="return checkForm(this)"
	action="<%=request.getContextPath()%>/servlet/Register">
	<table width="80%"  border="0" align="center" cellpadding="2" cellspacing="0" >
	<caption>
	<font color="blue" style="font-size: 20px">用户注册</font><br/></caption>
	
	  <tr bgcolor="#EFEFEF">
	    <td width="25%" align="right">*&nbsp;用户名:</td>
	    <td width="75%" colspan="2" valign="bottom">
	      <input name="username" type="text" id="username" size="20" maxlength="50" onBlur="UserNameCheck()"/>
	      <span id="check_username"></span></td>
	  </tr>

	  
	  <tr><td>密　码:</td>
	    <td><input name="password" type="password" id="password" size="20" maxlength="50"/></td>
	    <td>*(密码长度为6～16位，区分字母大小写。登录密码可以由字母、数字、特殊字符组成。)</td>
	  </tr>
	  
	  <tr bgcolor="#EFEFEF">
	    <td height="40" valign="middle">密码确认:</td>
	    <td><input name="confirmPassword" type="password" id="confirmPassword" size="20" maxlength="50"/></td>
	    <td>*(请再输一遍，以便确认！) </td>
	  </tr>
	  
	  <tr><td valign="middle">电子邮件:</td>
	    <td><input name="email" type="text" size="20" maxlength="50" onBlur="EmailCheck()"/></td>
	    <td><span id="check_email"></span>*(请您输入正确的E-mail地址！<font color="#cc0000">方便您的密码查询</font>！)</td>
	  </tr>
	  
	  <tr bgcolor="#EFEFEF"><td align="right">身 份:</td>
	    <td colspan="2"><p> <label><input type="radio" name="gender" value="0" checked/>本科生</label>
	        <label><input type="radio" name="gender" value="1"/>研究生</label>
	        <label><input type="radio" name="gender" value="2"/>老师</label><br/>
	    </p></td>
	  </tr>
	  
	  <tr>
	    <td align="right" valign="middle"><div align="right">密码提示问题:</div></td>
	    <td ><input name="question" type="text" size="20" maxlength="50"/></td>
	    <td>*(帐号验证以及用于帮你找回密码！)</td>
	  </tr>
	  
	  <tr bgcolor="#EFEFEF">
	    <td valign="middle"><div align="right">提示问题答案:</div></td>
	    <td ><input name="answer" type="text"  size="20" maxlength="50"/></td>
	    <td bgcolor="#EFEFEF">*(找回密码的答案！)</td>
	  </tr>
	  
	  <tr>
	    <td align="right">昵 称:</td>
	    <td><input name="realName" type="text"id="realName" size="20" maxlength="50"/></td>
	    <td>&nbsp;</td>
	  </tr>
	  
	  <tr>
	    <td colspan="3" align="center">
	      <input type="submit" name="Submit" value="提交"/>
	      <input type="button" name="Submit2" value="登录" onclick="javascript:window.location='login.jsp'"/>
		</td>
	  </tr>
	</table>
	</form>
		</div>
<!--主题内容关闭-->
	 <%@include file="../public/bottom.jsp"%>
	 </div>
	 
<!--body关闭-->
</div>

<script language="JavaScript">
	function checkForm(form){
		if(isEmpty(form.username.value) || isEmpty(form.password.value) 
		|| isEmpty(form.confirmPassword.value) || isEmpty(form.email.value) 
		|| isEmpty(form.question.value) || isEmpty(form.answer.value) ){
			alert("请将必填项填写完整!");
			return false;
		}
		if(form.password.value!=form.confirmPassword.value){
			alert("两次密码不匹配!");
			return false;
		}
		if(form.password.value.length<6 || form.password.value.length>16){
			alert("密码长度不得少于6个字符，不得多于16个字符！");
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


