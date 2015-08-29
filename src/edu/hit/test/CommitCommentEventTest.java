package edu.hit.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.hit.GithubDataModel.CommitCommentEvent;
import edu.hit.GithubDataModel.CreateEvent;
import edu.hit.GithubDataModel.HibernateUtil;

public class CommitCommentEventTest {

	public static void main(String[] args) {
		
		/*CommitCommentEvent commitCommentEvent = new CommitCommentEvent();
		commitCommentEvent.setCommitComment_id("000231546");
		commitCommentEvent.setCommit_id("2086");
		commitCommentEvent.setBody("我是测试文本");*/
		
		/*CreateEvent createEvent = new CreateEvent();
		createEvent.setCreate_id("0001252*98981");
		createEvent.setHtml_url("www.baidu.com");
		createEvent.setActor("asd");
		createEvent.setCreate_time("2015-06-03");
		createEvent.setDescription("我是测试文本");
		createEvent.setRef_type("2222");
		createEvent.setRepo_name("yiyi8989");*/
		
		
		/*利用静态类获取数据的session*/
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		long time1 = System.currentTimeMillis();
		session.beginTransaction();
		//session.save(createEvent);
		session.getTransaction().commit();
		System.out.println(System.currentTimeMillis()-time1);
		session.close();
		HibernateUtil.closeSessionFactory();
		
		
	}

}
