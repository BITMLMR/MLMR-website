<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>
<%@page import="AI.jspsmart.upload.*" %>
<%
	//�½�һ��SmartUploat����
	SmartUpload su = new SmartUpload();
	//��ʼ��
	su.initialize(pageContext);
	//�趨contentDispositionΪnull�Խ�ֹ������Զ����ļ�����֤�������Ӻ��������ļ���
	//�����趨�������ص��ļ���չ��Ϊdocʱ��������Զ���word����������չ��Ϊpdfʱ�����������acrobat�򿪡�
	su.setContentDisposition(null);
	su.downloadFile("attachment/11.rar");
%>