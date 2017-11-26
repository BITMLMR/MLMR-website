/**
 * 
 */
package AI.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AI.service.UserService;
import AI.vo.User;

/**
 * @author Useristrator
 *
 */
public class ModifyUserInfo extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.setContentType("text/html;charset=utf-8");
        try{
        	String usename=request.getParameter("usename");
	      	String email=request.getParameter("email");
	      	String gender=request.getParameter("gender");
	    	String nickname=request.getParameter("nickname");
	    	UserService userService=new UserService();
	      	User user= userService.getUser(usename);
	        PrintWriter out = response.getWriter();
	      	//if(user.getUsename().equals(usename)){
	        	user.setUsename(usename);
		    	user.setEmail(email);
		    	user.setGender(gender);
		    	user.setNickname(nickname);
	    	  	userService.updateUser(user);
	    	  	out.println("<center><font color='blue'>信息修改成功！</font></center>");
	    	//}else{
		   //     out.println("<center><font color='red'>不存在该会员!</font><a href='#' onclick='history.back();'>返回</a></center>");
	      	//}
        }catch(Exception e){
        	e.printStackTrace();
    		request.setAttribute("errMsg","信息修改错误！");
		 	this.getServletContext().getRequestDispatcher("/public/error.jsp").forward(request,response);  
		 	return;
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
}
