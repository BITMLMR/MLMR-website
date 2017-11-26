/*
 * Created on 2005-11-10
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package CV.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import CV.dao.AttachmentDAO;
import CV.util.db.Database;
import CV.vo.Attachment;
import CV.vo.Source;

/**
 * @author Administrator
 */
public class AttachmentDAOImpl implements AttachmentDAO {
	private Connection connection;

	public AttachmentDAOImpl() {
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

	public void addAttachment(Attachment attachment) throws Exception {
		String sql="insert into attachment(source_id,attachment_name,attachment_addr)" +
				" values(?,?,?)";			
		PreparedStatement ps = connection.prepareStatement(sql);
		int i=1;
		ps.setInt(i++, attachment.getSource_id());
		ps.setString(i++,attachment.getAttachment_name());
		ps.setString(i++,attachment.getAttachment_addr());
		ps.executeUpdate();
		ps.close();	
		
	}

	//yangali 此函数有用，也有修改
	public void deleteAttachmentBySource(Source source) throws Exception {

		String sqlString="delete from attachment where source_id=?";
		PreparedStatement ps = connection.prepareStatement(sqlString);
		ps.setInt(1,source.getSource_id());
		ps.executeUpdate();
		ps.close();		
	}

	public Attachment getAttachment(int attachment_id) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Attachment attachment = null;

		try {
			ps = connection.prepareStatement("select * from attachment where attachment_id=?");
			ps.setInt(1, attachment_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				attachment = new Attachment();
				attachment.setAttachment_id(new Long(rs.getInt("attachment_id")));
				attachment.setSource_id(rs.getInt("source_id"));
				attachment.setAttachment_name(rs.getString("attachment_name"));
				attachment.setAttachment_addr(rs.getString("attachment_addr"));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
		return attachment;
	}

	public List listAllAttachment() throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection
					.prepareStatement("select * from attachment order by source_id desc");
			rs = ps.executeQuery();
			Attachment attachment = null;
			result = new ArrayList();
			while (rs.next()) {
				attachment = new Attachment();
				attachment.setAttachment_id(new Long(rs.getInt("attachment_id")));
				attachment.setSource_id(rs.getInt("source_id"));
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

	public List listAttachmentBySource(int source_id)
			throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection.prepareStatement("select * from attachment where source_id=? " +
					"order by attachment_id  desc ");
			ps.setInt(1, source_id);
			rs = ps.executeQuery();
			Attachment attachment = null;
			result = new ArrayList();
			while (rs.next()) {
				attachment = new Attachment();
				attachment.setAttachment_id(new Long(rs.getInt("attachment_id")));
				attachment.setSource_id(rs.getInt("source_id"));
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

	public List listAttachmentByPage(int pageNo, int pageSize) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection.prepareStatement("select * from attachment order by source_id desc limit ?,?");
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
			rs = ps.executeQuery();
			Attachment attachment = null;
			result = new ArrayList();
			while (rs.next()) {
				attachment = new Attachment();
				attachment.setAttachment_id(new Long(rs.getInt("attachment_id")));
				attachment.setSource_id(rs.getInt("source_id"));
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

	public void updateAttachment(Attachment attachment) throws Exception {
		String sql="update attachment set source_id=?,attachment_name=?,attachment_addr=?" +
				" where attachment_id=?";			
		PreparedStatement ps = connection.prepareStatement(sql);
		int i=1;
		ps.setInt(i++, attachment.getSource_id());
		ps.setString(i++,attachment.getAttachment_name());
		ps.setString(i++,attachment.getAttachment_addr());
		ps.executeUpdate();
		ps.close();
		
	}

	public Attachment getAttachmentBySource(int source_id) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Attachment attachment = null;

		try {
			ps = connection.prepareStatement("select * from attachment where source_id=?");
			ps.setInt(1, source_id);
			rs = ps.executeQuery();
			if (rs.next()) {
				attachment = new Attachment();
				attachment.setAttachment_id(new Long(rs.getInt("attachment_id")));
				attachment.setSource_id(rs.getInt("source_id"));
				attachment.setAttachment_name(rs.getString("attachment_name"));
				attachment.setAttachment_addr(rs.getString("attachment_addr"));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
		return attachment;
	}

	public List listAttachments(Attachment AttachmentCondition)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

/*	//yangali 2010.7.27 暂时不用了，因为传参有误
	public List listAttachments(Attachment AttachmentCondition)
			throws Exception {
		boolean Condition=false;
		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("select * from attachment where 1=1");
		System.out.println("Attachement"+AttachmentCondition.getSource_id());//test
		if(new Long(AttachmentCondition.getSource_id())!=null){
			stringBuffer.append(" and source_id=13");//test
			Condition=true;
		}
		
		PreparedStatement ps = connection.prepareStatement(stringBuffer.toString());
		ResultSet rs = ps.executeQuery();
		List list = new ArrayList();
		while(rs.next()){
			Attachment attachment = new Attachment();
			attachment.setAttachment_id(new Long(rs.getInt("attachment_id")));
			attachment.setAttachment_name(rs.getString("attachment_name"));
			attachment.setAttachment_addr(rs.getString("attachment_addr"));
			attachment.setSource_id(AttachmentCondition.getSource_id());
			list.add(attachment);
		}
		return list;
	}*/
}
