// Title: regPreCheck
// Description: ��ǰ�����û����Ƿ��ѽ�����
// URL: 
// Version: 1.0
// Date: 09-01-2010 (mm-dd-yyyy)
// Contact: yangali@bit.edu.cn (specify product title in the subject)
// Notes: 
//

	var req;//����ȫ�ֱ���req
	//���������������������֤��������֤�û����Ƿ�Ϸ�
	function UserNameCheck()
	{
	var username = document.getElementById('usename').value;//��ȡ�ı����ֵ

         var url = "pre?user_name=" + escape(username);//ָ�������͵�url��ַ�Ͳ���

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