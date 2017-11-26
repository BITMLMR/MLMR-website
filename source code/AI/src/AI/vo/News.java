/*
 * Created on 2005-12-2
 *
 * TODO To change the template for this generated file go to
 * Window - Preferences - Java - Code Style - Code Templates
 */
package AI.vo;


/**
 * @author Administrator
 */
public class News {
	private int new_id;
	private String new_title;
	private String new_date;
	private String new_content;
	private String new_author;
	private int legal;


	public String getNew_title() {
		return new_title;
	}

	public void setNew_title(String new_title) {
		this.new_title = new_title;
	}

	public String getNew_content() {
		return new_content;
	}

	public void setNew_content(String new_content) {
		this.new_content = new_content;
	}

	public int getNew_id() {
		return new_id;
	}

	public void setNew_id(int new_id) {
		this.new_id = new_id;
	}

	public String getNew_date() {
		return new_date;
	}

	public void setNew_date(String new_date) {
		this.new_date = new_date;
	}

	public String getNew_author() {
		return new_author;
	}

	public void setNew_author(String newAuthor) {
		new_author = newAuthor;
	}

	public int getLegal() {
		return legal;
	}

	public void setLegal(int legal) {
		this.legal = legal;
	}	

}
