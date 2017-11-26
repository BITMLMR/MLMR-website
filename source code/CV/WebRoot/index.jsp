<%@ page contentType="text/html;charset=gbk" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>计算机视觉网站</title>
<link rel="stylesheet" href="css/style.css" type="text/css" />
</head>

<body>

<div class="bodymain">
<%@ include file="public/top.jsp"%>


<div id="pagecell1">
  <!--pagecell1-->
  <img alt="" src="image/tl_curve_white.gif" height="6" width="6" id="tl" /> <img alt="" src="image/tr_curve_white.gif" height="6" width="6" id="tr" />
  <div id="breadCrumb"> <a href="#">首页</a> </div>
  <div id="pageName">
    <h2>计算机视觉教学网站</h2>
    </div>
  <div id="pageNav">
    <div id="sectionLinks"> 
    	<a href="<%=request.getContextPath()%>/news">新闻公告</a> 
    	<a href="<%=request.getContextPath()%>/course/index.jsp?channel=11">课程学习</a> 
    	<a href="<%=request.getContextPath()%>/source/source.jsp?channel=5">练习题</a> 
    	<a href="<%=request.getContextPath()%>/source/source.jsp?channel=4">资源共享</a> 
    	<a href="<%=request.getContextPath()%>/question/message.jsp">问题与建议</a> 
    	<a href="<%=request.getContextPath()%>/source/source.jsp?channel=2">实验</a> 
    	<a href="<%=request.getContextPath()%>/source/source.jsp?channel=3">成果展示</a> 
    </div>
    <div class="relatedLinks">
      <h3>友情链接</h3>
	      <a href="http://www.bit.edu.cn/" target="_blank">北京理工大学</a> 
	      <a href="#"></a> 
	      <a href="#"></a> 
	      <a href="#"></a> 
	      <a href="#"></a> 
	      <a href="#"></a> 
     </div>
    <div class="relatedLinks">
      <h3>计算机视觉网站</h3>
	      <a href="#"></a> 
	      <a href="#"></a> 

     </div>
    <div id="advert">
    <h3>任课教师</h3>
     <div  align="center"><img src="<%=request.getContextPath()%>/image/liuxiabi.JPG" alt="" width="107" /> </div>
    刘峡壁博士，北京理工大学计算机学院副教授、博士生导师。办公电话：010-6891447；E-mail: liuxiabi@bit.edu.cn
    </div>
    <div id="advert">
    梁伟博士，北京理工大学计算机学院副教授。
    </div>
  </div>
  <div id="content">
    <div class="feature"> <img src="" alt="" width="0" />
      <h3>教学目的</h3>
      	<p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;本课程是计算机科学与技术学科的研究生选修课。主要讲述计算机视觉的基本概念、理论与算法。目标是使学生能够掌握计算机视觉的核心内容，为研究与应用计算机视觉技术奠定基础。本课程的任务如下：</p>
		<p>1.	学习计算机视觉的基本概念和主要任务，重点掌握Marr视觉计算理论。</p>
		<p>2.	学习二维视觉信息处理的基本任务与主要方法。重点掌握图像分割、边缘与轮廓分析、纹理分析与合成、明暗与颜色视觉。</p>
		<p>3.	学习立体视觉的基本思想与主要方法，重点掌握深度测量方法、摄像机标定与三维重建。</p>
		<p>4.	学习运动视觉的基本思想与主要方法，重点掌握二维与三维运动估计方法。</p>
		<p>5.	培养学生在计算机视觉领域的研究与创新能力以及应用计算机视觉方法解决有关问题的能力。</p>   
    </div>
    <div class="story">
      <h3></h3>
      <p></p>
    </div>
    <div class="story">
      <table width="78%" cellpadding="0" cellspacing="0" summary="">
        <tr valign="top">
          <td class="storyLeft">
            <p> <a href="#" class="capsule">课程学习</a>&nbsp;  </p></td>
          <td>
            <p> <a href="#" class="capsule">练习题</a> &nbsp;  </p></td>
        </tr>
        <tr valign="top">
          <td class="storyLeft">
            <p> <a href="#" class="capsule">资源共享</a> &nbsp;  </p></td>
          <td>
            <p> <a href="#" class="capsule">成果展示</a> &nbsp; </p></td>
        </tr>
      </table>
    </div>
  </div>
  <%@ include file="public/bottom.jsp"%>
  </div>
</div>

</body>
</html>