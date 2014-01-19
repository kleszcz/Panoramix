/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ObjectsOnImage;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Jan
 */
public class ObjectsOnImageDAO {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<ObjectsOnImage> getByIid(int iid) {
		String query = "select "
			+ "	pid, POI.uid as point_author, x, y, "
			+ "	aid, Votes.uid as assumption_author, votes, Votes.added as added, "
			+ "	oid, description, label "
			+ "from  POI join Votes using (pid) join Objects using (oid) "
			+ "where iid = ? "
			+ "order by pid, Votes.votes desc";
		List<ObjectsOnImage> objects = null;
		try {
			objects = jdbcTemplate.query(query, new Object[]{iid}, new BeanPropertyRowMapper<>(ObjectsOnImage.class));
		} catch (DataAccessException e) {

		}
		return objects;
	}

}
