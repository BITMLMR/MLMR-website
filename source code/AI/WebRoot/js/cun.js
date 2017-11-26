jQuery(function($){
		
		$(".formtable").attr("align","center");
		$(".formtable").css("margin","auto");
		$(".formtable tr td").find("input").attr("style","width:220px;height:22px;");	
		var trs =  $(".formtable tr");	
		
		
		trs.each(function(i){
				$(this).find("td:eq(0)").attr("style","width:70px;text-align:right;valign:middle");
				$(this).find("td:eq(2)").attr("style","text-align:left;valign:middle");
				$(this).find("td:eq(2)").find("input").attr("style","width:220px;height:22px;valign:middle");				
				$(this).find("td:eq(1)").css("width","5px");
				$(this).find("td:eq(1)").find("label").append("*").attr("style","color:red;");;
				
		})
		$(".formtable tr:eq(5)").find("td:eq(2)").find("input").css("width","20px");

$("#servItems").attr("style","width:12px;");	
$(".btn-submit").attr("style","width:117px;height:45px;");		
}

)

//打开服务条款
function openServiceItems(){
	/*
	domain=$("#domain").val();
	url="163_serviceitems.htm";
	if(domain=="@163.com")
		url="163_serviceitems.htm";
	else if(domain=="@126.com")
		url="126_serviceitems.htm";
	else if(domain=="@yeah.net")
		url="yeah_serviceitems.htm";
	*/
	url="CASS.htm";
	window.open(url,'regconfirm','height=620,width=850,toolbar=no,menubar=no,scrollbars=no,resizable=no,location=no,status=no');
	return true;
}



/*检查用户名*/
function chkUsername() {
	var username = $.trim($("#inp_uname").val());
	if(username=="") {
		return 0;
	}
	else if( /^\d.*$/.test( username ) ){
		//用户名不能以数字开头
		return -1;
	}
	else if(fLen( username )<6 || fLen( username )>26 ){
		//合法长度为6-26个字符
		return -2;
	}
	else if(! /^\w+$/.test( username ) ){
		//用户名只能包含_,英文字母，数字
		return -3;
	}
	else if(! /^([a-z]|[A-Z])[0-9a-zA-Z_]+$/.test( username ) ){
		//用户名只能英文字母开头
		return -4;
	}
	else if(!(/[0-9a-zA-Z]+$/.test( username ))){
		//用户名只能英文字母或数字结尾
		return -5;
	} else if(checkUserByAjax(username) == 1) {
		//用户名必须不能重复
		return -6;
	}
	return 1;
}
//通过ajax验证
function checkUserByAjax(username) {
	$.ajax({
           type: "post",
           dataType: "text",
           url: "user.do",
           data: "method=checkUserName&userName=" + username,
           timeout: 2000,
           error: function(){
           },
           complete :function(){
           		$("#load").hide();
           },
           success: function(data){
           	if(data == '1')
           		$("#div_uname_err").show();
           }
   });
}

var replacement = unescape('%u25CF');
function getpass(passin,passstore)
{
	var passwd=document.getElementById(passstore);
	var strin=passin.value;
	var strcache=passwd.value;
	var password="";
	var strout="";
	for(i=0;i<strin.length;i++)
	{
		switch(strin.charAt(i))
		{
			case replacement:
				password+=strcache.charAt(i)==""?strin.charAt(i):strcache.charAt(i);
				break;
			default:
				password+=strin.charAt(i);
				break;			
		}
		strout+=replacement;
	}
	passwd.value=password;
	passin.value=strout;
}

//计算字符数，一个中文2个字符
function fLen(Obj){
  var nCNLenth = 0;
  var nLenth = Obj.length;
  for (var i=0; i<nLenth; i++){
    if(Obj.charCodeAt(i)>255){
      nCNLenth += 2; 
    }else{
      nCNLenth++;
    }
  }
  return nCNLenth;
}

function chkPassword(){
	password= $("#pwd").val();
	if(password == "") return 0;
	var len;
	var i;
	var isPassword = true;
	len = 0;
	for (i=0;i<password.length;i++){
		if (password.charCodeAt(i)>255) isPassword = false;
	}
	if(!isPassword || password.length > 16 || password.length < 6)
		return -1;
	
	return 1;
}

/**
 * 显示密码强弱
 * @return
 */
function chkPasswordStrong(me) {
	//恢复重复输入密码状态
	$("#div_passwordconfirm_err").hide();
	$("#passwordconfirm").attr("class","inp ipt-normal");
	$("#passwordconfirm_ico_ok").hide();
	$("#passwordconfirm_ico_err").hide();
	//-----
	$("#password_ico_ok").hide();
	$("#password_ico_err").hide();
	
	$("#div_password_err").hide();
	$("#div_password_err_info").html("");
	
	$("#password").attr("class","inp ipt-normal");
	//打开密码提示内容div
	$("#div_password_rule").show();
	var csint = checkStrong(me);
	$("#div_passowrd_Strong").attr("class","bar state"+csint);
}


function CharMode(iN){ 
	if (iN>=48 && iN <=57) //数字 
	return 1; 
	if (iN>=65 && iN <=90) //大写字母 
	return 2; 
	if (iN>=97 && iN <=122) //小写 
	return 4; 
	else 
	return 8; //特殊字符 
} 

function chkPasswordconfirm(){
	var password= $("#pwd").val();
	var passwordconfirm = $("#pwdcfm").val();
	
	if(password != passwordconfirm){
		$("#div_passwordconfirm_err").show();
		$("#passwordconfirm").attr("class","inp ipt-error");
		$("#passwordconfirm_ico_ok").hide();
		$("#passwordconfirm_ico_err").show();
		$("#div_passwordconfirm_err_info").show();
		$("#div_passwordconfirm_err_info").html("两次密码输入不一致");
		return false;
	}
	else if(passwordconfirm==''){
		$("#div_passwordconfirm_err").hide();
		$("#passwordconfirm").attr("class","inp ipt-normal");
		$("#passwordconfirm_ico_ok").hide();
		$("#passwordconfirm_ico_err").show();
		$("#div_passwordconfirm_err_info").hide();
		$("#div_passwordconfirm_err_info").html("确认密码不能为空");
		return false;
	}
	else {
		$("#div_passwordconfirm_err").hide();
		$("#passwordconfirm").attr("class","inp ipt-normal");
		
		$("#passwordconfirm_ico_err").hide();
		if($("#password_ico_err").is(":visible")){
			$("#passwordconfirm_ico_ok").hide();
		}
		else $("#passwordconfirm_ico_ok").show();
	}
	return true;
}

//bitTotal函数 
//计算出当前密码当中一共有多少种模式 
function bitTotal(num){
	modes=0; 
	for (i=0;i<4;i++){ 
		if (num & 1) modes++; 
		num>>>=1; 
	} 
	return modes; 
} 

//checkStrong函数 
//返回密码的强度级别 
function checkStrong(sPW){
	Modes=0; 
	for (i=0;i<sPW.length;i++){ 
	
		//测试每一个字符的类别并统计一共有多少种模式. 
		Modes|=CharMode(sPW.charCodeAt(i)); 
	} 
	return bitTotal(Modes);
}
/**
 * 获取事件
 * @param e
 * @return
 */
function fGetEvent (e) {
	var ev = e || window.event;
	
	if (!ev) {
		var aCaller = [];
		var c = fGetEvent.caller;
		while (c) {
			ev = c.arguments[0];
			if (ev && Event == ev.constructor) {
				break;
			}
			
			var b = false;
			for(var i=0;i<aCaller.length;i++){
				if(c == aCaller[i]){
					b = true;
					break;
				}
			}
			if(b){
				break;
			}else{
				aCaller.push(c);
			}
			c = c.caller;
		}
	}

	return ev;
}
function chkEmail(){
	email=$.trim($("#email").val());
	var zcemail =/^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
	if(email=="") return 0;
	if(zcemail.test(email))
		return 1;
	return -1;
}

function chkAuthcode(){
	authcode=$.trim($("#authcode").val());
	if(authcode=="") return 0;
	return 1;
}
$(document).ready(function(){
	/* ----------- 用户名输入框事件 ----------- */
	$("#inp_uname").bind("focus", function(){
		
		var ret=chkUsername();
		
		$("#inp_uname").attr("class","inp ipt-focus");
		if(ret==0){
			//用户名输入框为空,显示规则
			$("#inp_uname").attr("class","inp ipt-normal");
			$("#div_uname_err_info").show();
			$("#div_uname_err").hide();
			$("#div_uname_rule").show();
			if($("#password_ico_err").is(":visible")){
				$("#div_password_err").hide();
			}
		}
		return false;
});
	
	
	
$("#inp_uname").bind("blur", function(){
		
		var ret=chkUsername();
		if(ret>0) {
			if($("#inp_uname").val()==$("#tmp").val()) return false;
			$("#inp_uname").attr("class","inp ipt-focus");
			$("#div_uname_rule").hide();
			$("#uname_ico_err").hide();
			//$("#uname_ico_ok").hide();
			$("#div_uname_err").hide();
			$("#div_uname_err_info").show();
			
			//setUsername($("#inp_uname").val());
			//doParameterRequest('chkUname.jsp','inp_uname','domain');
			//url="chkUname.jsp?username="+$.trim($("#inp_uname").val())+"&domain="+$.trim($("#domain").val());
			//doRequest(url);
		}
		else if(ret==0){
		  //用户名输入框为空,显示规则
			$("#tmp").attr("value","");
			$("#inp_uname").attr("class","inp ipt-normal");
			$("#div_uname_rule").hide();
			$("#div_uname_err").hide();
			$("#uname_ico_err").hide();
			//$("#uname_ico_ok").hide();
			$("#tr_chk_username_result").hide();
		
		}
		else {
			$("#tmp").attr("value","");
			$("#tr_chk_username_result").hide();
			//更改用户名标签样式
			$("#inp_uname").attr("class","inp ipt-error");
			//显示错误提示图标
			$("#uname_ico_err").show();
			//隐藏正常提示内容div
			$("#div_uname_rule").hide();
			//打开用户名检查错误div
			$("#div_uname_err").show();
			if(ret == -1){
				//显示具体的错误内容
				$("#div_uname_err_info").html("用户名不能以数字开头");
			} else if(ret == -2){
				$("#div_uname_err_info").html("合法长度为6-26个字符");
			} else if(ret == -3){
				$("#div_uname_err_info").html("用户名只能包含_,英文字母,数字 ");
			} else if(ret == -4){
				$("#div_uname_err_info").html("用户名只能英文字母开头");
			} else if(ret == -5){
				$("#div_uname_err_info").html("用户名只能英文字母或数字结尾");
			} else if(ret == -6) {
				$("#div_uname_err_info").html("您填写的用户名已经被占用，请重新输入");
			}
		}
		
		if($("#password_ico_err").is(":visible")){
			$("#div_password_err").show();
		}
		return false;
	});
	
	$("#inp_uname").bind("keydown", function(event){
		//event = fGetEvent();
		if (event.keyCode == 13) { 
			if(event.preventDefault) {    
		        // Firefox    
				event.preventDefault();    
				event.stopPropagation();    
		     } else {    
		        // IE    
		    	 event.cancelBubble=true;    
		    	 event.returnValue = false;    
		     }  
			$("#inp_uname").blur();
		}
		return true;
	});
		/** --------- end ------------ */
		/** ----------- 密码输入框事件 ----------- */
	$("#password").bind("focus", function(){
		//check account radio
		/*if($("input[name='rdAccount'][checked]").val()==undefined){
			//$("#div_chose_uname").attr("class","chose-list notice");
		}*/
		
		ret = chkPassword();
		$("#password").attr("class","inp ipt-focus");
		if(ret==0){
			if($("#password_ico_err").is(":visible")){
				$("#div_password_err").hide();
				$("#password_ico_err").hide();
			}
			$("#div_password_rule").show();
			//恢复重复输入密码状态
			$("#div_passwordconfirm_err").hide();
			$("#passwordconfirm").attr("class","inp ipt-normal");
			$("#passwordconfirm").attr("value","");
			$("#passwordconfirm_ico_ok").hide();
			$("#passwordconfirm_ico_err").hide();
		}
		else if(ret>0) {
			chkPasswordStrong($("#pwd").val());
		}
		
		return false;
	});
	$("#password").bind("blur", function(){
		ret = chkPassword();
		if(ret>0){
			
			$("#password").attr("class","inp ipt-normal");
			$("#password_ico_ok").show();
			$("#password_ico_err").hide();
			$("#div_password_rule").hide();
			$("#div_password_err").hide();
			$("#div_password_err_info").html("");
		}
		else {
			if(ret==0){
			$("#password").attr("class","inp ipt-normal");
			$("#password_ico_ok").hide();
			$("#password_ico_err").hide();
			$("#div_password_rule").hide();
			$("#div_password_err").hide();
			$("#div_password_err_info").html("");
		}
		else if(ret==-1){
			$("#password").attr("class","inp ipt-error");
			$("#password_ico_ok").hide();
			$("#password_ico_err").show();
			$("#div_password_rule").hide();
			$("#div_password_err").show();
			$("#div_password_err_info").html("请输入6～16位字符的密码");
			
		}
		}
		return false;
	});
	$("#password").bind("keyup", function(){
		getpass(this,'pwd');
		$("#passwordconfirm").attr("value","");
		//检查密码强度
		chkPasswordStrong($("#pwd").val());
		return false;
	});
	
	$("#passwordconfirm").bind("blur",function(){
		$("#passwordconfirm").attr("class","inp ipt-normal");
		
		return chkPasswordconfirm();
	}
	);
	/** --------- end ------------ */
	/** ----------- 电子邮箱事件 ----------- */
	$("#email").bind("focus",function(){
		$("#email").attr("class","inp ipt-focus");
		$("#email_ico_err").hide();
		$("#email_ico_ok").hide();
		//$("#div_email_err").hide();
		$("#div_email_err").show();
		$("#div_email_err").attr("class","info-pop");
		$("#div_email_err_info").html("如果遗忘密码可用电子邮件找回");
		return false;
	});
	$("#email").bind("blur",function(){
		ret=chkEmail();
		if(ret==0){
			$("#email").attr("class","inp ipt-normal");
			$("#email_ico_err").hide();
			$("#email_ico_ok").hide();
			$("#div_email_err").hide();
		}
		else if(ret<0){
			$("#email").attr("class","inp ipt-error");
			$("#email_ico_ok").hide();
			$("#email_ico_err").show();
			$("#div_email_err").show();
			$("#div_email_err").attr("class","info-pop I-error");
			$("#div_email_err_info").html("输入电子邮件格式有错误");
		}
		else {
			$("#email").attr("class","inp ipt-normal");
			$("#email_ico_err").hide();
			$("#email_ico_ok").show();
			$("#div_email_err").hide();
		}
		return false;
	}
	);
	/** --------- end ------------ */
	
	/** 检查验证码 */
	
	$("#authcode").bind("blur",function(){
		ret=chkAuthcode();
		if(ret<1){
			ok=false;
			$("#authcode").attr("class","inp ipt-error");
			//$("#authcode_ico_ok").hide();
			$("#authcode_ico_err").show();
			$("#div_authcode_err").show();
			$("#div_authcode_err_info").html("验证码不能为空");
		}else if(ret>0){
			ok=true;
			$("#authcode_ico_ok").show();
			$("#authcode_ico_err").hide();
			$("#div_authcode_err").hide();
			$("#div_authcode_err_info").html("");
		}
		
		//if(ok) doFormRequest('create.jsp','regform');
		/*if(ok) {
			//$("#reqtime").attr("value",(new Date()).getTime());
			var crypt = hex_md5($("#username").val()+$("#pwd").val()+$("#birthday").val()).toLowerCase();
			$("#crypt").attr("value",crypt);
			doParameterRequest('create.jsp','authcode','birthday','domain','from','mobile','password','passwordconfirm','secanswer','secproblem','username','gender','crypt','reqtime');
		}*/
		//*else document.body.scrollTop=212;
		//else document.documentElement.scrollTop = 212;
	
		return ok;
		
		})

})

function doRegFormSubmit(){
	if($("#servItems").attr("checked") != true){
		alert("您还没有阅读服务条款!");
		return false;
	}
	ok = true;
	
/*	var rdAccount=document.getElementsByName("rdAccount");
	var a=0;
	for(i=0;i<rdAccount.length;i++){
		if(rdAccount[i].checked) a=1;
	}
	if(a==0){
		alert("请输入用户名!");
		return false;
	}
	*/
	ret = chkUsername();
	if(ret<1) {
		ok = false;
		$("#tr_chk_username_result").hide();
		//更改用户名标签样式
		$("#inp_uname").attr("class","inp ipt-error");
		//显示错误提示图标
		$("#uname_ico_err").show();
		//隐藏正常提示内容div
		$("#div_uname_rule").hide();
		//打开用户名检查错误div
		$("#div_uname_err").show();
		if(ret == 0){
			$("#div_uname_err_info").html("用户名不能为空");
		}
		else if(ret == -1){
			//显示具体的错误内容
			
			$("#div_uname_err_info").html("用户名不能以数字开头");
		}
		else if(ret == -2){
			$("#div_uname_err_info").html("合法长度为6-26个字符");
		}
		else if(ret == -3){
			$("#div_uname_err_info").html("由数字、26个英文字母或者下划线组成的字符串 ");
		}
		else if(ret == -4){
			$("#div_uname_err_info").html("用户名只能包含_,英文字母,数字");
		}
	}
	//用户处理
	$.ajax({
           type: "post",
           dataType: "text",
           url: "user.do",
           data: "method=checkUserName&userName=" + username,
           timeout: 2000,
           error: function(){
           },
           complete :function(){
           		$("#load").hide();
           },
           success: function(data){
           	if(data == '1') {
           		$("#div_uname_err").show();
           		ok = false;	
           	}
           }
   	});
	alert(ok);
	ret = chkPassword();
	if(ret<1){
		ok=false;
		$("#password").attr("class","inp ipt-error");
		$("#password_ico_ok").hide();
		$("#password_ico_err").show();
		$("#div_password_rule").hide();
		$("#div_password_err").show();
		$("#div_password_err_info").html("请输入6～16位字符的密码");
	}
	
	
	
	else {
		if(!chkPasswordconfirm()){
			ok=false;
			$("#div_passwordconfirm_err").show();
			$("#passwordconfirm").attr("class","inp ipt-error");
			$("#passwordconfirm_ico_ok").hide();
			$("#passwordconfirm_ico_err").show();
		}
		else if($.trim($("#pwd").val())==$.trim($("#username").val()) 
				|| $.trim($("#pwd").val())==($.trim($("#username").val())+$.trim($("#domain").val()))){
			//检查用户名与密码是否相同
			ok=false;
			$("#password").attr("class","inp ipt-error");
			$("#password_ico_ok").hide();
			$("#password_ico_err").show();
			$("#div_password_rule").hide();
			$("#div_password_err").show();
			$("#div_password_err_info").html("输入的密码不能与用户名一样");
		}
	}
	
	/** 性别检查 	
		var genders = $("input[name='gender'][checked]");
		if(genders.length==0){
			ok=false;
			$("#div_gender_err").show();
		}*/
		var genders=document.getElementsByName("gender");
		var g=0;
		for(i=0;i<genders.length;i++){
			if(genders[i].checked) g=1;
		}
		if(g==0){
			ok=false;
			$("#div_gender_err").show();
		}
								
	/** 检查电子邮件 */
		ret=chkEmail();
		if(ret==0){
			ok=false;
			$("#email").attr("class","inp ipt-error");
			$("#email_ico_ok").hide();
			$("#email_ico_err").show();
			$("#div_email_err").show();
			$("#div_email_err_info").html("电子邮件不能为空");
		}
		if(ret<0){
			ok=false;
			$("#email").attr("class","inp ipt-error");
			$("#email_ico_ok").hide();
			$("#email_ico_err").show();
			$("#div_email_err").show();
			$("#div_email_err_info").html("输入的电子邮件有错误");
		}
		
	/** 检查验证码 */
		ret=chkAuthcode();
		if(ret<1){
			return false;
			$("#authcode").attr("class","inp ipt-error");
			//$("#authcode_ico_ok").hide();
			$("#authcode_ico_err").show();
			$("#div_authcode_err").show();
			$("#div_authcode_err_info").html("验证码不能为空");
		}
		
		//if(ok) doFormRequest('create.jsp','regform');
		//if(ok) {
			//$("#reqtime").attr("value",(new Date()).getTime());
		//	var crypt = hex_md5($("#username").val()+$("#pwd").val()+$("#birthday").val()).toLowerCase();
			//$("#crypt").attr("value",crypt);
			//doParameterRequest('create.jsp','authcode','birthday','domain','from','mobile','password','passwordconfirm','secanswer','secproblem','username','gender','crypt','reqtime');
		//}
		//else document.body.scrollTop=212;
		//else document.documentElement.scrollTop = 212;
		alert(ok);
		if(ok){
			doParameterRequest();
		}
		return true;
}


function doParameterRequest(){
	$("regForm").dosubmit();
}