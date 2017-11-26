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
			sourceDAO.addSource(source);//首先添加资源信息
			Long currentID = sourceDAO.getCurrentID();
			for(int i=0;i<upload.getFiles().getCount();i++){
				File f = upload.getFiles().getFile(i);
				if(f.isMissing())continue;
				Attachment attachment=new Attachment();
				attachment.setSource_id(currentID.intValue());
				attachment.setAttachment_name(f.getFileName());
				attachment.setAttachment_addr(saveurl[i]);
				attachmentDAO.addAttachment(attachment);	//添加一条附件信息	
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
	};//添加Source信息
	//yangali有改动，改动较大。添加了删除服务器上的文件
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
			//yangali添加删除服务器上面的文件
			//首先得到该资源下面有几个附件			
			//列出所有该资源的附件
			List results = attachmentDAO.listAttachmentBySource(source_id);
			System.out.println(results.size()+"个附件被删除！");
			//依次删除资源下面的所有附件
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
			    if (f.exists())  //检查File.txt是否存在
			    f.delete();
			}
			attachmentDAO.deleteAttachmentBySource(source);//.deleteAttrBySource(source);
			//yangali添加删除服务器上面的文件end
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
	};//删除Source信息
	
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
   //yangali 2010.7.26添加
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
   //yangali 2010.8.29添加,根据资源是否审核来查询
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
 //yangali 2010.8.31添加,根据资源频道,是否审核,资源tree_id来查询
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
   //yangali 2010.8.30添加,根据资源是否审核来查询附件，列出所有审核通过的该类型的资源附件
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
 //yangali 2010.9.13添加,根据资源频道和上传者用户名列出所有资源，包括审核通过和未审核的
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
   //yangali 2010.7.26添加
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
   //yangali 2010.8.30添加,查询频道审核通过的个数
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
 //yangali 2010.9.13 添加,后台学生处显示用到，根据学生用户名、资源频道查询资源个数
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
 //yangali 2010.8.30添加,查询频道审核通过的资源对应附件的个数
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
   //yangali该函数是我自己添加的，用于计算该资源对应的附件个数//暂时无用了
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
