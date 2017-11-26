/*
 * Created on 2005-11-10
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package AI.dao;

import java.sql.Connection;
import java.util.List;

import AI.vo.Message;

/**
 * @author Administrator
 */
public interface MessageDAO {

	public void addMessage(Message message)throws Exception;//���Message��Ϣ
	
	public void updateMessage(Message message)throws Exception;

	public void deleteMessage(Message message)throws Exception;//ɾ��Message��Ϣ

	public List listAllMessage()throws Exception;
	
	public List listMessageByUsename(String usename,int pageNo,int pageSize)throws Exception;

	public List listMessageByPage(int pageNo,int pageSize)throws Exception;

	public Message getMessage(int mid)throws Exception;
	
	public Connection getConnection()throws Exception;
	
	public void setConnection(Connection connection)throws Exception;
	
}
