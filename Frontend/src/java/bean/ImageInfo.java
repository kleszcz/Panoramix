package bean;

import java.sql.Timestamp;
import org.springframework.web.multipart.MultipartFile;

public class ImageInfo {

	private Integer oid;
	private Integer iid;
	private Integer uid;
	private String filename;
	private String description;
	private Timestamp added;
	private String taken_from;
	private String uname;
	MultipartFile image;

	public ImageInfo() {
	}

	public ImageInfo(
			Integer iid,
			Integer uid,
			String uname,
			String filename,
			String description,
			Timestamp added,
			String taken_from
	) {
		this.iid = iid;
		this.uid = uid;
		this.uname = uname;
		this.filename = filename;
		this.description = description;
		this.added = added;
		this.taken_from = taken_from;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public MultipartFile getImage() {
		return image;
	}

	public void setImage(MultipartFile image) {
		this.image = image;
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

	public String getTaken_from() {
		return taken_from;
	}

	public void setTaken_from(String taken_from_label) {
		this.taken_from = taken_from_label;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}
}
