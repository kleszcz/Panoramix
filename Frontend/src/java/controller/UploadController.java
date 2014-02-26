package controller;

import bean.ImageUpload;
import java.util.UUID;
import java.util.logging.*;
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
		setCommandName("imageUpload");
		setSuccessView("image");
		setFormView("uploader");
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response,
			Object command, BindException errors) throws Exception {
		ImageUpload iu = (ImageUpload) command;
		Logger.getLogger("debug").severe((new Boolean(iu.getImage() == null)).toString());
		Logger.getLogger("debug").severe(errors.getMessage().toString());
		Logger.getLogger("debug").severe("" + iu.getImage() + iu.getDescription() + iu.getName() + iu.getTakenFrom());
		ModelAndView mv;

		mv = new ModelAndView(getSuccessView());
		int iid = imageService.saveImage((ImageUpload) command, request.getServletContext());
		imageService.addImageInfo(mv, iid);

		return null;
	}
}
