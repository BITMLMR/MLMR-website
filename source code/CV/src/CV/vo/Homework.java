package CV.vo;

public class Homework {
	private int id;//作业编号,主键
	private int source_id;//对应的作业题目编号
	private String username;//交作业的学生姓名
	private String homework_addr;//作业保存地址
	private String homework_time;//交作业时间
	private String teacher;//批改作业的老师姓名
	private String correction_addr;//批改作业保存地址
	private String correction_time;//批改作业时间
	private String homework_title;//上交作业的名称
	private String correction_title;//批改作业的名称
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSource_id() {
		return source_id;
	}
	public void setSource_id(int sourceId) {
		source_id = sourceId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getHomework_addr() {
		return homework_addr;
	}
	public void setHomework_addr(String homeworkAddr) {
		homework_addr = homeworkAddr;
	}
	public String getHomework_time() {
		return homework_time;
	}
	public void setHomework_time(String homeworkTime) {
		homework_time = homeworkTime;
	}
	public String getTeacher() {
		return teacher;
	}
	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}
	public String getCorrection_addr() {
		return correction_addr;
	}
	public void setCorrection_addr(String correctionAddr) {
		correction_addr = correctionAddr;
	}
	public String getCorrection_time() {
		return correction_time;
	}
	public void setCorrection_time(String correctionTime) {
		correction_time = correctionTime;
	}
	public String getHomework_title() {
		return homework_title;
	}
	public void setHomework_title(String homeworkTitle) {
		homework_title = homeworkTitle;
	}
	public String getCorrection_title() {
		return correction_title;
	}
	public void setCorrection_title(String correctionTitle) {
		correction_title = correctionTitle;
	}
	
}
