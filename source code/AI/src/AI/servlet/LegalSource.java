package AI.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AI.service.SourceService;
import AI.vo.Source;


public class LegalSource extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//获取新闻的id
		String sourceId = request.getParameter("source_id");
		String channel = request.getParameter("channel");

		Source source = new Source();
		source.setSource_id(Integer.valueOf(sourceId).intValue());
		source.setLegal(1);

		SourceService ns = new SourceService();
			
		if(ns.legalSource(source))
			response.sendRedirect(request.getContextPath()+"/user/source/source.jsp?channel="+channel);
		else
			response.sendRedirect(request.getContextPath()+"/public/opfail.jsp?message="+URLEncoder.encode(ns.getMessage(),"GBK"));
	}
}
