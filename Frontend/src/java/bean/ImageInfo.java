package bean;

import java.sql.Timestamp;

public class ImageInfo {

	private Integer iid;
	private Integer uid;
	private String filename;
	private String description;
	private Timestamp added;
	private String taken_from_label;
	private String uname;

	public ImageInfo() {
	}

	public ImageInfo(
			Integer iid,
			Integer uid,
			String uname,
			String filename,
			String description,
			Timestamp added,
			String taken_from_label
	) {
		this.iid = iid;
		this.uid = uid;
		this.uname = uname;
		this.filename = filename;
		this.description = description;
		this.added = added;
		this.taken_from_label = taken_from_label;
	}

	public Integer getIid() {
		return iid;
	}

	public void setIid(Integer iid) {
		this.iid = iid;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getAdded() {
		return added;
	}

	public void setAdded(Timestamp added) {
		this.added = added;
	}

	public String getTaken_from_label() {
		return taken_from_label;
	}

	public void setTaken_from_label(String taken_from_label) {
		this.taken_from_label = taken_from_label;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
}
