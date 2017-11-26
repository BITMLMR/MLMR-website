package AI.dao;

import java.sql.Connection;
import java.util.List;

import AI.vo.Suggestion;

public interface SuggestionDAO {
	public void addSuggestion(Suggestion suggestion)throws Exception;//增加建议
	public void updateSuggestion(Suggestion suggestion)throws Exception;//编辑更改建议
	public void deleteSuggestion(int id)throws Exception;//删除该条建议
	public List listSuggestionByPage(int pageNo,int pageSize)throws Exception ;//列出所有建议，按页码分别显示
	public List listSuggettionByUserByPage(String username,int pageNo,int pageSize)throws Exception;//根据用户名称列出所有建议,按页码显示
	public Connection getConnection()throws Exception;
	public void setConnection(Connection connection)throws Exception;
}
