/*
 * Created on 2005-11-10
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package AI.service;

import java.sql.Connection;

import AI.vo.Attachment;
import AI.dao.AttachmentDAO;
import AI.dao.impl.AttachmentDAOImpl;

import AI.util.db.Database;


/**
 * @author Administrator
 *
 */
public class AttachmentService  extends BaseService{
	private AttachmentDAO attachmentDAO=new AttachmentDAOImpl();
	public Attachment getAttachment(int attachment_id)throws Exception{
	   Attachment attachment=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   attachmentDAO.setConnection(connection);
		   attachment=attachmentDAO.getAttachment(attachment_id);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);
	   }
	   return attachment;
   }
/**
 * @return Returns the attachmentDAO.
 */
public AttachmentDAO getAttachmentDAO() {
	return attachmentDAO;
}
/**
 * @param sourceDAO The attachmentDAO to set.
 */
public void setAttachmentDAO(AttachmentDAO attachmentDAO) {
	this.attachmentDAO = attachmentDAO;
}
   
}
