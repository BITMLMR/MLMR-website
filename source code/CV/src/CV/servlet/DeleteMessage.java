/*
 * Created on 2005-12-9
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

import CV.vo.Message;
import CV.service.MessageService;

/**
 * @author Administrator
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class DeleteMessage extends HttpServlet {
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
	String mid = request.getParameter("mid");
	//System.out.println(mid);
	Message message = new Message();
	message.setMid(Integer.valueOf(mid).intValue());

	MessageService ns = new MessageService();
		
	if(ns.deleteMessage(message))
		response.sendRedirect(request.getContextPath()+"/user/question/question.jsp");
	else
		response.sendRedirect(request.getContextPath()+"/public/opfail.jsp?message="+URLEncoder.encode(ns.getMessage(),"GBK"));
}
}
