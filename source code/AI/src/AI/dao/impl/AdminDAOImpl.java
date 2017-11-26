/**
 * 
 */
package AI.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import AI.dao.AdminDAO;
import AI.util.db.Database;
import AI.vo.Admin;


public class AdminDAOImpl implements AdminDAO {
	private Connection connection;

	public AdminDAOImpl() {
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

	public void addAdmin(Admin admin) throws Exception {
		PreparedStatement ps = null;

		try {
			ps = connection
					.prepareStatement("Insert into admin(uid,password) values(?,?)");
			ps.setString(1, admin.getAid());
			ps.setString(2, admin.getPassword());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeStatement(ps);
		}
	}

	public void updateAdmin(Admin admin) throws Exception {
		PreparedStatement ps = null;

		try {
			ps = connection
					.prepareStatement("update admin set password=? where aid=? ");
			ps.setString(1, admin.getPassword());
			ps.setString(2, admin.getAid());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeStatement(ps);
		}
	}


	public void deleteAdmin(String aid) throws Exception {
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement("delete from admin where aid=?");
			ps.setString(1, aid);
			ps.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeStatement(ps);
		}
	}

	public List listAllAdmin() throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection
					.prepareStatement("select * from admin order by aid asc");
			rs = ps.executeQuery();
			Admin admin = null;
			result = new ArrayList();
			while (rs.next()) {
				admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setAid(rs.getString("uid"));
				admin.setPassword(rs.getString("password"));
				result.add(admin);
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

	public Admin getAdmin(String aid) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin admin = null;

		try {
			ps = connection.prepareStatement("select * from admin where aid=?");
			ps.setString(1, aid);
			rs = ps.executeQuery();
			if (rs.next()) {
				admin = new Admin();
				admin.setId(rs.getInt("id"));
				admin.setAid(rs.getString("aid"));
				admin.setPassword(rs.getString("password"));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
		return admin;
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
}
