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
public class Source {
	private int source_id;

	private String source_title;

	private String source_date;

	private String source_content;
	
	private int channel;
	
	private int type;
	
	private String source_author;
	
	private int legal;
	
	private String tree_id;

	public String getSource_title() {
		return source_title;
	}

	public void setSource_title(String source_title) {
		this.source_title = source_title;
	}

	public String getSource_content() {
		return source_content;
	}

	public void setSource_content(String source_content) {
		this.source_content = source_content;
	}

	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.channel = channel;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getSource_id() {
		return source_id;
	}

	public void setSource_id(int source_id) {
		this.source_id = source_id;
	}

	public String getSource_date() {
		return source_date;
	}

	public void setSource_date(String source_date) {
		this.source_date = source_date;
	}	



	public String getSource_author() {
		return source_author;
	}

	public void setSource_author(String source_author) {
		this.source_author = source_author;
	}

	public int getLegal() {
		return legal;
	}

	public void setLegal(int legal) {
		this.legal = legal;
	}

	public String getTree_id() {
		return tree_id;
	}

	public void setTree_id(String treeId) {
		tree_id = treeId;
	}
}
