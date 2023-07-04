package com.prowings.main;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.prowings.entity.Person;

public class TestHibernateApp {

	public static void main(String[] args) {
		Person p1 = new Person();
		p1.setName("taksh");
		p1.setAddress("haidarabad");

		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
//		session.saveOrUpdate(p1);
		session.persist(p1);
//		session.save(p1);
		session.flush();
		p1.setName("zzzzzzz");
		
		tx.commit();
		System.out.println("Object saved to database successfully");
		session.close();
	}
}
