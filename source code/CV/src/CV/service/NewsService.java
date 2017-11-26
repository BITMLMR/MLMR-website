/*
 * Created on 2005-11-10
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package CV.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import CV.dao.NewsDAO;
import CV.dao.impl.NewsDAOImpl;
import CV.util.db.Database;
import CV.vo.News;

/**
 * @author Administrator
 *
 */
public class NewsService  extends BaseService{
	private NewsDAO newsDAO=new NewsDAOImpl();

	public boolean addNews(News news) {
		Connection connection = null;
		try {	
			connection = Database.getConnection();			
			newsDAO.setConnection(connection);
			newsDAO.addNews(news);
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
	};//添加News信息
 
	public boolean deleteNews(News news) {
		Connection connection = null;
		try {			
			connection = Database.getConnection();
			newsDAO.setConnection(connection);
			newsDAO.deleteNews(news);
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
	};//删除News信息
   public boolean updateNews(News news){
		Connection connection = null;
		try{
		   connection=Database.getConnection();
		   newsDAO.setConnection(connection);
		   newsDAO.updateNews(news);
		   connection.commit();
		   return true;
	   }catch(Exception  e){
		   e.printStackTrace();
		   message = e.getMessage();
		   Database.rollback();
		   return false;
	   }finally{
		   Database.releaseConnection(connection);
	   }
   }
   public boolean legalNews(News news){
		Connection connection = null;
		try{
		   connection=Database.getConnection();
		   newsDAO.setConnection(connection);
		   newsDAO.legalNews(news);
		   connection.commit();
		   return true;
	   }catch(Exception  e){
		   e.printStackTrace();
		   message = e.getMessage();
		   Database.rollback();
		   return false;
	   }finally{
		   Database.releaseConnection(connection);
	   }
  }
   public List listAllNews()throws Exception{
	   List newsList=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   newsDAO.setConnection(connection);
		   newsList=newsDAO.listAllNews();
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);		   
	   }	   
	   return newsList;
   }
   public List listNewsByPage(int pageNo,int pageSize)throws Exception{
	   List newsList=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   newsDAO.setConnection(connection);
		   newsList=newsDAO.listNewsByPage(pageNo,pageSize);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);		   
	   }	   
	   return newsList;
   }
   //列出审核通过的新闻
   public List listNewsByLegalByPage(int legal,int pageNo,int pageSize)throws Exception{
	   List newsList=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   newsDAO.setConnection(connection);
		   newsList=newsDAO.listNewsByLegalByPage(legal,pageNo,pageSize);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);		   
	   }	   
	   return newsList;
   }
   public int getNewsCount(){
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select count(*) as count from new"); 
		Connection conn =null;
		try {
		conn = Database.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sqlStr.toString());
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next())
		return resultSet.getInt("count");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Database.releaseConnection(conn);
		}
		return 0;		
	}
   //统计审核通过的数量
   public int getNewsCountByLegal(){
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("select count(*) as count from new where legal=1"); 
		Connection conn =null;
		try {
		conn = Database.getConnection();
		PreparedStatement preparedStatement = conn.prepareStatement(sqlStr.toString());
		ResultSet resultSet = preparedStatement.executeQuery();
		if(resultSet.next())
		return resultSet.getInt("count");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			Database.releaseConnection(conn);
		}
		return 0;		
	}
   public News getNews(int news_id)throws Exception{
	   News news=null;
	   Connection connection = null;
	   try{
		   connection=Database.getConnection();
		   newsDAO.setConnection(connection);
		   news=newsDAO.getNews(news_id);
	   }catch(Exception e){
		   e.printStackTrace();
		   throw e;
	   }finally{
		   Database.releaseConnection(connection);
	   }
	   return news;
   }
   
/**
 * @return Returns the newsDAO.
 */
public NewsDAO getNewsDAO() {
	return newsDAO;
}
/**
 * @param newsDAO The newsDAO to set.
 */
public void setNewsDAO(NewsDAO newsDAO) {
	this.newsDAO = newsDAO;
}
   
}
