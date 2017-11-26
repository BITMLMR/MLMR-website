package AI.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AI.service.NewsService;
import AI.vo.News;

public class LegalNews extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取新闻的id
		String new_id = request.getParameter("newId");

		News news = new News();
		news.setNew_id(Integer.valueOf(new_id).intValue());
		news.setLegal(1);

		NewsService ns = new NewsService();
			
		if(ns.legalNews(news))
			response.sendRedirect(request.getContextPath()+"/user/news/news.jsp");
		else
			response.sendRedirect(request.getContextPath()+"/public/opfail.jsp?message="+URLEncoder.encode(ns.getMessage(),"GBK"));
	}
}
