package AI.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import AI.dao.HomeworkDAO;
import AI.util.db.Database;
import AI.vo.Homework;

public class HomeworkDAOImpl implements HomeworkDAO {
	private Connection connection;
	
	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	public HomeworkDAOImpl(){
		try {
			connection = Database.getConnection();
		} catch (SQLException sqle) {
			sqle.getStackTrace();
		}
	}
	//ѧ���ϴ���ҵ
	public void addHomework(Homework homework) throws Exception {
		PreparedStatement ps=null;
		try {
			ps=connection.prepareStatement("insert into homework(source_id,username,homework_addr,homework_time,homework_title) values(?,?,?,?,?)");
			ps.setInt(1, homework.getSource_id());
			ps.setString(2, homework.getUsername());
			ps.setString(3, homework.getHomework_addr());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ps.setString(4, sdf.format(new Date()));
			ps.setString(5, homework.getHomework_title());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		}finally{
			closeStatement(ps);
		}
	}
	//��ʦ������ʾ���е���ҵ
	public List listHomeworkByPage(int pageNo, int pageSize) throws Exception {
		PreparedStatement ps=null;
		ResultSet rs=null;
		List result=null;
		try {
			ps=connection.prepareStatement("select * from homework " +
					" order by homework_time desc limit ?,?");
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs=ps.executeQuery();
			Homework homework=null;
			result= new ArrayList();
			while (rs.next()) {
				homework = new Homework();
				homework.setId(rs.getInt("id"));
				homework.setSource_id(rs.getInt("source_id"));
				homework.setUsername(rs.getString("username"));
				homework.setHomework_addr(rs.getString("homework_addr"));
				homework.setHomework_time(rs.getString("homework_time"));
				homework.setTeacher(rs.getString("teacher"));
				homework.setCorrection_addr(rs.getString("correction_addr"));
				homework.setCorrection_time(rs.getString("correction_time"));
				homework.setHomework_title(rs.getString("homework_title"));
				homework.setCorrection_title(rs.getString("correction_title"));
				result.add(homework);
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
	//ѧ��ֻ��ʾ�Լ�����ҵ
	public List listHomeworkByUsernameByPage(String username, int pageNo,
			int pageSize) throws Exception {
		PreparedStatement ps=null;
		ResultSet rs=null;
		List result=null;
		try {
			ps=connection.prepareStatement("select * from homework where username=?" +
					" order by homework_time desc limit ?,?");
			ps.setString(1, username);
			ps.setInt(2, (pageNo-1)*pageSize);
			ps.setInt(3, pageSize);
			rs=ps.executeQuery();
			Homework homework=null;
			result= new ArrayList();
			while (rs.next()) {
				homework = new Homework();
				homework.setId(rs.getInt("id"));
				homework.setSource_id(rs.getInt("source_id"));
				homework.setUsername(rs.getString("username"));
				homework.setHomework_addr(rs.getString("homework_addr"));
				homework.setHomework_time(rs.getString("homework_time"));
				homework.setTeacher(rs.getString("teacher"));
				homework.setCorrection_addr(rs.getString("correction_addr"));
				homework.setCorrection_time(rs.getString("correction_time"));
				homework.setHomework_title(rs.getString("homework_title"));
				homework.setCorrection_title(rs.getString("correction_title"));
				result.add(homework);
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
	//������ҵ��������ʦ�ϴ�������ҵ
	public void updateHomework(Homework homework) throws Exception {
		PreparedStatement ps=null;
		try {
			ps=connection.prepareStatement("update homework set teacher=?,correction_addr=?,correction_time=?,correction_title=? where id=?");
			ps.setString(1, homework.getTeacher());
			ps.setString(2, homework.getCorrection_addr());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ps.setString(3, sdf.format(new Date()));
			ps.setString(4, homework.getCorrection_title());
			ps.setInt(5, homework.getId());
			ps.executeUpdate();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeStatement(ps);
		}		
	}
	//ѧ���ϴ��°汾����ҵ
	public void updateHomeworkByStu(Homework homework) throws Exception {
		PreparedStatement ps=null;
		try {
			ps=connection.prepareStatement("update homework set homework_addr=?,homework_time=?,homework_title=? " +
					"where username=? and source_id=?");
			ps.setString(1, homework.getHomework_addr());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			ps.setString(2, sdf.format(new Date()));
			ps.setString(3, homework.getHomework_title());
			ps.setString(4, homework.getUsername());
			ps.setInt(5, homework.getSource_id());
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
	//�����û�����username,��ҵsource_id�г�������ҵ
	public List listHomeworkByUserBySourceId(String username, int sourceId)
			throws Exception {
		PreparedStatement ps=null;
		ResultSet rs=null;
		List result=null;
		try {
			ps=connection.prepareStatement("select * from homework where username=?" +
					"and source_id=? order by homework_time");
			ps.setString(1, username);
			ps.setInt(2, sourceId);
			rs=ps.executeQuery();
			Homework homework=null;
			result= new ArrayList();
			while (rs.next()) {
				homework = new Homework();
				homework.setId(rs.getInt("id"));
				homework.setSource_id(rs.getInt("source_id"));
				homework.setUsername(rs.getString("username"));
				homework.setHomework_addr(rs.getString("homework_addr"));
				homework.setHomework_time(rs.getString("homework_time"));
				homework.setTeacher(rs.getString("teacher"));
				homework.setCorrection_addr(rs.getString("correction_addr"));
				homework.setCorrection_time(rs.getString("correction_time"));
				homework.setHomework_title(rs.getString("homework_title"));
				homework.setCorrection_title(rs.getString("correction_title"));
				result.add(homework);
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
	//ͨ���û�������Դ��Ų�ѯ�Ƿ���ڸ�����¼�������ظü�¼
	public Homework getHomework(String username, int sourceId)throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Homework homework = null;

		try {
			ps = connection.prepareStatement("select * from homework where username=? and source_id=?");
			ps.setString(1, username);
			ps.setInt(2, sourceId);
			rs = ps.executeQuery();
			if (rs.next()) {
				homework = new Homework();
				homework.setId(rs.getInt("id"));
				homework.setSource_id(rs.getInt("source_id"));
				homework.setUsername(rs.getString("username"));
				homework.setHomework_addr(rs.getString("homework_addr"));
				homework.setHomework_time(rs.getString("homework_time"));
				homework.setTeacher(rs.getString("teacher"));
				homework.setCorrection_addr(rs.getString("correction_addr"));
				homework.setCorrection_time(rs.getString("correction_time"));
				homework.setHomework_title(rs.getString("homework_title"));
				homework.setCorrection_title(rs.getString("correction_title"));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
		return homework;
	}
	//������ҵsource_id�г�������ҵ
	public List listHomeworkBySourceId(int sourceId) throws Exception {
		PreparedStatement ps=null;
		ResultSet rs=null;
		List result=null;
		try {
			ps=connection.prepareStatement("select * from homework where " +
					" source_id=? order by correction_time,homework_time");
			ps.setInt(1, sourceId);
			rs=ps.executeQuery();
			Homework homework=null;
			result= new ArrayList();
			while (rs.next()) {
				homework = new Homework();
				homework.setId(rs.getInt("id"));
				homework.setSource_id(rs.getInt("source_id"));
				homework.setUsername(rs.getString("username"));
				homework.setHomework_addr(rs.getString("homework_addr"));
				homework.setHomework_time(rs.getString("homework_time"));
				homework.setTeacher(rs.getString("teacher"));
				homework.setCorrection_addr(rs.getString("correction_addr"));
				homework.setCorrection_time(rs.getString("correction_time"));
				homework.setHomework_title(rs.getString("homework_title"));
				homework.setCorrection_title(rs.getString("correction_title"));
				result.add(homework);
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
}
