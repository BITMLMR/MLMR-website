package AI.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import AI.dao.impl.HomeworkDAOImpl;
import AI.jspsmart.upload.Request;
import AI.jspsmart.upload.SmartUpload;
import AI.jspsmart.upload.SmartUploadException;
import AI.service.HomeworkService;
import AI.vo.Homework;

public class AddHomework extends HttpServlet {
	private ServletConfig config;
	public void init(ServletConfig arg0) throws ServletException {
		config = arg0;
	}
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SmartUpload upload = new SmartUpload();
		long file_size_max=500000000;//�����ϴ��ĵ����ļ�����󳤶�
		String ext="";
		String url="homework/"; //Ӧ��֤�ڸ�Ŀ¼���д�Ŀ¼�Ĵ��ڣ�Ҳ����˵��Ҫ�Լ�������Ӧ���ļ��У�
		String myFileName="";
		String rooturl = "";//�����Ŀ¼
		String saveurl = null;//��ഫ��1����������ȡ�����ڱ��صľ���·��
		String savesql = null;//���浽���ݿ��� ��ַ
		String savetitle = null;//��ʾ��ҳ���е�����
		//String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		PrintWriter out = response.getWriter();
		try
	    {
			upload.initialize(config, request, response);//�ϴ��ļ���ʼ��
			// �����ϴ����ļ�����
			// upload.setAllowedFilesList("doc,xls,");
			// �ܾ��ϴ����ļ�����
			// upload.setDeniedFilesList("exe,bat,jsp");
			// �����ϴ��ļ��ĵ�������С
			upload.setMaxFileSize(file_size_max);
			// �����ϴ��ļ�������С�ܺ�
			// upload.setTotalMaxFileSize(1024*1024*10);
			//�ϴ�����
			upload.upload();//�ϴ��ļ�
			rooturl = request.getSession().getServletContext().getRealPath("/") + url;//�����Ŀ�ľ���·��
			//rooturl = "attachment/";//�������е��ļ��ı����ַ
			//int count=upload.save(saveurl);//��һ�����ļ������ļ�ԭʼ���ֱ����
			//int count=1;

			AI.jspsmart.upload.File myFile = upload.getFiles().getFile(0);//ֻ�ϴ�һ���ļ�����ȡ0����
			if(myFile.isMissing()){
				//xml +="<message><info>�������û���!</info></message>";//���ļ�����������ʾ�û�û���ϴ�����
				out.println("<center><font color='red'>���ϴ���ҵ����</font></center>");
			}else {
				//��ʾ��ǰ�ļ���Ϣ
				myFileName = myFile.getFileName(); //ȡ�����ص��ļ����ļ���
				ext = myFile.getFileExt(); //ȡ�ú�׺��
				int file_size = myFile.getSize(); //ȡ���ļ��Ĵ�С

				//System.out.println(saveurl);//test
				if (file_size < file_size_max) {
					//�����ļ�����ȡ�õ�ǰ�ϴ�ʱ��ĺ�����ֵ
					//Calendar calendar = Calendar.getInstance();
					//String filename = String.valueOf(calendar.getTimeInMillis());
					String filename = upload.getRequest().getParameter("username")+"_"+upload.getRequest().getParameter("sourceId");//�����û�������ҵid������
					saveurl = rooturl + filename +"." +ext;//����·��
					savesql = "homework/" + filename +"." +ext;//����·��
					savetitle = filename +"." +ext;
					//saveurl+=filename+"."+ext; //����·��
					myFile.saveAs(saveurl, SmartUpload.SAVE_PHYSICAL);//�ֱ�����һ�Σ�������Ե�ǰʱ�����ֵ�����
					System.out.println(saveurl);
				}
			}
			//response.getWriter().write(xml);

		}
		catch (SmartUploadException e){
			e.printStackTrace();
			return;
		}

		Request req = upload.getRequest();
		String sourceId=req.getParameter("sourceId");
		String username=req.getParameter("username");
		String homework_addr=savesql;
		String homework_title=savetitle;

		Homework homework=new Homework();
		homework.setSource_id(Integer.parseInt(sourceId));
		homework.setUsername(username);
		homework.setHomework_addr(homework_addr);
		homework.setHomework_title(homework_title);

		HomeworkService service=new HomeworkService();
		service.setHomeworkDAO(new HomeworkDAOImpl());
		//���ݵ�ǰ�û���username����Դ���sourceId�ж����ݿ����Ƿ��Ѿ����ڸ�����¼
		//�����������ֱ�Ӳ���ü�¼������Ѿ���������и���
		try {
			boolean isExist=service.checkHomework(username, Integer.parseInt(sourceId));
			boolean result=false;
			if (isExist) {
				result=service.updateHomeworkByStu(homework, upload);
			}else {
				result=service.addHomework(homework,upload);
			}
			//����result����ж��Ƿ����ҳ��
			if (result) {
				response.sendRedirect(request.getContextPath()+"/public/opsucc.jsp?message="+URLEncoder.encode(service.getMessage(),"GBK"));
			}else {
				response.sendRedirect(request.getContextPath()+"/public/opfail.jsp?message="+URLEncoder.encode(service.getMessage(),"GBK"));
			}
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
