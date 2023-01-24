package com.MyFirstMaven;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {
		
		//get and load method

		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		SessionFactory factory = cfg.buildSessionFactory();
		
		Session session = factory.openSession();
		
		//get 
		//Student student = session.get(Student.class, 10231);
		
		//load
		Student student = session.load(Student.class, 10231);
		System.out.println(student);
		
		
		Address ad = session.get(Address.class, 1);
		System.out.println(ad);
		System.out.println(ad.getStreet()+" :"+ad.getAddedDate());
		
		session.close();
		factory.close();
	}

}
