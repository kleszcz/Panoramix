/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.Comments;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Jan
 */
public class CommentsDAO {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Comments> getByIid(Integer iid) {
		List<Comments> comments = null;
		String query = "select "
			+ "cid, text, Comments.UID as author, vote, Comments.added as added, "
			+ "aid "
			+ "from  POI join Assumptions using (pid) join Comments using (aid) "
			+ "where iid = ?";
		try {
			comments = jdbcTemplate.query(query, new Object[]{iid}, new BeanPropertyRowMapper<>(Comments.class));
		} catch (DataAccessException e) {

		}
		return comments;
	}

}
