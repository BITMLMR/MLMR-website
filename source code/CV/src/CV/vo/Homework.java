package CV.vo;

public class Homework {
	private int id;//��ҵ���,����
	private int source_id;//��Ӧ����ҵ��Ŀ���
	private String username;//����ҵ��ѧ������
	private String homework_addr;//��ҵ�����ַ
	private String homework_time;//����ҵʱ��
	private String teacher;//������ҵ����ʦ����
	private String correction_addr;//������ҵ�����ַ
	private String correction_time;//������ҵʱ��
	private String homework_title;//�Ͻ���ҵ������
	private String correction_title;//������ҵ������
	
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
