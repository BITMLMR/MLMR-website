/*
 * Created on 2005-12-10
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

import AI.vo.Message;
import AI.service.MessageService;

/**
 * @author yangali
 *
 * TODO To change the template for this generated type comment go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
public class AnswerMessage extends HttpServlet {
protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

	String mid = request.getParameter("mid");
	String answer = request.getParameter("answer");
	String teacher = request.getParameter("teacher");
	
	Message message = new Message();
	message.setMid(Integer.valueOf(mid).intValue());
	message.setAnswer(answer);
	message.setTeacher(teacher);
	MessageService mservice = new MessageService();
	boolean result = mservice.modifyMessage(message);
	
	if(result)
		response.sendRedirect(request.getContextPath()+"/public/opsucc.jsp?message="+URLEncoder.encode(mservice.getMessage(),"GBK"));
	else
		response.sendRedirect(request.getContextPath()+"/public/opfail.jsp?message="+URLEncoder.encode(mservice.getMessage(),"GBK"));

}
}
