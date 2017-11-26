package AI.dao;

import java.sql.Connection;
import java.util.List;

import AI.vo.Homework;

public interface HomeworkDAO {
	public void addHomework(Homework homework)throws Exception;//ѧ���ϴ���ҵ
	public void updateHomework(Homework homework)throws Exception;//������ҵ��������ʦ�ϴ�������ҵ
	public List listHomeworkByPage(int pageNo,int pageSize)throws Exception ;//��ʦ������ʾ���е���ҵ
	public List listHomeworkByUsernameByPage(String username,int pageNo,int pageSize)throws Exception;//ѧ��ֻ��ʾ�Լ�����ҵ
	public List listHomeworkByUserBySourceId(String username, int sourceId)throws Exception;//�����û�����username,��ҵsource_id�г�������ҵ
	public Homework getHomework(String username, int sourceId)throws Exception;//ͨ���û�������Դ��Ų�ѯ�Ƿ���ڸ�����¼�������ظü�¼
	public void updateHomeworkByStu(Homework homework)throws Exception;//ѧ���ϴ��°汾����ҵ
	public Connection getConnection()throws Exception;
	public void setConnection(Connection connection)throws Exception;
	public List listHomeworkBySourceId(int sourceId)throws Exception;//������ҵsource_id�г�������ҵ
}
