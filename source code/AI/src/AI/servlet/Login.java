package AI.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import AI.service.UserService;
import AI.vo.User;

public class Login extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        try{
	      	String usename=request.getParameter("usename");
	      	String password=request.getParameter("password");
	      	UserService userService=new UserService();
	      	HttpSession session=request.getSession();
	        PrintWriter out = response.getWriter();
	        //如果存在该用户则：
	      	if(userService.login(usename,password)){
	      		
	      		User user = userService.getUser(usename);
	      		if ((user.getValidateCode().equals("activated")||user.getValidateCode()=="activated")
	      				&&(user.getStatus().equals("1")||user.getStatus()=="1")) {
	      			session.setAttribute("usename",user.getUsename());
		    	  	session.setAttribute("password",user.getPassword());
		    	  	session.setAttribute("gender",user.getGender());
		      		//System.out.println(session.getAttribute("usename"));
		      		//System.out.println(session.getAttribute("password"));
		      		//System.out.println(session.getAttribute("gender"));
		    	  	response.sendRedirect("../index.jsp") ;
				}else {//如果没有激活或者没有审核通过则
					String loginmsg = "nostatus";
					response.sendRedirect("../user/login.jsp?loginmsg=" + loginmsg) ;
				}
	    	  	
	      	}else{//如果不存在该用户则
	      		String loginmsg = "userwrong" ;
	      		response.sendRedirect("../user/login.jsp?loginmsg=" + loginmsg) ;
	      	}
        }catch(Exception e){
        	e.printStackTrace();
    		request.setAttribute("errMsg","登录出错！");
		 	this.getServletContext().getRequestDispatcher("/public/error.jsp").forward(request,response);  
		 	return;
        }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
}
