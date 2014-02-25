package dao;

import bean.Comment;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class CommentsDAO {

	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public List<Comment> getByIid(Integer iid) {
		String query = "select "
				+ "cid, text, Comments.UID as author, vote, Comments.added as added, "
				+ "aid "
				+ "from  POI join Assumptions using (pid) join Comments using (aid) "
				+ "where iid = ? order by aid, added";
		return jdbcTemplate.query(query, new Object[]{iid}, new BeanPropertyRowMapper<>(Comment.class));
	}

	public void addComment(Comment comment) {
		String query = "insert into Comments (aid, uid, text, vote, added) values(?, ?, ?, ?, CURRENT_TIMESTAMP)";
		Object[] args = new Object[]{
			comment.getAid(),
			comment.getAuthor(),
			comment.getText(),
			comment.getVote()
		};
		jdbcTemplate.update(query, args);
	}
}
