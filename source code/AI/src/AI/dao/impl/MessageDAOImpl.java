/*
 * Created on 2005-11-10
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package AI.dao.impl;

import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



import AI.dao.MessageDAO;
import AI.util.db.Database;
import AI.vo.Message;

/**
 * @author yangali
 */
public class MessageDAOImpl implements MessageDAO {
	private Connection connection;

	public MessageDAOImpl() {
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

	public void addMessage(Message message) throws SQLException{
		String sql="insert into message(usename,question,question_time,title) values(?,?,?,?)";			
		PreparedStatement ps = connection.prepareStatement(sql);
		int i=1;
		ps.setString(i++,message.getUsename());
		ps.setString(i++, message.getQuestion());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ps.setString(i++,sdf.format(new Date()));
		//System.out.println(sdf.format(new java.util.Date()));
		ps.setString(i++, message.getTitle());
		ps.executeUpdate();
		ps.close();		
	}

	public void updateMessage(Message message) throws Exception {
		String sql="update message set answer=?,answer_time=?,teacher=? where mid=?";			
		PreparedStatement ps = connection.prepareStatement(sql);
		int i=1;
		ps.setString(i++,message.getAnswer());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ps.setString(i++,sdf.format(new Date()));
		ps.setString(i++, message.getTeacher());
		ps.setInt(i++, message.getMid());
		ps.executeUpdate();
		ps.close();
	}

	public void deleteMessage(Message message)throws Exception{
		String sqlString="delete from message where mid=?";
		PreparedStatement ps = connection.prepareStatement(sqlString);
		ps.setInt(1,message.getMid());
		ps.executeUpdate();
		ps.close();
	}

	public List listAllMessage() throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection
					.prepareStatement("select * from message order by question_time desc");
			rs = ps.executeQuery();
			Message message = null;
			result = new ArrayList();
			while (rs.next()) {
				message = new Message();
				message.setMid(rs.getInt("mid"));
				message.setUsename(rs.getString("usename"));
				message.setQuestion(rs.getString("question"));
				message.setQuestion_time(rs.getString("question_time"));
				message.setAnswer(rs.getString("answer"));
				message.setAnswer_time(rs.getString("answer_time"));
				message.setTitle(rs.getString("title"));
				message.setTeacher(rs.getString("teacher"));
				result.add(message);
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

	public List listMessageByUsename(String usename,int pageNo,int pageSize)throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection
					.prepareStatement("select * from message where usename=? order by question_time desc limit ?,?");
			ps.setString(1, usename);
			ps.setInt(2, (pageNo-1)*pageSize);
			ps.setInt(3, pageSize);
			rs = ps.executeQuery();
			Message message = null;
			result = new ArrayList();
			while (rs.next()) {
				message = new Message();
				message.setMid(rs.getInt("mid"));
				message.setUsename(rs.getString("usename"));
				message.setQuestion(rs.getString("question"));
				message.setQuestion_time(rs.getString("question_time"));
				message.setAnswer(rs.getString("answer"));
				message.setAnswer_time(rs.getString("answer_time"));
				message.setTitle(rs.getString("title"));
				message.setTeacher(rs.getString("teacher"));
				result.add(message);
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
	
	public List listMessageByPage(int pageNo,int pageSize)throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection
					.prepareStatement("select * from message order by question_time desc limit ?,?");
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			Message message = null;
			result = new ArrayList();
			while (rs.next()) {
				message = new Message();
				message.setMid(rs.getInt("mid"));
				message.setUsename(rs.getString("usename"));
				message.setQuestion(rs.getString("question"));
				message.setQuestion_time(rs.getString("question_time"));
				message.setAnswer(rs.getString("answer"));
				message.setAnswer_time(rs.getString("answer_time"));
				message.setTitle(rs.getString("title"));
				message.setTeacher(rs.getString("teacher"));
				result.add(message);
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

	public Message getMessage(int mid) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Message message = null;

		try {
			ps = connection.prepareStatement("select * from message where mid=?");
			ps.setInt(1, mid);
			rs = ps.executeQuery();
			if (rs.next()) {
				message = new Message();
				message.setMid(rs.getInt("mid"));
				message.setUsename(rs.getString("usename"));
				message.setQuestion(rs.getString("question"));
				message.setQuestion_time(rs.getString("question_time"));
				message.setAnswer(rs.getString("answer"));
				message.setAnswer_time(rs.getString("answer_time"));
				message.setTitle(rs.getString("title"));
				message.setTeacher(rs.getString("teacher"));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
		return message;
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
