package dao;

import bean.ObjectInfo;
import bean.ObjectsOnImage;
import java.util.*;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ObjectsDAO {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<ObjectsOnImage> getByIid(Integer iid) {
		String query = "select "
				+ "pid, POI.uid as point_author, x, y, "
				+ "aid, Votes.uid as assumption_author, votes, Votes.added as added, "
				+ "oid, description, label "
				+ "from  POI left join Votes using (pid) left join Objects using (oid) "
				+ "where iid = ? "
				+ "order by pid, Votes.votes desc";
		return jdbcTemplate.query(query, new Object[]{iid}, new BeanPropertyRowMapper<>(ObjectsOnImage.class));
	}

	public List<ObjectInfo> getAllObjects() {
		String query = "select * from Objects order by label";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ObjectInfo.class));
	}

	public void addObject(ObjectInfo object) {
		String query = "insert into Objects (uid, label, description, latitude, longitude) values(?, ?, ?, ?, ?)";
		Object[] args = new Object[]{
			object.getUid(),
			object.getLabel(),
			object.getDescription(),
			object.getLatitude(),
			object.getLongitude()
		};
		jdbcTemplate.update(query, args);
	}
}
