/*
 * Created on 2005-12-9
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package AI.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AI.vo.News;
import AI.service.NewsService;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DeleteNews extends HttpServlet {
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
	String new_id = request.getParameter("newId");

	News news = new News();
	news.setNew_id(Integer.valueOf(new_id).intValue());//yangali2010_7_15

	NewsService ns = new NewsService();
		
	if(ns.deleteNews(news))
		response.sendRedirect(request.getContextPath()+"/user/news/news.jsp");
	else
		response.sendRedirect(request.getContextPath()+"/public/opfail.jsp?message="+URLEncoder.encode(ns.getMessage(),"GBK"));
}
}
