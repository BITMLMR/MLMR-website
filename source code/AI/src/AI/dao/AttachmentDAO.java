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

	public void addAttachment(Attachment attachment)throws Exception;//���attachment��Ϣ
	
	public void updateAttachment(Attachment attachment)throws Exception;//����

	//ɾ����source��Ӧ�����attachment��Ϣ
	public void deleteAttachmentBySource(Source source)throws Exception;

	public List listAllAttachment()throws Exception;//�г����и���
	
	public List listAttachmentByPage(int pageNo,int pageSize)throws Exception;
	
	public List listAttachmentBySource(int source_id)throws Exception;
	
	//yangali 2010.7.27
	public List listAttachments(Attachment AttachmentCondition)throws Exception;//���������ѯ

	public Attachment getAttachment(int attachment_id)throws Exception;
	
	public Attachment getAttachmentBySource(int source_id)throws Exception;
	
	public Connection getConnection()throws Exception;
	
	public void setConnection(Connection connection)throws Exception;
	
}
