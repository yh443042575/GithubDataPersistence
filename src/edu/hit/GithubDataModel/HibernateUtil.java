package edu.hit.GithubDataModel;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static final SessionFactory sessionFactory = buildFactory();	

	private static SessionFactory buildFactory(){
		
		try {
			return new Configuration().configure().buildSessionFactory();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ExceptionInInitializerError();
		}
		
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}

}

