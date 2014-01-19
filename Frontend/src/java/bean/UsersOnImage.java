/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

/**
 *
 * @author Jan
 */
public class UsersOnImage {

	private Integer uid;
	private String uname;

	public Integer getUid() {
		return uid;
	}

	public UsersOnImage() {
	}

	public UsersOnImage(Integer uid, String uname) {
		this.uid = uid;
		this.uname = uname;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

}
