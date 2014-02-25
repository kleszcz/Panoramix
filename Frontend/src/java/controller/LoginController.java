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
		setSuccessView("index");
		setFormView("index");
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		LoginInfo user = (LoginInfo) command;
		ModelAndView mv;
		try {
			if (loginService.authenticate(user)) {
				request.getSession(true).setAttribute("uid", user.getUid());
				request.getSession(true).setAttribute("uname", user.getUname());
				mv = new ModelAndView(getSuccessView());
			} else {
				//FIXME: validator?
				mv = new ModelAndView(getFormView());
			}
		} catch (Exception e) {
			//FIXME: validator?
			mv = new ModelAndView(getFormView());
		}
		return mv;
	}
}
