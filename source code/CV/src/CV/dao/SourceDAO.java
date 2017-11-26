/*
 * Created on 2005-11-10
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package CV.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import CV.vo.Source;

/**
 * @author Administrator
 */
public interface SourceDAO {

	public void addSource(Source source)throws Exception;//���source��Ϣ
	
	public void updateSource(Source source)throws Exception;

	public void deleteSource(Source source)throws Exception;//ɾ��source��Ϣ

	public List listAllSource()throws Exception;
	
	public List listSourceByPage(int pageNo,int pageSize)throws Exception;
	
	//yangali 2010.7.26���
	public List listSourceByClassByPage(int class_id,int pageNo,int pageSize)throws Exception;
	
	//yangali 2010.8.29���,������Դ�Ƿ��������ѯ
	public List listSourceByClassByLegalByPage(int channel, int legal,
			int pageNo, int pageSize)throws Exception;
	
	public List listSourceByClass(int class_id,int pageNo,int pageSize)throws Exception;

	public Source getSource(int source_id)throws Exception;
	
	public Connection getConnection()throws Exception;
	
	public void setConnection(Connection connection)throws Exception;
	
	public Long getCurrentID() throws SQLException;
	//yangali 2010.8.30���,������Դ�Ƿ��������ѯ�������г��������ͨ���ĸ����͵���Դ����
	public List listAttachmentByChannelByLegalByPage(int channel, int legal,
			int pageNo, int pageSize)throws Exception;
	//yangali 2010.8.31���,������ԴƵ��,�Ƿ����,��Դtree_id����ѯ
	public List listSourceByChannelByLegalByTreeByPage(int channel, int legal,
			int tid, int pageNo, int pageSize)throws Exception;

	public void legalSource(Source source)throws Exception;//yangali 2010 9 9 �����Դ
	//yangali 2010.9.13���,������ԴƵ�����ϴ����û����г�������Դ���������ͨ����δ��˵�
	public List listSourceByChannelByStuByPage(int channel, String stu,
			int pageNo, int pageSize)throws Exception;
	
}
