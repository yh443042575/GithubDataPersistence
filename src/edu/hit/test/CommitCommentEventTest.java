package edu.hit.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import edu.hit.GithubDataModel.CommitCommentEvent;
import edu.hit.GithubDataModel.HibernateUtil;

public class CommitCommentEventTest {

	public static void main(String[] args) {
		
		CommitCommentEvent commitCommentEvent = new CommitCommentEvent();
		commitCommentEvent.setCommitComment_id("000231546");
		commitCommentEvent.setCommit_id("2086");
		commitCommentEvent.setBody("我是测试文本");
		
		
		/*利用静态类获取数据的session*/
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		session.save(commitCommentEvent);
		session.getTransaction().commit();
		session.close();
		
	}

}
