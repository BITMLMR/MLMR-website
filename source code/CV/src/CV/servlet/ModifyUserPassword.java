/**
 * 
 */
package CV.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CV.service.UserService;
import CV.vo.User;

/**
 * @author Useristrator
 *
 */
public class ModifyUserPassword extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.setContentType("text/html;charset=utf-8");
        try{
        	
        	String usename=request.getParameter("usename");
	      	String password=request.getParameter("oldp");
	      	String newpassword=request.getParameter("newp1");
	      	UserService userService=new UserService();
	      	userService.getUser(usename);
	      	User user= userService.getUser(usename);
	        PrintWriter out = response.getWriter();
	      	if(user.getPassword().equals(password)){
	        	user.setUsename(usename);
	    	  	user.setPassword(newpassword);
	    	  	userService.updateUser(user);
	    	  	out.println("<center><font color='blue'>修改密码成功！</font></center>");
	    	}else{
		        out.println("<center><font color='red'>原始密码输入错误!</font><a href='#' onclick='history.back();'>返回</a></center>");
	      	}
        }catch(Exception e){
        	e.printStackTrace();
    		request.setAttribute("errMsg","修改密码错误！");
		 	this.getServletContext().getRequestDispatcher("/public/error.jsp").forward(request,response);  
		 	return;
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
}
