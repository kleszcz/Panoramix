package bean;

public class LoginInfo {

	private Integer uid;
	private String uname;
	private String password;

	public LoginInfo(Integer uid, String uname, String password) {
		this.uid = uid;
		this.uname = uname;
		this.password = password;
	}

	public LoginInfo() {
		this(0, null, null);
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String toString() {
		return uname;
	}
}
