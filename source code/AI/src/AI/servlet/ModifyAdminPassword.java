/**
 * 
 */
package AI.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AI.service.AdminService;
//import AI.service.UserService;
import AI.vo.Admin;
//import AI.vo.User;

/**
 * @author Administrator
 *
 */
public class ModifyAdminPassword extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.setContentType("text/html;charset=utf-8");
        try{
        	String aid=request.getParameter("aid");
	      	String password=request.getParameter("oldp");
	      	String newpassword=request.getParameter("newp1");
	      	
	      	AdminService adminService=new AdminService();
	      	adminService.getAdmin(aid);
	      	Admin admin=adminService.getAdmin(aid);
	        PrintWriter out = response.getWriter();
	      	if(admin.getPassword().equals(password)){
	        	admin.setAid(aid);
	    	  	admin.setPassword(newpassword);
	    	  	adminService.updateAdmin(admin);
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
