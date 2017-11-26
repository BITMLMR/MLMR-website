package CV.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

import CV.dao.TreeDAO;
import CV.util.db.Database;
import CV.vo.Tree;

public class TreeDAOImpl implements TreeDAO {
	
	private Connection connection;

	public TreeDAOImpl() {
		try {
			connection = Database.getConnection();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
	public Connection getConnection() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	public void setConnection(Connection connection) throws Exception {
		// TODO Auto-generated method stub
		
	}
	//��Ӹ��ڵ�
	public void addTree(Tree tree) throws Exception {
		// TODO Auto-generated method stub
		
	}

	//ɾ�����ڵ�
	public void deleteTree(Tree tree) throws Exception {
		// TODO Auto-generated method stub
		
	}

	//������id��ѯ���ڵ�
	public Tree geTree(int treeId) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		Tree tree = null;
		try {
			ps = connection.prepareStatement("select * from tree where tree_id=?");
			ps.setInt(1, treeId);
			rs = ps.executeQuery();
			if (rs.next()) {
				tree = new Tree();
				tree.setTreeId(rs.getInt("tree_id"));
				tree.setTreeName(rs.getString("tree_name"));
				tree.setParentId(rs.getInt("parent_id"));
				tree.setLevel(rs.getInt("level"));
				tree.setOrder(rs.getInt("order"));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			throw sqle;
		} finally {
			closeResultSet(rs);
			closeStatement(ps);
		}
		return tree;
	}
	//�г����еĽڵ�
	public List listAllTree() throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection.prepareStatement("select * from tree");
			rs = ps.executeQuery();
			Tree tree = null;
			result = new ArrayList();
			while (rs.next()) {
				tree = new Tree();
				tree.setTreeId(rs.getInt("tree_id"));
				tree.setTreeName(rs.getString("tree_name"));
				tree.setParentId(rs.getInt("parent_id"));
				tree.setLevel(rs.getInt("level"));
				tree.setOrder(rs.getInt("order"));
				result.add(tree);
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

	//���ݸ��ڵ��г��ӽڵ�
	public List listByFather(int fatherId) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection.prepareStatement("select * from tree where parent_id=?");
			ps.setInt(1, fatherId);
			rs = ps.executeQuery();
			Tree tree = null;
			result = new ArrayList();
			while (rs.next()) {
				tree = new Tree();
				tree.setTreeId(rs.getInt("tree_id"));
				tree.setTreeName(rs.getString("tree_name"));
				tree.setParentId(rs.getInt("parent_id"));
				tree.setLevel(rs.getInt("level"));
				tree.setOrder(rs.getInt("order"));
				result.add(tree);
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

	//���ݵȼ���ѯ���ڵ�
	public List listByLevel(int level) throws Exception {
		PreparedStatement ps = null;
		ResultSet rs = null;
		List result = null;

		try {
			ps = connection.prepareStatement("select * from tree where level=?");
			ps.setInt(1, level);
			rs = ps.executeQuery();
			Tree tree = null;
			result = new ArrayList();
			while (rs.next()) {
				tree = new Tree();
				tree.setTreeId(rs.getInt("tree_id"));
				tree.setTreeName(rs.getString("tree_name"));
				tree.setParentId(rs.getInt("parent_id"));
				tree.setLevel(rs.getInt("level"));
				tree.setOrder(rs.getInt("order"));
				result.add(tree);
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
	//���¸��ڵ�
	public void updateTree(Tree tree) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	
	private void closeStatement(PreparedStatement ps) {
		if (ps != null) {
			try {
				ps.close();
				ps = null;
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}
	}
	private void closeResultSet(ResultSet rs) {
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
