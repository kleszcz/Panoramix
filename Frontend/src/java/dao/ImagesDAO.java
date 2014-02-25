package dao;

import bean.ImageInfo;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class ImagesDAO {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public ImageInfo getByIid(Integer iid) {
		String query = "select "
				+ "iid, Images.uid as uid, uname, filename, Images.description, added, "
				+ "label as taken_from "
				+ "from  Images join Users using (uid) left join Objects on (taken_from = oid) "
				+ "where iid = ?";
		return jdbcTemplate.queryForObject(query, new Object[]{iid}, new BeanPropertyRowMapper<>(ImageInfo.class));
	}

	public int addImage(Integer iid) {
		String query = "select "
				+ "iid, Images.uid as uid, uname, filename, Images.description, added, "
				+ "label as taken_from "
				+ "from  Images join Users using (uid) left join Objects on (taken_from = oid) "
				+ "where iid = ?";
		//return jdbcTemplate.queryForInt();
		return 5;
	}

	public List<ImageInfo> getAllImages() {
		String query = "select * from Images order by added desc";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ImageInfo.class));
	}
}
