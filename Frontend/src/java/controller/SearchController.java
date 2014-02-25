/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import bean.Search;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;
import service.SearchService;

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
		setCommandClass(Search.class);
		setCommandName("search");
		setSuccessView("results");
	}

	//FIXME: why
	@Override
	protected boolean isFormSubmission(HttpServletRequest request) {
		if (request.getParameter("name") == null) {
			return false;
		}
		return true;
	}

	@Override
	protected ModelAndView onSubmit(Object command, BindException errors) throws Exception {
		ModelAndView mv = new ModelAndView(getSuccessView());
		Search search = (Search) command;
		Object list = searchService.getSearchByName(search.getName());

		mv.addObject("searchList", list);
		mv.addObject("searchName", search.getName());
		return mv;
	}

}
