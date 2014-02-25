package bean;

public class UserInfo {

	private Integer uid;
	private String uname;

	public UserInfo() {
	}

	public UserInfo(Integer uid, String uname) {
		this.uid = uid;
		this.uname = uname;
	}

	public Integer getUid() {
		return uid;
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
