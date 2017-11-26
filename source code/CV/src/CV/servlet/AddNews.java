/*
 * Created on 2005-12-10
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package CV.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CV.vo.News;
import CV.service.NewsService;


public class AddNews extends HttpServlet {
protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
	String new_title = request.getParameter("title");
	String new_content	= request.getParameter("content");
	String author = request.getParameter("author");
	
	News news = new News();
	news.setNew_content(new_content);
	news.setNew_title(new_title);
	news.setNew_author(author);
	news.setLegal(0);
	NewsService nservice = new NewsService();
	boolean result = nservice.addNews(news);
	
	if(result)
		response.sendRedirect(request.getContextPath()+"/public/opsucc.jsp?message="+URLEncoder.encode(nservice.getMessage(),"GBK"));
	else
		response.sendRedirect(request.getContextPath()+"/public/opfail.jsp?message="+URLEncoder.encode(nservice.getMessage(),"GBK"));

}
}
