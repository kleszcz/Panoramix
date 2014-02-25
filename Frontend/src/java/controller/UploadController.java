package controller;

import bean.ImageUpload;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.ImageService;

public class UploadController extends SimpleFormController {

	private ImageService imageService;

	public ImageService getImageService() {
		return imageService;
	}

	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}

	public UploadController() {
		setCommandClass(ImageUpload.class);
		setCommandName("upload");
		setSuccessView("image");
		setFormView("upload");
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
			Object command, BindException errors) throws Exception {
		ModelAndView mv;
		//try {
		mv = new ModelAndView(getSuccessView());
		int iid = imageService.saveImage((ImageUpload) command);
		imageService.addImageInfo(mv, iid);
		/*} catch (Exception e) {
		 mv = new ModelAndView(getFormView());
		 }*/

		return mv;
	}
}
