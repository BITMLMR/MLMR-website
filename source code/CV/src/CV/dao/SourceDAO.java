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

	public void addSource(Source source)throws Exception;//添加source信息
	
	public void updateSource(Source source)throws Exception;

	public void deleteSource(Source source)throws Exception;//删除source信息

	public List listAllSource()throws Exception;
	
	public List listSourceByPage(int pageNo,int pageSize)throws Exception;
	
	//yangali 2010.7.26添加
	public List listSourceByClassByPage(int class_id,int pageNo,int pageSize)throws Exception;
	
	//yangali 2010.8.29添加,根据资源是否审核来查询
	public List listSourceByClassByLegalByPage(int channel, int legal,
			int pageNo, int pageSize)throws Exception;
	
	public List listSourceByClass(int class_id,int pageNo,int pageSize)throws Exception;

	public Source getSource(int source_id)throws Exception;
	
	public Connection getConnection()throws Exception;
	
	public void setConnection(Connection connection)throws Exception;
	
	public Long getCurrentID() throws SQLException;
	//yangali 2010.8.30添加,根据资源是否审核来查询附件，列出所有审核通过的该类型的资源附件
	public List listAttachmentByChannelByLegalByPage(int channel, int legal,
			int pageNo, int pageSize)throws Exception;
	//yangali 2010.8.31添加,根据资源频道,是否审核,资源tree_id来查询
	public List listSourceByChannelByLegalByTreeByPage(int channel, int legal,
			int tid, int pageNo, int pageSize)throws Exception;

	public void legalSource(Source source)throws Exception;//yangali 2010 9 9 审核资源
	//yangali 2010.9.13添加,根据资源频道和上传者用户名列出所有资源，包括审核通过和未审核的
	public List listSourceByChannelByStuByPage(int channel, String stu,
			int pageNo, int pageSize)throws Exception;
	
}
