package services.iml;

import org.hibernate.Session;

import models.pojo.User;
import services.itf.AccountService;
import utilities.HibernateUtil;

public class AccountServiceIml implements AccountService {

	@Override
	public User getUser(String usernameOrEmail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean authenticationUser(String usernameOrEmail, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkExistsUser(String usernameOrEmail) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean createUser(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateUserInformation(User user) {
		// TODO Auto-generated method stub
		return false;
	}

}
