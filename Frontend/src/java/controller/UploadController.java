package controller;

import bean.ImageInfo;
import java.util.UUID;
import java.util.logging.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
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
		setCommandClass(ImageInfo.class);
		setCommandName("imageUpload");
		setSuccessView("error");
		setFormView("uploader");
	}

	@Override
	protected ModelAndView onSubmit(
			HttpServletRequest request, HttpServletResponse response,
			Object command, BindException errors) throws Exception {
		ImageInfo image = (ImageInfo) command;
		Integer uid;
		HttpSession session = request.getSession(false);
		if (session != null && (uid = (Integer) session.getAttribute("uid")) != null) {
			image.setUid(uid);
			int iid = imageService.saveImage((ImageInfo) command, request.getServletContext());
			response.sendRedirect(request.getContextPath() + "/image.do?iid=" + iid);
		} else {
			ModelAndView mv = new ModelAndView(getSuccessView());
			mv.addObject("message", "Failure.");
		}

		return null;
	}
}
