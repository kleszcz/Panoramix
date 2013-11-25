/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package controller;

import bean.ObjectToImages;
import org.springframework.web.servlet.mvc.SimpleFormController;

/**
 *
 * @author Jan
 */
public class SearchObjectOnImagesController extends SimpleFormController {
    
    public SearchObjectOnImagesController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(ObjectToImages.class);
        setCommandName("objectToImages");
        setSuccessView("imagesListView");
        setFormView("searchObjectsView");
    }
    
    @Override
    protected void doSubmitAction(Object command) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    /*
     @Override
     protected ModelAndView onSubmit(
     HttpServletRequest request, 
     HttpServletResponse response, 
     Object command, 
     BindException errors) throws Exception {
     ModelAndView mv = new ModelAndView(getSuccessView());
     //Do something...
     return mv;
     }
     */
}
