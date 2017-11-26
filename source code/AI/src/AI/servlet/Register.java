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
        //��ȡ�û���
    	String username=request.getParameter("username");
    	//��ȡ����
    	String password=request.getParameter("password");
    	//��ȡȷ������
    	String confirmPassword=request.getParameter("confirmPassword");
    	//��ȡ�û���email
    	String email=request.getParameter("email");
    	//��ȡ�û����
    	//int gender=Integer.parseInt(request.getParameter("gender"));
    	String gender=request.getParameter("gender");
    	String status="0";//�����ѧ�������ͨ��
/*    	if (gender=="2"||gender.equals("2")) {
			status="0";//�������ʦ����Ҫ����Ա���
		}*/
    	//System.out.println(status);
    	//��ȡ�û���������
    	String question=request.getParameter("question");
    	//��ȡ�û��������ʴ�
    	String answer=request.getParameter("answer");
    	//��ȡ�û��ǳ�
    	String nickname=request.getParameter("nickname");
    	//�����Ϣ������,��ʾ�û�
    	if(username==null || password.trim().equals("") || 
    			 password.trim().equals("") ||confirmPassword==null || 
    			 confirmPassword.trim().equals("") || email==null || email.trim().equals("") 
    			 ||question==null || question.equals("") || answer==null || answer.equals("")
    			 ){
    			 	request.setAttribute("errMsg","�뽫�����������д����!");
    			 	this.getServletContext().getRequestDispatcher("/public/error.jsp").forward(request,response);
    			 	return;
    	}
    	//����������벻һ��,��ʾ�û�
    	else if(!password.equals(confirmPassword)){
		 	request.setAttribute("errMsg","�������벻ƥ��!");
		 	this.getServletContext().getRequestDispatcher("/public/error.jsp").forward(request,response);  
		 	return;
    	}
    	UserService service=new UserService();
    	try{
	    	boolean isExist=service.checkUsename(username);
	    	boolean emailExist=service.checkUseEmail(email);
	    	//���û��Ѿ����ڣ���ʾ�û�
	    	if(isExist){
	    		request.setAttribute("errMsg","�û����Ѿ����ڣ�");
			 	this.getServletContext().getRequestDispatcher("/public/error.jsp").forward(request,response);
			 	return;
	    	}
	    	//�������Ѿ���ʹ�ã���ʾ�û�
	    	if(emailExist){
	    		request.setAttribute("errMsg","�������Ѿ���ʹ�ã�������������䣡");
			 	this.getServletContext().getRequestDispatcher("/public/error.jsp").forward(request,response);
			 	return;
	    	}
	    	//ע��ɹ�
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
	        //out.println("<center>ע��ɹ���<br/>���¼ע�����伤���˺ţ��ȴ�����Ա���ͨ���󼴿�ʹ�ã�</center>");
	        response.sendRedirect(request.getContextPath()+"/user/RegSuccess.jsp");
    	}catch(Exception e){
    		e.printStackTrace();  
    		request.setAttribute("errMsg","ע�����");
		 	this.getServletContext().getRequestDispatcher("/public/error.jsp").forward(request,response);
    	}
	}
	//doPost����ת��doGet����
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
		throws ServletException, IOException {
		doGet(request,response);
	}
	
}
