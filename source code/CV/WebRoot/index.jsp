<%@ page contentType="text/html;charset=gbk" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>������Ӿ���վ</title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>

<body>

<div class="bodymain">
<%@ include file="public/top.jsp"%>


<div id="pagecell1">
  <!--pagecell1-->
  <img alt="" src="image/tl_curve_white.gif" height="6" width="6" id="tl" /> <img alt="" src="image/tr_curve_white.gif" height="6" width="6" id="tr" />
  <div id="breadCrumb"> <a href="#">��ҳ</a> </div>
  <div id="pageName">
    <h2>������Ӿ���ѧ��վ</h2>
    </div>
  <div id="pageNav">
    <div id="sectionLinks"> 
    	<a href="<%=request.getContextPath()%>/news">���Ź���</a> 
    	<a href="<%=request.getContextPath()%>/course/index.jsp?channel=11">�γ�ѧϰ</a> 
    	<a href="<%=request.getContextPath()%>/source/source.jsp?channel=5">��ϰ��</a> 
    	<a href="<%=request.getContextPath()%>/source/source.jsp?channel=4">��Դ����</a> 
    	<a href="<%=request.getContextPath()%>/question/message.jsp">�����뽨��</a> 
    	<a href="<%=request.getContextPath()%>/source/source.jsp?channel=2">ʵ��</a> 
    	<a href="<%=request.getContextPath()%>/source/source.jsp?channel=3">�ɹ�չʾ</a> 
    </div>
    <div class="relatedLinks">
      <h3>��������</h3>
	      <a href="http://www.bit.edu.cn/" target="_blank">��������ѧ</a> 
	      <a href="#"></a> 
	      <a href="#"></a> 
	      <a href="#"></a> 
	      <a href="#"></a> 
	      <a href="#"></a> 
     </div>
    <div class="relatedLinks">
      <h3>������Ӿ���վ</h3>
	      <a href="#"></a> 
	      <a href="#"></a> 

     </div>
    <div id="advert">
    <h3>�ον�ʦ</h3>
     <div  align="center"><img src="<%=request.getContextPath()%>/image/liuxiabi.JPG" alt="" width="107" /> </div>
    ��Ͽ�ڲ�ʿ����������ѧ�����ѧԺ�����ڡ���ʿ����ʦ���칫�绰��010-6891447��E-mail: liuxiabi@bit.edu.cn
    </div>
    <div id="advert">
    ��ΰ��ʿ����������ѧ�����ѧԺ�����ڡ�
    </div>
  </div>
  <div id="content">
    <div class="feature"> <img src="" alt="" width="0" />
      <h3>��ѧĿ��</h3>
      	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;���γ��Ǽ������ѧ�뼼��ѧ�Ƶ��о���ѡ�޿Ρ���Ҫ����������Ӿ��Ļ�������������㷨��Ŀ����ʹѧ���ܹ����ռ�����Ӿ��ĺ������ݣ�Ϊ�о���Ӧ�ü�����Ӿ������춨���������γ̵��������£�</p>
		<p>1.	ѧϰ������Ӿ��Ļ����������Ҫ�����ص�����Marr�Ӿ��������ۡ�</p>
		<p>2.	ѧϰ��ά�Ӿ���Ϣ����Ļ�����������Ҫ�������ص�����ͼ��ָ��Ե���������������������ϳɡ���������ɫ�Ӿ���</p>
		<p>3.	ѧϰ�����Ӿ��Ļ���˼������Ҫ�������ص�������Ȳ���������������궨����ά�ؽ���</p>
		<p>4.	ѧϰ�˶��Ӿ��Ļ���˼������Ҫ�������ص����ն�ά����ά�˶����Ʒ�����</p>
		<p>5.	����ѧ���ڼ�����Ӿ�������о��봴�������Լ�Ӧ�ü�����Ӿ���������й������������</p>   
    </div>
    <div class="story">
      <h3></h3>
      <p></p>
    </div>
    <div class="story">
      <table width="78%" cellpadding="0" cellspacing="0" summary="">
        <tr valign="top">
          <td class="storyLeft">
            <p> <a href="#" class="capsule">�γ�ѧϰ</a>&nbsp;  </p></td>
          <td>
            <p> <a href="#" class="capsule">��ϰ��</a> &nbsp;  </p></td>
        </tr>
        <tr valign="top">
          <td class="storyLeft">
            <p> <a href="#" class="capsule">��Դ����</a> &nbsp;  </p></td>
          <td>
            <p> <a href="#" class="capsule">�ɹ�չʾ</a> &nbsp; </p></td>
        </tr>
      </table>
    </div>
  </div>
  <%@ include file="public/bottom.jsp"%>
  </div>
</div>

</body>
</html>