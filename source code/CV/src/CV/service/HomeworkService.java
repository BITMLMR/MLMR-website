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
	//ѧ���ϴ���ҵ
	public boolean addHomework(Homework homework,SmartUpload upload){
		Connection connection=null;
		//boolean ret=false;
		try {
			connection=Database.getConnection();
			homeworkDAO.setConnection(connection);
			homeworkDAO.addHomework(homework);
			Database.commit();//�ύ����
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
	//��ʦ�ϴ�������ҵ
	public boolean updateHomework(Homework homework,SmartUpload upload){
		Connection connection=null;
		//boolean ret=false;
		try {
			connection=Database.getConnection();
			homeworkDAO.setConnection(connection);
			homeworkDAO.updateHomework(homework);
			Database.commit();//�ύ����
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
	//ѧ��������ҵ
	public boolean updateHomeworkByStu(Homework homework,SmartUpload upload){
		Connection connection=null;
		//boolean ret=false;
		try {
			connection=Database.getConnection();
			homeworkDAO.setConnection(connection);
			homeworkDAO.updateHomeworkByStu(homework);
			Database.commit();//�ύ����
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
	//�õ�������ҵ������Ŀ
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
	//�����û����õ���������Ŀ
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
	//�г�������ҵ����ҳ��ֱ���ʾ
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
	//�����û������г�������ҵ,��ҳ����ʾ
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
	//�����û�����username,��ҵsource_id�г�������ҵ
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
	//������ҵsource_id�г�������ҵ
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
	//��������ҵʱ������Ҫ����Ƿ��Ѿ������ˣ�������������
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
	//�����û�������Դ��Ų�ѯ�Ƿ���ڸ�����¼
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
