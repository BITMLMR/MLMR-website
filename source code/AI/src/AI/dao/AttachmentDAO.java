/*
 * Created on 2005-11-10
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package AI.dao;

import java.sql.Connection;
import java.util.List;
import AI.vo.Attachment;
import AI.vo.Source;

/**
 * @author Administrator
 */
public interface AttachmentDAO {

	public void addAttachment(Attachment attachment)throws Exception;//添加attachment信息
	
	public void updateAttachment(Attachment attachment)throws Exception;//更新

	//删除该source对应下面的attachment信息
	public void deleteAttachmentBySource(Source source)throws Exception;

	public List listAllAttachment()throws Exception;//列出所有附件
	
	public List listAttachmentByPage(int pageNo,int pageSize)throws Exception;
	
	public List listAttachmentBySource(int source_id)throws Exception;
	
	//yangali 2010.7.27
	public List listAttachments(Attachment AttachmentCondition)throws Exception;//组合条件查询

	public Attachment getAttachment(int attachment_id)throws Exception;
	
	public Attachment getAttachmentBySource(int source_id)throws Exception;
	
	public Connection getConnection()throws Exception;
	
	public void setConnection(Connection connection)throws Exception;
	
}
