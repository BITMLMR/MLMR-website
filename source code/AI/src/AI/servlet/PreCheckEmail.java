package AI.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AI.service.UserService;

public class PreCheckEmail extends HttpServlet {
	//Ԥ������û���
	//public String[] usernameList;
	//�����û���ע������
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		try {
			//���÷�����������
			response.setContentType("text/xml;charset=UTF-8");
			//���ò�����
		    response.setHeader("Cache-Control", "no-cache");	 
		    //ȡ���û�������û���
			String email = (String) request.getParameter("email");
			
			String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

			UserService service=new UserService();
			
			if (email.equals("") || email == null) {
				
				xml +="<message><info>����������!</info></message>";
			}
			else if(service.checkUseEmail(email))
			{
				xml += "<message><info>�������Ѿ���ʹ��,�������������!</info></message>";
			}
			else
			{
				xml += "<message><info>����Ϸ�!</info></message>";
			}
			
			response.getWriter().write(xml);
			
		} catch (Exception e) {
			String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
			xml += "<message><info>���䲻�Ϸ�!</info></message>";
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
