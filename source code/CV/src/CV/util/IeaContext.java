package CV.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import CV.vo.User;

/**
 * ���õ������Ĵ���
 * @author ���
 *
 */
public class IeaContext {

	public static final String USER_IN_SESSION = "loginUser";
	/**
	 * ���õ�ȡsession�е�user�İ취
	 * @param request
	 * @return
	 */
	public static User getUserFromSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(USER_IN_SESSION);
		return user;
	}
}
