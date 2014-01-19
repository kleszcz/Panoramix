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
	private int iid;
	
	public Search()
	{
	}

	public Search(int iid, int oid, String filename, String label, int votes, Timestamp added) {
		this.iid = iid;
		this.oid = oid;
		this.filename = filename;
		this.label = label;
		this.votes = votes;
		this.added = added;		
	}
	private int oid;
	private String filename;
	private Timestamp added;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public int getIid() {
		return iid;
	}

	public void setIid(int iid) {
		this.iid = iid;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
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

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}
	private int votes;

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
