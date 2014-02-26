package bean;

import java.sql.Timestamp;

public class Comment {

	private Integer cid;
	private String text;
	private Integer aid;
	private Integer author;
	private Integer vote;
	private Timestamp added;

	public Comment() {
	}

	public Comment(Integer cid, String text, Integer author, Integer vote, Timestamp added, Integer aid) {
		this.cid = cid;
		this.text = text;
		this.aid = aid;
		this.author = author;
		this.vote = vote;
		this.added = added;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
		/*try {
			this.text = new String(text.getBytes("iso-8859-1"), "UTF-8");
		} catch (Exception ex) {}*/
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Integer getAuthor() {
		return author;
	}

	public void setAuthor(Integer author) {
		this.author = author;
	}

	public Integer getVote() {
		return vote;
	}

	public void setVote(Integer vote) {
		this.vote = vote;
	}

	public Timestamp getAdded() {
		return added;
	}

	public void setAdded(Timestamp added) {
		this.added = added;
	}

}
