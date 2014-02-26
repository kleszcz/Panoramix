package controller;

import bean.LoginInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import service.LoginService;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.web.servlet.mvc.SimpleFormController;

public class RegisterController extends SimpleFormController {
	LoginService loginService;

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public RegisterController() {
		setCommandClass(LoginInfo.class);
		setCommandName("register");
		setSuccessView("index");
		setFormView("register");
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		LoginInfo user = (LoginInfo)command;
		ModelAndView mv = new ModelAndView(getSuccessView());
		try {
			loginService.addUser(user);
			user = loginService.getUser(user);
			request.getSession(true).setAttribute("uid", user.getUid());
			request.getSession(true).setAttribute("uname", user.getUname());
			response.sendRedirect(request.getContextPath());
		} catch(Exception e) {
			mv.addObject("welcomeMessage", "registration failure");
		}
		return mv;
	}
}
