/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Search;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import services.SearchService;

/**
 *
 * @author Jan
 */
public class SearchController extends SimpleFormController {

    private SearchService searchService;

    public SearchService getSearchService() {
        return searchService;
    }

    public void setSearchService(SearchService searchService) {
        this.searchService = searchService;
    }

    public SearchController() {
        //Initialize controller properties here or 
        //in the Web Application Context

        setCommandClass(Search.class);
        setCommandName("search");
        setSuccessView("results");
        setFormView("search");
    }

    @Override
    protected void doSubmitAction(Object command) throws Exception {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    protected boolean isFormSubmission(HttpServletRequest request) {
        if(request.getParameter("name") == null)
            return false;
        return true;
    }
    
    //Use onSubmit instead of doSubmitAction 
    //when you need access to the Request, Response, or BindException objects
    @Override
    protected ModelAndView onSubmit(
            HttpServletRequest request,
            HttpServletResponse response,
            Object command,
            BindException errors) throws Exception {
        ModelAndView mv = new ModelAndView(getSuccessView());
        //Do something...
        Search search = (Search) command;
        Object list = searchService.getImagesByObjectName(search.getName());
        if (list == null) 
            mv.addObject("noResults", true);
        else {
            mv.addObject("noResults", false);
            mv.addObject("imagesList", list);
        }            
        mv.addObject("searchName", search.getName());
        return mv;
    }

}
