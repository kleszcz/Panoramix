package dao;

import bean.SearchResult;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class SearchDAO {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<SearchResult> getByName(String name) {
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
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(SearchResult.class));
	}

	public List<SearchResult> getByOid(Integer oid) {
		String query = "select iid, oid, filename, label, votes, Images.added "
				+ "from ( "
				+ "select iid, oid, max(votes) as votes "
				+ "from Votes join POI using (pid) "
				+ "where oid = " + oid
				+ " group by iid,oid "
				+ ") as Results join Objects using (oid) join Images using (iid) "
				+ "order by label, votes desc";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(SearchResult.class));
	}
}
