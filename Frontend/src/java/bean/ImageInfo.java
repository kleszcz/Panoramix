/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.sql.Timestamp;

/**
 *
 * @author Jan
 */
public class ImageInfo {

	private int iid;
	private int uid;
	private String filename;
	private String description;
	private Timestamp added;
	private String taken_from_label;
	private String uname;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public ImageInfo() {
	}

	public ImageInfo(
		int iid,
		int uid,
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

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public int getUid() {
		return uid;
	}

	public void setUid(int uid) {
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

}
