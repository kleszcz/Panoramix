package dao;

import bean.AssumptionInfo;
import bean.ImageInfo;
import bean.PoiInfo;
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
				+ "taken_from as oid, label as taken_from "
				+ "from  Images join Users using (uid) left join Objects on (taken_from = oid) "
				+ "where iid = ?";
		return jdbcTemplate.queryForObject(query, new Object[]{iid}, new BeanPropertyRowMapper<>(ImageInfo.class));
	}

	public int addImage(ImageInfo image) {
		String query = "insert into Images (uid, filename, description, taken_from, added) values (?, ?, ?, ?, CURRENT_TIMESTAMP)";
		jdbcTemplate.update(query, new Object[]{
			image.getUid(),
			image.getFilename(),
			image.getDescription(),
			image.getOid()
		});
		return jdbcTemplate.queryForInt("select iid from Images where filename = ?", image.getFilename());
	}

	public void addAssumption(AssumptionInfo assumption) {
		String query = "insert into Assumptions (uid, oid, pid, added) values(?, ?, ?, CURRENT_TIMESTAMP)";
		Object[] args = new Object[]{
			assumption.getUid(),
			assumption.getOid(),
			assumption.getPid()};
		jdbcTemplate.update(query, args);
	}

	public void addPoi(PoiInfo poi) {
		String query = "insert into POI (iid, uid, x, y) values(?, ?, ?, ?)";
		Object[] args = new Object[]{
			poi.getIid(),
			poi.getUid(),
			poi.getX(),
			poi.getY()
		};
		jdbcTemplate.update(query, args);
	}

	public List<ImageInfo> getAllImages() {
		String query = "select * from Images order by added desc";
		return jdbcTemplate.query(query, new BeanPropertyRowMapper<>(ImageInfo.class));
	}
}
