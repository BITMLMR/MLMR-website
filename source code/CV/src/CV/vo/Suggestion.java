/**
 * 
 */
package CV.vo;

/**
 * @author Administrator
 */
public class Suggestion {
	private int id;//编号
	private String content;//意见建议的内容
	private String username;//留意见人的用户名
	private String time;//时间
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}

	
}
