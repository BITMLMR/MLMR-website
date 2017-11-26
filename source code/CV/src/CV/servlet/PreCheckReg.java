package CV.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CV.service.UserService;

public class PreCheckReg extends HttpServlet {
	//预定义的用户名
	//public String[] usernameList;
	//处理用户的注册请求
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			//设置返回内容类型
			response.setContentType("text/xml;charset=UTF-8");
			//设置不缓存
		    response.setHeader("Cache-Control", "no-cache");	 
		    //取出用户输入的用户名
			String username = (String) request.getParameter("username");
			
			String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

			UserService service=new UserService();
			
			if (username.equals("") || username == null) {
				
				xml +="<message><info>请输入用户名!</info></message>";
			}
			else if(service.checkUsename(username))
			{
				xml += "<message><info>用户名已存在,请输入其他用户名!</info></message>";
			}
			else
			{
				xml += "<message><info>合法!</info></message>";
			}
			
			response.getWriter().write(xml);
			
		} catch (Exception e) {
			String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			xml += "<message><info>用户名不合法!</info></message>";
			response.getWriter().write(xml);
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doGet(request, response);
	}
/*
	public void init(ServletConfig config) throws ServletException {
		usernameList = new String[] { "Tom", "Jerry", "Brain" };
	}

	public boolean IsContain(String param) {
		for (int i = 0; i < usernameList.length; i++) {
			if (usernameList[i].equals(param)) {
				return true;
			} else
				continue;
		}

		return false;
	}
*/
}
