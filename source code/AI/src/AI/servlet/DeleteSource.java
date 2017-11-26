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

import AI.vo.Source;
import AI.service.SourceService;

import java.util.*;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DeleteSource extends HttpServlet {
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
	String source_id = request.getParameter("source_id");
	String channel = request.getParameter("channel");

	Source source = new Source();
	source.setSource_id(Integer.valueOf(source_id).intValue());//yangali2010_7_15
	
	SourceService ns = new SourceService();
		
	if(ns.deleteSource(source,source.getSource_id()))
		response.sendRedirect(request.getContextPath()+"/user/source/source.jsp?channel="+channel);
	else
		response.sendRedirect(request.getContextPath()+"/public/opfail.jsp?message="+URLEncoder.encode(ns.getMessage(),"GBK"));
}
}
