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

    private int cid;
	private String text;    
    private int author;
    private int vote;
    private Timestamp added;    

	public int getAuthor() {
		return author;
	}

	public Comments() {
	}

	public Comments(int cid, String text, int author, int vote, Timestamp added, int aid) {
		this.cid = cid;
		this.text = text;
		this.author = author;
		this.vote = vote;
		this.added = added;
		this.aid = aid;
	}

	public void setAuthor(int author) {
		this.author = author;
	}
	private int aid;
	
    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
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

    public int getVote() {
        return vote;
    }

    public void setVote(int vote) {
        this.vote = vote;
    }
}
