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

import AI.dao.MessageDAO;
import AI.dao.impl.MessageDAOImpl;
import AI.util.db.Database;
import AI.vo.Message;

/**
 * @author yangali
 *
 */
public class MessageService  extends BaseService{
	private MessageDAO messDAO=new MessageDAOImpl();

	public boolean modifyMessage(Message mess) {
		Connection connection = null;
		try {
			connection = Database.getConnection();			
			messDAO.setConnection(connection);
			messDAO.updateMessage(mess);
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
	public boolean addMessage(Message mess) {
		Connection connection = null;
		try {
			
			connection = Database.getConnection();			
			messDAO.setConnection(connection);	
			messDAO.addMessage(mess);
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
	};//添加News信息

	public boolean deleteMessage(Message mess) {
		Connection connection = null;
		try {			
			connection = Database.getConnection();
			messDAO.setConnection(connection);
			messDAO.deleteMessage(mess);
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
	};//删除News信息
   public boolean updateMessage(Message mess)throws Exception{
		Connection connection = null;
		try{
		   connection=Database.getConnection();
		   messDAO.setConnection(connection);
		   messDAO.updateMessage(mess);
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
   public List listAllMessage()throws Exception{
	   List messList=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   messDAO.setConnection(connection);
		   messList=messDAO.listAllMessage();
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);		   
	   }	   
	   return messList;
   }
   public List listMessageByUsename(String usename,int pageNo,int pageSize)throws Exception{
	   List messList=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   messDAO.setConnection(connection);
		   messList=messDAO.listMessageByUsename(usename,pageNo,pageSize);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);		   
	   }	   
	   return messList;
   }
   public List listMessageByPage(int pageNo,int pageSize)throws Exception{
	   List messList=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   messDAO.setConnection(connection);
		   messList=messDAO.listMessageByPage(pageNo,pageSize);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);		   
	   }	   
	   return messList;
   }


   public int getMessageCountByUsename(String usename){
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select count(*) as count from message where usename=?");
		Connection conn =null;
		try {
		conn = Database.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sqlStr.toString());
		int i=1;
		preparedStatement.setString(i++, usename);
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
   public int getMessageCount(){
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select count(*) as count from message"); 
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
   public Message getMessage(int mid)throws Exception{
	   Message mess=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   messDAO.setConnection(connection);
		   mess=messDAO.getMessage(mid);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);
	   }
	   return mess;
   }
   
public MessageDAO getMessageDAO() {
	return messDAO;
}

public void setMessageDAO(MessageDAO messDAO) {
	this.messDAO = messDAO;
}
   
}
