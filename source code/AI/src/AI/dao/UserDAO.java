/**
 * 
 */
package AI.dao;

import java.sql.Connection;
import java.util.List;

import AI.vo.User;

/**
 * @author Administrator
 */
public interface UserDAO {
	public void addUser(User user)throws Exception;

	public void updateUser(User user)throws Exception;

	public void deleteUser(int userId)throws Exception;

	public List listAllUser()throws Exception;
	
	public List listUserByPage(int pageNo,int pageSize)throws Exception;

	public User getUser(String usename)throws Exception;
	
	public User getUser(int id)throws Exception;
	
	public Connection getConnection()throws Exception;
	
	public void setConnection(Connection connection)throws Exception;

	public List listUserByGenderByPage(int benke, int yanjiu, int teacher,
			int admin, int pageNo, int pageSize)throws Exception;

	public void legalUser(User user)throws Exception;

	public User getUserByEmail(String email)throws Exception;
	
}
