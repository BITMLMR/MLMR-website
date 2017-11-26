package AI.service;

import java.sql.Connection;
import java.util.List;

import AI.dao.TreeDAO;
import AI.dao.impl.TreeDAOImpl;
import AI.util.db.Database;

public class TreeService {

	private TreeDAO treeDAO = new TreeDAOImpl();
	//���ݵȼ���ѯ���ڵ�
	public List listByLevel(int level)throws Exception{
		List treeList=null;
		Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   treeDAO.setConnection(connection);
		   treeList=treeDAO.listByLevel(level);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);		   
	   }	   
	   return treeList;
	}
	//���ݸ��ڵ��г��ӽڵ�
	public List listByFather(int fatherId)throws Exception{
		List treeList=null;
		Connection connection = null;
		try{
			connection=Database.getConnection();
			treeDAO.setConnection(connection);
			treeList=treeDAO.listByLevel(fatherId);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			Database.releaseConnection(connection);		   
		}	   
		return treeList;
	}
	//�г����нڵ�
	public List listAllTree()throws Exception{
		List treeList=null;
		Connection connection = null;
		try{
			connection=Database.getConnection();
			treeDAO.setConnection(connection);
			treeList=treeDAO.listAllTree();
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}finally{
			Database.releaseConnection(connection);		   
		}	   
		return treeList;
	}
}
