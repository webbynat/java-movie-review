package services.iml;

import org.hibernate.Query;
import org.hibernate.Session;

import models.pojo.User;
import services.itf.AccountService;
import utilities.HibernateUtil;
import utilities.Encoder;

public class AccountServiceIml implements AccountService {
	private Session session;
	
	public User getUser(String usernameOrEmail) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String _hql = "FROM User U WHERE U.username = :userID OR U.email = :userID";
		Query _query = session.createQuery(_hql);
		_query.setParameter("userID",usernameOrEmail);
		User _user = (User) _query.uniqueResult();
		
		session.getTransaction().commit();
		return _user;
	}

	
	public boolean authenticationUser(String usernameOrEmail, String password) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String _hql = "SELECT U.password FROM User U WHERE U.username = :userID OR U.email = :userID";
		Query _query = session.createQuery(_hql);
		_query.setParameter("userID",usernameOrEmail);
		String _userPass = (String) _query.uniqueResult();
		
		session.getTransaction().commit();
		if(_userPass != null){
			String _pass = Encoder.MD5(password);
			if(_userPass.equals(_pass))
				return true;
		}
		return false;
	}

	
	public boolean checkExistsUser(String usernameOrEmail) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String _hql = "FROM User U WHERE U.username = :userID OR U.email = :userID";
		Query _query = session.createQuery(_hql);
		_query.setParameter("userID",usernameOrEmail);
		User _user = (User) _query.uniqueResult();
		
		session.getTransaction().commit();
		if(_user != null)
			return false;
		return true;
	}

	
	public boolean createUser(User user) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		if(user == null || checkExistsUser(user.getUsername()) || checkExistsUser(user.getEmail())){
			return false;
		}
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		return true;
	}

	
	public boolean updateUserInformation(User user) {
		// TODO Auto-generated method stub
		session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String _hql = "UPDATE User U SET U.password = :password, U.displayName = :displayName, U.mail = :mail, U.phone = :phone "
				+ "WHERE U.username = :username";
		Query _query = session.createQuery(_hql);
		_query.setParameter("password", user.getPassword());
		_query.setParameter("displayName", user.getDisplayName());
		_query.setParameter("mail", user.getEmail());
		_query.setParameter("phone", user.getPhone());
		_query.setParameter("username",user.getUsername());
		@SuppressWarnings("unused")
		int result = _query.executeUpdate();
		
		session.getTransaction().commit();
		return false;
	}

}
