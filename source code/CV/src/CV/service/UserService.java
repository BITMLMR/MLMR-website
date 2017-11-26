/**
 * 
 */
package CV.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import CV.dao.UserDAO;
import CV.dao.impl.UserDAOImpl;
import CV.util.db.Database;
import CV.util.mail.MailUtil;
import CV.vo.User;

/**
 * @author Administrator
 *
 */
public class UserService extends BaseService {
	private UserDAO userDAO=new UserDAOImpl();
	
	public void addUser(User user,String basePath)throws Exception{
		Connection connection = null;
		
		StringBuffer body=new StringBuffer();
		StringBuffer link=new StringBuffer();
		body.append("�����˹�������վ��ע����û����ǣ�");
		body.append(user.getUsename());
		body.append(",�����������Ӽ����ʺţ�\n");
		link.append(basePath);
		link.append("user/activeUser.jsp?usename=");
		link.append(user.getUsename());
		link.append("&validateCode=");
		link.append(user.getValidateCode());
		body.append(link.toString());
		try{
			connection=Database.getConnection();
			userDAO.setConnection(connection);
			
			userDAO.addUser(user);
			MailUtil.sendEmail(user.getEmail(),"�˹�������վ�û�ע�ἤ����",body.toString());
			Database.commit();
		}catch(Exception e){
			e.printStackTrace();
			Database.rollback();
			throw e;
		}finally{
			Database.releaseConnection(connection);
		}
	}
   public boolean deleteUser(int userId){
		Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   userDAO.setConnection(connection);
		   userDAO.deleteUser(userId);
		   Database.commit();
		   return true;
	   }catch(Exception e){
		   e.printStackTrace();
		   message = e.getMessage();
		   Database.rollback();
		   return false;
	   }finally{
		   Database.releaseConnection(connection);
	   }
   }
   public void updateUser(User user)throws Exception{
		Connection connection = null;
		try{
		   connection=Database.getConnection();
		   userDAO.setConnection(connection);
		   userDAO.updateUser(user);
		   Database.commit();
	   }catch(Exception  e){
		   e.printStackTrace();
		   Database.rollback();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);
	   }
   }
   public List listAllUser()throws Exception{
	   List userList=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   userDAO.setConnection(connection);
		   userList=userDAO.listAllUser();
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);		   
	   }	   
	   return userList;
   }
   public List listUserByPage(int pageNo,int pageSize)throws Exception{
	   List userList=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   userDAO.setConnection(connection);
		   userList=userDAO.listUserByPage(pageNo,pageSize);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);		   
	   }	   
	   return userList;
   }
 //�����û�����г��û�
   //�������û���ݣ��û���ݹ���4�࣬���������о�������ʦ����������Ա
   //����Ϊ1ʱ�г����û���Ϊ0ʱ�����г����û�
   public List listUserByGenderByPage(int benke,int yanjiu,int teacher,int admin,int pageNo,int pageSize)throws Exception{
	   List userList=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   userDAO.setConnection(connection);
		   userList=userDAO.listUserByGenderByPage(benke,yanjiu,teacher,admin,pageNo,pageSize);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);		   
	   }	   
	   return userList;
   }
   public User getUser(String usename)throws Exception{
	   User user=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   userDAO.setConnection(connection);
		   user=userDAO.getUser(usename);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);
	   }
	   return user;
   }
   public User getUser(int id)throws Exception{
	   User user=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   userDAO.setConnection(connection);
		   user=userDAO.getUser(id);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);
	   }
	   return user;
   }
   //�����û������������û���ݣ��û���ݹ���4�࣬���������о�������ʦ����������Ա
   //����Ϊ1ʱ�����������Ϊ0ʱ�������������
   public int getUserCount(int benke,int yanjiu,int teacher,int admin){
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select count(*) as count from user where 1=1 "); 
		//��ʦֻ�����ѧ��
		if (benke==1&&yanjiu==1&&teacher==0&&admin==0) {
			sqlStr.append(" and gender=0 or gender=1 ");
		}
		//����Ա�������ѧ������ʦ
		else if (benke==1&&yanjiu==1&&teacher==1&&admin==0) {
			sqlStr.append(" and gender=0 or gender=1 or gender=2");
		}
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
   public boolean login(String usename,String password)throws Exception{
	   User user=null;
	   boolean result=false;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   userDAO.setConnection(connection);
		   user=userDAO.getUser(usename);
		   if(user!=null){
			   if(user.getPassword().equals(password)){
				   user.setLoginNum(user.getLoginNum()+1);
				   userDAO.updateUser(user);
				   Database.commit();
				   result=true;
			   }
			   else{ result=false; }
		   }else{ result=false;}
	   }catch(Exception e){
		   e.printStackTrace();
		   Database.rollback();		   
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);
	   }
	   return result;
   }
   public boolean checkUsename(String usename)throws Exception{	   
	   try{
		   User user=getUser(usename);
		  // System.out.println(usename);
		   if(user==null)
			   return false;
		   else
			   return true;
	   }catch(Exception e){
		   throw e;
	   }
   }
   public boolean validateUser(String usename,String validateCode)throws Exception{
	   UserDAO userDAO=new UserDAOImpl();
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   userDAO.setConnection(connection);
		   User user=userDAO.getUser(usename);
		   if(user!=null){
			   if(user.getValidateCode().equals(validateCode)){
				   user.setValidateCode("activated");
				   userDAO.updateUser(user);
				   Database.commit();
				   return true;
			   }
		   }
	   }catch(Exception e){
		   e.printStackTrace();
		   Database.rollback();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);
	   }
	   return false;
   }

	public UserDAO getUserDAO() {
		return userDAO;
	}
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	public boolean legalUser(User user) {
		Connection connection = null;
		try{
		   connection=Database.getConnection();
		   userDAO.setConnection(connection);
		   userDAO.legalUser(user);
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
	public boolean checkUseEmail(String email) throws Exception{
		try{
			   User user=getUserByEmail(email);
			   if(user==null)
				   return false;
			   else
				   return true;
		   }catch(Exception e){
			   throw e;
		   }
	}
   public User getUserByEmail(String email)throws Exception{
	   User user=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   userDAO.setConnection(connection);
		   user=userDAO.getUserByEmail(email);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);
	   }
	   return user;
   }
   
}
