<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@page import="AI.jspsmart.upload.*" %>
<%
	//新建一个SmartUploat对象
	SmartUpload su = new SmartUpload();
	//初始化
	su.initialize(pageContext);
	//设定contentDisposition为null以禁止浏览器自动打开文件，保证单击链接后是下载文件。
	//若不设定，则下载的文件扩展名为doc时，浏览器自动用word开打它。扩展名为pdf时，浏览器将用acrobat打开。
	su.setContentDisposition(null);
	su.downloadFile("attachment/11.rar");
%>