package controller;

import bean.LoginInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.LoginService;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;

public class LoginController extends SimpleFormController {

	LoginService loginService;

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public LoginController() {
		setCommandClass(LoginInfo.class);
		setCommandName("login");
		setSuccessView("error");
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		LoginInfo user = (LoginInfo) command;
		ModelAndView mv;
		try {
			if (loginService.authenticate(user)) {
				request.getSession(true).setAttribute("uid", user.getUid());
				request.getSession(true).setAttribute("uname", user.getUname());
				response.sendRedirect(request.getHeader("referer"));
				return null;
			} else {
				mv = new ModelAndView(getSuccessView());
				mv.addObject("message", "Wrong password.");
			}
		} catch (Exception e) {
			mv = new ModelAndView(getSuccessView());
			mv.addObject("message", "Wrong username.");
		}
		return mv;
	}
}
