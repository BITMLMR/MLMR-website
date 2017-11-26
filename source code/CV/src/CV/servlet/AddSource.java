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
	long file_size_max=500000000;//允许上传的单个文件的最大长度
	String ext="";
	String url="attachment\\"; //应保证在根目录中有此目录的存在（也就是说需要自己建立相应的文件夹）
	String myFileName="";
	String rooturl = "";//保存根目录
	String saveurl[] = new String[10];//最多传递10个附件，获取附件在本地的绝对路径
	String savesql[] = new String[10];//保存到数据库中 地址
	
	try
    {
		upload.initialize(config, request, response);//上传文件初始化
		// 允许上传的文件类型
		// upload.setAllowedFilesList("doc,xls,");
		// 拒绝上传的文件类型
		// upload.setDeniedFilesList("exe,bat,jsp");
		// 允许上传文件的单个最大大小
		upload.setMaxFileSize(file_size_max);
		// 允许上传文件的最大大小总和
		// upload.setTotalMaxFileSize(1024*1024*10);
		//上传数据
		upload.upload();//上传文件
		rooturl = request.getSession().getServletContext().getRealPath("/") + url;//获得项目的绝对路径
		//rooturl = "attachment/";//服务器中的文件的保存地址
		//int count=upload.save(saveurl);//第一保存文件，以文件原始名字保存的
		//int count=1;
		System.out.println(upload.getFiles().getCount()+"个文件上传成功！");
		//逐一提取上传文件信息，同时可保存文件
		for(int i=0;i<upload.getFiles().getCount();i++)//i<count;i++)//
		{
			CV.jspsmart.upload.File myFile = upload.getFiles().getFile(i);
			if(myFile.isMissing()) continue;//若文件不存在则继续
			//显示当前文件信息
			myFileName = myFile.getFileName(); //取得上载的文件的文件名
			ext = myFile.getFileExt(); //取得后缀名
			int file_size = myFile.getSize(); //取得文件的大小 
			
			//System.out.println(saveurl);//test
			if (file_size < file_size_max) {
				//更改文件名，取得当前上传时间的毫秒数值
				Calendar calendar = Calendar.getInstance();
				String filename = String.valueOf(calendar.getTimeInMillis());
				saveurl[i] = rooturl + filename+"_"+i+"." +ext;//保存路径
				savesql[i] = "attachment/" + filename+"_"+i+"." +ext;//保存路径
				//saveurl+=filename+"."+ext; //保存路径
				myFile.saveAs(saveurl[i], SmartUpload.SAVE_PHYSICAL);//又保存了一次，这次是以当前时间毫秒值保存的
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
	source.setChannel(Integer.parseInt(channel));//把String类型转换成为Int类型
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
