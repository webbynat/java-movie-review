package services.itf;

import models.pojo.User;

/**
 * @author Toan
 *
 */
public interface AccountService {
	/*Get user from database using email or username*/
	public User getUser(String usernameOrEmail);
	
	/*Authentication user to allows user access your website*/
	public boolean authenticationUser(String usernameOrEmail, String password);
	
	/*Check if user exists in DB then return true, else return false. Using in register*/
	public boolean checkExistsUser(String usernameOrEmail);
	
	/*Create new user when user register new account*/
	public boolean createUser(User user);
	
	/*Update user information, when user click view profile and edit -> update their information*/
	public boolean updateUserInformation(User user);
}
