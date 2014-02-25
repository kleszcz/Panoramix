package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.ParameterizableViewController;
import service.ImageService;

public class IndexController extends ParameterizableViewController {

	private ImageService imageService;

	public ImageService getImageService() {
		return imageService;
	}

	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("images", imageService.getAllImages());
		mv.addObject("objects", imageService.getAllObjects());
		return mv;
	}
}
