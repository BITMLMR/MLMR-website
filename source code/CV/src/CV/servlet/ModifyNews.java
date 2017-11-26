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
import CV.vo.News;
import CV.service.NewsService;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class ModifyNews extends HttpServlet {
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
	String new_id = request.getParameter("new_id");
	String new_title = request.getParameter("new_title");
	String new_content	= request.getParameter("new_content");
	
	News news = new News();
	news.setNew_id(Integer.valueOf(new_id).intValue());
	news.setNew_content(new_content);
	news.setNew_title(new_title);
	news.setLegal(0);//修改新闻后需要再次审核才能够发布
	NewsService nservice = new NewsService();
	boolean result = nservice.updateNews(news);
	
	if(result)
		response.sendRedirect(request.getContextPath()+"/public/opsucc.jsp?message="+URLEncoder.encode(nservice.getMessage(),"GBK"));
	else
		response.sendRedirect(request.getContextPath()+"/public/opfail.jsp?message="+URLEncoder.encode(nservice.getMessage(),"GBK"));

}
}
