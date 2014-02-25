package dao;

import bean.LoginInfo;
import bean.UserInfo;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UsersDAO {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public void addUser(bean.LoginInfo user) {
		String query = "insert into Users (uname, password, joined) VALUES(?, ?, CURRENT_TIMESTAMP)";
		jdbcTemplate.update(query, new Object[]{
			user.getUname(),
			user.getPassword()
		});
	}

	public bean.LoginInfo getUser(String uname) {
		String query = "select * from users where uname = ?";
		try {
			return (LoginInfo) jdbcTemplate.queryForObject(query, new Object[]{uname}, new BeanPropertyRowMapper<>(LoginInfo.class));
		} catch (Exception e) {
			return null;
		}
	}

	public List<UserInfo> getByIid(Integer iid) {
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
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(UserInfo.class));
	}
}
