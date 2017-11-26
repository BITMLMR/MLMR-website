package AI.dao;

import java.sql.Connection;
import java.util.List;

import AI.vo.Homework;

public interface HomeworkDAO {
	public void addHomework(Homework homework)throws Exception;//学生上传作业
	public void updateHomework(Homework homework)throws Exception;//更新作业，用于老师上传批改作业
	public List listHomeworkByPage(int pageNo,int pageSize)throws Exception ;//老师这里显示所有的作业
	public List listHomeworkByUsernameByPage(String username,int pageNo,int pageSize)throws Exception;//学生只显示自己的作业
	public List listHomeworkByUserBySourceId(String username, int sourceId)throws Exception;//根据用户名称username,作业source_id列出所有作业
	public Homework getHomework(String username, int sourceId)throws Exception;//通过用户名和资源编号查询是否存在该条记录，并返回该记录
	public void updateHomeworkByStu(Homework homework)throws Exception;//学生上传新版本的作业
	public Connection getConnection()throws Exception;
	public void setConnection(Connection connection)throws Exception;
	public List listHomeworkBySourceId(int sourceId)throws Exception;//根据作业source_id列出所有作业
}
