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

import CV.dao.SourceDAO;
import CV.util.db.Database;
import CV.vo.Attachment;
import CV.vo.Source;;

/**
 * @author Administrator
 */
public class SourceDAOImpl implements SourceDAO {
	private Connection connection;

	public SourceDAOImpl() {
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

	public void addSource(Source source) throws Exception {
		String sql="insert into source(source_title,channel,type,source_date,source_author," +
				"source_content,legal,tree_id) values(?,?,?,?,?,?,?,?)";			
		PreparedStatement ps = connection.prepareStatement(sql);
		int i=1;
		ps.setString(i++,source.getSource_title());
		ps.setInt(i++, source.getChannel());
		ps.setInt(i++,source.getType());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ps.setString(i++,sdf.format(new Date()));
		ps.setString(i++,source.getSource_author());
		ps.setString(i++,source.getSource_content());
		ps.setInt(i++, source.getLegal());
		ps.setString(i++, source.getTree_id());
		ps.executeUpdate();
		ps.close();	
		
	}

	public void deleteSource(Source source) throws Exception {
		String sqlString="delete from source where source_id=?";
		PreparedStatement ps = connection.prepareStatement(sqlString);
		ps.setInt(1,source.getSource_id());
		ps.executeUpdate();
		ps.close();
		
	}

	public Source getSource(int source_id) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Source source = null;

		try {
			ps = connection.prepareStatement("select * from source where source_id=?");
			ps.setInt(1, source_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				source = new Source();
				source.setSource_id(rs.getInt("source_id"));
				source.setSource_title(rs.getString("source_title"));
				source.setChannel(rs.getInt("channel"));
				source.setType(rs.getInt("type"));
				source.setSource_date(rs.getString("source_date"));
				source.setSource_author(rs.getString("source_author"));
				source.setSource_content(rs.getString("source_content"));
				source.setLegal(rs.getInt("legal"));
				source.setTree_id(rs.getString("tree_id"));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
		return source;
	}

	public List listAllSource() throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection
					.prepareStatement("select * from source order by source_date desc");
			rs = ps.executeQuery();
			Source source = null;
			result = new ArrayList();
			while (rs.next()) {
				source = new Source();
				source.setSource_id(rs.getInt("source_id"));
				source.setSource_title(rs.getString("source_title"));
				source.setChannel(rs.getInt("channel"));
				source.setType(rs.getInt("type"));
				source.setSource_date(rs.getString("source_date"));
				source.setSource_author(rs.getString("source_author"));
				source.setSource_content(rs.getString("source_content"));
				source.setLegal(rs.getInt("legal"));
				source.setTree_id(rs.getString("tree_id"));
				result.add(source);
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

	public List listSourceByClass(int channel, int pageNo, int pageSize)
			throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection
					.prepareStatement("select * from source where channel=? " +
							"order by source_date desc limit ?,?");
			ps.setInt(1, channel);
			ps.setInt(2, (pageNo-1)*pageSize);
			ps.setInt(3, pageSize);
			rs = ps.executeQuery();
			Source source = null;
			result = new ArrayList();
			while (rs.next()) {
				source = new Source();
				source.setSource_id(rs.getInt("source_id"));
				source.setSource_title(rs.getString("source_title"));
				source.setChannel(rs.getInt("channel"));
				source.setType(rs.getInt("type"));
				source.setSource_date(rs.getString("source_date"));
				source.setSource_author(rs.getString("source_author"));
				source.setSource_content(rs.getString("source_content"));
				source.setLegal(rs.getInt("legal"));
				source.setTree_id(rs.getString("tree_id"));
				result.add(source);
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

	public List listSourceByPage(int pageNo, int pageSize) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection
					.prepareStatement("select * from source order by source_date desc limit ?,?");
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			Source source = null;
			result = new ArrayList();
			while (rs.next()) {
				source = new Source();
				source.setSource_id(rs.getInt("source_id"));
				source.setSource_title(rs.getString("source_title"));
				source.setChannel(rs.getInt("channel"));
				source.setType(rs.getInt("type"));
				source.setSource_date(rs.getString("source_date"));
				source.setSource_author(rs.getString("source_author"));
				source.setSource_content(rs.getString("source_content"));
				source.setLegal(rs.getInt("legal"));
				source.setTree_id(rs.getString("tree_id"));
				result.add(source);
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

	public void updateSource(Source source) throws Exception {
		String sql="update source set source_title=?,channel=?,class_name=?,source_date=?," +
					"source_author=?,source_content=?,legal=?,tree_id=? where source_id=?";			
		PreparedStatement ps = connection.prepareStatement(sql);
		int i=1;
		ps.setString(i++,source.getSource_title());
		ps.setInt(i++, source.getChannel());
		ps.setInt(i++,source.getType());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ps.setString(i++,sdf.format(new Date()));
		ps.setString(i++,source.getSource_author());
		ps.setString(i++,source.getSource_content());
		ps.setInt(i++, source.getLegal());
		ps.setString(i++, source.getTree_id());
		ps.setInt(i++, source.getSource_id());
		
		ps.executeUpdate();
		ps.close();
		
	}
	
	public synchronized Long getCurrentID() throws SQLException {
		PreparedStatement preparedStatement = connection.prepareStatement("select max(ni.source_id) as m from source ni");
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next()){
		long currentID = resultSet.getLong("m");
		return new Long(currentID);
		}
		return null;
	}

	//yangali 2010.7.27 
	public List listSourceByClassByPage(int channel, int pageNo, int pageSize)
			throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection.prepareStatement("select * from source where channel=?" +
					" order by source_date desc limit ?,?");
			ps.setInt(1, channel);
			ps.setInt(2, (pageNo-1)*pageSize);
			ps.setInt(3, pageSize);
			rs = ps.executeQuery();
			Source source = null;
			result = new ArrayList();
			while (rs.next()) {
				source = new Source();
				source.setSource_id(rs.getInt("source_id"));
				source.setSource_title(rs.getString("source_title"));
				source.setChannel(rs.getInt("channel"));
				source.setType(rs.getInt("type"));
				source.setSource_date(rs.getString("source_date"));
				source.setSource_author(rs.getString("source_author"));
				source.setSource_content(rs.getString("source_content"));
				source.setLegal(rs.getInt("legal"));
				source.setTree_id(rs.getString("tree_id"));
				result.add(source);
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
	//yangali 2010.8.29添加,根据资源是否审核来查询
	public List listSourceByClassByLegalByPage(int channel, int legal,int pageNo, int pageSize) 
			throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection.prepareStatement("select * from source where channel=? and legal=?" +
					" order by source_date desc limit ?,?");
			ps.setInt(1, channel);
			ps.setInt(2, legal);
			ps.setInt(3, (pageNo-1)*pageSize);
			ps.setInt(4, pageSize);
			rs = ps.executeQuery();
			Source source = null;
			result = new ArrayList();
			while (rs.next()) {
				source = new Source();
				source.setSource_id(rs.getInt("source_id"));
				source.setSource_title(rs.getString("source_title"));
				source.setChannel(rs.getInt("channel"));
				source.setType(rs.getInt("type"));
				source.setSource_date(rs.getString("source_date"));
				source.setSource_author(rs.getString("source_author"));
				source.setSource_content(rs.getString("source_content"));
				source.setLegal(rs.getInt("legal"));
				source.setTree_id(rs.getString("tree_id"));
				result.add(source);
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
	//yangali 2010.8.30添加,根据资源是否审核来查询附件，列出所有审核通过的该类型的资源附件
	public List listAttachmentByChannelByLegalByPage(int channel, int legal,
			int pageNo, int pageSize) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection.prepareStatement("select attachment_id,source.source_id," +
					"attachment_name,attachment_addr from attachment,source" +
					" where attachment.source_id=source.source_id and source.channel=? " +
					"and source.legal=? order by source.source_date desc limit ?,?");
			ps.setInt(1, channel);
			ps.setInt(2, legal);
			ps.setInt(3, (pageNo-1)*pageSize);
			ps.setInt(4, pageSize);
			rs = ps.executeQuery();
			Attachment attachment = null;
			result = new ArrayList();
			while (rs.next()) {
				attachment = new Attachment();
				attachment.setAttachment_id(new Long(rs.getInt("attachment_id")));
				attachment.setSource_id(rs.getInt("source.source_id"));
				attachment.setAttachment_name(rs.getString("attachment_name"));
				attachment.setAttachment_addr(rs.getString("attachment_addr"));
				result.add(attachment);
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
	//yangali 2010.8.31添加,根据资源频道,是否审核,资源tree_id来查询
	public List listSourceByChannelByLegalByTreeByPage(int channel, int legal,
			int tid, int pageNo, int pageSize) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection.prepareStatement("select * from source where channel=? and legal=? " +
					"and tree_id like ? order by source_date desc limit ?,?");
			ps.setInt(1, channel);
			ps.setInt(2, legal);
			ps.setString(3, "%/"+tid+"/%");
			ps.setInt(4, (pageNo-1)*pageSize);
			ps.setInt(5, pageSize);
			rs = ps.executeQuery();
			Source source = null;
			result = new ArrayList();
			while (rs.next()) {
				source = new Source();
				source.setSource_id(rs.getInt("source_id"));
				source.setSource_title(rs.getString("source_title"));
				source.setChannel(rs.getInt("channel"));
				source.setType(rs.getInt("type"));
				source.setSource_date(rs.getString("source_date"));
				source.setSource_author(rs.getString("source_author"));
				source.setSource_content(rs.getString("source_content"));
				source.setLegal(rs.getInt("legal"));
				source.setTree_id(rs.getString("tree_id"));
				result.add(source);
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
	//yangali 2010.9.13添加,根据资源频道和上传者用户名列出所有资源，包括审核通过和未审核的
	public List listSourceByChannelByStuByPage(int channel, String stu,
			int pageNo, int pageSize) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection.prepareStatement("select * from source where channel=? and" +
					" source_author=? order by source_date desc limit ?,?");
			ps.setInt(1, channel);
			ps.setString(2, stu);
			ps.setInt(3, (pageNo-1)*pageSize);
			ps.setInt(4, pageSize);
			rs = ps.executeQuery();
			Source source = null;
			result = new ArrayList();
			while (rs.next()) {
				source = new Source();
				source.setSource_id(rs.getInt("source_id"));
				source.setSource_title(rs.getString("source_title"));
				source.setChannel(rs.getInt("channel"));
				source.setType(rs.getInt("type"));
				source.setSource_date(rs.getString("source_date"));
				source.setSource_author(rs.getString("source_author"));
				source.setSource_content(rs.getString("source_content"));
				source.setLegal(rs.getInt("legal"));
				source.setTree_id(rs.getString("tree_id"));
				result.add(source);
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
	
	public void legalSource(Source source) throws Exception {
		String sql="update source set legal=? where source_id=?";			
		PreparedStatement ps = connection.prepareStatement(sql);
		int i=1;
		ps.setInt(i++, source.getLegal());
		ps.setInt(i++, source.getSource_id());
		ps.executeUpdate();
		ps.close();
		
	}

}
