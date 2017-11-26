/**
 * 
 */
package AI.service;

import java.sql.Connection;
import java.util.List;

import AI.dao.AdminDAO;
import AI.dao.impl.AdminDAOImpl;
import AI.util.db.Database;
import AI.vo.Admin;

/**
 * @author Administrator
 *
 */
public class AdminService extends BaseService{
	private AdminDAO AdminDAO=new AdminDAOImpl();
	
   public void deleteAdmin(String aid)throws Exception{
		Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   AdminDAO.setConnection(connection);
		   AdminDAO.deleteAdmin(aid);
		   Database.commit();
	   }catch(Exception e){
		   e.printStackTrace();
		   Database.rollback();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);
	   }
   }
   public void updateAdmin(Admin Admin)throws Exception{
		Connection connection = null;
		try{
		   connection=Database.getConnection();
		   AdminDAO.setConnection(connection);
		   AdminDAO.updateAdmin(Admin);
		   Database.commit();
	   }catch(Exception  e){
		   e.printStackTrace();
		   Database.rollback();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);
	   }
   }
   public boolean modifyAdmin(Admin admin) {
		Connection connection = null;
		try {
			connection = Database.getConnection();
			AdminDAO.setConnection(connection);
			AdminDAO.updateAdmin(admin);
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
   public List listAllAdmin()throws Exception{
	   List AdminList=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   AdminDAO.setConnection(connection);
		   AdminList=AdminDAO.listAllAdmin();
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);		   
	   }	   
	   return AdminList;
   }
   public Admin getAdmin(String aid)throws Exception{
	   Admin Admin=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   AdminDAO.setConnection(connection);
		   Admin=AdminDAO.getAdmin(aid);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);
	   }
	   return Admin;
   }
   public boolean login(String aid,String password)throws Exception{
	   Admin admin=null;
	   boolean result=false;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   AdminDAO.setConnection(connection);
		   admin=AdminDAO.getAdmin(aid);
		   if(admin!=null){
			   if(admin.getPassword().equals(password)){
				   //admin.setLoginNum(admin.getLoginNum()+1);
				   //adminDAO.updateUser(admin);
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
/**
 * @return Returns the AdminDAO.
 */
public AdminDAO getAdminDAO() {
	return AdminDAO;
}
/**
 * @param AdminDAO The AdminDAO to set.
 */
public void setAdminDAO(AdminDAO AdminDAO) {
	this.AdminDAO = AdminDAO;
}
   
}
