/*
 * Created on 2005-12-10
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package AI.servlet;

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

import AI.jspsmart.upload.Request;
import AI.jspsmart.upload.SmartUpload;
import AI.jspsmart.upload.SmartUploadException;
import AI.vo.Source;
import AI.service.SourceService;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ModifySource extends HttpServlet {
	
	private ServletConfig config;

public void init(ServletConfig arg0) throws ServletException {
	config = arg0;
}
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	SmartUpload upload = new SmartUpload();
	try
    {
		upload.initialize(config, request, response);
		// 允许上传的文件类型
		// upload.setAllowedFilesList("doc,xls,");
		// 拒绝上传的文件类型
		// upload.setDeniedFilesList("exe,bat,jsp");
		// 允许上传文件的单个最大大小
		upload.setMaxFileSize(1024 * 1024 * 20);
		// 允许上传文件的最大大小总和
		// upload.setTotalMaxFileSize(1024*1024*10);
		//上传数据
		upload.upload();
	}
	catch (SmartUploadException e){
		e.printStackTrace();
		return;
	}
	Request req = upload.getRequest();
	Integer source_id = Integer.valueOf(req.getParameter("source_id"));
	String source_title = req.getParameter("source_title");
	String source_content	= req.getParameter("source_content");
	String source_author = req.getParameter("source_author");

	Source source = new Source();
	source.setSource_id(source_id.intValue());
	source.setSource_content(source_content);
	source.setSource_title(source_title);
	source.setSource_author(source_author);
	SourceService nservice = new SourceService();
	boolean result = nservice.modifySource(source,upload);
	
	if(result)
		response.sendRedirect(request.getContextPath()+"/public/opsucc.jsp?message="+URLEncoder.encode(nservice.getMessage(),"GBK"));
	else
		response.sendRedirect(request.getContextPath()+"/public/opfail.jsp?message="+URLEncoder.encode(nservice.getMessage(),"GBK"));

}
}
