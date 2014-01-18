/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import bean.Search;
import dao.SearchDAO;
import java.util.List;

/**
 *
 * @author Jan
 */
public class SearchService {

	private SearchDAO searchDAO;

	public SearchDAO getSearchDAO() {
		return searchDAO;
	}

	public List<Search> getSearchByName(String name) {
		return searchDAO.getByName(name);
	}

	public void setSearchDAO(SearchDAO searchDAO) {
		this.searchDAO = searchDAO;
	}
}
