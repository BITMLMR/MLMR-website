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
		long file_size_max=500000000;//允许上传的单个文件的最大长度500M
		String ext="";
		String url="homework\\"; //应保证在根目录中有此目录的存在（也就是说需要自己建立相应的文件夹）
		String myFileName="";
		String rooturl = "";//保存根目录
		String saveurl = null;//最多传递1个附件，获取附件在本地的绝对路径
		String savesql = null;//保存到数据库中 地址
		String savetitle = null;//显示到页面中的名称
		//String xml = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
		PrintWriter out = response.getWriter();
		try
	    {
			upload.initialize(config, request, response);//上传文件初始化
			// 允许上传的文件类型
			// upload.setAllowedFilesList("doc,xls,");
			// 拒绝上传的文件类型
			// upload.setDeniedFilesList("exe,bat,jsp");
			// 允许上传文件的单个最大大小
			upload.setMaxFileSize(file_size_max);
			// 允许上传文件的最大大小总和
			// upload.setTotalMaxFileSize(1024*1024*10);
			//上传数据
			upload.upload();//上传文件
			rooturl = request.getSession().getServletContext().getRealPath("/") + url;//获得项目的绝对路径
			//rooturl = "attachment/";//服务器中的文件的保存地址
			//int count=upload.save(saveurl);//第一保存文件，以文件原始名字保存的
			//int count=1;
			
			CV.jspsmart.upload.File myFile = upload.getFiles().getFile(0);//只上传一个文件所以取0即可
			if(myFile.isMissing()){
				//xml +="<message><info>请输入用户名!</info></message>";//若文件不存在则提示用户没有上传附件
				out.println("<center><font color='red'>请上传作业附件</font></center>");
			}else {
				//显示当前文件信息
				myFileName = myFile.getFileName(); //取得上载的文件的文件名
				ext = myFile.getFileExt(); //取得后缀名
				int file_size = myFile.getSize(); //取得文件的大小 
				
				//System.out.println(saveurl);//test
				if (file_size < file_size_max) {
					//更改文件名，取得当前上传时间的毫秒数值
					//Calendar calendar = Calendar.getInstance();
					//String filename = String.valueOf(calendar.getTimeInMillis());
					String filename = upload.getRequest().getParameter("student")+"_"+upload.getRequest().getParameter("sourceId")+"_批改";//根据用户名和作业id号命名
					saveurl = rooturl + filename +"." +ext;//保存路径
					savesql = "homework/" + filename +"." +ext;//保存路径
					savetitle = filename +"." +ext;
					//saveurl+=filename+"."+ext; //保存路径
					myFile.saveAs(saveurl, SmartUpload.SAVE_PHYSICAL);//又保存了一次，这次是以当前时间毫秒值保存的
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
