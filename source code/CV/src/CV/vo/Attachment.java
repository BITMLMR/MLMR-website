/*
 * Created on 2005-12-2
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package CV.vo;

/**
 * @author Administrator
 */
public class Attachment {
	private int source_id;
	
	private Long attachment_id;
	
	private String attachment_name;
	
	private String attachment_addr;


	/**
	 * @return Returns the source_id.
	 */
	public int getSource_id() {
		return source_id;
	}

	/**
	 * @param source_id
	 *            The source_id to set.
	 */
	public void setSource_id(int source_id) {
		this.source_id = source_id;
	}

	/**
	 * @return Returns the attachment_id.
	 */
	public Long getAttachment_id() {
		return attachment_id;
	}

	/**
	 * @param attachment_id
	 *            The attachment_id to set.
	 */
	public void setAttachment_id(Long attachment_id) {
		this.attachment_id = attachment_id;
	}
	
	/**
	 * @return Returns the attachment_name.
	 */
	public String getAttachment_name() {
		return attachment_name;
	}

	/**
	 * @param attachment_name
	 *            The attachment_name to set.
	 */
	public void setAttachment_name(String attachment_name) {
		this.attachment_name = attachment_name;
	}

	/**
	 * @return Returns the attachment_addr.
	 */
	public String getAttachment_addr() {
		return attachment_addr;
	}

	/**
	 * @param attachment_addr
	 *            The source_author to set.
	 */
	public void setAttachment_addr(String attachment_addr) {
		this.attachment_addr = attachment_addr;
	}

}
