package bean;

import java.sql.Timestamp;

public class ObjectsOnImage {

	private Integer pid;
	private Integer point_author;
	private Float x;
	private Float y;
	private Integer aid;
	private Integer assumption_author;
	private Integer votes;
	private Timestamp added;
	private Integer oid;
	private String description;
	private String label;

	public ObjectsOnImage() {
	}

	public ObjectsOnImage(Integer pid, Integer point_author, Float x, Float y, Integer aid, Integer assumption_author, Integer votes, Timestamp added, Integer oid, String description, String label) {
		this.pid = pid;
		this.point_author = point_author;
		this.x = x;
		this.y = y;
		this.aid = aid;
		this.assumption_author = assumption_author;
		this.votes = votes;
		this.added = added;
		this.oid = oid;
		this.description = description;
		this.label = label;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public Integer getPoint_author() {
		return point_author;
	}

	public void setPoint_author(Integer point_author) {
		this.point_author = point_author;
	}

	public Float getX() {
		return x;
	}

	public void setX(Float x) {
		this.x = x;
	}

	public Float getY() {
		return y;
	}

	public void setY(Float y) {
		this.y = y;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public Integer getAssumption_author() {
		return assumption_author;
	}

	public void setAssumption_author(Integer assumption_author) {
		this.assumption_author = assumption_author;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}

	public Timestamp getAdded() {
		return added;
	}

	public void setAdded(Timestamp added) {
		this.added = added;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

}
