/*
 * Created on 2010-07-27
 *
 * bit.edu.cn
 * yangali
 */
package AI.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AI.dao.impl.AttachmentDAOImpl;
import AI.jspsmart.upload.*;
import AI.vo.Attachment;
import AI.vo.Source;
import AI.service.AttachmentService;
import AI.service.SourceService;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DownloadAttachment extends HttpServlet {
	private ServletConfig config;

	public void init(ServletConfig arg0) throws ServletException {
		config = arg0;
	}
	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		try{
			Long attachment_id = Long.valueOf(request.getParameter("id"));
			AttachmentService service = new AttachmentService();
			service.setAttachmentDAO(new AttachmentDAOImpl());
			Attachment attachment = service.getAttachment(attachment_id.intValue());
			
			String attachment_addr = attachment.getAttachment_addr();
			//System.out.println(attachment_id+attachment_addr);//test
			//新建一个SmartUploat对象
			SmartUpload su = new SmartUpload();
			//初始化
			su.initialize(config, request, response);
			//设定contentDisposition为null以禁止浏览器自动打开文件，保证单击链接后是下载文件。
			//若不设定，则下载的文件扩展名为doc时，浏览器自动用word开打它。扩展名为pdf时，浏览器将用acrobat打开。
			su.setContentDisposition(null);
			su.downloadFile(attachment_addr);
			
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
}
}
