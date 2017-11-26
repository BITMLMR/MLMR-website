package CV.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import CV.vo.User;

/**
 * 公用的上下文处理
 * @author 杨阿丽
 *
 */
public class IeaContext {

	public static final String USER_IN_SESSION = "loginUser";
	/**
	 * 公用的取session中的user的办法
	 * @param request
	 * @return
	 */
	public static User getUserFromSession(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute(USER_IN_SESSION);
		return user;
	}
}
