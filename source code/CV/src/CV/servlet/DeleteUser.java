package CV.servlet;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CV.service.UserService;

public class DeleteUser extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		String userId=request.getParameter("userId");
		UserService service = new UserService();
		if (service.deleteUser(Integer.valueOf(userId).intValue())) {
			response.sendRedirect(request.getContextPath()+"/user/userManager/allusers.jsp");
		}else {
			response.sendRedirect(request.getContextPath()+"/public/opfail.jsp?message="+URLEncoder.encode(service.getMessage(),"GBK"));
		}
	}

}
