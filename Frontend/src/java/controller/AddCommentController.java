package controller;

import bean.Comment;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.ImageService;

public class AddCommentController extends SimpleFormController {

	ImageService imageService;

	public ImageService getImageService() {
		return imageService;
	}

	public void setImageService(ImageService imageService) {
		this.imageService = imageService;
	}

	public AddCommentController() {
		setCommandClass(Comment.class);
		setCommandName("comment");
		setSuccessView("image");
		setFormView("image");
	}

	@Override
	protected ModelAndView onSubmit(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		Comment comment = (Comment) command;
		ModelAndView mv = null;
		Integer uid;
		HttpSession session = request.getSession(false);
		if(session != null && (uid = (Integer) session.getAttribute("uid")) != null) {
			comment.setAuthor(uid);
			imageService.addComment(comment);
			response.sendRedirect(request.getHeader("referer"));
		} else {
			response.sendRedirect(request.getHeader("referer"));
		}

		return mv;
	}
}
