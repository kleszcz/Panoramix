/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Images;
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

        setCommandClass(Images.class);
        setCommandName("imageaaa");
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
        //Do something...
        if(command != null)
        {
            Images im = (Images)command;
            int iid = im.getIid();
            mv.addObject("iid", iid);
            mv.addObject("image", imageService.getImageById(iid));
            mv.addObject("POIList", imageService.getPOIByIid(iid));
            mv.addObject("POIMap", imageService.getPOIToObjectsMapByIid(iid));
        }
        else
        {
            System.out.println("[ERROR] Empty command!");
        }
        return mv;
    }

}
