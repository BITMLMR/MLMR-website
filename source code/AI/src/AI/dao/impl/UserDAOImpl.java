/**
 * 
 */
package AI.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

import AI.dao.UserDAO;
import AI.util.db.Database;
import AI.vo.User;

/**
 * @author Administrator
 */
public class UserDAOImpl implements UserDAO {
	private Connection connection;

	public UserDAOImpl() {
		try {
			connection = Database.getConnection();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public void addUser(User user) throws Exception {
		PreparedStatement ps = null;

		try {
			ps = connection
					.prepareStatement("Insert into user(usename,password,email,nickname,gender,status," +
							"question,answer,registerdate,validateCode) values(?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, user.getUsename());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getNickname());
			ps.setString(5, user.getGender());
			ps.setString(6, user.getStatus());
			ps.setString(7, user.getQuestion());
			ps.setString(8, user.getAnswer());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ps.setString(9,sdf.format(new Date()));
			ps.setString(10, user.getValidateCode());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeStatement(ps);
		}
	}

	public void updateUser(User user) throws Exception {
		PreparedStatement ps = null;

		try {
			ps = connection
					.prepareStatement("update user set password=?,email=?,nickname=?,loginNum=?,gender=?,validateCode=? where usename=? ");
			ps.setString(1, user.getPassword());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getNickname());
			ps.setInt(4, user.getLoginNum());
			ps.setString(5, user.getGender());
			ps.setString(6, user.getValidateCode());
			ps.setString(7, user.getUsename());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeStatement(ps);
		}
	}

	public void deleteUser(int userId) throws Exception {
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement("delete from user where id=?");
			ps.setInt(1, userId);
			ps.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeStatement(ps);
		}
	}

	public List listAllUser() throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection
					.prepareStatement("select * from user order by usename asc");
			rs = ps.executeQuery();
			User user = null;
			result = new ArrayList();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsename(rs.getString("usename"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setNickname(rs.getString("nickname"));
				user.setGender(rs.getString("gender"));
				user.setQuestion(rs.getString("question"));
				user.setAnswer(rs.getString("answer"));
				user.setStatus(rs.getString("status"));
				user.setRegisterdate(rs.getTime("registerdate"));
				user.setValidateCode(rs.getString("validateCode"));
				result.add(user);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
		return result;
	}
	public List listUserByPage(int pageNo,int pageSize)throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection
					.prepareStatement("select * from user order by loginNum desc limit ?,?");
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			User user = null;
			result = new ArrayList();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsename(rs.getString("usename"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setNickname(rs.getString("nickname"));
				user.setGender(rs.getString("gender"));
				user.setQuestion(rs.getString("question"));
				user.setAnswer(rs.getString("answer"));
				user.setStatus(rs.getString("status"));
				user.setRegisterdate(rs.getTime("registerdate"));
				user.setLoginNum(rs.getInt("loginNum"));
				user.setValidateCode(rs.getString("validateCode"));
				result.add(user);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
		return result;
	}

	public User getUser(String usename) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;

		try {
			ps = connection.prepareStatement("select * from user where usename=?");
			ps.setString(1, usename);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsename(rs.getString("usename"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setNickname(rs.getString("nickname"));
				user.setGender(rs.getString("gender"));
				user.setQuestion(rs.getString("question"));
				user.setAnswer(rs.getString("answer"));
				user.setStatus(rs.getString("status"));
				user.setRegisterdate(rs.getTime("registerdate"));
				user.setLoginNum(rs.getInt("loginNum"));
				user.setValidateCode(rs.getString("validateCode"));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
		return user;
	}

	public User getUser(int id) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;

		try {
			ps = connection.prepareStatement("select * from user where id=?");
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsename(rs.getString("usename"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setNickname(rs.getString("nickname"));
				user.setGender(rs.getString("gender"));
				user.setQuestion(rs.getString("question"));
				user.setAnswer(rs.getString("answer"));
				user.setStatus(rs.getString("status"));
				user.setRegisterdate(rs.getTime("registerdate"));
				user.setLoginNum(rs.getInt("loginNum"));
				user.setValidateCode(rs.getString("validateCode"));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
		return user;
	}
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
				st = null;
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}

	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}

	public List listUserByGenderByPage(int benke, int yanjiu, int teacher,
			int admin, int pageNo, int pageSize) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			//老师只能审核学生
			if (benke==1&&yanjiu==1&&teacher==0&&admin==0) {
				ps = connection.prepareStatement("select * from user" +
						" where gender=0 or gender=1 order by loginNum desc limit ?,?");
			}
			//管理员可以审核学生和老师
			else if (benke==1&&yanjiu==1&&teacher==1&&admin==0) {
					ps = connection.prepareStatement("select * from user " +
							" where gender=0 or gender=1 or gender=2 order by loginNum desc limit ?,?");
			}
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			User user = null;
			result = new ArrayList();
			while (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsename(rs.getString("usename"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setNickname(rs.getString("nickname"));
				user.setGender(rs.getString("gender"));
				user.setQuestion(rs.getString("question"));
				user.setAnswer(rs.getString("answer"));
				user.setStatus(rs.getString("status"));
				user.setRegisterdate(rs.getTime("registerdate"));
				user.setLoginNum(rs.getInt("loginNum"));
				user.setValidateCode(rs.getString("validateCode"));
				result.add(user);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
		return result;
	}

	public void legalUser(User user) throws Exception {
		String sql="update user set status=? where id=?";			
		PreparedStatement ps = connection.prepareStatement(sql);
		int i=1;
		ps.setString(i++, user.getStatus());
		ps.setInt(i++, user.getId());
		ps.executeUpdate();
		ps.close();
		
	}

	public User getUserByEmail(String email) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		User user = null;

		try {
			ps = connection.prepareStatement("select * from user where email=?");
			ps.setString(1, email);
			rs = ps.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsename(rs.getString("usename"));
				user.setPassword(rs.getString("password"));
				user.setEmail(rs.getString("email"));
				user.setNickname(rs.getString("nickname"));
				user.setGender(rs.getString("gender"));
				user.setQuestion(rs.getString("question"));
				user.setAnswer(rs.getString("answer"));
				user.setStatus(rs.getString("status"));
				user.setRegisterdate(rs.getTime("registerdate"));
				user.setLoginNum(rs.getInt("loginNum"));
				user.setValidateCode(rs.getString("validateCode"));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
		return user;
	}
}
