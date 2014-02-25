package controller;

import bean.ImageInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.ImageService;

public class ImageController extends SimpleFormController {

	private ImageService imageService;

	public ImageService getImageService() {
		return imageService;
	}

	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}

	public ImageController() {
		setCommandClass(ImageInfo.class);
		setCommandName("image");
		setSuccessView("image");
		//      setFormView("results");
	}

	//FIXME: why?
	@Override
	protected boolean isFormSubmission(HttpServletRequest request) {
		return true;
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		ModelAndView mv = new ModelAndView(getSuccessView());
		imageService.addImageInfo(mv, ((ImageInfo)command).getIid());
		return mv;
	}
}
