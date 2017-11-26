/*
 * Created on 2005-12-10
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package CV.servlet;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CV.jspsmart.upload.Request;
import CV.jspsmart.upload.SmartUpload;
import CV.jspsmart.upload.SmartUploadException;
import CV.vo.Source;
import CV.service.SourceService;
import CV.dao.impl.SourceDAOImpl;
import java.util.*;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AddSource extends HttpServlet {
	
	private ServletConfig config;

public void init(ServletConfig arg0) throws ServletException {
	config = arg0;
}
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	SmartUpload upload = new SmartUpload();
	long file_size_max=500000000;//�����ϴ��ĵ����ļ�����󳤶�
	String ext="";
	String url="attachment\\"; //Ӧ��֤�ڸ�Ŀ¼���д�Ŀ¼�Ĵ��ڣ�Ҳ����˵��Ҫ�Լ�������Ӧ���ļ��У�
	String myFileName="";
	String rooturl = "";//�����Ŀ¼
	String saveurl[] = new String[10];//��ഫ��10����������ȡ�����ڱ��صľ���·��
	String savesql[] = new String[10];//���浽���ݿ��� ��ַ
	
	try
    {
		upload.initialize(config, request, response);//�ϴ��ļ���ʼ��
		// �����ϴ����ļ�����
		// upload.setAllowedFilesList("doc,xls,");
		// �ܾ��ϴ����ļ�����
		// upload.setDeniedFilesList("exe,bat,jsp");
		// �����ϴ��ļ��ĵ�������С
		upload.setMaxFileSize(file_size_max);
		// �����ϴ��ļ�������С�ܺ�
		// upload.setTotalMaxFileSize(1024*1024*10);
		//�ϴ�����
		upload.upload();//�ϴ��ļ�
		rooturl = request.getSession().getServletContext().getRealPath("/") + url;//�����Ŀ�ľ���·��
		//rooturl = "attachment/";//�������е��ļ��ı����ַ
		//int count=upload.save(saveurl);//��һ�����ļ������ļ�ԭʼ���ֱ����
		//int count=1;
		System.out.println(upload.getFiles().getCount()+"���ļ��ϴ��ɹ���");
		//��һ��ȡ�ϴ��ļ���Ϣ��ͬʱ�ɱ����ļ�
		for(int i=0;i<upload.getFiles().getCount();i++)//i<count;i++)//
		{
			CV.jspsmart.upload.File myFile = upload.getFiles().getFile(i);
			if(myFile.isMissing()) continue;//���ļ������������
			//��ʾ��ǰ�ļ���Ϣ
			myFileName = myFile.getFileName(); //ȡ�����ص��ļ����ļ���
			ext = myFile.getFileExt(); //ȡ�ú�׺��
			int file_size = myFile.getSize(); //ȡ���ļ��Ĵ�С 
			
			//System.out.println(saveurl);//test
			if (file_size < file_size_max) {
				//�����ļ�����ȡ�õ�ǰ�ϴ�ʱ��ĺ�����ֵ
				Calendar calendar = Calendar.getInstance();
				String filename = String.valueOf(calendar.getTimeInMillis());
				saveurl[i] = rooturl + filename+"_"+i+"." +ext;//����·��
				savesql[i] = "attachment/" + filename+"_"+i+"." +ext;//����·��
				//saveurl+=filename+"."+ext; //����·��
				myFile.saveAs(saveurl[i], SmartUpload.SAVE_PHYSICAL);//�ֱ�����һ�Σ�������Ե�ǰʱ�����ֵ�����
				System.out.println(saveurl[i]);
			}
		}
	}
	catch (SmartUploadException e){
		e.printStackTrace();
		return;
	}
	
	Request req = upload.getRequest();
	String source_title = req.getParameter("source_title");
	String channel = req.getParameter("channel");
	String type = req.getParameter("type");
	String source_author = req.getParameter("source_author");
	String legal = req.getParameter("legal");
	String source_content	= req.getParameter("source_content");
	String tree_id = req.getParameter("tree_id");
	
	Source source = new Source();
	source.setSource_title(source_title);
	source.setChannel(Integer.parseInt(channel));//��String����ת����ΪInt����
	source.setType(Integer.parseInt(type));
	source.setSource_author(source_author);
	source.setLegal(Integer.parseInt(legal));
	source.setSource_content(source_content);
	source.setTree_id(tree_id);
	SourceService nservice = new SourceService();
	nservice.setSourceDAO(new SourceDAOImpl());
	boolean result = nservice.addSource(source,upload,savesql);
	
	if(result)
		response.sendRedirect(request.getContextPath()+"/public/opsucc.jsp?message="+URLEncoder.encode(nservice.getMessage(),"GBK"));
	else
		response.sendRedirect(request.getContextPath()+"/public/opfail.jsp?message="+URLEncoder.encode(nservice.getMessage(),"GBK"));

}
}
