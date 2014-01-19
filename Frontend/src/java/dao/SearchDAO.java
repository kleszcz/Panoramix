/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Search;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Jan
 */
public class SearchDAO {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Search> getByName(String name) {
		String query = "select iid, oid, filename, label, votes, Images.added "
			+ "from ( "
			+ "select iid, oid, max(votes) as votes "
			+ "from Votes join POI using (pid) "
			+ "where oid in ( "
			+ "select oid from Objects where upper(label) like upper('%" + name + "%') "
			+ ") "
			+ "group by iid,oid "
			+ ") as Results join Objects using (oid) join Images using (iid) "
			+ "order by label, votes desc";

		List<Search> search = null;
		try {
/*			List<Map<String, Object>> result = null;
			result = jdbcTemplate.queryForList(query);//, new Object[] {name});
			search = new ArrayList<>();
			for (Map<String, Object> el : result) {
				Search s = new Search();
				s.setName(name);
				s.setLabel((String) el.get("label"));
				s.setIid((int) el.get("iid"));
				s.setOid((int) el.get("oid"));
				s.setFilename((String) el.get("filename"));
				s.setAdded((Timestamp) el.get("added"));
				s.setVotes((int) el.get("votes"));
				search.add(s);
			}
	*/
			search = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(Search.class));
		} catch (DataAccessException e) {
			System.out.println("Couldn't get images for object [" + name + "]");
			System.out.println(query);
			System.out.println(e.getCause());
		}

		return search;

	}

}
