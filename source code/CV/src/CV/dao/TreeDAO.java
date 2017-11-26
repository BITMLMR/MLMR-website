package CV.dao;

import java.sql.Connection;

import java.util.List;

import CV.vo.Tree;

public interface TreeDAO {

	public void addTree(Tree tree)throws Exception;
	public void updateTree(Tree tree)throws Exception;
	public void deleteTree(Tree tree)throws Exception;
	public List listAllTree()throws Exception;
	public List listByLevel(int level)throws Exception;
	public List listByFather(int fatherId)throws Exception;
	public Tree geTree(int treeId)throws Exception;
	public Connection getConnection()throws Exception;
	public void setConnection(Connection connection)throws Exception;

}
