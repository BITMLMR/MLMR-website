/**
 * 
 */
package CV.vo;

import java.util.Date;
/**
 * @author Administrator
 */
public class User {
	private int id;
	private String usename;//�û���
	private String password;//����
	private String nickname;//�ǳƻ���ʵ����
	private String gender;//���
	private String status;//״̬
	private String question;//��������
	private String answer;//����ش�
	private String email;//����
	private Date registerdate;//ע��ʱ��
	private int loginNum;//��¼����
	private String validateCode;//������

	/**
	 * @return Returns the email.
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return Returns the gender.
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender
	 *            The gender to set.
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	/**
	 * @return Returns the id.
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 *            The id to set.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return Returns the password.
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            The password to set.
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return Returns the nickname.
	 */
	public String getNickname() {
		return nickname;
	}

	/**
	 * @param nickname
	 *            The nickname to set.
	 */
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	/**
	 * @return Returns the usename.
	 */
	public String getUsename() {
		return usename;
	}

	/**
	 * @param uid
	 *            The usename to set.
	 */
	public void setUsename(String usename) {
		this.usename = usename;
	}
	
	/**
	 * @return Returns the registerdate.
	 */
	public Date getRegisterdate() {
		return registerdate;
	}

	/**
	 * @param registerdate
	 *            The registerdate to set.
	 */
	public void setRegisterdate(Date registerdate) {
		this.registerdate = registerdate;
	}	
	
	/**
	 * @return Returns the loginNum.
	 */
	public int getLoginNum() {
		return loginNum;
	}

	/**
	 * @param loginNum The loginNum to set.
	 */
	public void setLoginNum(int loginNum) {
		this.loginNum = loginNum;
	}

	/**
	 * @return Returns the validateCode.
	 */
	public String getValidateCode() {
		return validateCode;
	}

	/**
	 * @param validateCode
	 *            The validateCode to set.
	 */
	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
}
