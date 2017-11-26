package CV.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CV.service.SuggestionService;
import CV.vo.Suggestion;

public class AddSuggestion extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		//从页面接受数据
		String content=request.getParameter("content");
		String username=request.getParameter("username");
		Suggestion suggestion=new Suggestion();
		suggestion.setContent(content);
		
		if(username!=null)
		{
		  suggestion.setUsername(username);
		}
		 else
		  {
			 username="Anonymous";
			 suggestion.setUsername(username);
		  }
		
		SuggestionService service=new SuggestionService();
		boolean result=service.addSuggestion(suggestion);
		if (result) {
			response.sendRedirect(request.getContextPath()+"/public/opsucc.jsp?message="+URLEncoder.encode(service.getMessage(),"GBK"));
		}else {
			response.sendRedirect(request.getContextPath()+"/public/opfail.jsp?message="+URLEncoder.encode(service.getMessage(),"GBK"));
		}
	}

}
