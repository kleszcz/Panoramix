/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.ImageInfo;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import services.ImageService;

/**
 *
 * @author Jan
 */
public class ImageController extends SimpleFormController {

	private ImageService imageService;

	public ImageService getImageService() {
		return imageService;
	}

	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}

	public ImageController() {
		//Initialize controller properties here or 
		//in the Web Application Context

		setCommandClass(ImageInfo.class);
		setCommandName("image");
		setSuccessView("image");
		//      setFormView("results");
	}

	@Override
	protected void doSubmitAction(Object command) throws Exception {
		throw new UnsupportedOperationException("Not yet implemented");
	}

	//Use onSubmit instead of doSubmitAction 
	//when you need access to the Request, Response, or BindException objects
	@Override
	protected boolean isFormSubmission(HttpServletRequest request) {
		return true;
	}

	@Override
	protected ModelAndView onSubmit(
		HttpServletRequest request,
		HttpServletResponse response,
		Object command,
		BindException errors) throws Exception {
		ModelAndView mv = new ModelAndView(getSuccessView());
		//	System.out.println(request.getParameter("img.x") + " " + request.getParameter("img.y") );
		// Powyższa linia pozwala znaleźć klik na obrazku
		if (command != null) {
			ImageInfo im = (ImageInfo) command;
			int iid = im.getIid();
			mv.addObject("iid", iid);
			mv.addObject("image", imageService.getImageById(iid));
			mv.addObject("objectsList", imageService.getObjectsOnImageByIid(iid));
			mv.addObject("commentsList", imageService.getCommentsByIid(iid));
		} else {
			System.out.println("[ERROR] Empty command!");
		}
		return mv;
	}

}
