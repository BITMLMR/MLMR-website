package CV.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CV.service.SuggestionService;
import CV.vo.Suggestion;

public class DeleteSuggestion extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		String sid=request.getParameter("sid");
		int id=Integer.valueOf(sid).intValue();
		//Suggestion suggestion=new Suggestion();
		//suggestion.setId(Integer.valueOf(sid).intValue());
		SuggestionService service=new SuggestionService();
		if (service.deleteSuggestion(id)) {
			response.sendRedirect(request.getContextPath()+"/user/question/suggestion.jsp");
		}else {
			response.sendRedirect(request.getContextPath()+"/public/opfail.jsp?message="+URLEncoder.encode(service.getMessage(),"GBK"));
		}
		
	}

}
