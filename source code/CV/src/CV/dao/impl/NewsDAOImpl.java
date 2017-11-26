/*
 * Created on 2005-11-10
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package CV.dao.impl;

import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;



import CV.dao.NewsDAO;
import CV.util.db.Database;
import CV.vo.News;

/**
 * @author Administrator
 */
public class NewsDAOImpl implements NewsDAO {
	private Connection connection;

	public NewsDAOImpl() {
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


	public void addNews(News news) throws SQLException{
		String sql="insert into new(new_title,new_date,new_content,new_author,legal) values(?,?,?,?,?)";			
		PreparedStatement ps = connection.prepareStatement(sql);
		int i=1;
		ps.setString(i++,news.getNew_title());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ps.setString(i++,sdf.format(new Date()));
		ps.setString(i++,news.getNew_content());
		ps.setString(i++, news.getNew_author());
		ps.setInt(i++, news.getLegal());
		ps.executeUpdate();
		ps.close();		
	}

	public void updateNews(News news) throws Exception {
		String sql="update new set new_title=?,new_date=?,new_content=?,legal=? where new_id=?";			
		PreparedStatement ps = connection.prepareStatement(sql);
		int i=1;
		ps.setString(i++,news.getNew_title());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ps.setString(i++,sdf.format(new Date()));
		ps.setString(i++,news.getNew_content());
		ps.setInt(i++, news.getLegal());
		ps.setInt(i++, news.getNew_id());
		ps.executeUpdate();
		ps.close();
	}
	
	public void deleteNews(News news)throws Exception{
		String sqlString="delete from new where new_id=?";
		PreparedStatement ps = connection.prepareStatement(sqlString);
		ps.setInt(1,news.getNew_id());
		ps.executeUpdate();
		ps.close();
	}

	public List listAllNews() throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection
					.prepareStatement("select * from new order by new_date desc");
			rs = ps.executeQuery();
			News news = null;
			result = new ArrayList();
			while (rs.next()) {
				news = new News();
				news.setNew_id(rs.getInt("new_id"));
				news.setNew_title(rs.getString("new_title"));
				news.setNew_date(rs.getString("new_date"));
				news.setNew_content(rs.getString("new_content"));
				news.setNew_author(rs.getString("new_author"));
				news.setLegal(rs.getInt("legal"));
				result.add(news);
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
	
	public List listNewsByPage(int pageNo,int pageSize)throws Exception{
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection
					.prepareStatement("select * from new order by new_date desc limit ?,?");
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			News news = null;
			result = new ArrayList();
			while (rs.next()) {
				news = new News();
				news.setNew_id(rs.getInt("new_id"));
				news.setNew_title(rs.getString("new_title"));
				news.setNew_date(rs.getString("new_date"));
				news.setNew_content(rs.getString("new_content"));
				news.setNew_author(rs.getString("new_author"));
				news.setLegal(rs.getInt("legal"));
				result.add(news);
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

	public News getNews(int news_id) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		News news = null;

		try {
			ps = connection.prepareStatement("select * from new where new_id=?");
			ps.setInt(1, news_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				news = new News();
				news.setNew_id(rs.getInt("new_id"));
				news.setNew_title(rs.getString("new_title"));
				news.setNew_date(rs.getString("new_date"));
				news.setNew_content(rs.getString("new_content"));
				news.setNew_author(rs.getString("new_author"));
				news.setLegal(rs.getInt("legal"));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
		return news;
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

	public void legalNews(News news)throws Exception  {
		String sql="update new set legal=? where new_id=?";			
		PreparedStatement ps = connection.prepareStatement(sql);
		int i=1;
		ps.setInt(i++, news.getLegal());
		ps.setInt(i++, news.getNew_id());
		ps.executeUpdate();
		ps.close();
		
	}

	public List listNewsByLegalByPage(int legal, int pageNo, int pageSize)
			throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection
					.prepareStatement("select * from new where legal=? order by new_date desc limit ?,?");
			ps.setInt(1, legal);
			ps.setInt(2, (pageNo-1)*pageSize);
			ps.setInt(3, pageSize);
			rs = ps.executeQuery();
			News news = null;
			result = new ArrayList();
			while (rs.next()) {
				news = new News();
				news.setNew_id(rs.getInt("new_id"));
				news.setNew_title(rs.getString("new_title"));
				news.setNew_date(rs.getString("new_date"));
				news.setNew_content(rs.getString("new_content"));
				news.setNew_author(rs.getString("new_author"));
				news.setLegal(rs.getInt("legal"));
				result.add(news);
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
