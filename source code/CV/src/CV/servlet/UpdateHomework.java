package CV.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Calendar;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import CV.dao.impl.HomeworkDAOImpl;
import CV.jspsmart.upload.Request;
import CV.jspsmart.upload.SmartUpload;
import CV.jspsmart.upload.SmartUploadException;
import CV.service.HomeworkService;
import CV.vo.Homework;

public class UpdateHomework extends HttpServlet{
	private ServletConfig config;
	public void init(ServletConfig arg0) throws ServletException {
		config = arg0;
	}
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SmartUpload upload = new SmartUpload();
		long file_size_max=500000000;//�����ϴ��ĵ����ļ�����󳤶�500M
		String ext="";
		String url="homework\\"; //Ӧ��֤�ڸ�Ŀ¼���д�Ŀ¼�Ĵ��ڣ�Ҳ����˵��Ҫ�Լ�������Ӧ���ļ��У�
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
			
			CV.jspsmart.upload.File myFile = upload.getFiles().getFile(0);//ֻ�ϴ�һ���ļ�����ȡ0����
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
					String filename = upload.getRequest().getParameter("student")+"_"+upload.getRequest().getParameter("sourceId")+"_����";//�����û�������ҵid������
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
		String hid=req.getParameter("hid");
		String teacher=req.getParameter("teacher");
		String correction_addr=savesql;
		String correction_title=savetitle;
		
		Homework homework=new Homework();
		homework.setId(Integer.parseInt(hid));
		homework.setTeacher(teacher);
		homework.setCorrection_addr(correction_addr);
		homework.setCorrection_title(correction_title);
		
		HomeworkService service=new HomeworkService();
		service.setHomeworkDAO(new HomeworkDAOImpl());
		boolean result=service.updateHomework(homework, upload);
		if (result) {
			response.sendRedirect(request.getContextPath()+"/public/opsucc.jsp?message="+URLEncoder.encode(service.getMessage(),"GBK"));
		}else {
			response.sendRedirect(request.getContextPath()+"/public/opfail.jsp?message="+URLEncoder.encode(service.getMessage(),"GBK"));
		}
		
	}
}
