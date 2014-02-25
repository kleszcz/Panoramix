package service;

import bean.Search;
import dao.SearchDAO;
import java.util.List;

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
