package AI.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import AI.dao.SuggestionDAO;
import AI.dao.impl.SuggestionDAOImpl;
import AI.util.db.Database;
import AI.vo.Suggestion;

public class SuggestionService extends BaseService {
	private SuggestionDAO suggestionDAO=new SuggestionDAOImpl();
	public SuggestionDAO getSuggestionDAO() {
		return suggestionDAO;
	}
	public void setSuggestionDAO(SuggestionDAO suggestionDAO) {
		this.suggestionDAO = suggestionDAO;
	}
	//添加建议
	public boolean addSuggestion(Suggestion suggestion){
		Connection connection=null;
		try {
			connection=Database.getConnection();
			suggestionDAO.setConnection(connection);
			suggestionDAO.addSuggestion(suggestion);
			Database.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
			Database.rollback();
			return false;
		} finally {
			Database.releaseConnection(connection);
		}
	}
	//删除建议
	public boolean deleteSuggestion(int id){
		Connection connection=null;
		try {
			connection=Database.getConnection();
			suggestionDAO.setConnection(connection);
			suggestionDAO.deleteSuggestion(id);
			Database.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
			Database.rollback();
			return false;
		} finally {
			Database.releaseConnection(connection);
		}
	}
	//更新编辑建议
	public boolean updateSuggestion(Suggestion suggestion){
		Connection connection=null;
		try {
			connection=Database.getConnection();
			suggestionDAO.setConnection(connection);
			suggestionDAO.updateSuggestion(suggestion);
			Database.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			message = e.getMessage();
			Database.rollback();
			return false;
		} finally {
			Database.releaseConnection(connection);
		}
	}
	//得到所有建议的总数目
	public int getCount(){
		StringBuffer sqlStr=new StringBuffer();
		sqlStr.append("select count(*) as count from suggestion");
		Connection connection=null;
		try {
			connection=Database.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(sqlStr.toString());
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.releaseConnection(connection);
		}
		return 0;
	}
	//根据用户名得到建议总数目
	public int getCountByUser(String username){
		StringBuffer sqlStr=new StringBuffer();
		sqlStr.append("select count(*) as count from suggestion where username=?");
		Connection connection=null;
		try {
			connection=Database.getConnection();
			PreparedStatement preparedStatement=connection.prepareStatement(sqlStr.toString());
			preparedStatement.setString(1, username);
			ResultSet resultSet=preparedStatement.executeQuery();
			if (resultSet.next()) {
				return resultSet.getInt("count");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			Database.releaseConnection(connection);
		}
		return 0;
	}
	//列出所有建议，按页码分别显示
	public List listSuggestionByPage(int pageNo,int pageSize) throws Exception {
		List list=null;
		Connection connection=null;
		try {
			connection=Database.getConnection();
			suggestionDAO.setConnection(connection);
			list=suggestionDAO.listSuggestionByPage(pageNo, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			Database.releaseConnection(connection);
		}
		return list;
	}
	//根据用户名称列出所有建议,按页码显示
	public List listSuggettionByUserByPage(String username,int pageNo,int pageSize) throws Exception {
		List list=null;
		Connection connection=null;
		try {
			connection=Database.getConnection();
			suggestionDAO.setConnection(connection);
			list=suggestionDAO.listSuggettionByUserByPage(username, pageNo, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			Database.releaseConnection(connection);
		}
		return list;
	}
	
}
