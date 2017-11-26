package AI.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import AI.vo.Suggestion;
import AI.dao.SuggestionDAO;
import AI.util.db.Database;

public class SuggestionDAOImpl implements SuggestionDAO {
	
	private Connection connection;
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public SuggestionDAOImpl(){
		try {
			connection = Database.getConnection();
		} catch (SQLException sqle) {
			sqle.getStackTrace();
		}
	}
	//增加建议
	public void addSuggestion(Suggestion suggestion) throws Exception {
		PreparedStatement ps=null;
		try {
			ps=connection.prepareStatement("insert into suggestion(content,username,time) values(?,?,?)");
			ps.setString(1, suggestion.getContent());
			ps.setString(2, suggestion.getUsername());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ps.setString(3, sdf.format(new Date()));
			ps.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		}finally{
			closeStatement(ps);
		}
	}
	//删除该条建议
	public void deleteSuggestion(int id) throws Exception {
		PreparedStatement ps=null;
		try {
			ps=connection.prepareStatement("delete from suggestion where id=?");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		}finally{
			closeStatement(ps);
		}
	}
	//列出所有建议，按页码分别显示
	public List listSuggestionByPage(int pageNo,int pageSize) throws Exception {
		PreparedStatement ps=null;
		ResultSet rs=null;
		List result=null;
		try {
			ps=connection.prepareStatement("select * from suggestion order by time desc limit ?,?");
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			Suggestion suggestion=null;
			result= new ArrayList();
			while (rs.next()) {
				suggestion = new Suggestion();
				suggestion.setId(rs.getInt("id"));
				suggestion.setContent(rs.getString("content"));
				suggestion.setUsername(rs.getString("username"));
				suggestion.setTime(rs.getString("time"));
				result.add(suggestion);
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
	//根据用户名称列出所有建议,按页码显示
	public List listSuggettionByUserByPage(String username,int pageNo,int pageSize) throws Exception {
		PreparedStatement ps=null;
		ResultSet rs=null;
		List result=null;
		try {
			ps=connection.prepareStatement("select * from suggestion where username=?" +
					" order by time desc limit ?,?");
			ps.setString(1, username);
			ps.setInt(2, (pageNo-1)*pageSize);
			ps.setInt(3, pageSize);
			rs=ps.executeQuery();
			Suggestion suggestion=null;
			result= new ArrayList();
			while (rs.next()) {
				suggestion = new Suggestion();
				suggestion.setId(rs.getInt("id"));
				suggestion.setContent(rs.getString("content"));
				suggestion.setUsername(rs.getString("username"));
				suggestion.setTime(rs.getString("time"));
				result.add(suggestion);
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
	//编辑更改建议
	public void updateSuggestion(Suggestion suggestion) throws Exception {
		PreparedStatement ps=null;
		try {
			ps=connection.prepareStatement("update suggestion set content=? where id=?");
			ps.setString(1, suggestion.getContent());
			ps.setInt(2, suggestion.getId());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeStatement(ps);
		}
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
