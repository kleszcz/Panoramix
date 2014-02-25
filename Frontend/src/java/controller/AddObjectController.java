package controller;

import bean.ObjectInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.ImageService;

public class AddObjectController extends SimpleFormController {

	ImageService imageService;

	public ImageService getImageService() {
		return imageService;
	}

	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}

	public AddObjectController() {
		setCommandClass(ObjectInfo.class);
		setCommandName("object");
		setSuccessView("index");
		setFormView("index");
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		ObjectInfo object = (ObjectInfo) command;
		ModelAndView mv;
		Integer uid;
		HttpSession session = request.getSession(false);
		if(session != null && (uid = (Integer) session.getAttribute("uid")) != null) {
			object.setUid(uid);
			imageService.addObjectInfo(object);
			mv = new ModelAndView(getSuccessView());
		} else {
			mv = new ModelAndView(getFormView());
		}

		return mv;
	}
}
