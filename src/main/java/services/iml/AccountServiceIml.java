package services.iml;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import models.pojo.User;
import services.itf.AccountService;
import utilities.HibernateUtil;

public class AccountServiceIml implements AccountService {

	public User getUser(String usernameOrEmail) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "FROM User user WHERE (user.username = :us or user.email = :us)";
		Query query = session.createQuery(hql);
		
		query.setParameter("us", usernameOrEmail);
		User us = (User) query.uniqueResult();
		session.getTransaction().commit();
		return us;
	}

	public boolean authenticationUser(String usernameOrEmail, String password) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "FROM User user WHERE (user.username = :us or user.email = :us) and user.password = :pw";
		Query query = session.createQuery(hql);
		
		query.setParameter("us",usernameOrEmail);
		query.setParameter("pw",password);
		
		List results = query.list();
		session.getTransaction().commit();
		if (results.size() > 0)
			return true;
		return false;
	}

	public boolean checkExistsUser(String usernameOrEmail) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String hql = "FROM User user WHERE (user.username = :us or user.email = :us)";
		Query query = session.createQuery(hql);
		
		query.setParameter("us", usernameOrEmail);
		User us = (User) query.uniqueResult();
		session.getTransaction().commit();
		if(us != null)
			return true;
		return false;
	}

	public boolean createUser(User user) {
		if(user != null && checkExistsUser(user.getUsername())== false && checkExistsUser(user.getEmail())== false){
			Session session = HibernateUtil.getSessionFactory().getCurrentSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
			return true;
		}
		return false;
	}

	public boolean updateUserInformation(User user) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		
		String hql = "UPDATE User set password= :pw, phone= :ph, email= :em  "  + 
	             "WHERE username = :us";
		Query query = session.createQuery(hql);
		query.setParameter("pw", user.getPassword());
		query.setParameter("ph", user.getPhone());
		query.setParameter("em", user.getEmail());
		query.setParameter("us", user.getUsername());
		int rs = query.executeUpdate();
		
		session.getTransaction().commit();
		if(rs >= 0)
			return true;
		return false;
	}

}
