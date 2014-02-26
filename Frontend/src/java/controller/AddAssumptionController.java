package controller;

import bean.AssumptionInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.ImageService;

public class AddAssumptionController extends SimpleFormController {

	ImageService imageService;

	public ImageService getImageService() {
		return imageService;
	}

	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}

	public AddAssumptionController() {
		setCommandClass(AssumptionInfo.class);
		setCommandName("assumption");
		setSuccessView("image");
		setFormView("image");
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		AssumptionInfo assumption = (AssumptionInfo) command;
		Integer uid;
		HttpSession session = request.getSession(false);
		if (session != null && (uid = (Integer) session.getAttribute("uid")) != null) {
			assumption.setUid(uid);
			imageService.addAssumption(assumption);
		}
		response.sendRedirect(request.getHeader("referer"));
		return null;
	}
}
