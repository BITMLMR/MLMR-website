/*
 * Created on 2005-11-10
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package AI.dao;

import java.sql.Connection;
import java.util.List;

import AI.vo.News;

/**
 * @author Administrator
 */
public interface NewsDAO {
	//public void addNews(News news)throws Exception;
	public void addNews(News news)throws Exception;//添加News信息
	
	public void updateNews(News news)throws Exception;

	public void deleteNews(News news)throws Exception;//删除News信息

	public List listAllNews()throws Exception;
	
	public List listNewsByPage(int pageNo,int pageSize)throws Exception;

	public News getNews(int new_id)throws Exception;
	
	public Connection getConnection()throws Exception;
	
	public void setConnection(Connection connection)throws Exception;

	public void legalNews(News news) throws Exception;

	public List listNewsByLegalByPage(int legal, int pageNo, int pageSize)throws Exception;
	
}
