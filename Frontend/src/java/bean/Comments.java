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
public class Comments {

	private Integer cid;
	private String text;
	private Integer author;
	private Integer vote;
	private Timestamp added;

	public Integer getAuthor() {
		return author;
	}

	public Comments() {
	}

	public Comments(Integer cid, String text, Integer author, Integer vote, Timestamp added, Integer aid) {
		this.cid = cid;
		this.text = text;
		this.author = author;
		this.vote = vote;
		this.added = added;
		this.aid = aid;
	}

	public void setAuthor(Integer author) {
		this.author = author;
	}
	private Integer aid;

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public Integer getAid() {
		return aid;
	}

	public void setAid(Integer aid) {
		this.aid = aid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Timestamp getAdded() {
		return added;
	}

	public void setAdded(Timestamp added) {
		this.added = added;
	}

	public Integer getVote() {
		return vote;
	}

	public void setVote(Integer vote) {
		this.vote = vote;
	}
}
