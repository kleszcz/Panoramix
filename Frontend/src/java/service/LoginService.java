package service;

import bean.LoginInfo;
import dao.UsersDAO;

public class LoginService {
	UsersDAO userDAO;

	public boolean authenticate(LoginInfo user) {
		LoginInfo dbUser = userDAO.getUser(user.getUname());
		if (dbUser == null)
			throw new IllegalArgumentException(user.getUname() + " - no such user in DB.");
		user.setUid(dbUser.getUid());
		return user.getPassword().equals(dbUser.getPassword());
	}

	public void addUser(LoginInfo user) {
		userDAO.addUser(user);
	}

	public LoginInfo getUser(LoginInfo user) {
		return userDAO.getUser(user.getUname());
	}

	public void setUserDAO(UsersDAO userDAO) {
		this.userDAO = userDAO;
	}
}