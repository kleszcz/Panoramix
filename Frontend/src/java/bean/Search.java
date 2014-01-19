/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jan
 */
public class Search {

	private String name;

	private String label;
	private Integer iid;

	public Search() {
	}

	public Search(Integer iid, Integer oid, String filename, String label, Integer votes, Timestamp added) {
		this.iid = iid;
		this.oid = oid;
		this.filename = filename;
		this.label = label;
		this.votes = votes;
		this.added = added;
	}
	private Integer oid;
	private String filename;
	private Timestamp added;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Integer getIid() {
		return iid;
	}

	public void setIid(Integer iid) {
		this.iid = iid;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public Timestamp getAdded() {
		return added;
	}

	public void setAdded(Timestamp added) {
		this.added = added;
	}

	public Integer getVotes() {
		return votes;
	}

	public void setVotes(Integer votes) {
		this.votes = votes;
	}
	private Integer votes;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		try {
			this.name = new String(name.getBytes("iso-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException ex) {
			Logger.getLogger(Search.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}
