package AI.dao;

import java.sql.Connection;
import java.util.List;

import AI.vo.Suggestion;

public interface SuggestionDAO {
	public void addSuggestion(Suggestion suggestion)throws Exception;//���ӽ���
	public void updateSuggestion(Suggestion suggestion)throws Exception;//�༭���Ľ���
	public void deleteSuggestion(int id)throws Exception;//ɾ����������
	public List listSuggestionByPage(int pageNo,int pageSize)throws Exception ;//�г����н��飬��ҳ��ֱ���ʾ
	public List listSuggettionByUserByPage(String username,int pageNo,int pageSize)throws Exception;//�����û������г����н���,��ҳ����ʾ
	public Connection getConnection()throws Exception;
	public void setConnection(Connection connection)throws Exception;
}
