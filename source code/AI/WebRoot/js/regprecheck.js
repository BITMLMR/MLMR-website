// Title: regPreCheck
// Description: 提前检验用户名是否已近存在
// URL: 
// Version: 1.0
// Date: 09-01-2010 (mm-dd-yyyy)
// Contact: yangali@bit.edu.cn (specify product title in the subject)
// Notes: 
//

	var req;//定义全局变量req
	//函数用来向服务器发送验证请求，来验证用户名是否合法
	function UserNameCheck()
	{
	var username = document.getElementById('usename').value;//获取文本框的值

         var url = "pre?user_name=" + escape(username);//指定请求发送的url地址和参数

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