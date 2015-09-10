package edu.hit.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import edu.hit.GithubDataModel.CommitCommentEvent;
import edu.hit.GithubDataModel.CreateEvent;
import edu.hit.GithubDataModel.HibernateUtil;

public class CommitCommentEventTest {

	public static void main(String[] args) {
		
		
		/*利用静态类获取数据的session*/
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		//session.save(createEvent);
		session.getTransaction().commit();
		session.close();
		HibernateUtil.closeSessionFactory();
		
		
		/*AnnotationConfiguration cfg = new AnnotationConfiguration();
		SchemaExport schemaExport = new SchemaExport(cfg);
		schemaExport.create(true,true);*/
		
		
	}

}
