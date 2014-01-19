/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import bean.ImageInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 *
 * @author Jan
 */
public class ImagesDAO {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public ImageInfo getImageById(int iid) {
		String query = "select "
			+ "	iid, Images.uid as uid, uname, filename, Images.description, added, "
			+ "	label as taken_from "
			+ "from  Images join Users using (uid) left join Objects on (taken_from = oid) "
			+ "where iid = ?";
		ImageInfo image = null;
		try {
			image = (ImageInfo) jdbcTemplate.queryForObject(query, new Object[]{iid}, new RowMapper() {
				@Override
				public Object mapRow(ResultSet rs, int i) throws SQLException {
					return new ImageInfo(rs.getInt("iid"),
						rs.getInt("uid"),
						rs.getString("uname"),
						rs.getString("filename"),
						rs.getString("description"),
						rs.getTimestamp("added"),
						rs.getString("taken_from")
					);
				}
			});
		} catch (DataAccessException e) {
			System.out.println("Couldn't get object [" + iid + "]");
		}
		return image;
	}
}
