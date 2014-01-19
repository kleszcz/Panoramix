/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.UsersOnImage;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Jan
 */
public class UsersOnImageDAO {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<UsersOnImage> getByIid(Integer iid) {
		List<UsersOnImage> users = null;
		String query = "select uid, uname from Users where uid in ( "
			+ "( select Images.uid from Images "
			+ "	where iid = " + iid + " "
			+ ") union ("
			+ "	select POI.uid from POI"
			+ "	where iid = " + iid + " "
			+ ") union ("
			+ "	select Assumptions.uid from POI join Assumptions using (pid) "
			+ "	where iid = " + iid + " "
			+ ") union ("
			+ "	select Objects.uid     from POI join Assumptions using (pid) join Objects  using (oid) "
			+ "	where iid = " + iid + " "
			+ ") union ( "
			+ "	select Comments.uid	   from POI join Assumptions using (pid) join Comments using (aid) "
			+ "	where iid = " + iid + " "
			+ "))";
		try {
			users = jdbcTemplate.query(query, new BeanPropertyRowMapper<>(UsersOnImage.class));
		} catch (DataAccessException e) {

		}
		return users;
	}

}
