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
import AI.util.Generator;
import AI.vo.User;

/**
 * @author Administrator
 *
 */
public class Register extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        response.setContentType("text/html;charset=utf-8");
        //获取用户名
    	String username=request.getParameter("username");
    	//获取密码
    	String password=request.getParameter("password");
    	//获取确认密码
    	String confirmPassword=request.getParameter("confirmPassword");
    	//获取用户的email
    	String email=request.getParameter("email");
    	//获取用户身份
    	//int gender=Integer.parseInt(request.getParameter("gender"));
    	String gender=request.getParameter("gender");
    	String status="0";//如果是学生则审核通过
/*    	if (gender=="2"||gender.equals("2")) {
			status="0";//如果是老师则需要管理员审核
		}*/
    	//System.out.println(status);
    	//获取用户密码提问
    	String question=request.getParameter("question");
    	//获取用户密码提问答案
    	String answer=request.getParameter("answer");
    	//获取用户昵称
    	String nickname=request.getParameter("nickname");
    	//如果信息不完整,提示用户
    	if(username==null || password.trim().equals("") || 
    			 password.trim().equals("") ||confirmPassword==null || 
    			 confirmPassword.trim().equals("") || email==null || email.trim().equals("") 
    			 ||question==null || question.equals("") || answer==null || answer.equals("")
    			 ){
    			 	request.setAttribute("errMsg","请将必填的数据填写完整!");
    			 	this.getServletContext().getRequestDispatcher("/public/error.jsp").forward(request,response);
    			 	return;
    	}
    	//如果两次密码不一致,提示用户
    	else if(!password.equals(confirmPassword)){
		 	request.setAttribute("errMsg","两次密码不匹配!");
		 	this.getServletContext().getRequestDispatcher("/public/error.jsp").forward(request,response);  
		 	return;
    	}
    	UserService service=new UserService();
    	try{
	    	boolean isExist=service.checkUsename(username);
	    	boolean emailExist=service.checkUseEmail(email);
	    	//若用户已经存在，提示用户
	    	if(isExist){
	    		request.setAttribute("errMsg","用户名已经存在！");
			 	this.getServletContext().getRequestDispatcher("/public/error.jsp").forward(request,response);
			 	return;
	    	}
	    	//若邮箱已经被使用，提示用户
	    	if(emailExist){
	    		request.setAttribute("errMsg","该邮箱已经被使用，请更换其他邮箱！");
			 	this.getServletContext().getRequestDispatcher("/public/error.jsp").forward(request,response);
			 	return;
	    	}
	    	//注册成功
	    	User user=new User();
	    	user.setUsename(username);
	    	user.setPassword(password);
	    	user.setEmail(email);
	    	user.setGender(gender);
	    	user.setStatus(status);
	    	user.setNickname(nickname);
	    	user.setQuestion(question);
	    	user.setAnswer(answer);
	    	String validateCode=Generator.getEmailCode();
	    	user.setValidateCode(validateCode);
	    	//user.setRegisterdate(registerdate);
	    	String path = request.getContextPath();
	    	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	    	service.addUser(user,basePath);
	        //PrintWriter out = response.getWriter();
	        //out.println("<center>注册成功！<br/>请登录注册邮箱激活账号！等待管理员审核通过后即可使用！</center>");
	        response.sendRedirect(request.getContextPath()+"/user/RegSuccess.jsp");
    	}catch(Exception e){
    		e.printStackTrace();  
    		request.setAttribute("errMsg","注册出错！");
		 	this.getServletContext().getRequestDispatcher("/public/error.jsp").forward(request,response);
    	}
	}
	//doPost方法转至doGet方法
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		doGet(request,response);
	}
	
}
