/*
 * Created on 2005-11-10
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package AI.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import AI.vo.Source;
import AI.dao.SourceDAO;
import AI.dao.impl.SourceDAOImpl;
import AI.vo.Attachment;
import AI.dao.AttachmentDAO;
import AI.dao.impl.AttachmentDAOImpl;

import AI.util.db.Database;

import AI.jspsmart.upload.File;
import AI.jspsmart.upload.SmartUpload;
/**
 * @author Administrator
 *
 */
public class SourceService  extends BaseService{
	private SourceDAO sourceDAO=new SourceDAOImpl();

	public boolean modifySource(Source source,SmartUpload upload) {
		Connection connection = null;
		try {
			String updateAttr=upload.getRequest().getParameter("updateattr");
			connection = Database.getConnection();
			//SourceAttachmentDAO attachmentDAO = new SourceAttachmentDAOImpl();			
			sourceDAO.setConnection(connection);
			//attachmentDAO.setConnection(connection);	
			sourceDAO.updateSource(source);
			if(updateAttr!=null&&updateAttr.equals("y")){
				//attachmentDAO.deleteAttrBySource(source);
				//Long currentID = source.getSourceId();
				for(int i=0;i<upload.getFiles().getCount();i++){
					File f = upload.getFiles().getFile(i);
					if(f.isMissing())continue;
					
					//SourceAttachment sourceAttachment=new SourceAttachment();
					//sourceAttachment.setSourceId(currentID);
					//sourceAttachment.setAttachmentName(f.getFileName());
					//sourceAttachment.setAttachmentContent(f.getFileBinaryData());
					//attachmentDAO.addSourceAttachment(sourceAttachment);				
				}				
			}
			Database.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
			Database.rollback();
			return false;
		} finally {
			Database.releaseConnection(connection);
		}
	};	
	public boolean addSource(Source source,SmartUpload upload,String saveurl[]) {
		Connection connection = null;
		//boolean ret = false;
		try {
			connection = Database.getConnection();
			AttachmentDAO attachmentDAO = new AttachmentDAOImpl();			
			sourceDAO.setConnection(connection);
			attachmentDAO.setConnection(connection);	
			sourceDAO.addSource(source);//���������Դ��Ϣ
			Long currentID = sourceDAO.getCurrentID();
			for(int i=0;i<upload.getFiles().getCount();i++){
				File f = upload.getFiles().getFile(i);
				if(f.isMissing())continue;
				Attachment attachment=new Attachment();
				attachment.setSource_id(currentID.intValue());
				attachment.setAttachment_name(f.getFileName());
				attachment.setAttachment_addr(saveurl[i]);
				attachmentDAO.addAttachment(attachment);	//���һ��������Ϣ	
			}
			Database.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
			Database.rollback();
			return false;
		} finally {
			Database.releaseConnection(connection);
		}
	};//���Source��Ϣ
	//yangali�иĶ����Ķ��ϴ������ɾ���������ϵ��ļ�
	public boolean deleteSource(Source source,int source_id) {
		Connection connection = null;
		try {			
			connection = Database.getConnection();
			AttachmentDAO attachmentDAO =new AttachmentDAOImpl();
			//SourceAttributeDAO attrDAO = new SourceAttributeDAOImpl();
			//SourceCommentDAO commentDAO = new SourceCommentDAOImpl();
			sourceDAO.setConnection(connection);
			attachmentDAO.setConnection(connection);
			//attrDAO.setConnection(connection);
			sourceDAO.deleteSource(source);
			//yangali���ɾ��������������ļ�
			//���ȵõ�����Դ�����м�������			
			//�г����и���Դ�ĸ���
			List results = attachmentDAO.listAttachmentBySource(source_id);
			System.out.println(results.size()+"��������ɾ����");
			//����ɾ����Դ��������и���
			String fileUrlStr="";
			String fileUrlOutStr="";
			for (int i=0;i<results.size();i++)
			{
				Attachment attachment  =(Attachment)results.get(i);
				//File file = new File(attachment.get,"");
				fileUrlStr=(String)attachment.getAttachment_addr();
			    fileUrlStr=fileUrlStr.trim();
			    fileUrlOutStr=fileUrlStr;
			    fileUrlOutStr = fileUrlOutStr.replaceAll("/", "//");
			    java.io.File f = new java.io.File(fileUrlOutStr);
			    if (f.exists())  //���File.txt�Ƿ����
			    f.delete();
			}
			attachmentDAO.deleteAttachmentBySource(source);//.deleteAttrBySource(source);
			//yangali���ɾ��������������ļ�end
			Database.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
			Database.rollback();
			return false;
		} finally {
			Database.releaseConnection(connection);
		}				
	};//ɾ��Source��Ϣ
	
   public boolean updateSource(Source source)throws Exception{
		Connection connection = null;
		try{
		   connection=Database.getConnection();
		   sourceDAO.setConnection(connection);
		   sourceDAO.updateSource(source);
		   connection.commit();
		   return true;
	   }catch(Exception  e){
		   e.printStackTrace();
		   message = e.getMessage();
		   Database.rollback();
		   return false;
	   }finally{
		   Database.releaseConnection(connection);
	   }
   }
   public boolean legalSource(Source source){
		Connection connection = null;
		try{
		   connection=Database.getConnection();
		   sourceDAO.setConnection(connection);
		   sourceDAO.legalSource(source);
		   connection.commit();
		   return true;
	   }catch(Exception  e){
		   e.printStackTrace();
		   message = e.getMessage();
		   Database.rollback();
		   return false;
	   }finally{
		   Database.releaseConnection(connection);
	   }
  }
   public List listAllSource()throws Exception{
	   List sourceList=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   sourceDAO.setConnection(connection);
		   sourceList=sourceDAO.listAllSource();
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);		   
	   }	   
	   return sourceList;
   }
   public List listSourceByPage(int pageNo,int pageSize)throws Exception{
	   List sourceList=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   sourceDAO.setConnection(connection);
		   sourceList=sourceDAO.listSourceByPage(pageNo,pageSize);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);		   
	   }	   
	   return sourceList;
   }
   //yangali 2010.7.26���
   public List listSourceByClassByPage(int channel,int pageNo,int pageSize)throws Exception{
	   List sourceList=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   sourceDAO.setConnection(connection);
		   sourceList=sourceDAO.listSourceByClassByPage(channel,pageNo,pageSize);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);		   
	   }	   
	   return sourceList;
   }
   //yangali 2010.8.29���,������Դ�Ƿ��������ѯ
   public List listSourceByClassByLegalByPage(int channel,int legal, int pageNo,int pageSize)throws Exception{
	   List sourceList=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   sourceDAO.setConnection(connection);
		   sourceList=sourceDAO.listSourceByClassByLegalByPage(channel,legal,pageNo,pageSize);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);		   
	   }	   
	   return sourceList;
   }
 //yangali 2010.8.31���,������ԴƵ��,�Ƿ����,��Դtree_id����ѯ
   public List listSourceByChannelByLegalByTreeByPage(int channel,int legal,int tid, int pageNo,int pageSize)throws Exception{
	   List sourceList=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   sourceDAO.setConnection(connection);
		   if(tid==0){
			   sourceList=sourceDAO.listSourceByClassByLegalByPage(channel, legal, pageNo, pageSize);
		   }else{
			   sourceList=sourceDAO.listSourceByChannelByLegalByTreeByPage(channel,legal,tid,pageNo,pageSize);
		   }
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);		   
	   }	   
	   return sourceList;
   }
   //yangali 2010.8.30���,������Դ�Ƿ��������ѯ�������г��������ͨ���ĸ����͵���Դ����
   public List listAttachmentByChannelByLegalByPage(int channel,int legal, int pageNo,int pageSize)throws Exception{
	   List sourceList=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   sourceDAO.setConnection(connection);
		   sourceList=sourceDAO.listAttachmentByChannelByLegalByPage(channel,legal,pageNo,pageSize);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);		   
	   }	   
	   return sourceList;
   }
 //yangali 2010.9.13���,������ԴƵ�����ϴ����û����г�������Դ���������ͨ����δ��˵�
   public List listSourceByChannelByStuByPage(int channel,String stu, int pageNo,int pageSize)throws Exception{
	   List sourceList=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   sourceDAO.setConnection(connection);
		   sourceList=sourceDAO.listSourceByChannelByStuByPage(channel,stu,pageNo,pageSize);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);		   
	   }	   
	   return sourceList;
   }
   public int getSourceCount(){
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select count(*) as count from source"); 
		Connection conn =null;
		try {
		conn = Database.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sqlStr.toString());
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next())
		return resultSet.getInt("count");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			Database.releaseConnection(conn);
		}
		return 0;		
	}
   //yangali 2010.7.26���
   public int getSourceCountByClass(int channel){
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select count(*) as count from source where channel=?"); 
		Connection conn =null;
		try {
		conn = Database.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sqlStr.toString());
		preparedStatement.setInt(1, channel);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next())
		return resultSet.getInt("count");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			Database.releaseConnection(conn);
		}
		return 0;		
	}
   //yangali 2010.8.30���,��ѯƵ�����ͨ���ĸ���
   public int getSourceCountByChannelByLegal(int channel,int legal){
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select count(*) as count from source where channel=? and legal=?"); 
		Connection conn =null;
		try {
		conn = Database.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sqlStr.toString());
		preparedStatement.setInt(1, channel);
		preparedStatement.setInt(2, legal);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next())
		return resultSet.getInt("count");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			Database.releaseConnection(conn);
		}
		return 0;		
	}
 //yangali 2010.9.13 ���,��̨ѧ������ʾ�õ�������ѧ���û�������ԴƵ����ѯ��Դ����
   public int getSourceCountByChannelByStu(int channel,String stu){
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select count(*) as count from source where channel=? and source_author=?"); 
		Connection conn =null;
		try {
		conn = Database.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sqlStr.toString());
		preparedStatement.setInt(1, channel);
		preparedStatement.setString(2, stu);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next())
		return resultSet.getInt("count");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			Database.releaseConnection(conn);
		}
		return 0;		
	}
 //yangali 2010.8.30���,��ѯƵ�����ͨ������Դ��Ӧ�����ĸ���
   public int getAttachmentCountByChannelByLegal(int channel,int legal){
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select count(*) as count from attachment,source" +
					" where attachment.source_id=source.source_id and source.channel=? " +
					"and source.legal=? "); 
		Connection conn =null;
		try {
		conn = Database.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sqlStr.toString());
		preparedStatement.setInt(1, channel);
		preparedStatement.setInt(2, legal);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next())
		return resultSet.getInt("count");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			Database.releaseConnection(conn);
		}
		return 0;		
	}
   //yangali�ú��������Լ���ӵģ����ڼ������Դ��Ӧ�ĸ�������//��ʱ������
   public int getAttachmentCount(int source_id){
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select count(*) as count from attachment");// where source_id=?"); 
		Connection conn =null;
		try {
		conn = Database.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sqlStr.toString());
		//preparedStatement.setInt(1, source_id);
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next())
		return resultSet.getInt("count");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			Database.releaseConnection(conn);
		}
		return 0;		
	}
   
   //yangali 2010.7.27
	public List getAttachments(Long source_id){
		Connection conn =null;
		Attachment condition=new Attachment();
		condition.setAttachment_id(source_id);
		//System.out.println("SourceService.java"+source_id);//test
		try {
			AttachmentDAO attDAO = new AttachmentDAOImpl();
			conn = Database.getConnection();
			attDAO.setConnection(conn);
			return attDAO.listAttachmentBySource(source_id.intValue());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Database.releaseConnection(conn);
		}
		return null;
	}
   
   public Source getSource(int source_id)throws Exception{
	   Source source=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   sourceDAO.setConnection(connection);
		   source=sourceDAO.getSource(source_id);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);
	   }
	   return source;
   }
   //yangali 2010.7.27
   public boolean isImage(Attachment attachment){
		if(
		attachment.getAttachment_addr().toUpperCase().endsWith("JPG")||
		attachment.getAttachment_addr().toUpperCase().endsWith("BMP")||
		attachment.getAttachment_addr().toUpperCase().endsWith("JPEG")||
		attachment.getAttachment_addr().toUpperCase().endsWith("GIF")
		)
			return true;
		return false;
	}
   //yangali 2010.7.27
   
/**
 * @return Returns the sourceDAO.
 */
public SourceDAO getSourceDAO() {
	return sourceDAO;
}
/**
 * @param sourceDAO The sourceDAO to set.
 */
public void setSourceDAO(SourceDAO sourceDAO) {
	this.sourceDAO = sourceDAO;
}
   
}
