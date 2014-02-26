package service;

import bean.SearchResult;
import dao.SearchDAO;
import java.util.List;

public class SearchService {

	private SearchDAO searchDAO;

	public SearchDAO getSearchDAO() {
		return searchDAO;
	}

	public void setSearchDAO(SearchDAO searchDAO) {
		this.searchDAO = searchDAO;
	}

	public List<SearchResult> getSearchByName(String name) {
		return searchDAO.getByName(name);
	}

	public List<SearchResult> getSearchByOid(Integer oid) {
		return searchDAO.getByOid(oid);
	}
}
