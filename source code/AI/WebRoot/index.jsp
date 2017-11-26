<%@ page contentType="text/html;charset=gbk" language="java"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>人工智能网站</title>
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
    <h2>人工智能教学网站</h2>
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
      <h3>人工智能网站</h3>
	      <a href="#"></a> 
	      <a href="#"></a> 

     </div>
    <div id="advert">
    <h3>任课老师</h3>
     <div  align="center"><img src="<%=request.getContextPath()%>/image/img_mine.JPG" alt="" width="107" /> </div>
    刘峡壁博士，北京理工大学计算机学院副教授、博士生导师。<br />电话:68913447<br />邮箱:liuxiabi@bit.edu.cn</div>
  </div>
  <div id="content">
    <div class="feature"> <img src="<%=request.getContextPath()%>/image/AI_BookFace.jpg" alt="" width="200" />
      <h3>教材介绍</h3>
      <p><b>刘峡壁</b>，人工智能导论-方法与系统，国防工业出版社，2008年08月.</p>
      <p>本书以人工智能的哲学基础和工程实践为主线，系统全面地介绍人工智能的核心知识和最新进展。目的在于帮助读者建立起对于人工智能的总体认识，为以后进入人工智能各分支的研究和应用奠定基础。</p>
      <p>哲学基础涵盖目前实现人工智能的六大类思想和方法，分别是（1）符号主义，分为基于搜索的问题求解和基于知识的推理两个主题；（2）连接主义，即人工神经网络；（3）学习主义，指机器学习方法；（4）行为主义，含智能体和强化学习；（5）进化主义，指遗传算法、进化规划、进化策略这三种进化计算方法；（6）群体主义，分为多智能体系统和群智能优化方法两个部分。群智能优化方法包括蚁群优化算法和粒子群优化算法。工程实践涉及具有代表性和广泛应用性的人工智能系统—专家系统，以及实现人工智能的软硬件条件，包括两种智能程序设计语言（LISP、PROLOG）和三种下一代智能计算机（光计算机、量子计算机、生物计算机）。</p>
      <p>除了这些主要内容以外，本书还有两项特色性的辅助内容：（1）在每一章最后推荐了深入学习资源，为希望更加透彻地理解和思考有关问题的读者提供获取相应信息的地图。（2）在附录部分提供了汉英-英汉术语对照与索引，有助于读者形成人工智能的英文概念体系，获得查询和阅读有关英文文献的初步能力。</p>
      <p>本书可作为相关专业本科生和研究生的人工智能教材，也可供从事人工智能研究和应用的专业技术人员参考。</p>
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