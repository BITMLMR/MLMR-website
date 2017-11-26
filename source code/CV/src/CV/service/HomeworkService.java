package CV.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import CV.dao.HomeworkDAO;
import CV.dao.impl.HomeworkDAOImpl;
import CV.jspsmart.upload.SmartUpload;
import CV.util.db.Database;
import CV.vo.Homework;

public class HomeworkService extends BaseService {
	private HomeworkDAO homeworkDAO=new HomeworkDAOImpl();
	
	public HomeworkDAO getHomeworkDAO() {
		return homeworkDAO;
	}
	public void setHomeworkDAO(HomeworkDAO homeworkDAO) {
		this.homeworkDAO = homeworkDAO;
	}
	//学生上传作业
	public boolean addHomework(Homework homework,SmartUpload upload){
		Connection connection=null;
		//boolean ret=false;
		try {
			connection=Database.getConnection();
			homeworkDAO.setConnection(connection);
			homeworkDAO.addHomework(homework);
			Database.commit();//提交事务
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
	//老师上传批改作业
	public boolean updateHomework(Homework homework,SmartUpload upload){
		Connection connection=null;
		//boolean ret=false;
		try {
			connection=Database.getConnection();
			homeworkDAO.setConnection(connection);
			homeworkDAO.updateHomework(homework);
			Database.commit();//提交事务
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
	//学生更新作业
	public boolean updateHomeworkByStu(Homework homework,SmartUpload upload){
		Connection connection=null;
		//boolean ret=false;
		try {
			connection=Database.getConnection();
			homeworkDAO.setConnection(connection);
			homeworkDAO.updateHomeworkByStu(homework);
			Database.commit();//提交事务
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
	//得到所有作业的总数目
	public int getCount(){
		StringBuffer sqlStr=new StringBuffer();
		sqlStr.append("select count(*) as count from homework");
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
		sqlStr.append("select count(*) as count from homework where username=?");
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
	//列出所有作业，按页码分别显示
	public List listHomeworkByPage(int pageNo,int pageSize) throws Exception {
		List list=null;
		Connection connection=null;
		try {
			connection=Database.getConnection();
			homeworkDAO.setConnection(connection);
			list=homeworkDAO.listHomeworkByPage(pageNo, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			Database.releaseConnection(connection);
		}
		return list;
	}
	//根据用户名称列出所有作业,按页码显示
	public List listHomeworkByUserByPage(String username,int pageNo,int pageSize) throws Exception {
		List list=null;
		Connection connection=null;
		try {
			connection=Database.getConnection();
			homeworkDAO.setConnection(connection);
			list=homeworkDAO.listHomeworkByUsernameByPage(username, pageNo, pageSize);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			Database.releaseConnection(connection);
		}
		return list;
	}
	//根据用户名称username,作业source_id列出所有作业
	public List listHomeworkByUserBySourceId(String username,int sourceId) throws Exception {
		List list=null;
		Connection connection=null;
		try {
			connection=Database.getConnection();
			homeworkDAO.setConnection(connection);
			list=homeworkDAO.listHomeworkByUserBySourceId(username,sourceId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			Database.releaseConnection(connection);
		}
		return list;
	}
	//根据作业source_id列出所有作业
	public List listHomeworkBySourceId(int sourceId) throws Exception {
		List list=null;
		Connection connection=null;
		try {
			connection=Database.getConnection();
			homeworkDAO.setConnection(connection);
			list=homeworkDAO.listHomeworkBySourceId(sourceId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			Database.releaseConnection(connection);
		}
		return list;
	}
	//插入新作业时，首先要检测是否已经存在了，如果存在则更新
	public boolean checkHomework(String username,int sourceId)throws Exception{	   
	   try{
		   Homework homework=getHomework(username, sourceId);
		   if(homework==null)
			   return false;
		   else
			   return true;
	   }catch(Exception e){
		   throw e;
	   }
   }
	//根据用户名和资源编号查询是否存在该条记录
	public Homework getHomework(String username,int sourceId)throws Exception{
		Homework homework=null;
		Connection connection=null;
		try{
			   connection=Database.getConnection();
			   homeworkDAO.setConnection(connection);
			   homework=homeworkDAO.getHomework(username,sourceId);
		   }catch(Exception e){
			   e.printStackTrace();
			   throw e;
		   }finally{
			   Database.releaseConnection(connection);
		   }
		   return homework;
	}
}
