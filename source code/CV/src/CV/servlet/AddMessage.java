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

import CV.vo.Message;
import CV.service.MessageService;

public class AddMessage extends HttpServlet {
protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
	
	String usename = request.getParameter("username");
	String question = request.getParameter("question");
	String title = request.getParameter("title");
	Message message = new Message();
	message.setUsename(usename);
	message.setQuestion(question);
	message.setTitle(title);
	
	MessageService nservice = new MessageService();
	boolean result = nservice.addMessage(message);
	
	if(result)
		response.sendRedirect(request.getContextPath()+"/public/opsucc.jsp?message="+URLEncoder.encode(nservice.getMessage(),"GBK"));
	else
		response.sendRedirect(request.getContextPath()+"/public/opfail.jsp?message="+URLEncoder.encode(nservice.getMessage(),"GBK"));

}
}
