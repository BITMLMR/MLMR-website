/**
 * 
 */
package AI.dao;

import java.sql.Connection;
import java.util.List;

import AI.vo.Admin;

/**
 * @author Administrator
 */
public interface AdminDAO {
	public void addAdmin(Admin admin)throws Exception;

	public void updateAdmin(Admin admin)throws Exception;

	public void deleteAdmin(String aid)throws Exception;

	public List listAllAdmin()throws Exception;

	public Admin getAdmin(String aid)throws Exception;
	
	public Connection getConnection()throws Exception;
	
	public void setConnection(Connection connection)throws Exception;
	
}
